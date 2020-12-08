window.onload = function () {

    // **************************** SHOW TABLE PERSONAL INFORMATION OF EMPLOYEE********************************/

    // ********************* SHOW TABLE WITH EMPLOYEE BY EMPLOYEE ID****/
    let xhr2 = new XMLHttpRequest();
    const url2 = "http://localhost:9099/getAllEmployeesById";
    xhr2.onreadystatechange = function () {
        console.log(xhr2.readyState);
        if (this.readyState == 4 && this.status == 200) {
            //console.log(xhr.responseText);
            let eventList = JSON.parse(xhr2.responseText);
            console.log(eventList);
            eventList.forEach(element => {
                let table = document.getElementById("employee-table");
                let tableRow = document.createElement("tr");
                let emfirstName = document.createElement("td");
                let emmiddleName = document.createElement("td");
                let emlastName = document.createElement("td");
                let emdateBirth = document.createElement("td");
                let emphoneNumber = document.createElement("td");
                let ememail = document.createElement("td");

                emfirstName.innerHTML = element.firstName;
                emmiddleName.innerHTML = element.middleName;
                emlastName.innerHTML = element.lastName;
                emdateBirth.innerHTML = element.dateBirth;
                emphoneNumber.innerHTML = element.phoneNumber;
                ememail.innerHTML = element.email;

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

    // ********************* SHOW TABLE WITH REIMBURSEMENTS BY EMPLOYEE ID****/
    let xhr = new XMLHttpRequest();
    const url = "http://localhost:9099/getReimbursementByEmployeeId";
    xhr.onreadystatechange = function () {
        console.log(xhr.readyState);
        if (this.readyState == 4 && this.status == 200) {
            //console.log(xhr.responseText);
            let reimbursementList = JSON.parse(xhr.responseText);
            console.log(reimbursementList);
            reimbursementList.forEach(element => {
                let table = document.getElementById("reimbursement-table");
                let tableRow = document.createElement("tr");
                let submit_date = document.createElement("td");
                let amount_requested = document.createElement("td");
                let adjusted_amount = document.createElement("td");
                let notes = document.createElement("td");
                let reimbursementStatusId = document.createElement("td");
                let uploads = document.createElement("td");
                let employeeCancellation = document.createElement("td");
                let update = document.createElement("td");

                submit_date.innerHTML = element.dateSubmition;
                amount_requested.innerHTML = "$ " + element.amountRequested;
                adjusted_amount.innerHTML = "$ " + element.adjustedAmount;
                notes.innerHTML = element.notes;
                /*hard code status*/
                let status = check_status(element.reimbursementStatusId);
                reimbursementStatusId.innerHTML = status;
                employeeCancellation.innerHTML = element.employeeCancellation;
                uploads.innerHTML = element.updateFileId;

                tableRow.appendChild(submit_date);
                tableRow.appendChild(amount_requested);
                tableRow.appendChild(adjusted_amount);
                tableRow.appendChild(notes);
                tableRow.appendChild(reimbursementStatusId);
                tableRow.appendChild(employeeCancellation);
                tableRow.appendChild(update);
                table.appendChild(tableRow);


                /***Update Grade****/
                let updateForm = document.createElement("form");
                updateForm.action = "reimbursementCancellation.html"
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

            });
        }
    }
    xhr.open("GET", url, true);
    xhr.send();


    // ********************* POPULATE TABLE WITH EVENT INFO BY EMPLOYEE ID****/
    let xhr1 = new XMLHttpRequest();
    const url1 = "http://localhost:9099/getEventByEmployeeId";
    xhr1.onreadystatechange = function () {
        console.log(xhr1.readyState);
        if (this.readyState == 4 && this.status == 200) {
            //console.log(xhr1.responseText);
            let eventList = JSON.parse(xhr1.responseText);
            console.log(eventList);
            eventList.forEach(element => {
                let table = document.getElementById("event-table");
                let tableRow = document.createElement("tr");
                let nameEvent = document.createElement("td");
                let description = document.createElement("td");
                let StartDate = document.createElement("td");
                let EndDate = document.createElement("td");
                let location = document.createElement("td");
                let employeeGrade = document.createElement("td");
                let gradeId = document.createElement("td");
                let update = document.createElement("td");
                let grade = check_grade(element.gradeId);

                nameEvent.innerHTML = element.name;
                description.innerHTML = element.description;
                StartDate.innerHTML = element.startDate;
                EndDate.innerHTML = element.endDate;
                location.innerHTML = element.location;
                employeeGrade.innerHTML = element.employeeGrade;
                gradeId.innerHTML = grade;

                tableRow.appendChild(nameEvent);
                tableRow.appendChild(description);
                tableRow.appendChild(StartDate);
                tableRow.appendChild(EndDate);
                tableRow.appendChild(location);
                tableRow.appendChild(employeeGrade);
                tableRow.appendChild(gradeId);
                tableRow.appendChild(update);
                table.appendChild(tableRow);

                /***Update Grade****/
                    let updateForm = document.createElement("form");
                    updateForm.action = "updateAfterGradeEmployee.html"
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
    xhr1.open("GET", url1, true);
    xhr1.send();

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

    function check_cancelation(employeeCancellation) {
        switch (employeeCancellation) {
            case "true":
                return "Cancel";
            case "false":
                return "Not Cancel";
        }
    }

}