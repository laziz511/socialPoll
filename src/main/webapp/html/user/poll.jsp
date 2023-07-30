<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Poll Webpage</title>
    <link rel="icon" href="images/poll-icon.png">

    <link rel="stylesheet" href="css/user/poll.css">
</head>

<body>
    <!-- Include the header -->
    <jsp:include page="../fragments/header.jsp" />

    <section>
        <div class="poll-section">
            <div class="container">

                <h1 class="topic">${not empty requestScope.poll ? poll.pollName : 'You have already taken this poll.'}
                </h1>

                <form class="poll-form" method="post" action="/SocialPoll/take-poll">

                    <input type="hidden" name="pollId" value="${not empty requestScope.poll ? poll.id : 20}">
                    <c:if test="${not empty requestScope.questionOptionsMap}">
                        <c:forEach items="${requestScope.questionOptionsMap}" var="entry">
                            <c:set var="question" value="${entry.key}" />
                            <div class="question-card">
                                <h2 class="question">${question.questionText}</h2>
                                <ul class="answers">
                                    <c:if test="${not empty entry.value}">
                                        <c:forEach items="${entry.value}" var="option">
                                            <li class="custom-checkbox-container">
                                                <input type="radio" name="question_${question.id}"
                                                    id="option${option.id}" value="${option.id}">
                                                <label for="option${option.id}" class="custom-checkbox"></label>
                                                <label for="option${option.id}"
                                                    class="checkbox-text">${option.optionText}</label>
                                            </li>
                                        </c:forEach>
                                    </c:if>
                                </ul>
                            </div>

                        </c:forEach>
                    </c:if>

                    <!-- Submit button -->
                    <c:choose>
                        <c:when test="${requestScope.poll.userHasTaken}">

                            <div class="button-container">
                                <!-- If the poll is taken, show the "Back to home" button -->
                                <a href="/SocialPoll/home" class="submit-button">Back to home</a>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="button-container">
                                <!-- If the poll is not taken, show the "Submit" button -->
                                <button type="submit" class="submit-button">Submit</button>
                            </div>
                        </c:otherwise>
                    </c:choose>

                </form>
            </div>
        </div>
    </section>



</body>

</html>