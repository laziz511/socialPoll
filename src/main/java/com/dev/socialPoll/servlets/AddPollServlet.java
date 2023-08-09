package com.dev.socialPoll.servlets;

import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.entity.UserRole;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.PollService;
import com.dev.socialPoll.service.ServiceFactory;
import com.dev.socialPoll.service.TopicService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;


@WebServlet("/add-poll")
public class AddPollServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        if (user != null && user.getRole() == UserRole.ADMIN) {
            request.getRequestDispatcher("html/admin/add-poll.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/SocialPoll/error").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            response.sendRedirect("log-in");
            return;
        }

        long topicId = Long.parseLong(request.getParameter("topicId"));
        String pollName = request.getParameter("pollName");
        String pollDescription = request.getParameter("pollDescription");
        int questionCount = Integer.parseInt(request.getParameter("questionCount"));

        Map<String, List<String>> questionOptionsMap = new HashMap<>();
        int actualNumberOfQuestions = 0;
        for (int i = 1; i <= questionCount; i++) {
            String questionKey = "question" + i;
            String questionText = request.getParameter(questionKey);
            if (questionText != null && !questionText.isEmpty()) {
                actualNumberOfQuestions++;
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

        PollService pollService = ServiceFactory.getInstance().getPollService();

        try {
            boolean success = pollService.addNewPoll(topicId, pollName, pollDescription, actualNumberOfQuestions, questionOptionsMap, user.getId());

            if (!success) {
                response.sendRedirect("/SocialPoll/error");
                return;
            }

            // Update the number of polls for the corresponding topic
            TopicService topicService = ServiceFactory.getInstance().getTopicService();
            topicService.updateNumPollsForTopic(topicId);
            response.sendRedirect("/SocialPoll/home");

        } catch (ServiceException e) {
            logger.error("Error occurred while adding a new poll!", e);
            response.sendRedirect("/SocialPoll/error");
        }
    }
}
