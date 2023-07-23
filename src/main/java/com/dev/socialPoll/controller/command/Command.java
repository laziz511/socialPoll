package com.dev.socialPoll.controller.command;

import com.dev.socialPoll.controller.context.RequestContextHelper;
import jakarta.servlet.http.HttpServletResponse;


public interface Command {

    /**
     * Method that is executed by controller when certain command is called
     *
     * @param helper   RequestContextHelper from incoming request
     * @param response HttpServletResponse for incoming request
     * @return CommandResult of page with routing type
     */
    CommandResult execute(RequestContextHelper helper, HttpServletResponse response);
}