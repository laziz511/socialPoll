<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Administrator Page - Manage Polls</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/admin/add-poll.css" rel="stylesheet" type="text/css" media="all" />
    <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
</head>
<body>
    <!-- Include the header -->
    <%@ include file="../fragments/header.jsp" %>

    <!-- Poll Management Section -->
    <section>
        <div class="form-container">
            <h2>Manage Poll</h2>
            <form id="manage-poll-form" method="post" action="/SocialPoll/manage-poll">
                <!-- Display the poll details for editing -->

                <!-- Add this hidden input field to send the pollId value -->
                <input type="hidden" name="pollId" value="${poll.id}" />


                <label for="pollName">Poll Name:</label>
                <input type="text" id="pollName" name="pollName" value="${poll.pollName}" required>

                <label for="description">Description:</label>
                <input type="text" id="description" name="description" value="${poll.description}" required>

                <!-- Display the questions and options for editing -->
                <div id="questions-container">
                    <c:forEach items="${poll.questions}" var="question" varStatus="counter">
                        <div class="question-container"  id="question-${question.id}">
                            <h3>Question ${counter.count}:</h3>
                            <input type="text" name="question_${question.id}" value="${question.questionText}" required readonly>

                            <label>Answer Options:</label>
                            <c:forEach items="${question.options}" var="option">
                                <input type="text" id="option_${option.id}" name="option_${option.id}" value="${option.optionText}" required readonly>
                            </c:forEach>

                           <button type="button" onclick="removeQuestion(${question.id})">Remove Question</button>

                        </div>
                    </c:forEach>
                </div>

                <div id="questions-container">
                <!-- Questions will be dynamically added here -->
                </div>

                 <input type="hidden" id="questionCount" name="questionCount" value="0">
                 <input type="hidden" id="optionCount" name="optionCount" value="0">


                <button type="button" onclick="addQuestion()">Add Question</button>

                <input type="hidden" id="removedQuestionsInput" name="removedQuestions" value="" />

                <button type="submit" class="submit" >Save Changes</button>
            </form>
        </div>
    </section>
    <!-- //Poll Management Section -->

    <!-- Include the footer -->
    <%@ include file="../fragments/footer.jsp" %>

    <script src="script/admin/manage-poll.js"></script>
</body>
</html>
