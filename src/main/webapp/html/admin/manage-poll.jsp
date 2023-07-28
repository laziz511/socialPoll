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
                <h2>Manage Polls</h2>
                <form id="manage-poll-form">
                    <div id="questions-container">
                        <!-- Questions will be dynamically added here -->
                    </div>

                    <button type="button" onclick="addQuestion()">Add Question</button>
                    <button type="submit">Save Changes</button>
                </form>
            </div>
        </section>
        <!-- //Poll Management Section -->

        <!-- footer start -->
        <%@ include file="../fragments/footer.jsp" %>
            <!-- footer end -->

            <script src="script/admin/manage-poll.js"></script>
</body>

</html>