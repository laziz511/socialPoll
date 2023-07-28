<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="css/admin/admin-dashboard.css">
</head>

<body>
    <!-- Include the header -->
    <%@ include file="../fragments/header.jsp" %>

        <!-- landing-page start -->
        <div class="landing-page-section">
            <div class="landing-page background">
                <section class="introduction-section">
                    <h1 class="title">Easy survey maker: ask with style</h1>
                    <div class="description">
                        <p>Typeforms are more engaging, so you get more responses: 95%
                            of our users get more data, more easily after switching to Typeform.</p>
                    </div>
                    <div class="main-section">
                        <a href="add-poll" class="survey-button">create polls</a>
                        <a href="admin-polls" class="survey-button">manage polls</a>
                    </div>

                </section>
            </div>
        </div>
        <!-- landing-page end -->


        <!-- footer start -->
        <%@ include file="../fragments/footer.jsp" %>
            <!-- footer end -->

</body>

</html>