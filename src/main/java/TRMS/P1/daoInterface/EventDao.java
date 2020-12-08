package TRMS.P1.daoInterface;

import java.util.List;

import TRMS.P1.pojo.Event;

public interface EventDao {
	
	public Event createEvent(Event event);
	
	public Event readEvent(int eventId);
	
	public List<Event> readEventByEmployeeId(int employeeId);
	
	public List<Event> readAllEvents();
	
	public List<Event> readAllEventsByReportTo(int reportsTo);
	
	public int updateEventGradeEmployee(int eventId, Event event);
	
	public int updateEventGradeBencoDirSup(int eventId, Event event);
	
	public int updateEvent(int eventId, Event event);
	
	public int deleteEvent(int eventId);

}
