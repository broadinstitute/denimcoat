printTime(d3.select("#loadTime"));
setInterval(function () {
    printTime(d3.select("#nowTime"))
}, 200);

function printTime(element) {
    var nowTime = new Date();
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

var answers = {};

function clearAnswers() {
    answers = {};
}

function addAnswer(reasonerId, answer) {
    answers[reasonerId] = answer;
}

function displayAnswers() {
    var answersJsonPretty = JSON.stringify(answers, null, 2);
    d3.select("#answer").property("value", answersJsonPretty);
}

function submitQuestion() {
    var questionText = d3.select("#input").property("value").trim();
    if (questionText === "") {
        alert("Please enter a question to submit.")
    } else {
        var currentTimeInMs = new Date().getTime();
        var requestObject = {"text": questionText, "timestamp": currentTimeInMs};
        var requestJson = JSON.stringify(requestObject);
        var reasonerIds = getReasonerIds();
        if(reasonerIds.length === 0) {
            alert("Please check at least one reasoner.");
        } else {
            clearAnswers();
            reasonerIds.forEach(reasonerId => {
                var reasonerIdConst = reasonerId;
                var http = new XMLHttpRequest();
                http.onreadystatechange = function () {
                    if (this.readyState === 4) {
                        var responseJson = this.responseText;
                        var answer = JSON.parse(responseJson);
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

var exampleInput = "How many roads must a man walk down, before you call him a man?";

function setExample() {
    d3.select("#input").property("value", exampleInput);
}
function clearInput() {
    d3.select("#input").property("value", "");
}
