package com.dev.socialPoll.servlets;

import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.PollService;
import com.dev.socialPoll.service.PollResponseService;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user-polls")
public class UserPollsServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doGet of UserPollsServlet is working");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // Check if the user is logged in
        if (user == null) {
            response.sendRedirect("log-in");
            return;
        }

        PollResponseService pollResponseService = ServiceFactory.getInstance().getPollResponseService();
        PollService pollService = ServiceFactory.getInstance().getPollService();

        try {
            long userId = user.getId();

            // Retrieve all pollIds where user has submitted responses
            List<Long> pollIds = pollResponseService.getPollIdsByUserId(userId);

            // Retrieve all polls with the retrieved pollIds
            List<Poll> userPolls = new ArrayList<>();
            for (long pollId : pollIds) {
                Poll poll = pollService.retrievePollById(pollId).orElse(null);
                if (poll != null) {
                    userPolls.add(poll);
                }
            }

            // Set the user polls in the request attribute to be displayed in the JSP
            request.setAttribute("userPolls", userPolls);
            request.getRequestDispatcher("html/user/user-polls.jsp").forward(request, response);

        } catch (ServiceException e) {
            logger.error("Error occurred while retrieving user polls!", e);
            response.sendRedirect("html/error.jsp");
        }
    }
}
