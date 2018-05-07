printTime(d3.select("#loadTime"));
setInterval(function () {
    printTime(d3.select("#nowTime"))
}, 200);

function printTime(element) {
    var nowTime = new Date();
    element.html(nowTime.toLocaleTimeString());
}

d3.select("#greeting").style("color", "red");
