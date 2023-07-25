package com.dev.socialPoll.servlets;

import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.entity.Topic;
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
import java.util.List;
import java.util.Optional;

@WebServlet("/polls")
public class PollsServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long topicId = Long.parseLong(request.getParameter("topicId"));
        PollService pollService = ServiceFactory.getInstance().getPollService();
        TopicService topicService = ServiceFactory.getInstance().getTopicService();

        try {
            List<Poll> polls = pollService.retrievePollsByTopic(topicId);
            Optional<Topic> topic = topicService.retrieveTopicById(topicId);

            request.setAttribute("topic", topic.get().getTopicName());
            request.setAttribute("polls", polls);

            request.getRequestDispatcher("html/user/polls.jsp").forward(request, response);
        } catch (ServiceException e) {
            logger.info("Error occured while retrieving polls by topicId");
            response.sendRedirect("index.jsp");
        }
    }
}
