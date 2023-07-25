package com.dev.socialPoll.servlets;

import com.dev.socialPoll.entity.*;

import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet("/take-poll")
public class ParticipateInPollServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("ParticipateInPollServlet doGet method is called");

        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("/log-in").forward(request, response);
        }

        PollService pollService = ServiceFactory.getInstance().getPollService();
        QuestionService questionService = ServiceFactory.getInstance().getQuestionService();
        OptionService optionService = ServiceFactory.getInstance().getOptionService();

        try {
            long pollId = Long.parseLong(request.getParameter("pollId"));
            Optional<Poll> poll = pollService.retrievePollById(pollId);

            if (poll.isPresent()) {

                List<Question> questions = questionService.retrieveQuestionsByPoll(pollId);
                Map<Question, List<Option>> questionOptionsMap = new HashMap<>();

                for (Question question : questions) {
                    List<Option> options = optionService.retrieveOptionsByQuestion(question.getId());
                    question.setOptions(options);
                    questionOptionsMap.put(question, options);
                }

                HttpSession session = request.getSession();
                session.setAttribute("poll", poll);
                session.setAttribute("questionOptionsMap", questionOptionsMap);

                request.getRequestDispatcher("html/user/poll.jsp").forward(request, response);

            } else {
                response.sendRedirect("html/error.jsp");
            }
        } catch (NumberFormatException e) {
            logger.info("NumberFormatException occurred while retrieving poll details");
            response.sendRedirect("index.jsp");
        } catch (ServiceException e) {
            logger.info("Error occurred while retrieving poll details");
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doPost of ParticipateInPollServlet is working");

        PollService pollService = ServiceFactory.getInstance().getPollService();
        QuestionService questionService = ServiceFactory.getInstance().getQuestionService();
        PollResponseService pollResponseService = ServiceFactory.getInstance().getPollResponseService();

        try {
            long pollId = Long.parseLong(request.getParameter("pollId"));
            User user = (User) request.getSession().getAttribute("user");
            long userId = user.getId();

            Optional<Poll> poll = pollService.retrievePollById(pollId);

            if (poll.isPresent()) {
                List<Question> questions = questionService.retrieveQuestionsByPoll(pollId);

                for (Question question : questions) {
                    Long selectedOptionId = Long.parseLong(request.getParameter("q" + question.getId()));
                    pollResponseService.addNewPollResponse(pollId,question.getId(),selectedOptionId, userId);
                }

                response.sendRedirect("/SocialPoll/results");
            } else {
                response.sendRedirect("html/error.jsp");
            }
        } catch (ServiceException e) {
            logger.info("Error occurred while saving poll responses");
            response.sendRedirect("html/error.jsp");
        }
    }

}
