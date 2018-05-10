printTime(d3.select("#loadTime"));
setInterval(function () {
    printTime(d3.select("#nowTime"))
}, 200);

function printTime(element) {
    const nowTime = new Date();
    element.html(nowTime.toLocaleTimeString());
}

d3.select("#inputSubmitButton").on("click", submitQuestion);
d3.select("#inputExampleButton").on("click", setExample);
d3.select("#inputClearButton").on("click", clearInput);


function getReasonerIds(){
    return d3.selectAll(".reasoners").nodes().filter(element => element.checked).map(element => element.value);
}

function getReasonerUrl(reasonerId) {
    return "/reasoner/" + reasonerId;
}

let answers = {};

function clearAnswers() {
    answers = {};
}

function addAnswer(reasonerId, answer) {
    answers[reasonerId] = answer;
}

function answersAsArray() {
    return Object.entries(answers).map(entry => {
        const answerWithKey = entry[1];
        answerWithKey["reasonerId"] = entry[0];
        return answerWithKey;
    })
}

function populateAnswerTable() {
    const answersArray = answersAsArray();
    const rows = d3.select("#answersTable").selectAll("tr").data(answersArray, answer => answer.reasonerId);
    const rowsEnter = rows.enter().append("tr");
    rows.exit().remove();
    rowsEnter.merge(rows).html(answer => `<th>${answer.reasonerId}</th><td>${answer.text}</td>`);
}

function displayAnswers() {
    const answersJsonPretty = JSON.stringify(answers, null, 2);
    d3.select("#answersRaw").property("value", answersJsonPretty);
    populateAnswerTable();
}

function submitQuestion() {
    const questionText = d3.select("#input").property("value").trim();
    if (questionText === "") {
        alert("Please enter a question to submit.")
    } else {
        const currentTimeInMs = new Date().getTime();
        const requestObject = {"text": questionText, "timestamp": currentTimeInMs};
        const requestJson = JSON.stringify(requestObject);
        const reasonerIds = getReasonerIds();
        if(reasonerIds.length === 0) {
            alert("Please check at least one reasoner.");
        } else {
            clearAnswers();
            reasonerIds.forEach(reasonerId => {
                const reasonerIdConst = reasonerId;
                const http = new XMLHttpRequest();
                http.onreadystatechange = function () {
                    if (this.readyState === 4) {
                        const responseJson = this.responseText;
                        const answer = JSON.parse(responseJson);
                        addAnswer(reasonerIdConst, answer);
                        displayAnswers();
                    }
                };
                http.open("POST", getReasonerUrl(reasonerId), true);
                http.setRequestHeader("Content-type", "application/json");
                http.send(requestJson);
            })
        }
    }
}

const exampleInput = "How many roads must a man walk down, before you call him a man?";

function setExample() {
    d3.select("#input").property("value", exampleInput);
}
function clearInput() {
    d3.select("#input").property("value", "");
}
