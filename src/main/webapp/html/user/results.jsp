<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Poll Webpage - Results</title>
    <link rel="icon" href="images/poll-icon.png">
    <link rel="stylesheet" href="css/user/results.css">
</head>

<body>
    <!-- Include the header -->
    <jsp:include page="../fragments/header.jsp" />

    <section>
        <div class="poll-section">
            <div class="container">
                <h1 class="topic">Results of ${not empty requestScope.poll ? poll.get().pollName : 'Poll'}</h1>

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
</body>

</html>