<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>

<head>
    <title>Administrator Page - Create Polls</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link href="css/admin/add-poll.css" rel="stylesheet" type="text/css" media="all" />

    <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
</head>

<body>
    <!-- Poll Management Section -->
    <section>
        <div class="form-container">
            <h2>Create Polls</h2>

            <form id="poll-form" action="add-poll" method="post">

                <label for="poll-topic">Poll Topic:</label>
                <select id="poll-topic" name="topicId" required>
                    <option value="" disabled selected>Select a topic</option>
                    <option value="1">Family</option>
                    <option value="2">Environment</option>
                    <option value="3">Gender Equality</option>
                    <option value="4">Politics</option>
                    <!-- Add more topics as needed -->
                </select>

                <label for="poll-name">Poll Name:</label>
                <input type="text" name="pollName" id="poll-name" required>

                <label for="poll-description">Poll Description:</label>
                <input type="text" name="pollDescription" id="poll-description" required>



                <div id="questions-container">
                    <!-- Questions will be dynamically added here -->
                </div>

                <button type="button" onclick="addQuestion()">Add Question</button>
                <button type="submit" class="submit">Create Poll</button>

                <input type="hidden" id="questionCount" name="questionCount" value="0">
                <input type="hidden" id="optionCount" name="optionCount" value="0">

            </form>


        </div>
    </section>
    <!-- //Poll Management Section -->

    <script src="script/admin/add-poll.js"> </script>
</body>

</html>