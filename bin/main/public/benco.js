window.onload = function () {

    let xhr2 = new XMLHttpRequest();
    const url2 = "http://localhost:9099/readAllEmployee";
    xhr2.onreadystatechange = function () {
        console.log(xhr2.readyState);
        if (this.readyState == 4 && this.status == 200) {
            //console.log(xhr.responseText);
            let eventList = JSON.parse(xhr2.responseText);
            console.log(eventList);
            eventList.forEach(element => {
                let table = document.getElementById("allEmployee-table");
                let tableRow = document.createElement("tr");
                let employeeId = document.createElement("td");
                let emfirstName = document.createElement("td");
                let emmiddleName = document.createElement("td");
                let emlastName = document.createElement("td");
                let emdateBirth = document.createElement("td");
                let emphoneNumber = document.createElement("td");
                let ememail = document.createElement("td");

                employeeId.innerHTML = element.employeeId;
                emfirstName.innerHTML = element.firstName;
                emmiddleName.innerHTML = element.middleName;
                emlastName.innerHTML = element.lastName;
                emdateBirth.innerHTML = element.dateBirth;
                emphoneNumber.innerHTML = element.phoneNumber;
                ememail.innerHTML = element.email;

                tableRow.appendChild(employeeId);
                tableRow.appendChild(emfirstName);
                tableRow.appendChild(emmiddleName);
                tableRow.appendChild(emlastName);
                tableRow.appendChild(emdateBirth);
                tableRow.appendChild(emphoneNumber);
                tableRow.appendChild(ememail);
                table.appendChild(tableRow);
            });
        }
    }
    xhr2.open("GET", url2, true);
    xhr2.send();

    // ********************* POPULATE TABLE WITH REIMBURSEMENT INFO BY EMPLOYEE ID REPORTS TO****/

    let xhr4 = new XMLHttpRequest();
    const url4 = "http://localhost:9099/getAllReimbursement";
    xhr4.onreadystatechange = function () {
        console.log(xhr4.readyState);
        if (this.readyState == 4 && this.status == 200) {
            //console.log(xhr.responseText);
            let reimbursementListRepostTo = JSON.parse(xhr4.responseText);
            console.log(reimbursementListRepostTo);
            reimbursementListRepostTo.forEach(element => {
                let table = document.getElementById("getAllReimbursement-table");
                let tableRow = document.createElement("tr");
                let employee_Id = document.createElement("td");
                let event_IdReim = document.createElement("td");
                let submit_date = document.createElement("td");
                let employeeCancellation = document.createElement("td");
                let justification = document.createElement("td");
                let amount_requested = document.createElement("td");
                let adjusted_amount = document.createElement("td");
                let dephead_approval_date = document.createElement("td");
                let dirsup_approval_date = document.createElement("td");
                let benco_approval_date = document.createElement("td");
                let notes = document.createElement("td");
                let reimbursementStatusId = document.createElement("td");
                let update = document.createElement("td");
                let updateAmount = document.createElement("td");

                employee_Id.innerHTML = element.employeeId;
                event_IdReim.innerHTML = element.eventId;
                submit_date.innerHTML = element.dateSubmition;
                employeeCancellation.innerHTML = element.employeeCancellation;
                justification.innerHTML = element.justification;
                amount_requested.innerHTML = "$ " + element.amountRequested;
                adjusted_amount.innerHTML = "$ " + element.adjustedAmount;
                dephead_approval_date.innerHTML = element.departmentHeadApprovalDate;
                dirsup_approval_date.innerHTML = element.directorSupervisorApprovalDate;
                benco_approval_date.innerHTML = element.benCoApprovalDate;
                notes.innerHTML = element.notes;
                /*hard code status*/
                let status = check_status(element.reimbursementStatusId);
                reimbursementStatusId.innerHTML = status;


                tableRow.appendChild(employee_Id);
                tableRow.appendChild(event_IdReim);
                tableRow.appendChild(submit_date);
                tableRow.appendChild(employeeCancellation);
                tableRow.appendChild(justification);
                tableRow.appendChild(amount_requested);
                tableRow.appendChild(adjusted_amount);
                tableRow.appendChild(dephead_approval_date);
                tableRow.appendChild(dirsup_approval_date);
                tableRow.appendChild(benco_approval_date);
                tableRow.appendChild(notes);
                tableRow.appendChild(reimbursementStatusId);
                tableRow.appendChild(update);
                tableRow.appendChild(updateAmount);
                table.appendChild(tableRow);

                /***Update Note & Status****/
                let updateForm = document.createElement("form");
                updateForm.action = "updateNoteStatusBenco.html"
                let input1 = document.createElement("input");
                let input2 = document.createElement("input");

                input1.type = "hidden";
                input1.name = "reimbursementId"
                input1.value = element.reimbursementId;

                input2.type = "submit";
                input2.className = "btn btn-outline-primary";
                input2.value = "Update";

                updateForm.appendChild(input1);
                updateForm.appendChild(input2);

                update.appendChild(updateForm);

                /***Update Amount****/
                let updateAmountForm = document.createElement("form");
                updateAmountForm.action = "updateAdjustedAmountBenCo.html"
                let input3 = document.createElement("input");
                let input4 = document.createElement("input");

                input3.type = "hidden";
                input3.name = "reimbursementId"
                input3.value = element.reimbursementId;

                input4.type = "submit";
                input4.className = "btn btn-outline-primary";
                input4.value = "Update";

                updateAmountForm.appendChild(input3);
                updateAmountForm.appendChild(input4);

                updateAmount.appendChild(updateAmountForm);


            });
        }
    }
    xhr4.open("GET", url4, true);
    xhr4.send();

    // ********************* POPULATE TABLE WITH EVENT INFO BY EMPLOYEE ID REPORTS TO****/
    let xhr5 = new XMLHttpRequest();
    const url5 = "http://localhost:9099/getAllEvents";
    xhr5.onreadystatechange = function () {
        console.log(xhr5.readyState);
        if (this.readyState == 4 && this.status == 200) {
            //console.log(xhr.responseText);
            let reimbursementListRepostTo = JSON.parse(xhr5.responseText);
            console.log(reimbursementListRepostTo);
            reimbursementListRepostTo.forEach(element => {
                let table = document.getElementById("getAllEvents-table");
                let tableRow = document.createElement("tr");
                let eventId = document.createElement("td");
                let eventTypeId = document.createElement("td");
                let name = document.createElement("td");
                let description = document.createElement("td");
                let startDate = document.createElement("td");
                let endDate = document.createElement("td");
                let location = document.createElement("td");
                let gradingFormatId = document.createElement("td");
                let employeeGrade = document.createElement("td");
                let gradeId = document.createElement("td");
                let update = document.createElement("td");


                eventId.innerHTML = element.eventId;
                /* hard code event type id*/
                let eventType = check_event(element.eventTypeId);
                eventTypeId.innerHTML = eventType;
                name.innerHTML = element.name;
                description.innerHTML = element.description;
                startDate.innerHTML = element.startDate;
                endDate.innerHTML = element.endDate;
                location.innerHTML = "$ " + element.location;
                /* hard code grade format id*/
                let gradeFormat = check_gradeFormat(element.gradingFormatId);
                gradingFormatId.innerHTML = gradeFormat;

                employeeGrade.innerHTML = element.employeeGrade;
                /* hard code grade id*/
                let grade = check_grade(element.gradeId);
                gradeId.innerHTML = grade;

                tableRow.appendChild(eventId);
                tableRow.appendChild(eventTypeId);
                tableRow.appendChild(name);
                tableRow.appendChild(description);
                tableRow.appendChild(startDate);
                tableRow.appendChild(endDate);
                tableRow.appendChild(location);
                tableRow.appendChild(gradingFormatId);
                tableRow.appendChild(employeeGrade);
                tableRow.appendChild(gradeId);
                tableRow.appendChild(update);
                table.appendChild(tableRow);

                /***Update Grade****/
                let updateForm = document.createElement("form");
                updateForm.action = "updateGradeBenCo.html"
                let input1 = document.createElement("input");
                let input2 = document.createElement("input");

                input1.type = "hidden";
                input1.name = "eventId"
                input1.value = element.eventId;

                input2.type = "submit";
                input2.className = "btn btn-outline-primary";
                input2.value = "Update";

                updateForm.appendChild(input1);
                updateForm.appendChild(input2);

                update.appendChild(updateForm);
            });
        }
    }
    xhr5.open("GET", url5, true);
    xhr5.send();

    function check_status(status) {
        switch (status) {
            case 1:
                return "Pending";
            case 2:
                return "Grade Pending";
            case 3:
                return "Approval Pending";
            case 4:
                return "Awarded";
            case 5:
                return "Cancelled";
            case 6:
                return "Urgent";
            case 7:
                return "Denied";
        }
    }

    function check_grade(grade) {
        switch (grade) {
            case 0:
                return "None";
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            case 4:
                return "D";
            case 5:
                return "F";
        }
    }


    function check_event(event) {
        switch (event) {
            case 1:
                return "University Course";
            case 2:
                return "Seminar";
            case 3:
                return "Certification Preparation Classes";
            case 4:
                return "Certification Exam";
            case 5:
                return "Technical Training";
            case 6:
                return "Other";

        }
    }

    function check_gradeFormat(gradeFormat) {
        switch (gradeFormat) {
            case 1:
                return "Letter grading and variations";
            case 2:
                return "Percentage Grading";
            case 3:
                return "Pass/Fail";
            case 4:
                return "Reference Grade";
        }
    }
}