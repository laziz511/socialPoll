package com.dev.socialPoll.servlets;

import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.entity.UserRole;
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
        // Get the form data from the request
        long topicId = Long.parseLong(request.getParameter("topicId"));
        String pollName = request.getParameter("pollName");
        String pollDescription = request.getParameter("pollDescription");

        logger.info(topicId);
        logger.info(pollName);
        logger.info(pollDescription);

        // Retrieve the questions and their answer options
        Map<String, List<String>> questionOptionsMap = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.startsWith("question")) {
                String[] parts = paramName.split("-"); // Split the question and option indices
                String questionKey = parts[0];
                String optionValue = request.getParameter(paramName);
                questionOptionsMap.computeIfAbsent(questionKey, k -> new ArrayList<>()).add(optionValue);
            }
        }
        // Process the form data, save it to the database, etc.
        // Call your service method passing all the data, including the questionOptionsMap
    }
}
