window.onload = function () {

    let parameters = location.search.substring(1).split("?");
    let param = parameters[0].split("=");

    let reimbursementId = param[1];
    console.log(parameters);

    let form = document.getElementById("reimbursementCancellation");
    form.action = "http://localhost:9099/updateReimEmployeeCancelation/" + reimbursementId;

}