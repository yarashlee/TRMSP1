package TRMS.P1.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import TRMS.P1.daoInterface.GradeDao;
import TRMS.P1.pojo.Grade;
import TRMS.P1.util.ConnectionUtil;

public class GradeDaoImpl implements GradeDao {

	private static Logger log = Logger.getRootLogger();

	private PreparedStatement stmt;

	private ConnectionUtil connUtil = new ConnectionUtil();

	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public Grade readGrade(int gradeId) {

		String sql = "select * from grade where grade_id = " + gradeId;

		Grade grade = new Grade();

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read grade by id = " + gradeId);

			while (rs.next()) {

				gradeId = rs.getInt("grade_id");
				String gradeLetter = rs.getString("grade_letter");
				double minPercentage = rs.getDouble("min_percentage");
				double maxPercentage = rs.getDouble("max_percentage");
				String passFail = rs.getString("pass_fail");

				grade.setGradeId(gradeId);
				grade.setGradeLetter(gradeLetter);
				grade.setMinPercentage(minPercentage);
				grade.setMaxPercentage(maxPercentage);
				grade.setPassFail(passFail);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grade;
	}

	@Override
	public List<Grade> readAllGrades() {

		List<Grade> gradeList = new ArrayList();

		String sql = "select * from event_type";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read all grades");

			while (rs.next()) {

				Grade grade = new Grade();

				int gradeId = rs.getInt("grade_id");
				String gradeLetter = rs.getString("grade_letter");
				double minPercentage = rs.getDouble("min_percentage");
				double maxPercentage = rs.getDouble("max_percentage");
				String passFail = rs.getString("pass_fail");

				grade.setGradeId(gradeId);
				grade.setGradeLetter(gradeLetter);
				grade.setMinPercentage(minPercentage);
				grade.setMaxPercentage(maxPercentage);
				grade.setPassFail(passFail);

				gradeList.add(grade);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gradeList;
	}

}
