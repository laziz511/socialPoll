package com.dev.socialPoll.servlets;

import com.dev.socialPoll.entity.*;

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

        User currentUser = (User) request.getSession().getAttribute("user");
        if (currentUser == null) {
            request.getRequestDispatcher("/log-in").forward(request, response);
        }
        long userId = currentUser.getId();

        PollService pollService = ServiceFactory.getInstance().getPollService();
        OptionService optionService = ServiceFactory.getInstance().getOptionService();
        QuestionService questionService = ServiceFactory.getInstance().getQuestionService();

        try {
            long pollId = Long.parseLong(request.getParameter("pollId"));
            Optional<Poll> poll = pollService.retrievePollById(pollId);

            if (poll.isPresent()) {
                Poll currentPoll = poll.get();

                List<Question> questions = questionService.retrieveQuestionsByPoll(pollId);
                Map<Question, List<Option>> questionOptionsMap = new HashMap<>();

                boolean userHasTakenPoll = pollService.hasPollResponse(userId, currentPoll.getId());
                currentPoll.setUserHasTaken(userHasTakenPoll);

                for (Question question : questions) {
                    List<Option> options = optionService.retrieveOptionsByQuestion(question.getId());
                    question.setOptions(options);
                    questionOptionsMap.put(question, options);
                }

                request.setAttribute("poll", currentPoll);
                request.setAttribute("questionOptionsMap", questionOptionsMap);

                request.getRequestDispatcher("html/user/poll.jsp").forward(request, response);

            } else {
                response.sendRedirect("/SocialPoll/error");
            }
        } catch (NumberFormatException e) {
            logger.info("NumberFormatException occurred while retrieving poll details");
            response.sendRedirect("/SocialPoll/error");
        } catch (ServiceException e) {
            logger.info("Error occurred while retrieving poll details");
            response.sendRedirect("/SocialPoll/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PollService pollService = ServiceFactory.getInstance().getPollService();
        TopicService topicService = ServiceFactory.getInstance().getTopicService();
        OptionService optionService = ServiceFactory.getInstance().getOptionService();
        QuestionService questionService = ServiceFactory.getInstance().getQuestionService();
        PollResponseService pollResponseService = ServiceFactory.getInstance().getPollResponseService();

        try {
            String pollIdParam = request.getParameter("pollId");

            // Check if pollIdParam is not null and not empty before parsing it as Long
            if (pollIdParam != null && !pollIdParam.isEmpty()) {
                long pollId = Long.parseLong(pollIdParam);

                User user = (User) request.getSession().getAttribute("user");
                long userId = user.getId();

                // Check if the user has already taken the poll
                boolean userHasTakenPoll = pollService.hasPollResponse(userId, pollId);

                if (userHasTakenPoll) {
                    request.getRequestDispatcher("html/user/poll.jsp").forward(request, response);
                    return;
                }

                Optional<Poll> poll = pollService.retrievePollById(pollId);

                if (poll.isPresent()) {

                    List<Question> questions = questionService.retrieveQuestionsByPoll(pollId);

                    for (Question question : questions) {
                        String parameterName = "question_" + question.getId();
                        long selectedOptionId = Long.parseLong(request.getParameter(parameterName));

                        optionService.increaseParticipantsCount(selectedOptionId);

                        pollResponseService.addNewPollResponse(pollId, question.getId(), selectedOptionId, userId);
                    }

                    // Increment num_participants for the poll
                    pollService.incrementNumParticipants(pollId);

                    // Increment num_participants for the poll's topic
                    long topicId = poll.get().getTopicId();
                    topicService.incrementNumParticipantsForTopic(topicId);

                    response.sendRedirect("/SocialPoll/results?pollId=" + pollId);
                }
            }
            response.sendRedirect("/SocialPoll/error");

        } catch (NumberFormatException e) {
            logger.info("NumberFormatException occurred while parsing pollId");
            response.sendRedirect("/SocialPoll/error");
        } catch (ServiceException e) {
            logger.info("Error occurred while saving poll responses");
            response.sendRedirect("/SocialPoll/error");
        }
    }

}
