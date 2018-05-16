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
    rowsEnter.merge(rows).html(answer => `<th>${answer.reasonerId}</th><td>${answer.message}</td>`);
}

const branchPropsKey = "treeBranchProps";
const treeBranchTextMax = 120;

function keyPrefix(key) {
    if(typeof key === "undefined") {
        return "";
    } else {
        return key + ": ";
    }
}

function renderTreeBranch(branch) {
    const props = branch[branchPropsKey];
    branch.innerHTML = "";
    if(props.collapsed) {
        let text = keyPrefix(props.key) + JSON.stringify(props.value);
        if(text.length > treeBranchTextMax) {
            text = text.substr(0, treeBranchTextMax - 3) + "..."
        }
        branch.append(document.createTextNode(text));
    } else {
        const value = props.value;
        if (typeof value === "object") {
            if(Array.isArray(value)) {
                branch.append(document.createTextNode("["));
                value.forEach(childValue => branch.append(createTreeBranch(childValue)));
                branch.append(document.createTextNode("]"));
            } else {
                branch.append(document.createTextNode("{"));
                Object.entries(value).forEach(
                    ([childKey, childValue]) => branch.append(createTreeBranch(childValue, childKey))
                );
                branch.append(document.createTextNode("}"));
            }
        } else {
            let text = keyPrefix(props.key) + JSON.stringify(props.value);
            branch.append(document.createTextNode(text));
        }
    }
}

function onTreeBranchClicked(event) {
    const props = this[branchPropsKey];
    props.collapsed = !(props.collapsed);
    renderTreeBranch(this);
    event.stopPropagation();
}

function createTreeBranch(value, key) {
    const branch = document.createElement("div");
    branch[branchPropsKey] = { key: key, value: value, collapsed: true };
    renderTreeBranch(branch);
    branch.setAttribute("class", "treeBranch");
    branch.onclick = onTreeBranchClicked;
    return branch;
}

function plantTree() {
    const node = d3.select("#answersTree").node();
    node.innerHTML = "";
    node.append(createTreeBranch(answers));
}

function displayAnswers() {
    const answersJsonPretty = JSON.stringify(answers, null, 2);
    d3.select("#answersRaw").property("value", answersJsonPretty);
    populateAnswerTable();
    plantTree();
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

const exampleInput = "What are targets of aspirin?";

function setExample() {
    d3.select("#input").property("value", exampleInput);
}
function clearInput() {
    d3.select("#input").property("value", "");
}
