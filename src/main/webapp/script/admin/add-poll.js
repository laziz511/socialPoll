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

    questionDiv.appendChild(questionLabel);
    questionDiv.appendChild(questionInput);
    questionDiv.appendChild(answerOptionsLabel);
    questionDiv.appendChild(answerOptions);
    questionDiv.appendChild(addOptionButton);

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

const pollForm = document.getElementById("poll-form");
pollForm.addEventListener("submit", createPoll);

function createPoll(event) {
    event.preventDefault();

    // Gather the poll data and submit it to the server or store in the database
    // You can access the data using form elements and their values
    console.log("Poll data submitted:", pollForm);
}