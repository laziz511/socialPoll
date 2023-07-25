<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Poll Webpage</title>
    <link rel="stylesheet" href="../../css/user/poll.css">

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
                <h1 class="topic">Gender Equality Poll</h1>

                <form class="poll-form">
                    <div class="question-card">
                        <h2 class="question">Question 1: What is your opinion on the gender pay gap?</h2>
                        <ul class="answers">
                            <li class="custom-checkbox-container">
                                <input type="radio" name="q1" id="option1">
                                <label for="option1" class="custom-checkbox"></label>
                                <label for="option1" class="checkbox-text">Strongly Agree</label>
                            </li>
                            <li class="custom-checkbox-container">
                                <input type="radio" name="q1" id="option2">
                                <label for="option2" class="custom-checkbox"></label>
                                <label for="option2" class="checkbox-text">Agree</label>
                            </li>
                            <li class="custom-checkbox-container">
                                <input type="radio" name="q1" id="option3">
                                <label for="option3" class="custom-checkbox"></label>
                                <label for="option3" class="checkbox-text">Neutral</label>
                            </li>
                            <li class="custom-checkbox-container">
                                <input type="radio" name="q1" id="option4">
                                <label for="option4" class="custom-checkbox"></label>
                                <label for="option4" class="checkbox-text">Disagree</label>
                            </li>
                            <li class="custom-checkbox-container">
                                <input type="radio" name="q1" id="option5">
                                <label for="option5" class="custom-checkbox"></label>
                                <label for="option5" class="checkbox-text">Strongly Disagree</label>
                            </li>
                        </ul>
                    </div>

                    <div class="question-card">
                        <h2 class="question">Question 2: Do you think gender stereotypes impact career opportunities?
                        </h2>
                        <ul class="answers">
                            <li class="custom-checkbox-container">
                                <input type="radio" name="q2" id="option6">
                                <label for="option6" class="custom-checkbox"></label>
                                <label for="option6" class="checkbox-text">Yes</label>
                            </li>
                            <li class="custom-checkbox-container">
                                <input type="radio" name="q2" id="option7">
                                <label for="option7" class="custom-checkbox"></label>
                                <label for="option7" class="checkbox-text">No</label>
                            </li>
                            <li class="custom-checkbox-container">
                                <input type="radio" name="q2" id="option8">
                                <label for="option8" class="custom-checkbox"></label>
                                <label for="option8" class="checkbox-text">Not Sure</label>
                            </li>
                        </ul>
                    </div>

                    <div class="question-card">
                        <h2 class="question">Question 3: Should there be more initiatives to promote gender equality in
                            education?</h2>
                        <ul class="answers">
                            <li class="custom-checkbox-container">
                                <input type="radio" name="q3" id="option9">
                                <label for="option9" class="custom-checkbox"></label>
                                <label for="option9" class="checkbox-text">Definitely</label>
                            </li>
                            <li class="custom-checkbox-container">
                                <input type="radio" name="q3" id="option10">
                                <label for="option10" class="custom-checkbox"></label>
                                <label for="option10" class="checkbox-text">Maybe</label>
                            </li>
                            <li class="custom-checkbox-container">
                                <input type="radio" name="q3" id="option11">
                                <label for="option11" class="custom-checkbox"></label>
                                <label for="option11" class="checkbox-text">Not Necessary</label>
                            </li>
                        </ul>
                    </div>


                    <!-- Submit button and additional buttons -->
                    <div class="button-container">
                        <button type="submit" class="submit-button" onclick="submitPoll(event)">Submit</button>
                        <p id="submission-text" class="hidden">Poll is submitted.</p>
                        <div class="additional-buttons hidden" id="additionalButtons">

                            <a href="surveys.html" class="survey-button">Back to Surveys</a>
                            <a href="results.html" class="result-button">See Results</a>

                        </div>
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

    <script>

        function submitPoll(event) {
            event.preventDefault();
            var submissionText = document.getElementById('submission-text');
            submissionText.classList.remove('hidden');

            var submitButton = document.querySelector('.submit-button');
            submitButton.classList.add('hidden');

            var additionalButtons = document.getElementById('additionalButtons');
            additionalButtons.classList.remove('hidden');
        } 
    </script>

</body>

</html>