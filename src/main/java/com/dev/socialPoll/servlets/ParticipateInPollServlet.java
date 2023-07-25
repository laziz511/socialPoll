package com.dev.socialPoll.servlets;

import com.dev.socialPoll.entity.Option;
import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.entity.Question;
import com.dev.socialPoll.entity.Topic;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

        long pollId = Long.parseLong(request.getParameter("pollId"));
        PollService pollService = ServiceFactory.getInstance().getPollService();
        QuestionService questionService = ServiceFactory.getInstance().getQuestionService();
        OptionService optionService = ServiceFactory.getInstance().getOptionService();

        try {
            Optional<Poll> poll = pollService.retrievePollById(pollId);

            if (poll.isPresent()) {
                // Retrieve questions for the poll
                List<Question> questions = questionService.retrieveQuestionsByPoll(pollId);

                // Create a map to store questions and their options
                Map<Question, List<Option>> questionOptionsMap = new HashMap<>();

                for (Question question : questions) {
                    // Retrieve options for each question
                    List<Option> options = optionService.retrieveOptionsByQuestion(question.getId());
                    questionOptionsMap.put(question, options);
                }

                request.setAttribute("questionOptionsMap", questionOptionsMap);

                // Forward the request to the poll.jsp page
                request.getRequestDispatcher("html/user/poll.jsp").forward(request, response);

            } else {
                // Poll not found, redirect to an error page or display a message
                response.sendRedirect("html/error.jsp");
            }
        } catch (ServiceException e) {
            logger.info("Error occurred while retrieving poll details");
            response.sendRedirect("index.jsp");
        }
    }

}
