package TRMS.P1.controller;

import java.util.List;

import org.apache.log4j.Logger;

import TRMS.P1.pojo.Event;
import TRMS.P1.pojo.Reimbursement;
import TRMS.P1.service.FormService;
import TRMS.P1.service.FormServiceFS;
import io.javalin.http.Context;

public class FormController {
	
	FormService formService = new FormServiceFS();

	private static Logger log = Logger.getRootLogger();
	
	public void createEvent(Context ctx) {

		log.info("Form Controller --> create form --> event ");

		String name = ctx.formParam("name");

		String description = ctx.formParam("description");

		String startDate = ctx.formParam("startDate");

		String endDate = ctx.formParam("endDate");

		String location = ctx.formParam("location");
		
		int gradingFormatId = Integer.parseInt(ctx.formParam("gradingFormatId"));

		int eventTypeId = Integer.parseInt(ctx.formParam("eventTypeId"));
		
		Event event = new Event(eventTypeId, name, description, startDate, endDate, location, gradingFormatId);
		
		Event newlyCreated = formService.creatEvent(event);
		
		ctx.sessionAttribute("newEventId", newlyCreated.getEventId());
		
		ctx.redirect("http://localhost:9099/formReimbursement.html");

	}

	public void createReimbursement(Context ctx) {

		log.info("Form Controller --> create form --> reimbursement");

		int employeeId = ctx.cookieStore("id");
		
		int eventId = ctx.sessionAttribute("newEventId");

		String justification = ctx.formParam("justification");

		double amountRequested = Double.parseDouble(ctx.formParam("amountRequested"));
		
		Event ev = formService.readEvent(eventId);
		
		double adjustedAmount = calculateAdjustedAmount(amountRequested, ev.getEventTypeId());
		
		Reimbursement reimbursement = new Reimbursement(employeeId, eventId, justification, amountRequested,
				adjustedAmount);

		formService.createReimbursement(reimbursement);

		ctx.cookieStore("submitted", true);
		
		if (employeeId < 200) {
			ctx.redirect("regularemployeeHomePage.html");
		}
		if (employeeId >= 200 && employeeId < 300) {
			ctx.redirect("directSupervisorHomePage.html");
		}
		if (employeeId >= 300 && employeeId < 400) {
			ctx.redirect("departmentHomePage.html");
		}
		if (employeeId >= 400) {
			ctx.redirect("benCoHomePage.html");

		}

	}

	private double calculateAdjustedAmount(double amountRequested, int eventTypeId) {
		switch (eventTypeId) {
		case 1: // University Course
			return amountRequested * 0.8;
		case 2: // Seminar
			return amountRequested * 0.6;
		case 3: // Certification Preparation Classes
			return amountRequested * 0.75;
		case 4: // Certification Exam
			return amountRequested * 1.0;
		case 5: // Technical Training
			return amountRequested * 0.9;
		case 6: // Other
			return amountRequested * 0.3;
		}
		return 0;
	}

	public void getAllReimbursementByEmployeeId(Context ctx) {

		log.info("Form Controller --> getAllReimbursementByEmployeeId ");

		int employeeId = ctx.cookieStore("id");

		List<Reimbursement> getReimbursementList = formService.readReimbursementById(employeeId);

		ctx.json(getReimbursementList);
	}

	public void getAllEventByEmployeeId(Context ctx) {

		log.info("Form Controller --> getAllEventByEmployeeId ");

		int employeeId = ctx.cookieStore("id");

		List<Event> getEventList = formService.readEventById(employeeId);

		ctx.json(getEventList);
	}

	public void getEventsByReporsTo(Context ctx) {

		log.info("Form Controller --> getEventsByReporsTo ");

		int employeeId = ctx.cookieStore("id");

		List<Event> getEventByReporsToList = formService.readAllEventsByReportTo(employeeId);

		ctx.json(getEventByReporsToList);
	}

	public void getReimbursementByReporsTo(Context ctx) {

		log.info("Form Controller --> getReimbursementByReporsTo ");

		int employeeId = ctx.cookieStore("id");

		List<Reimbursement> getReimbursemenByReportsTotList = formService.readReimbursementByReportTo(employeeId);

		ctx.json(getReimbursemenByReportsTotList);
	}

	public void updateReimbursementDepHeadDate(Context ctx) {

		log.info("Form Controller --> updateReimbursementDepHeadDate ");

		int reimbursementId = Integer.parseInt(ctx.pathParam("reimbursementId"));

		String departmentHeadApprovalDate = ctx.formParam("departmentHeadApprovalDate");

		String notes = ctx.formParam("notes");

		Reimbursement reimbursement = new Reimbursement(departmentHeadApprovalDate, notes);

		formService.updateReimbursementDepHead(reimbursementId, reimbursement);

		// ctx.html(Integer.toString(reimbursement.getReimbursementId()));

		ctx.redirect("http://localhost:9099/reviewReimbursementDepHead.html");

	}

	public void updateReimbursementDirSupDate(Context ctx) {

		log.info("Form Controller --> updateReimbursementDirSupDate ");

		int reimbursementId = Integer.parseInt(ctx.pathParam("reimbursementId"));

		String directorSupervisorApprovalDate = ctx.formParam("directorSupervisorApprovalDate");

		String notes = ctx.formParam("notes");

		int reimbursementStatusId = Integer.parseInt(ctx.formParam("reimbursementStatusId"));

		Reimbursement reimbursement = new Reimbursement(directorSupervisorApprovalDate, null, reimbursementStatusId,
				notes);

		formService.updateReimbursementDirSup(reimbursementId, reimbursement);

		// ctx.html(Integer.toString(reimbursement.getReimbursementId()));

		ctx.redirect("http://localhost:9099/reviewReimbursementDirSup.html");
	}

	public void updateReimbursementBenCoDate(Context ctx) {

		log.info("Form Controller --> updateReimbursementBenCoDate ");

		int reimbursementId = Integer.parseInt(ctx.pathParam("reimbursementId"));

		String benCoApprovalDate = ctx.formParam("benCoApprovalDate");

		String notes = ctx.formParam("notes");

		int reimbursementStatusId = Integer.parseInt(ctx.formParam("reimbursementStatusId"));

		Reimbursement reimbursement = new Reimbursement(benCoApprovalDate, null, reimbursementStatusId, notes);

		formService.updateReimbursementBenCo(reimbursementId, reimbursement);

		// ctx.html(Integer.toString(reimbursement.getReimbursementId()));

		ctx.redirect("http://localhost:9099/reviewReimbursementBenCo.html");
	}

	public void updateEventGradeEmployee(Context ctx) {

		int employeeId = ctx.cookieStore("id");

		log.info("Form Controller --> updateEventGradeEmployee ");

		int eventId = Integer.parseInt(ctx.pathParam("eventId"));

		String employeeGrade = ctx.formParam("employeeGrade");

		Event event = new Event(employeeGrade);

		formService.updateEventGradeEmployee(eventId, event);

		// ctx.html(Integer.toString(event.getEventId()));

		ctx.redirect("http://localhost:9099/eventList.html");

	}

	public void updateReimEmployeeCancelation(Context ctx) {

		int employeeId = ctx.cookieStore("id");

		log.info("Form Controller --> updateReimEmployeeCancelation ");

		int reimbursementId = Integer.parseInt(ctx.pathParam("reimbursementId"));

		// int reimbursementId = Integer.parseInt(ctx.formParam("reimbursementId"));

		String employeeCancellation = ctx.formParam("employeeCancellation");

		Reimbursement reimbursement = new Reimbursement(employeeCancellation);

		formService.updateReimbursementCancellation(reimbursementId, reimbursement);

		ctx.redirect("http://localhost:9099/reimbursementLits.html");

		// ctx.html(Integer.toString(reimbursement.getReimbursementId()));

	}

	public void updateAdjustedAmount(Context ctx) {

		int employeeId = ctx.cookieStore("id");

		log.info("Form Controller --> updateAdjustedAmount");

		int reimbursementId = Integer.parseInt(ctx.pathParam("reimbursementId"));

		Double adjustedAmount = Double.parseDouble(ctx.formParam("adjustedAmount"));

		Reimbursement reimbursement = new Reimbursement(adjustedAmount);

		formService.updateAdjustedAmount(reimbursementId, reimbursement);

		ctx.redirect("http://localhost:9099/reviewReimbursementBenCo.html");

	}

	public void updateEventGradeBenco(Context ctx) {

		log.info("Form Controller --> updateEventGradeBenco ");

		int eventId = Integer.parseInt(ctx.pathParam("eventId"));

		int gradeId = Integer.parseInt(ctx.formParam("gradeId"));

		Event event = new Event(gradeId);

		formService.updateEventGradeBencoDirSup(eventId, event);

		// ctx.html(Integer.toString(event.getEventId()));

		ctx.redirect("http://localhost:9099/reviewReimbursementBenCo.html");
	}

	public void updateEventGradeDirSup(Context ctx) {

		log.info("Form Controller --> updateEventGradeBenco ");

		int eventId = Integer.parseInt(ctx.pathParam("eventId"));

		int gradeId = Integer.parseInt(ctx.formParam("gradeId"));

		Event event = new Event(gradeId);

		formService.updateEventGradeBencoDirSup(eventId, event);

		// ctx.html(Integer.toString(event.getEventId()));

		ctx.redirect("http://localhost:9099/reviewReimbursementDirSup.html");

	}

	public void getAllEvents(Context ctx) {

		log.info("Form Controller --> read all events");

		List<Event> getAllEvents = formService.readAllEvents();

		ctx.json(getAllEvents);

	}

	public void getAllReimbursement(Context ctx) {

		log.info("form Controller --> read all reimbursement");

		List<Reimbursement> getAllReimbursement = formService.readAllReimbursements();

		ctx.json(getAllReimbursement);

	}

}
