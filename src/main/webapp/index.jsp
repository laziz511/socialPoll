<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/user/home.css">
    <link rel="stylesheet" media="all" type="text/css" href="https://www.typeform.com/fonts/font-subset.css"
        fetchpriority="low" />
</head>

<body>
    <!-- navbar start -->
    <div class="navbar">
        <div class="navbar-container">

            <div class="logo-container">
                <svg fill="none" viewBox="0 0 245 55" width="100"></svg>
                <h1>My Voice</h1>
            </div>

            <div class="navbar-menu">
                <a href="home" class="navbar-menu-element">Home</a>
                <a href="admin-dashboard" class="navbar-menu-element"> My polls</a>
                <a href="#" class="navbar-menu-element">My Submissions</a>
                <a href="log-in" class="navbar-menu-element">Log in</a>
            </div>

        </div>
    </div>
    <!-- navbar end -->


    <!-- main-section start -->
    <div class="main-section">

        <!-- landing-page start -->
        <div class="landing-page-section">
            <div class="landing-page background">
                <section class="introduction-section">
                    <h1 class="title">Easy survey maker: ask with style</h1>
                    <div class="description">
                        <p>Typeforms are more engaging, so you get more responses: 95%
                            of our users get more data, more easily after switching to Typeform.</p>
                    </div>

                </section>
            </div>
        </div>
        <!-- landing-page end -->


        <section>
            <div class="balanced-section center1 background">
                <div class="image-container">
                    <img src="https://images.ctfassets.net/co0pvta7hzrh/1I2vFuMaY9YAlILzOsKaeU/995863a599e70869fe56a687f9b16619/fdeecc1e-logic-jumps_10s00oo000000000000028__1_.png?fm=webp&amp;q=75"
                        class="image-align" />
                </div>

                <div class="heading-container">
                    <h2 class="text-box">Quality, actionable data</h2>
                </div>

                <div class="para-box">
                    <p>Typeform responds to previous answers to show only the most relevant questions. A
                        better experience for respondents = better data for you, presented in clear
                        reports and metrics.</p>
                </div>
            </div>
        </section>


         <!-- Survey topics start -->
                <section>
                    <div class="poll-section">
                        <div class="container">
                            <h2 class="text-box">Poll Topics</h2>
                            <div class="cards">
                                <c:forEach items="${requestScope.pollTopics}" var="topic">
                                    <div class="card">
                                        <h2 class="topic">${topic.topicName}</h2>
                                        <p class="description">${topic.description}</p>
                                        <div class="info">
                                            <div class="info-text">
                                                <p class="survey-count">Polls: <span>${topic.numPolls}</span></p>
                                                <p class="participant-count">Participants: <span>${topic.numParticipants}</span></p>
                                            </div>
                                            <div class="info-button">
                                                <div>
                                                    <a href="polls.jsp?topicId=${topic.id}" class="button">See Polls</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- Survey topics end -->


        <section>
            <div class="balanced-section center2 background">
                <div class="image-container"><img
                        src="https://images.ctfassets.net/co0pvta7hzrh/yQdeEnCIVwAoOoDC6wcaa/4bdf10e0cd6de3b4c001505d4ea0482b/Frame_1347.png?fm=webp&amp;q=75"
                        width="1016" height="1052" class="image-align" /></div>

                <div class="heading-container">
                    <h2 class="text-box">Time-saving simplicity</h2>
                </div>

                <div class="para-box">
                    <p> Typeforms are quick and easy to build: set up and share a beautiful survey in
                        minutes. Use Integrations to automatically send data wherever you want it. Zero
                        coding or onboarding needed.</p>
                </div>
            </div>
        </section>

        <!-- footer start -->
        <section>
            <footer class="footer-section">

                <span>This is a footer</span>

                <span> My Voice</span>
            </footer>
        </section>
        <!-- footer end -->

    </div>

</body>

</html>