<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Polls</title>
    <link rel="stylesheet" href="css/user/polls.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>

<body>

    <!-- Include the header -->
    <%@ include file="../fragments/header.jsp" %>

        <!-- Admin Polls Cards start -->
        <section>
            <div class="topic-section">
                <h2 class="text-box">Admin Polls</h2>

                <div class="cards">
                    <!-- Loop through admin poll submissions and display poll cards -->
                    <c:forEach items="${adminPolls}" var="poll">
                        <div class="card">
                            <h3 class="topic">
                                <i class="fas fa-user-tie icon"></i>
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
                                        <a href="/SocialPoll/manage-poll?pollId=${poll.id}" class="survey-button">Edit
                                            Poll</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Admin Polls Cards end -->


</body>

</html>