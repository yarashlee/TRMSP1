package TRMS.P1.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import TRMS.P1.daoInterface.ReimbursementDao;
import TRMS.P1.pojo.Reimbursement;
import TRMS.P1.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	private static Logger log = Logger.getRootLogger();

	private PreparedStatement stmt;

	private ConnectionUtil connUtil = new ConnectionUtil();

	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	
	LocalDate date = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public void createReimbursement(Reimbursement reimbursement) {

		String sql = "insert into reimbursement (employee_id, event_id, employee_cancel, justification, date_submition, amount_requested, adjusted_amount, "
				+ "reimbursement_status_id)" + "values(?, ?, ?, ?, ?, ?, ?, ?);";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, reimbursement.getEmployeeId());
			stmt.setInt(2, reimbursement.getEventId());
			stmt.setBoolean(3, false);
			stmt.setString(4, reimbursement.getJustification());
			stmt.setDate(5, Date.valueOf(date.format(formatter)));
			stmt.setDouble(6, reimbursement.getAmountRequested());
			stmt.setDouble(7, reimbursement.getAdjustedAmount());
			stmt.setInt(8, 1);
			stmt.executeUpdate();

			log.info("Dao creating reimbursement");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Reimbursement readReimbursement(int reimbursementId) {

		String sql = "select * from reimbursement where reimbursement_id = " + reimbursementId;

		Reimbursement reimbursement = new Reimbursement();

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read reimbursement by id = " + reimbursementId);

			while (rs.next()) {

				reimbursementId = rs.getInt("reimbursement_id");
				int eventId = rs.getInt("event_id");
				String dateSubmition = rs.getString("date_submition");
				String employeeCancellation = rs.getString("employee_cancel");
				String justification = rs.getString("justification");
				double amountRequested = rs.getDouble("amount_requested");
				double adjustedAmount = rs.getDouble("adjusted_amount");
				String directorSupervisorApprovalDate = rs.getString("dirsup_approval_date");
				String departmentHeadApprovalDate = rs.getString("dephead_approval_date");
				String benCoApprovalDate = rs.getString("benco_approval_date");
				int reimbursementStatusId = rs.getInt("reimbursement_status_id");
				String notes = rs.getString("notes");
				int updateFileId = rs.getInt("upload_file_id");

				reimbursement.setReimbursementId(reimbursementId);
				reimbursement.setEventId(eventId);
				reimbursement.setDateSubmition(dateSubmition);
				reimbursement.setEmployeeCancellation(employeeCancellation);
				reimbursement.setJustification(justification);
				reimbursement.setAmountRequested(amountRequested);
				reimbursement.setAdjustedAmount(adjustedAmount);
				reimbursement.setDirectorSupervisorApprovalDate(directorSupervisorApprovalDate);
				reimbursement.setDepartmentHeadApprovalDate(departmentHeadApprovalDate);
				reimbursement.setBenCoApprovalDate(benCoApprovalDate);
				reimbursement.setReimbursementStatusId(reimbursementStatusId);
				reimbursement.setNotes(notes);
				reimbursement.setUpdateFileId(updateFileId);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursement;
	}

	@Override
	public List<Reimbursement> readReimbursementByEmployeeId(int employeeId) {

		List<Reimbursement> reimbursementList = new ArrayList();

		String sql = "select * from reimbursement where employee_id = ? ;";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, employeeId);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read all event reimbursement");

			while (rs.next()) {

				Reimbursement reimbursement = new Reimbursement();

				int reimbursementId = rs.getInt("reimbursement_id");
				int eventId = rs.getInt("event_id");
				String dateSubmition = rs.getString("date_submition");
				String employeeCancellation = rs.getString("employee_cancel");
				String justification = rs.getString("justification");
				double amountRequested = rs.getDouble("amount_requested");
				double adjustedAmount = rs.getDouble("adjusted_amount");
				String directorSupervisorApprovalDate = rs.getString("dirsup_approval_date");
				String departmentHeadApprovalDate = rs.getString("dephead_approval_date");
				String benCoApprovalDate = rs.getString("benco_approval_date");
				int reimbursementStatusId = rs.getInt("reimbursement_status_id");
				String notes = rs.getString("notes");
				int updateFileId = rs.getInt("upload_file_id");

				reimbursement.setReimbursementId(reimbursementId);
				reimbursement.setEventId(eventId);
				reimbursement.setDateSubmition(dateSubmition);
				reimbursement.setEmployeeCancellation(employeeCancellation);
				reimbursement.setJustification(justification);
				reimbursement.setAmountRequested(amountRequested);
				reimbursement.setAdjustedAmount(adjustedAmount);
				reimbursement.setDirectorSupervisorApprovalDate(directorSupervisorApprovalDate);
				reimbursement.setDepartmentHeadApprovalDate(departmentHeadApprovalDate);
				reimbursement.setBenCoApprovalDate(benCoApprovalDate);
				reimbursement.setReimbursementStatusId(reimbursementStatusId);
				reimbursement.setNotes(notes);
				reimbursement.setUpdateFileId(updateFileId);

				reimbursementList.add(reimbursement);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursementList;
	}

	@Override
	public List<Reimbursement> readAllReimbursements() {

		List<Reimbursement> reimbursementList = new ArrayList();

		String sql = "select * from reimbursement";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read all event reimbursement");

			while (rs.next()) {

				Reimbursement reimbursement = new Reimbursement();

				int employeeId = rs.getInt("employee_id");
				int reimbursementId = rs.getInt("reimbursement_id");
				int eventId = rs.getInt("event_id");
				String dateSubmition = rs.getString("date_submition");
				String employeeCancellation = rs.getString("employee_cancel");
				String justification = rs.getString("justification");
				double amountRequested = rs.getDouble("amount_requested");
				double adjustedAmount = rs.getDouble("adjusted_amount");
				String directorSupervisorApprovalDate = rs.getString("dirsup_approval_date");
				String departmentHeadApprovalDate = rs.getString("dephead_approval_date");
				String benCoApprovalDate = rs.getString("benco_approval_date");
				int reimbursementStatusId = rs.getInt("reimbursement_status_id");
				String notes = rs.getString("notes");
				int updateFileId = rs.getInt("upload_file_id");

				reimbursement.setEmployeeId(employeeId);
				reimbursement.setReimbursementId(reimbursementId);
				reimbursement.setEventId(eventId);
				reimbursement.setDateSubmition(dateSubmition);
				reimbursement.setEmployeeCancellation(employeeCancellation);
				reimbursement.setJustification(justification);
				reimbursement.setAmountRequested(amountRequested);
				reimbursement.setAdjustedAmount(adjustedAmount);
				reimbursement.setDirectorSupervisorApprovalDate(directorSupervisorApprovalDate);
				reimbursement.setDepartmentHeadApprovalDate(departmentHeadApprovalDate);
				reimbursement.setBenCoApprovalDate(benCoApprovalDate);
				reimbursement.setReimbursementStatusId(reimbursementStatusId);
				reimbursement.setNotes(notes);
				reimbursement.setUpdateFileId(updateFileId);

				reimbursementList.add(reimbursement);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursementList;
	}

	@Override
	public List<Reimbursement> readAllReimbsByReportTo(int reportsTo) {

		List<Reimbursement> reimbursementList = new ArrayList();

		String sql = "select r.reimbursement_id, r.employee_id, r.event_id, r.date_submition, r.employee_cancel, r.justification, "
				+ "r.amount_requested, r.adjusted_amount, r.dirsup_approval_date, r.dephead_approval_date, r.benco_approval_date, r.reimbursement_status_id, "
				+ "r.notes, r.upload_file_id " + "from reimbursement r " + "inner join employee e "
				+ "on r.employee_id = e.employee_id " + "where reports_to = ?;";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, reportsTo);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read all event reimbursement");

			while (rs.next()) {

				Reimbursement reimbursement = new Reimbursement();

				int employeeId = rs.getInt("employee_id");
				int reimbursementId = rs.getInt("reimbursement_id");
				int eventId = rs.getInt("event_id");
				String dateSubmition = rs.getString("date_submition");
				String employeeCancellation = rs.getString("employee_cancel");
				String justification = rs.getString("justification");
				double amountRequested = rs.getDouble("amount_requested");
				double adjustedAmount = rs.getDouble("adjusted_amount");
				String directorSupervisorApprovalDate = rs.getString("dirsup_approval_date");
				String departmentHeadApprovalDate = rs.getString("dephead_approval_date");
				String benCoApprovalDate = rs.getString("benco_approval_date");
				int reimbursementStatusId = rs.getInt("reimbursement_status_id");
				String notes = rs.getString("notes");
				int updateFileId = rs.getInt("upload_file_id");

				reimbursement.setEmployeeId(employeeId);
				reimbursement.setReimbursementId(reimbursementId);
				reimbursement.setEventId(eventId);
				reimbursement.setDateSubmition(dateSubmition);
				reimbursement.setEmployeeCancellation(employeeCancellation);
				reimbursement.setJustification(justification);
				reimbursement.setAmountRequested(amountRequested);
				reimbursement.setAdjustedAmount(adjustedAmount);
				reimbursement.setDirectorSupervisorApprovalDate(directorSupervisorApprovalDate);
				reimbursement.setDepartmentHeadApprovalDate(departmentHeadApprovalDate);
				reimbursement.setBenCoApprovalDate(benCoApprovalDate);
				reimbursement.setReimbursementStatusId(reimbursementStatusId);
				reimbursement.setNotes(notes);
				reimbursement.setUpdateFileId(updateFileId);

				reimbursementList.add(reimbursement);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursementList;
	}

	@Override
	public int updateReimbursementDepHead(int reimbursementId, Reimbursement reimbursement) {

		String sql = "update reimbursement " + "set dephead_approval_date = ?, notes = ? "
				+ "where reimbursement_id = ?";

		int rows = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, date.format(formatter));
			stmt.setString(2, reimbursement.getNotes());
			stmt.setInt(3, reimbursementId);

			rows = stmt.executeUpdate();

			log.info("Reimbursementid dao update reimbursement department head  = " + reimbursementId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int updateReimbursementDirSup(int reimbursementId, Reimbursement reimbursement) {

		String sql = "update reimbursement " + "set dirsup_approval_date = ?, notes = ?, reimbursement_status_id = ? "
				+ "where reimbursement_id = ?";

		int rows = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, date.format(formatter));
			stmt.setString(2, reimbursement.getNotes());
			stmt.setInt(3, reimbursement.getReimbursementStatusId());
			stmt.setInt(4, reimbursementId);

			rows = stmt.executeUpdate();

			log.info("Reimbursementid dao update reimbursement direct supervisor  = " + reimbursementId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int updateReimbursementBenCo(int reimbursementId, Reimbursement reimbursement) {

		String sql = "update reimbursement " + "set benco_approval_date = ?, notes = ?, reimbursement_status_id = ? "
				+ "where reimbursement_id = ?";

		int rows = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, date.format(formatter));
			stmt.setString(2, reimbursement.getNotes());
			stmt.setInt(3, reimbursement.getReimbursementStatusId());
			stmt.setInt(4, reimbursementId);

			rows = stmt.executeUpdate();

			log.info("Reimbursementid dao update reimbursement BenCo = " + reimbursementId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int updateReimbursement(int reimbursementid, Reimbursement reimbursement) {

		String sql = "update reimbursement "
				+ "set employee_id = ?, event_id = ?, date_submition = ?, employee_cancel = ?, justification = ?, amount_requested =?, adjusted_amount = ? "
				+ "dirsup_approval_date = ?, dephead_approval_date = ?, benco_approval_date = ?, reimbursement_status_id = ?, notes = ?, upload_file_id = ?"
				+ "where reimbursement_id = ?";

		int rows = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, reimbursement.getEmployeeId());
			stmt.setInt(2, reimbursement.getEventId());
			stmt.setDate(3, Date.valueOf(reimbursement.getDateSubmition()));
			stmt.setString(4, reimbursement.getEmployeeCancellation());
			stmt.setString(5, reimbursement.getJustification());
			stmt.setDouble(6, reimbursement.getAmountRequested());
			stmt.setDouble(7, reimbursement.getAdjustedAmount());
			stmt.setDate(8, Date.valueOf(reimbursement.getDirectorSupervisorApprovalDate()));
			stmt.setDate(9, Date.valueOf(reimbursement.getDepartmentHeadApprovalDate()));
			stmt.setDate(10, Date.valueOf(reimbursement.getBenCoApprovalDate()));
			stmt.setInt(11, reimbursement.getReimbursementStatusId());
			stmt.setString(12, reimbursement.getNotes());
			stmt.setInt(13, reimbursement.getUpdateFileId());
			stmt.setInt(14, reimbursement.getReimbursementId());

			rows = stmt.executeUpdate();

			log.info("Dao updating reimbursementid by reimbursementid = " + reimbursementid);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int updateReimbursementCancellation(int reimbursementId, Reimbursement reimbursement) {

		String sql = "update reimbursement " + "set employee_cancel = ? " + "where reimbursement_id = ? ";

		int rows = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, reimbursement.getEmployeeCancellation());
			stmt.setInt(2, reimbursementId);

			rows = stmt.executeUpdate();

			log.info("Dao updating reimbursement cancellation by reimbursementid = " + reimbursementId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int updateAdjustedAmount(int reimbursementId, Reimbursement reimbursement) {

		String sql = "update reimbursement " + "set adjusted_amount = ? " + "where reimbursement_id = ? ";

		int rows = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setDouble(1, reimbursement.getAdjustedAmount());
			stmt.setInt(2, reimbursementId);

			rows = stmt.executeUpdate();

			log.info("Dao updating reimbursement adjusted amount by reimbursementid = " + reimbursementId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int deleteReimbursement(int reimbursementId) {

		String sql = "delete from reimbursement where reimbursement_id = ?";

		int rowsToDelete = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, reimbursementId);

			rowsToDelete = stmt.executeUpdate();

			log.info("Dao deleting reimbursement by reimbursementId = " + reimbursementId);

			if (rowsToDelete == 0) {
				System.out.println("No rows to delete.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsToDelete;
	}

}
