package com.dev.socialPoll.servlets;

import com.dev.socialPoll.entity.Option;
import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.entity.Question;
import com.dev.socialPoll.entity.User;
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
import java.util.*;
import java.util.stream.Collectors;


@WebServlet("/manage-poll")
public class ManagePollServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("log-in");
            return;
        }

        try {
            long pollId = Long.parseLong(request.getParameter("pollId"));

            PollService pollService = ServiceFactory.getInstance().getPollService();
            QuestionService questionService = ServiceFactory.getInstance().getQuestionService();
            OptionService optionService = ServiceFactory.getInstance().getOptionService();

            Optional<Poll> poll = pollService.retrievePollById(pollId);

            if (poll.isPresent()) {
                Poll currentPoll = poll.get();

                // Get the questions of the poll from the database
                List<Question> questions = questionService.retrieveQuestionsByPoll(pollId);

                // Get the options of each question from the database
                for (Question question : questions) {
                    List<Option> options = optionService.retrieveOptionsByQuestion(question.getId());
                    question.setOptions(options);
                }

                currentPoll.setQuestions(questions);

                request.setAttribute("poll", currentPoll);
                request.getRequestDispatcher("html/admin/manage-poll.jsp").forward(request, response);
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
        logger.info("doPost of ManagePollServlet is working");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("log-in");
            return;
        }

        long pollId = Long.parseLong(request.getParameter("pollId"));
        String pollName = request.getParameter("pollName");
        String description = request.getParameter("description");
        PollService pollService = ServiceFactory.getInstance().getPollService();
        int questionCount = Integer.parseInt(request.getParameter("questionCount"));

        String removedQuestionsString = request.getParameter("removedQuestions");
        List<Long> removedQuestions = Arrays.stream(removedQuestionsString.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        logger.info("Removed question IDs: " + removedQuestions);
        try {
            pollService.decreaseNumQuestions(pollId, removedQuestions.size());
        } catch (ServiceException e) {
            logger.error("Error occurred while decresing number of questions in the poll!", e);
            response.sendRedirect("/SocialPoll/error");
            return;
        }

        Map<String, List<String>> questionOptionsMap = new HashMap<>();
        for (int i = 1; i <= questionCount; i++) {
            String questionKey = "question" + i;
            String questionText = request.getParameter(questionKey); // Get the question text from the request parameter
            if (questionText != null && !questionText.isEmpty()) {
                List<String> options = new ArrayList<>();
                for (int j = 1; j <= 5; j++) {
                    String optionKey = questionKey + "-option" + j;
                    String optionValue = request.getParameter(optionKey);
                    if (optionValue != null) {
                        options.add(optionValue);
                    }
                }
                questionOptionsMap.put(questionText, options);
            }
        }
        logger.info("questionOptionsMap: " + questionOptionsMap);

        // Remove poll responses, options, and questions from the database for each removed question ID
        PollResponseService pollResponseService = ServiceFactory.getInstance().getPollResponseService();
        OptionService optionService = ServiceFactory.getInstance().getOptionService();
        QuestionService questionService = ServiceFactory.getInstance().getQuestionService();

        for (Long removedQuestionId : removedQuestions) {
            try {
                // Remove poll responses for the question
                pollResponseService.deleteResponsesByQuestion(removedQuestionId);

                // Retrieve options for the question and remove them
                List<Option> options = optionService.retrieveOptionsByQuestion(removedQuestionId);
                for (Option option : options) {
                    optionService.deleteOption(option.getId());
                }

                // Finally, remove the question itself
                questionService.deleteQuestion(removedQuestionId);
            } catch (ServiceException e) {
                logger.error("Error occurred while removing question with ID: " + removedQuestionId, e);
                response.sendRedirect("/SocialPoll/error");
                return;
            }
        }

        // Update the poll information for the remaining questions
        try {
            boolean success = pollService.updatePollInformation(pollId, pollName, description, questionCount, questionOptionsMap);
            if (!success) {
                response.sendRedirect("/SocialPoll/error");
                return;
            }
        } catch (ServiceException e) {
            logger.error("Error occurred while updating the poll!", e);
            response.sendRedirect("/SocialPoll/error");
            return;
        }

        response.sendRedirect("/SocialPoll/admin-dashboard");
    }
}