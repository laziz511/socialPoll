function submitPoll(event) {
    event.preventDefault();
    var submissionText = document.getElementById('submission-text');
    submissionText.classList.remove('hidden');

    var submitButton = document.querySelector('.submit-button');
    submitButton.classList.add('hidden');

    var additionalButtons = document.getElementById('additionalButtons');
    additionalButtons.classList.remove('hidden');
}