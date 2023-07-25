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

        // Get the form data from the request
        long topicId = Long.parseLong(request.getParameter("topicId"));
        String pollName = request.getParameter("pollName");
        String pollDescription = request.getParameter("pollDescription");


        // Retrieve the question and option counts from hidden input fields
        int questionCount = Integer.parseInt(request.getParameter("questionCount"));
        int optionCount = Integer.parseInt(request.getParameter("optionCount"));

        logger.info(topicId);
        logger.info(pollName);
        logger.info(pollDescription);
        logger.info(questionCount);
        logger.info(optionCount);


        // Retrieve the questions and their answer options
        Map<String, List<String>> questionOptionsMap = new HashMap<>();
        for (int i = 1; i <= questionCount; i++) {
            String questionKey = "question" + i;
            List<String> options = new ArrayList<>();
            for (int j = 1; j <= optionCount; j++) {
                String optionKey = questionKey + "-option" + j;
                String optionValue = request.getParameter(optionKey);
                options.add(optionValue);
            }
            questionOptionsMap.put(questionKey, options);
        }

        logger.info(questionOptionsMap);

        // Process the form data and save it to the database using your service method
        PollService pollService = ServiceFactory.getInstance().getPollService();

        try {
            pollService.addNewPoll(topicId, pollName, pollDescription, questionOptionsMap);
        } catch (ServiceException e) {
            logger.error("Error occurred while adding a new poll!", e);
            // Handle the error and redirect to an error page or display an error message
            response.sendRedirect("error.jsp");
        }

        logger.info("- - - - - - - - - - - doPost ends  - - - - - - - - - - - - - -  - -");
        response.sendRedirect("/SocialPoll/home"); // Redirect to a confirmation page or the polls list page
    }

}
