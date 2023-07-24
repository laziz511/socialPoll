package com.dev.socialPoll.servlets;

import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.ServiceFactory;
import com.dev.socialPoll.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/log-in")
public class LogInServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the sign-up.jsp page
        request.getRequestDispatcher("html/auth/log-in.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        logger.info(email, password);

        UserService userService = ServiceFactory.getInstance().getUserService();
        try {
            Optional<User> userOptional = userService.login(email, password);
            if (userOptional.isPresent()) {
                // Login successful
                HttpSession session = request.getSession();
                User user = userOptional.orElseGet(() -> new User());
                session.setAttribute("user", user);

                response.sendRedirect("/SocialPoll/home");
            } else {
                // Login failed, set error message and forward to login page
                request.setAttribute("error", "Credentials are not correct. Try Sign-up!");
                doGet(request, response);
            }
        } catch (ServiceException e) {
            logger.error("Error occurred while log in!", e);
        //    doGet(request, response);
            throw new ServletException(e.getMessage(), e);
        }
    }
}
