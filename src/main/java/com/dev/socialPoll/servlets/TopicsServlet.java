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

import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class TopicsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve the list of poll topics from the TopicService
            TopicService topicService = ServiceFactory.getInstance().getTopicService();
            List<Topic> pollTopics = topicService.retrieveTopics();

            // Store the list of poll topics in a request attribute
            request.setAttribute("pollTopics", pollTopics);

            // Forward the request to the index.jsp page
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServiceException e) {
            // Handle the exception (you can redirect to an error page)
            response.getWriter().println("Error occurred while retrieving poll topics.");
            e.printStackTrace();
        }
    }

    // Add other methods (if needed) for handling POST requests or other functionalities
}