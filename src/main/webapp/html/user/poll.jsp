<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Poll Webpage</title>
    <link rel="stylesheet" href="css/user/poll.css">
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
                <h1 class="topic">${not empty sessionScope.poll ? poll.get().pollName : 'Poll not found'}
                </h1>

                <form class="poll-form"  method="post">

                    <c:if test="${not empty sessionScope.questionOptionsMap}">
                        <c:forEach items="${sessionScope.questionOptionsMap}" var="entry">
                            <c:set var="question" value="${entry.key}" />
                            <div class="question-card">
                                <h2 class="question">${question.questionText}</h2>
                                <ul class="answers">
                                    <c:if test="${not empty entry.value}">
                                        <c:forEach items="${entry.value}" var="option">
                                            <li class="custom-checkbox-container">
                                                <input type="radio" name="q${question.id}" id="option${option.id}" value="${option.id}">
                                                <label for="option${option.id}" class="custom-checkbox"></label>
                                                <label for="option${option.id}" class="checkbox-text">${option.optionText}</label>
                                            </li>
                                        </c:forEach>
                                    </c:if>
                                </ul>
                            </div>

                        </c:forEach>
                    </c:if>


                    <!-- Submit button -->
                    <div class="button-container">
                        <a href="/SocialPoll/results?pollId=${poll.get().id}" class="submit-button">Submit</a>
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