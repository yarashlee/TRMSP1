window.onload = function () {

    let parameters = location.search.substring(1).split("?");
    let param = parameters[0].split("=");

    let eventId = param[1];
    console.log(parameters);

    let form = document.getElementById("updateAfterGradeEmployee");
    form.action = "http://localhost:9099/updateEventGradeEmployee/" + eventId;

}

function myFunction() {
    location.replace("http://localhost:9099/regularemployeeHomePage.html")
  }