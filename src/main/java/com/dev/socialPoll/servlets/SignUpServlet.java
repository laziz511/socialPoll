package com.dev.socialPoll.servlets;

import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.entity.UserRole;
import com.dev.socialPoll.exception.DaoException;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.ServiceFactory;
import com.dev.socialPoll.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;


import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the sign-up.jsp page
        request.getRequestDispatcher("html/auth/sign-up.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get the user input from the request parameters
        String firstName = request.getParameter("Name");
        String lastName = request.getParameter("Surname");

        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        String gender = request.getParameter("gender");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserRole userRole = UserRole.valueOf("USER");

        logger.info(firstName, lastName, birthday, gender, email, password, userRole);

        UserService userService = ServiceFactory.getInstance().getUserService();
        try {
            userService.register(firstName,lastName,birthday, gender, email, password, userRole);
            Optional<User> user = userService.login(email, password);

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect("index.jsp");
        } catch (ServiceException e) {
            logger.error("error occured while registering the user!");
            request.setAttribute("error", "This email is already registered. Please try another");
            doGet(request, response);
        }
    }
}
