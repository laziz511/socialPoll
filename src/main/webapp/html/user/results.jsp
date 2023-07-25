<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dev.socialPoll.entity.Question" %>
<%@ page import="com.dev.socialPoll.entity.Option" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Poll Webpage - Results</title>
    <link rel="stylesheet" href="css/user/results.css">
</head>

<body>
    <!-- navbar start -->
    <div class="navbar">
        <div class="navbar-container">
            <div class="logo-container">
                <svg fill="none" viewBox="0 0 400 50" width="100"></svg>
                <h1>My Voice</h1>
            </div>
        </div>
    </div>
    <!-- navbar end -->

    <section>
        <div class="poll-section">
            <div class="container">
                <h1 class="topic">Results of ${not empty requestScope.poll ? poll.get().pollName : 'Poll'}</h1>

                <p class="participants-text">
                    Total participants: <span id="total-participants" class="participants-number">${not empty sessionScope.totalParticipants ? requestScope.totalParticipants : '0'}</span>
                </p>
                <form class="poll-form">


                    <c:if test="${not empty questionOptionsMap}">
                        <c:forEach items="${questionOptionsMap}" var="entry">
                            <c:set var="question" value="${entry.key}" />
                            <div class="question-card">
                                <h2 class="question">${question.questionText}</h2>
                                <ul class="answers">
                                    <c:if test="${not empty entry.value}">
                                        <c:forEach items="${entry.value}" var="option">
                                            <li class="answer-option">
                                                <span class="answer-text">${option.optionText}</span>
                                                <span class="percentage">${option.numParticipants}%</span>
                                            </li>
                                        </c:forEach>
                                    </c:if>
                                </ul>
                            </div>
                        </c:forEach>
                    </c:if>


                    <div class="button-container">
                        <a href="/SocialPoll/home" class="survey-button">Back to Home</a>
                    </div>
                </form>
            </div>
        </div>
    </section>

    <!-- footer start -->
    <section>
        <footer class="footer-section">
            <span>This is a footer</span>
            <span>© My Voice</span>
        </footer>
    </section>
    <!-- footer end -->
</body>

</html>