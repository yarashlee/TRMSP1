package TRMS.P1.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import TRMS.P1.daoInterface.GradingFormatDao;
import TRMS.P1.pojo.GradingFormat;
import TRMS.P1.util.ConnectionUtil;

public class GradingFormatDaoImpl implements GradingFormatDao {

	private static Logger log = Logger.getRootLogger();

	private PreparedStatement stmt;

	private ConnectionUtil connUtil = new ConnectionUtil();

	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public GradingFormat readGradingFormat(int gradeFormatId) {

		String sql = "select * from grading_format_company where grading_format_id = " + gradeFormatId;

		GradingFormat gradingFormat = new GradingFormat();

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read grading format company by id = " + gradeFormatId);

			while (rs.next()) {

				gradeFormatId = rs.getInt("grading_format_id");
				String gradeFormat = rs.getString("grading_format");

				gradingFormat.setGradeFormatId(gradeFormatId);
				gradingFormat.setGradeFormat(gradeFormat);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gradingFormat;
	}

	@Override
	public List<GradingFormat> readAllGradingFormats() {
		// TODO Auto-generated method stub
		return null;
	}

}
