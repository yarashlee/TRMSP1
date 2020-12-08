package TRMS.P1.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import TRMS.P1.daoInterface.EventDao;
import TRMS.P1.pojo.Event;
import TRMS.P1.util.ConnectionUtil;

public class EventDaoImpl implements EventDao {

	private static Logger log = Logger.getRootLogger();

	private PreparedStatement stmt;

	private ConnectionUtil connUtil = new ConnectionUtil();

	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public Event createEvent(Event event) {

		String sql = "insert into event (event_type_id, name, description, start_date, end_date, location,"
				+ "grading_format_id)" + "values(?, ?, ?, ?, ?, ?, ?);";

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, event.getEventTypeId());
			stmt.setString(2, event.getName());
			stmt.setString(3, event.getDescription());
			stmt.setString(4, event.getStartDate());
			stmt.setString(5, event.getEndDate());
			stmt.setString(6, event.getLocation());
			stmt.setInt(7, event.getGradingFormatId());

			stmt.executeUpdate();

			ResultSet r = stmt.getGeneratedKeys();

			r.next();

			int eventId = r.getInt(1);

			event.setEventId(eventId);
			log.info("Dao creating event");

			return event;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Event readEvent(int eventId) {

		String sql = "select * from event where event_id = " + eventId;

		Event event = new Event();

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read event by id = " + eventId);

			while (rs.next()) {

				eventId = rs.getInt("event_id");
				int eventTypeId = rs.getInt("event_type_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				String location = rs.getString("location");
				int gradingFormatId = rs.getInt("grading_format_id");
				int gradeId = rs.getInt("grade_id");

				event.setEventId(eventId);
				event.setEventTypeId(eventTypeId);
				event.setName(name);
				event.setDescription(description);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setLocation(location);
				event.setGradingFormatId(gradingFormatId);
				event.setGradeId(gradeId);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event;
	}

	@Override
	public List<Event> readEventByEmployeeId(int employeeId) {

		List<Event> eventList = new ArrayList();

		String sql = "select r.employee_id, e.event_id, e.event_type_id, e.\"name\", e.description, e.start_date, e.end_date, e.\"location\", "
				+ "e.grading_format_id, e.employee_grade, e.grade_id " + "from reimbursement r " + "join \"event\" e "
				+ "on r.event_id = e.event_id " + "where employee_id = ?;";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, employeeId);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller read all events by employee");

			while (rs.next()) {

				Event event = new Event();

				int eventId = rs.getInt("event_id");
				int eventTypeId = rs.getInt("event_type_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				String location = rs.getString("location");
				int gradingFormatId = rs.getInt("grading_format_id");
				String employeeGrade = rs.getString("employee_grade");
				int gradeId = rs.getInt("grade_id");

				event.setEventId(eventId);
				event.setEventTypeId(eventTypeId);
				event.setName(name);
				event.setDescription(description);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setLocation(location);
				event.setGradingFormatId(gradingFormatId);
				event.setEmployeeGrade(employeeGrade);
				event.setGradeId(gradeId);

				eventList.add(event);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventList;
	}

	@Override
	public List<Event> readAllEvents() {

		List<Event> eventList = new ArrayList();

		String sql = "select * from event";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read all event types");

			while (rs.next()) {

				Event event = new Event();

				int eventId = rs.getInt("event_id");
				int eventTypeId = rs.getInt("event_type_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				String location = rs.getString("location");
				int gradingFormatId = rs.getInt("grading_format_id");
				String employeeGrade = rs.getString("employee_grade");
				int gradeId = rs.getInt("grade_id");

				event.setEventId(eventId);
				event.setEventTypeId(eventTypeId);
				event.setName(name);
				event.setDescription(description);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setLocation(location);
				event.setGradingFormatId(gradingFormatId);
				event.setEmployeeGrade(employeeGrade);
				event.setGradeId(gradeId);

				eventList.add(event);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventList;
	}

	@Override
	public List<Event> readAllEventsByReportTo(int reportsTo) {

		List<Event> eventList = new ArrayList();

		String sql = "select e.event_id, e.event_type_id, e.\"name\", e.description, e.start_date, e.end_date, e.\"location\", "
				+ "e.grading_format_id, e.employee_grade, e.grade_id " + "from \"event\" e " + "join reimbursement r "
				+ "on e.event_id = r.event_id " + "join employee em " + "on r.employee_id = em.employee_id "
				+ "where em.reports_to = ?;";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, reportsTo);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller read all events by employee");

			while (rs.next()) {

				Event event = new Event();

				int eventId = rs.getInt("event_id");
				int eventTypeId = rs.getInt("event_type_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				String location = rs.getString("location");
				int gradingFormatId = rs.getInt("grading_format_id");
				String employeeGrade = rs.getString("employee_grade");
				int gradeId = rs.getInt("grade_id");

				event.setEventId(eventId);
				event.setEventTypeId(eventTypeId);
				event.setName(name);
				event.setDescription(description);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setLocation(location);
				event.setGradingFormatId(gradingFormatId);
				event.setEmployeeGrade(employeeGrade);
				event.setGradeId(gradeId);

				eventList.add(event);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventList;
	}

	@Override
	public int updateEventGradeEmployee(int eventId, Event event) {

		String sql = "update event " + "set employee_grade = ?" + "where event_id = ?";

		int rows = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, event.getEmployeeGrade());
			stmt.setInt(2, eventId);

			rows = stmt.executeUpdate();

			log.info("Dao updateEventGradeEmployee by eventId = " + eventId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int updateEventGradeBencoDirSup(int eventId, Event event) {

		String sql = "update event " + "set grade_id = ?" + "where event_id = ?";

		int rows = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, event.getGradeId());
			stmt.setInt(2, eventId);

			rows = stmt.executeUpdate();

			log.info("Dao updateEventGradeBencoDirSup by eventId = " + eventId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int updateEvent(int eventId, Event event) {

		String sql = "update event "
				+ "set event_type_id = ?, name = ?, description = ?, start_date = ?, end_date = ?,  location = ?, "
				+ "grading_format_id = ?, grade_id = ?" + "where event_id = ?";

		int rows = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, event.getEventTypeId());
			stmt.setString(2, event.getName());
			stmt.setString(3, event.getDescription());
			stmt.setString(4, event.getStartDate());
			stmt.setString(5, event.getEndDate());
			stmt.setString(6, event.getLocation());
			stmt.setInt(7, event.getGradingFormatId());
			stmt.setInt(8, event.getGradeId());
			stmt.setInt(9, event.getEventId());

			rows = stmt.executeUpdate();

			log.info("Dao updating event by eventId = " + eventId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int deleteEvent(int eventId) {

		String sql = "delete from event where event_id = ?";

		int rowsToDelete = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, eventId);

			rowsToDelete = stmt.executeUpdate();

			log.info("Dao deleting event by eventId = " + eventId);

			if (rowsToDelete == 0) {
				System.out.println("No rows to delete.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsToDelete;
	}

}
