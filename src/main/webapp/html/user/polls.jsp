<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/user/polls.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

</head>

<body>

    <!-- navbar start -->
    <div class="navbar">
        <div class="navbar-container">

            <div class="logo-container">
                <svg fill="none" viewBox="0 0 245 55" width="100"></svg>
                <h1>My Voice</h1>
            </div>

            <div>
                <a href="/SocialPoll/admin-dashboard" class="survey-button"> Create my poll</a>
            </div>

        </div>
    </div>
    <!-- navbar end -->


    <!-- surveys section start -->
    <section>
        <div class="topic-section">
            <c:if test="${not empty requestScope.polls}">
                <h2 class="text-box">Polls in <span>${requestScope.topic}</span></h2>
            </c:if>

            <div class="cards">
                <c:if test="${not empty requestScope.polls}">
                    <c:forEach items="${requestScope.polls}" var="poll">
                        <div class="card">
                            <h3 class="topic">
                                <i class="fas fa-user-friends icon"></i>
                                ${poll.pollName}
                            </h3>
                            <p class="description">${poll.description}</p>
                            <div class="info">
                                <div class="info-text">
                                    <p class="question-count">
                                        <i class="fas fa-question-circle"></i>
                                        Number of questions: <span>${poll.numQuestions}</span>
                                    </p>
                                    <p class="participant-count">
                                        <i class="fas fa-users"></i>
                                        Participants: <span>${poll.numParticipants}</span>
                                    </p>
                                </div>
                                <div class="info-button">
                                    <div>
                                        <c:choose>
                                            <c:when test="${poll.userHasTaken}">
                                                <!-- Show the button in red with text "Taken" -->
                                                <a href="#" class="survey-button taken-button"  onclick="return false;" >Taken</a>
                                            </c:when>
                                            <c:otherwise>
                                                <!-- Show the button in black with text "Take the Poll" -->
                                                <a href="/SocialPoll/take-poll?pollId=${poll.id}" class="survey-button">Take the Poll</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>

            <div class="post-text">
                <a href="">
                    <h2>See More Polls...</h2>
                </a>
            </div>
        </div>
    </section>
    <!-- surveys section end -->


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