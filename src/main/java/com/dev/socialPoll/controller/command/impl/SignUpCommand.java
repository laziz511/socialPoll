package com.dev.socialPoll.controller.command.impl;
import com.dev.socialPoll.controller.command.Command;
import com.dev.socialPoll.controller.command.CommandResult;
import com.dev.socialPoll.controller.command.CommandResultType;
import com.dev.socialPoll.controller.context.RequestContext;
import com.dev.socialPoll.controller.context.RequestContextHelper;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.ServiceFactory;
import com.dev.socialPoll.service.UserService;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Optional;

public class SignUpCommand implements Command {
    private static final String LOG_UP_PAGE = "WEB-INF/view/logup.jsp";
    private static final String ERROR_PAGE = "WEB-INF/view/error.jsp";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String BIRTHDAY = "birthday";
    private static final String GENDER = "gender";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String MESSAGE = "message";
    private static final String ERROR = "error";
    private static final String OK = "ok";
    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext requestContext = helper.createContext();
        String message = ERROR;

        Optional<String> name = Optional.ofNullable(requestContext.getRequestParameter(NAME));
        Optional<String> surname = Optional.ofNullable(requestContext.getRequestParameter(SURNAME));
        Optional<String> birthday = Optional.ofNullable(requestContext.getRequestParameter(BIRTHDAY));
        Optional<String> gender = Optional.ofNullable(requestContext.getRequestParameter(GENDER));
        Optional<String> email = Optional.ofNullable(requestContext.getRequestParameter(EMAIL));
        Optional<String> password = Optional.ofNullable(requestContext.getRequestParameter(PASSWORD));

        try {
            if (name.isPresent() && surname.isPresent() && birthday.isPresent() && gender.isPresent() &&
                    email.isPresent() && password.isPresent()) {
                UserService userService = ServiceFactory.getInstance().getUserService();
                boolean result = userService.register(name.get(), surname.get(), birthday.get(), gender.get(), email.get(), password.get());
                if (result) message = OK;
            }
        } catch (ServiceException e) {
            return new CommandResult(ERROR_PAGE, CommandResultType.FORWARD);
        }

        requestContext.addRequestAttribute(MESSAGE, message);
        helper.updateRequest(requestContext);
        return new CommandResult(LOG_UP_PAGE, CommandResultType.FORWARD);
    }
}
