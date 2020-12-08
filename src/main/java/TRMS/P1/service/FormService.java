package TRMS.P1.service;

import java.io.FileNotFoundException;
import java.util.List;

import TRMS.P1.pojo.Event;
import TRMS.P1.pojo.EventType;
import TRMS.P1.pojo.Grade;
import TRMS.P1.pojo.GradingFormat;
import TRMS.P1.pojo.Reimbursement;
import TRMS.P1.pojo.ReimbursementStatus;
import TRMS.P1.pojo.UploadFile;

public interface FormService {

	public Reimbursement createReimbursement(Reimbursement reimbursement);

	public Reimbursement readReimbursement(int reimbursementId);

	public Reimbursement updateReimbursement(int reimbursementid, Reimbursement reimbursement);

	public ReimbursementStatus readReimbursementStatus(int reimbursementStatusId);

	public Event creatEvent(Event event);

	public Event readEvent(int eventId);

	public List<Event> readAllEvents();

	public List<Reimbursement> readAllReimbursements();

	public Event updateEvent(int eventId, Event event);

	public EventType readEventType(int eventTypeId);

	public GradingFormat readGradingFormat(int gradeFormatId);

	public Grade readGrade(int gradeId);

	public UploadFile createUploadFile(UploadFile uploadFile) throws FileNotFoundException;

	public List<Reimbursement> readReimbursementById(int employeeId);

	public List<Event> readEventById(int employeeId);

	public List<Event> readAllEventsByReportTo(int reportsTo);

	public List<Reimbursement> readReimbursementByReportTo(int reportsTo);

	public int updateReimbursementDepHead(int reimbursementId, Reimbursement reimbursement);

	public int updateReimbursementDirSup(int reimbursementId, Reimbursement reimbursement);

	public int updateReimbursementBenCo(int reimbursementId, Reimbursement reimbursement);

	public int updateEventGradeEmployee(int eventId, Event event);

	public int updateEventGradeBencoDirSup(int eventId, Event event);

	public int updateReimbursementCancellation(int reimbursementId, Reimbursement reimbursement);

	public int updateAdjustedAmount(int reimbursementId, Reimbursement reimbursement);

}
