package TRMS.P1.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.log4j.Logger;

import TRMS.P1.daoImpl.EmployeeDaoImpl;
import TRMS.P1.daoImpl.EventDaoImpl;
import TRMS.P1.daoImpl.EventTypeDaoImpl;
import TRMS.P1.daoImpl.GradeDaoImpl;
import TRMS.P1.daoImpl.GradingFormatDaoImpl;
import TRMS.P1.daoImpl.ReimbursementDaoImpl;
import TRMS.P1.daoImpl.ReimbursementStatusDaoImpl;
import TRMS.P1.daoImpl.UploadFileDaoImpl;
import TRMS.P1.daoInterface.EmployeeDao;
import TRMS.P1.daoInterface.EventDao;
import TRMS.P1.daoInterface.EventTypeDao;
import TRMS.P1.daoInterface.GradeDao;
import TRMS.P1.daoInterface.GradingFormatDao;
import TRMS.P1.daoInterface.ReimbursementDao;
import TRMS.P1.daoInterface.ReimbursementStatusDao;
import TRMS.P1.daoInterface.UploadFileDao;
import TRMS.P1.pojo.Event;
import TRMS.P1.pojo.EventType;
import TRMS.P1.pojo.Grade;
import TRMS.P1.pojo.GradingFormat;
import TRMS.P1.pojo.Reimbursement;
import TRMS.P1.pojo.ReimbursementStatus;
import TRMS.P1.pojo.UploadFile;

public class FormServiceFS implements FormService {
	
	EmployeeDao employeeDao = new EmployeeDaoImpl();

	ReimbursementDao reimbursementDao = new ReimbursementDaoImpl();

	ReimbursementStatusDao reimbursementStatusDao = new ReimbursementStatusDaoImpl();

	EventDao eventDao = new EventDaoImpl();

	EventTypeDao eventTypeDao = new EventTypeDaoImpl();

	GradingFormatDao gradingFormatDao = new GradingFormatDaoImpl();

	GradeDao gradeDao = new GradeDaoImpl();

	UploadFileDao uploadFileDao = new UploadFileDaoImpl();

	private static Logger log = Logger.getRootLogger();

	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		log.info("Form Service --> Create Reimbursement");
		reimbursementDao.createReimbursement(reimbursement);
		return reimbursement;
	}

	@Override
	public Reimbursement readReimbursement(int reimbursementId) {
		log.info("Form Service --> Read Reimbursement by Id");
		return reimbursementDao.readReimbursement(reimbursementId);
	}

	@Override
	public Reimbursement updateReimbursement(int reimbursementid, Reimbursement reimbursement) {
		log.info("Form Service --> Update Reimbursement by Id");
		reimbursementDao.updateReimbursement(reimbursementid, reimbursement);
		return reimbursement;
	}

	@Override
	public ReimbursementStatus readReimbursementStatus(int reimbursementStatusId) {
		log.info("Form Service --> Read Reimbursement Status by Id");
		return reimbursementStatusDao.readReimbursementStatus(reimbursementStatusId);
	}

	@Override
	public Event creatEvent(Event event) {
		log.info("Form Service --> Create Event");
		return eventDao.createEvent(event);
	}

	@Override
	public Event readEvent(int eventId) {
		log.info("Form Service --> Read Event by Id");
		return eventDao.readEvent(eventId);
	}

	@Override
	public Event updateEvent(int eventId, Event event) {
		log.info("Form Service --> Update Event by Id");
		eventDao.updateEvent(eventId, event);
		return event;
	}

	@Override
	public EventType readEventType(int eventTypeId) {
		log.info("Form Service --> Read Event Type by Id");
		return eventTypeDao.readEventType(eventTypeId);
	}

	@Override
	public GradingFormat readGradingFormat(int gradeFormatId) {
		log.info("Form Service --> Read Grading Format by Id");
		return gradingFormatDao.readGradingFormat(gradeFormatId);
	}

	@Override
	public Grade readGrade(int gradeId) {
		log.info("Form Service --> Read Grade by Id");
		return gradeDao.readGrade(gradeId);
	}

	@Override
	public UploadFile createUploadFile(UploadFile uploadFile) throws FileNotFoundException {
		log.info("Form Service --> Create uploadFile");
		uploadFileDao.createUploadFile(uploadFile);
		return uploadFile;
	}

	@Override
	public List<Reimbursement> readReimbursementById(int employeeId) {
		log.info("Form Service --> read Reimbursement by id");
		return reimbursementDao.readReimbursementByEmployeeId(employeeId);
	}

	@Override
	public List<Event> readEventById(int employeeId) {
		log.info("Form Service --> read event by id");
		return eventDao.readEventByEmployeeId(employeeId);
	}

	@Override
	public List<Event> readAllEventsByReportTo(int reportsTo) {
		log.info("Form Service --> read event by reports to");
		return eventDao.readAllEventsByReportTo(reportsTo);

	}

	@Override
	public List<Reimbursement> readReimbursementByReportTo(int reportsTo) {
		log.info("Form Service --> read reimbursement by reports to");
		return reimbursementDao.readAllReimbsByReportTo(reportsTo);
	}
	
	@Override
	public int updateReimbursementDepHead(int reimbursementId, Reimbursement reimbursement) {
		log.info("Form Service --> updateReimbursementDepHeadDate");
		return reimbursementDao.updateReimbursementDepHead(reimbursementId, reimbursement);
	}

	@Override
	public int updateReimbursementDirSup(int reimbursementId, Reimbursement reimbursement) {
		log.info("Form Service --> updateReimbursementDirSupDate");
		return reimbursementDao.updateReimbursementDirSup(reimbursementId, reimbursement);
	}

	@Override
	public int updateReimbursementBenCo(int reimbursementId, Reimbursement reimbursement) {
		log.info("Form Service --> updateReimbursementBenCoDate");
		return reimbursementDao.updateReimbursementBenCo(reimbursementId, reimbursement);
	}

	
	@Override
	public int updateEventGradeEmployee(int eventId, Event event) {
		log.info("Form Service --> updateEventGradeEmployee");
		return eventDao.updateEventGradeEmployee(eventId, event);
	}

	@Override
	public int updateEventGradeBencoDirSup(int eventId, Event event) {
		log.info("Form Service --> updateReimbursementBenCoDate");
		return eventDao.updateEventGradeBencoDirSup(eventId, event);
	}

	@Override
	public List<Event> readAllEvents() {
		log.info("Form Service --> read all events");
		return eventDao.readAllEvents();
	}

	@Override
	public List<Reimbursement> readAllReimbursements() {
		log.info("Form Service --> read all reimbursements");
		return reimbursementDao.readAllReimbursements();
	}

	@Override
	public int updateReimbursementCancellation(int reimbursementId, Reimbursement reimbursement) {
		log.info("Form Service --> updateReimbursementCancellation");
		return reimbursementDao.updateReimbursementCancellation(reimbursementId, reimbursement);
	}

	@Override
	public int updateAdjustedAmount(int reimbursementId, Reimbursement reimbursement) {
		log.info("Form Service --> updateAdjustedAmount");
		return reimbursementDao.updateAdjustedAmount(reimbursementId, reimbursement);
	}


}
