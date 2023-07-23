let questionCounter = 0;

function addQuestion() {
    if (questionCounter >= 20) {
        alert("You can create up to 20 questions.");
        return;
    }

    questionCounter++;

    const questionsContainer = document.getElementById("questions-container");

    const questionDiv = document.createElement("div");
    questionDiv.classList.add("question");

    const questionLabel = document.createElement("label");
    questionLabel.textContent = `Question ${questionCounter}:`;

    const questionInput = document.createElement("input");
    questionInput.type = "text";
    questionInput.name = `question${questionCounter}`;
    questionInput.placeholder = "Write your question here";
    questionInput.required = true;

    const answerOptionsLabel = document.createElement("label");
    answerOptionsLabel.textContent = "Answer Options:";

    const answerOptions = document.createElement("div");
    answerOptions.classList.add("answer-options");

    for (let i = 1; i <= 3; i++) {
        const optionInput = document.createElement("input");
        optionInput.type = "text";
        optionInput.name = `question${questionCounter}-option${i}`;
        optionInput.placeholder = `Option ${i}`;
        optionInput.required = true;
        answerOptions.appendChild(optionInput);
    }

    const addOptionButton = document.createElement("button");
    addOptionButton.textContent = "Add Option";
    addOptionButton.type = "button";
    addOptionButton.onclick = function () {
        addOption(answerOptions);
    };

    const removeQuestionButton = document.createElement("button");
    removeQuestionButton.textContent = "Remove Question";
    removeQuestionButton.type = "button";
    removeQuestionButton.onclick = function () {
        questionsContainer.removeChild(questionDiv);
        questionCounter--;
    };

    questionDiv.appendChild(questionLabel);
    questionDiv.appendChild(questionInput);
    questionDiv.appendChild(answerOptionsLabel);
    questionDiv.appendChild(answerOptions);
    questionDiv.appendChild(addOptionButton);
    questionDiv.appendChild(removeQuestionButton);

    questionsContainer.appendChild(questionDiv);
}

function addOption(answerOptions) {
    if (answerOptions.children.length >= 5) {
        alert("You can add up to 5 answer options.");
        return;
    }

    const optionInput = document.createElement("input");
    optionInput.type = "text";
    optionInput.name = `question${questionCounter}-option${answerOptions.children.length + 1}`;
    optionInput.placeholder = `Option ${answerOptions.children.length + 1}`;
    optionInput.required = true;
    answerOptions.appendChild(optionInput);
}

const managePollForm = document.getElementById("manage-poll-form");
managePollForm.addEventListener("submit", saveChanges);

function saveChanges(event) {
    event.preventDefault();

    // Save the changes to the server or update the database
    // You can access the data using form elements and their values
    console.log("Changes saved:", managePollForm);
}

// Load existing questions and answer options on page load
document.addEventListener("DOMContentLoaded", function () {
    const existingQuestions = [
        // You can load existing questions and answer options from the server or database here
        {
            question: "Question 1",
            options: ["Option 1", "Option 2", "Option 3"],
        },
        {
            question: "Question 2",
            options: ["Option 1", "Option 2", "Option 3", "Option 4"],
        },
        // Add more questions and options as needed
    ];

    existingQuestions.forEach((questionData) => {
        questionCounter++;

        const questionsContainer = document.getElementById("questions-container");

        const questionDiv = document.createElement("div");
        questionDiv.classList.add("question");

        const questionLabel = document.createElement("label");
        questionLabel.textContent = `Question ${questionCounter}:`;

        const questionInput = document.createElement("input");
        questionInput.type = "text";
        questionInput.name = `question${questionCounter}`;
        questionInput.value = questionData.question;
        questionInput.required = true;

        const answerOptionsLabel = document.createElement("label");
        answerOptionsLabel.textContent = "Answer Options:";

        const answerOptions = document.createElement("div");
        answerOptions.classList.add("answer-options");

        questionData.options.forEach((optionText, index) => {
            const optionInput = document.createElement("input");
            optionInput.type = "text";
            optionInput.name = `question${questionCounter}-option${index + 1}`;
            optionInput.value = optionText;
            optionInput.required = true;
            answerOptions.appendChild(optionInput);
        });

        const addOptionButton = document.createElement("button");
        addOptionButton.textContent = "Add Option";
        addOptionButton.type = "button";
        addOptionButton.onclick = function () {
            addOption(answerOptions);
        };

        const removeQuestionButton = document.createElement("button");
        removeQuestionButton.textContent = "Remove Question";
        removeQuestionButton.type = "button";
        removeQuestionButton.onclick = function () {
            questionsContainer.removeChild(questionDiv);
            questionCounter--;
        };

        questionDiv.appendChild(questionLabel);
        questionDiv.appendChild(questionInput);
        questionDiv.appendChild(answerOptionsLabel);
        questionDiv.appendChild(answerOptions);
        questionDiv.appendChild(addOptionButton);
        questionDiv.appendChild(removeQuestionButton);

        questionsContainer.appendChild(questionDiv);
    });
});
