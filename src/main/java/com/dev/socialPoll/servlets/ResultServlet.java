package com.dev.socialPoll.servlets;

import com.dev.socialPoll.entity.Option;
import com.dev.socialPoll.entity.Poll;
import com.dev.socialPoll.entity.Question;
import com.dev.socialPoll.exception.ServiceException;
import com.dev.socialPoll.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet("/results")
public class ResultServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("ResultServlet doGet method is called");

        // Assuming you already have "poll" and "questionOptionsMap" attributes in the session scope
        Optional<Poll> poll = (Optional<Poll>) request.getSession().getAttribute("poll");
        Map<Question, List<Option>> questionOptionsMap = (Map<Question, List<Option>>) request.getSession().getAttribute("questionOptionsMap");


        // Calculate percentages for each option
        int totalParticipants = calculateTotalParticipants(questionOptionsMap);

        for (Map.Entry<Question, List<Option>> entry : questionOptionsMap.entrySet()) {
            List<Option> options = entry.getValue();
            long totalVotesForQuestion = options.stream().mapToLong(Option::getNumParticipants).sum();

            for (Option option : options) {
                long votesForOption = option.getNumParticipants();
                double percentage = totalVotesForQuestion == 0 ? 0 : (votesForOption * 100.0) / totalVotesForQuestion;
                option.setNumParticipants((int)percentage);
            }
        }

        // Set the calculated data in request attributes
        request.setAttribute("totalParticipants", totalParticipants);
        request.setAttribute("questionOptionsMap", questionOptionsMap);

        // Forward the request to the JSP
        request.getRequestDispatcher("html/user/results.jsp").forward(request, response);
    }

    private int calculateTotalParticipants(Map<Question, List<Option>> questionOptionsMap) {
        int totalParticipants = 0;
        for (List<Option> options : questionOptionsMap.values()) {
            totalParticipants += options.stream().mapToInt(Option::getNumParticipants).sum();
        }
        return totalParticipants;
    }
}
