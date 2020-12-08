package TRMS.P1.driver;

import TRMS.P1.controller.AuthorizationLogInController;
import TRMS.P1.controller.EmployeeController;
import TRMS.P1.controller.FormController;
import io.javalin.Javalin;

public class ServerDriver {
	
	private static EmployeeController employeeController = new EmployeeController();

	private static FormController formController = new FormController();
	
	private static AuthorizationLogInController authorizationLogInController = new AuthorizationLogInController();

	public static void main(String[] args) {

		Javalin app=Javalin.create(config -> {config.addStaticFiles("/public");}).start(9099);

		
		app.get("/HelloYara", ctx -> ctx.html("Hello Yara!"));
		
		/*
		 * Employee's Log in
		 */
		app.post("/logIn", ctx -> authorizationLogInController.logIn(ctx));

		/*
		 * Employee
		 */

		app.post("/readEmployee", ctx -> employeeController.getEmployee(ctx));

		app.get("/readAllEmployee", ctx -> employeeController.getAllEmployees(ctx));
		
		app.get("/getAllEmployeesById", ctx -> employeeController.getAllEmployeesById(ctx));

		app.put("/updateEmployee", ctx -> employeeController.updateEmployee(ctx));
		
		app.get("/getAllEmployeesByReportsTo", ctx -> employeeController.getAllEmployeesByReportsTo(ctx));
		

		/*
		 * Form
		 */
		
		app.get("/goToForm", ctx -> ctx.redirect("form.html"));	
		
		app.get("/GoLogIn", ctx -> ctx.redirect("logIn.html"));	
		
		app.post("/createEvent", ctx -> formController.createEvent(ctx));
		
		app.post("/createReimbursement", ctx -> formController.createReimbursement(ctx));
		
		app.get("/getEventByEmployeeId", ctx -> formController.getAllEventByEmployeeId(ctx));
		
		app.get("/getReimbursementByEmployeeId", ctx -> formController.getAllReimbursementByEmployeeId(ctx));
		
		app.get("/getEventsByReporsTo", ctx -> formController.getEventsByReporsTo(ctx));
		
		app.get("/getReimbursementByReporsTo", ctx -> formController.getReimbursementByReporsTo(ctx));
		
		app.post("/updateReimbursementDirSupDate/:reimbursementId", ctx -> formController.updateReimbursementDirSupDate(ctx)); 
		
		app.post("/updateReimbursementDepHeadDate/:reimbursementId", ctx -> formController.updateReimbursementDepHeadDate(ctx)); 
		
		app.post("/updateReimbursementBenCoDate/:reimbursementId", ctx -> formController.updateReimbursementBenCoDate(ctx)); 
		
		app.post("/updateEventGradeEmployee/:eventId", ctx -> formController.updateEventGradeEmployee(ctx));
		
		app.post("/updateEventGradeBenco/:eventId", ctx -> formController.updateEventGradeBenco(ctx));
		
		app.post("/updateEventGradeDirSup/:eventId", ctx -> formController.updateEventGradeDirSup(ctx));
				
		app.get("/getAllEvents", ctx -> formController.getAllEvents(ctx));
		
		app.get("/getAllReimbursement", ctx -> formController.getAllReimbursement(ctx));
		
		app.post("/updateReimEmployeeCancelation/:reimbursementId", ctx -> formController.updateReimEmployeeCancelation(ctx)); 
		
		app.post("/updateAdjustedAmount/:reimbursementId",  ctx -> formController.updateAdjustedAmount(ctx));
		
		//app.post("/updateReimEmployeeCancelation", ctx -> formController.updateReimEmployeeCancelation(ctx)); 
		

		
	}

}
