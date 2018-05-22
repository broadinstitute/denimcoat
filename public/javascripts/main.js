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

function getDefaultReasonerUrl(reasonerId) {
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

function forEachButLast(array, forNonLast, forLast) {
    const length = array.length;
    if(length > 0) {
        let i;
        for(i = 0; i < length - 1; i++) {
            forNonLast(array[i]);
        }
        forLast(array[length - 1]);
    }
}

function renderTreeBranch(branch) {
    const props = branch[branchPropsKey];
    branch.innerHTML = "";
    const trailer = props.isLast ? "" : ",";
    if(props.collapsed) {
        let text = keyPrefix(props.key) + JSON.stringify(props.value);
        if(text.length > treeBranchTextMax) {
            text = text.substr(0, treeBranchTextMax - 3) + "...";
        }
        branch.append(document.createTextNode(text + trailer));
    } else {
        const value = props.value;
        if (typeof value === "object") {
            if(Array.isArray(value)) {
                branch.append(document.createTextNode(keyPrefix(props.key) + "["));
                forEachButLast(value,
                    childValue => branch.append(createTreeBranch(childValue)),
                    childValue => branch.append(createTreeBranch(childValue, undefined, true)),
                );
                branch.append(document.createTextNode("]" + trailer));
            } else {
                branch.append(document.createTextNode(keyPrefix(props.key) + "{"));
                forEachButLast(Object.entries(value),
                    ([childKey, childValue]) => branch.append(createTreeBranch(childValue, childKey)),
                    ([childKey, childValue]) => branch.append(createTreeBranch(childValue, childKey, true)),
                );
                branch.append(document.createTextNode("}" + trailer));
            }
        } else {
            const text = keyPrefix(props.key) + JSON.stringify(props.value) + trailer;
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

function createTreeBranch(value, key, isLast = false) {
    const branch = document.createElement("div");
    branch[branchPropsKey] = { key: key, value: value, collapsed: true, isLast: isLast };
    renderTreeBranch(branch);
    branch.setAttribute("class", "treeBranch");
    branch.onclick = onTreeBranchClicked;
    return branch;
}

function plantTree() {
    const node = d3.select("#answersTree").node();
    node.innerHTML = "";
    node.append(createTreeBranch(answers, undefined, true));
}

function displayAnswers() {
    const answersJsonPretty = JSON.stringify(answers, null, 2);
    d3.select("#answersRaw").property("value", answersJsonPretty);
    populateAnswerTable();
    plantTree();
}

function createDefaultRequest(questionText) {
    const currentTimeInMs = new Date().getTime();
    return {"text": questionText, "timestamp": currentTimeInMs};
}

function receiveResponse() {
    if (this.readyState === 4) {
        const responseJson = this.responseText;
        const answer = JSON.parse(responseJson);
        addAnswer(this.reasonerId, answer);
        displayAnswers();
    }
}

class ReasonerHttpRequest extends XMLHttpRequest {
    constructor(reasonerId) {
        super();
        this.reasonerId = reasonerId;
    }
}

function submitReasonerRequest(reasonerId, url, request, responseHandler) {
    const http = new ReasonerHttpRequest(reasonerId);
    http.onreadystatechange = responseHandler;
    http.open("POST", url, true);
    http.setRequestHeader("Content-type", "application/json");
    http.setRequestHeader("Accept", "application/json");
    http.send(JSON.stringify(request));
}

function queryDefaultReasoner(reasonerId, questionText) {
    const url = getDefaultReasonerUrl(reasonerId);
    const request = createDefaultRequest(questionText);
    submitReasonerRequest(reasonerId, url, request, receiveResponse);
}

function queryRtxReasoner(reasonerId, questionText) {
    const translateRequest = { language: "English", text: questionText};
    const baseUrl = "https://rtx.ncats.io/api/rtx/v1";
    const translateUrl = baseUrl + "/translate";
    function handleTranslateResponse() {
        if (this.readyState === 4) {
            const queryUrl = baseUrl + "/query";
            const queryRequest = JSON.parse(this.responseText);
            submitReasonerRequest(reasonerId, queryUrl, queryRequest, receiveResponse);
        }
    }
    submitReasonerRequest(reasonerId, translateUrl, translateRequest, handleTranslateResponse);
}

function queryIndigoReasoner(reasonerId, questionText) {
    const baseUrl = "https://indigo.ncats.io/reasoner/api/v0";
    const queryUrl = baseUrl + "/query";
    const queryRequest = { terms: { disease: "headache", drug: "aspirin"}, type: "cop"};
    submitReasonerRequest(reasonerId, queryUrl, queryRequest, receiveResponse);
}

function submitQuestion() {
    const questionText = d3.select("#input").property("value").trim();
    if (questionText === "") {
        alert("Please enter a question to submit.")
    } else {
        const reasonerIds = getReasonerIds();
        if(reasonerIds.length === 0) {
            alert("Please check at least one reasoner.");
        } else {
            clearAnswers();
            reasonerIds.forEach(reasonerId => {
                if(reasonerId === "rtx") {
                    queryRtxReasoner(reasonerId, questionText);
                } else if(reasonerId === "indigo") {
                    queryIndigoReasoner(reasonerId, questionText);
                } else {
                    queryDefaultReasoner(reasonerId, questionText);
                }
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

const cy = cytoscape({
    container: d3.select("#cytoscape").node(),
    elements: [ // list of graph elements to start with
        { // node a
            data: { id: 'a' }
        },
        { // node b
            data: { id: 'b' }
        },
        { // edge ab
            data: { id: 'ab', source: 'a', target: 'b' }
        }
    ],
    style: [ // the stylesheet for the graph
        {
            selector: 'node',
            style: {
                'background-color': '#666',
                'label': 'data(id)'
            }
        },
        {
            selector: 'edge',
            style: {
                'width': 3,
                'line-color': '#ccc',
                'target-arrow-color': '#ccc',
                'target-arrow-shape': 'triangle'
            }
        }
    ],
    layout: {
        name: 'grid',
        rows: 1
    }
});
