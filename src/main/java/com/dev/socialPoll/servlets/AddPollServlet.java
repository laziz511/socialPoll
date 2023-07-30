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
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;


@WebServlet("/add-poll")
public class AddPollServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.info("doGet of add-poll is working ");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null && user.getRole() == UserRole.ADMIN) {
            request.getRequestDispatcher("html/admin/add-poll.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/SocialPoll/error").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("- - - - - - - - - - - doPost starts  - - - - - - - - - - - - - -  - -");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("log-in");
            return;
        }

        long topicId = Long.parseLong(request.getParameter("topicId"));
        String pollName = request.getParameter("pollName");
        String pollDescription = request.getParameter("pollDescription");
        int questionCount = Integer.parseInt(request.getParameter("questionCount"));

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
                questionOptionsMap.put(questionText, options); // Use the extracted question text as the key in the map
            }
        }

        PollService pollService = ServiceFactory.getInstance().getPollService();

        try {
            boolean success = pollService.addNewPoll(topicId, pollName, pollDescription, questionCount, questionOptionsMap, user.getId());

            if (!success) {
                response.sendRedirect("/SocialPoll/error");
                return;
            }

            // Get the TopicService and update the number of polls for the corresponding topic
            TopicService topicService = ServiceFactory.getInstance().getTopicService();
            topicService.updateNumPollsForTopic(topicId);

        } catch (ServiceException e) {
            logger.error("Error occurred while adding a new poll!", e);
            response.sendRedirect("/SocialPoll/error");
            return;
        }
        logger.info("- - - - - - - - - - - doPost ends  - - - - - - - - - - - - - -  - -");
        response.sendRedirect("/SocialPoll/home");
    }
}
