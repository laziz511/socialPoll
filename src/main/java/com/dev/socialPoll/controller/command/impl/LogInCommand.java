package com.dev.socialPoll.controller.command.impl;

import com.dev.socialPoll.controller.command.Command;
import com.dev.socialPoll.controller.command.CommandResult;
import com.dev.socialPoll.controller.command.CommandResultType;
import com.dev.socialPoll.controller.context.RequestContext;
import com.dev.socialPoll.controller.context.RequestContextHelper;
import com.dev.socialPoll.entity.User;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.ServiceFactory;
import com.dev.socialPoll.service.UserService;
import jakarta.servlet.http.HttpServletResponse;



import java.util.Optional;

public class LogInCommand implements Command {
    private static final String PROFILE_PAGE = "command=profile";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String LOGIN_PAGE = "WEB-INF/view/login.jsp";
    private static final String EMAIL_PARAMETER = "email";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String USER = "user";
    private static final String ROLE = "role";
    private static final String ERROR_MESSAGE = "errorMessage";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();

        String email = requestContext.getRequestParameter(EMAIL_PARAMETER);
        String password = requestContext.getRequestParameter(PASSWORD_PARAMETER);

        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
            Optional<User> optionalUser= userService.login(email, password);

            if (optionalUser.isPresent()) {
                requestContext.addSessionAttribute(USER, optionalUser.get());

                return new CommandResult(PROFILE_PAGE, CommandResultType.REDIRECT);
            }

        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        requestContext.addRequestAttribute(ERROR_MESSAGE, true);
        helper.updateRequest(requestContext);
        return new CommandResult(LOGIN_PAGE, CommandResultType.FORWARD);

    }
}
