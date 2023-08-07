package com.dev.socialPoll.servlets;

import com.dev.socialPoll.service.ServiceFactory;
import com.dev.socialPoll.service.TopicService;
import com.dev.socialPoll.entity.Topic;
import com.dev.socialPoll.exception.ServiceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class TopicServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            // Retrieve the list of poll topics from the TopicService
            TopicService topicService = ServiceFactory.getInstance().getTopicService();
            List<Topic> pollTopics = topicService.retrieveTopics();

            request.setAttribute("pollTopics", pollTopics);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (ServiceException e) {
            logger.error("Error occurred while retrieving topics!", e);
            response.sendRedirect("/SocialPoll/error");
        }
    }
}