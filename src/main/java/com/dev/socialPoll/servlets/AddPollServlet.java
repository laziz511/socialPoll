package com.dev.socialPoll.servlets;

import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.entity.UserRole;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.PollService;
import com.dev.socialPoll.service.ServiceFactory;
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
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.info("- - - - - - - - - - - doPost starts  - - - - - - - - - - - - - -  - -");

        long topicId = Long.parseLong(request.getParameter("topicId"));
        String pollName = request.getParameter("pollName");
        String pollDescription = request.getParameter("pollDescription");
        int questionCount = Integer.parseInt(request.getParameter("questionCount"));


        Map<String, List<String>> questionOptionsMap = new HashMap<>();
        for (int i = 1; i <= questionCount; i++) {
            String questionKey = "question" + i;
            List<String> options = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                String optionKey = questionKey + "-option" + j;
                String optionValue = request.getParameter(optionKey);
                if (optionValue != null) {
                    options.add(optionValue);
                }
            }
            questionOptionsMap.put(questionKey, options);
        }

        logger.info("topicId : " + topicId + " pollName: " + pollName + " pollDescription: " + pollDescription);
        logger.info(questionOptionsMap);

        PollService pollService = ServiceFactory.getInstance().getPollService();

        try {
            pollService.addNewPoll(topicId, pollName, pollDescription, questionOptionsMap);
        } catch (ServiceException e) {
            logger.error("Error occurred while adding a new poll!", e);
            response.sendRedirect("error.jsp");
            return;
        }
        logger.info("- - - - - - - - - - - doPost ends  - - - - - - - - - - - - - -  - -");
        response.sendRedirect("/SocialPoll/admin-dashboard");
    }
}
