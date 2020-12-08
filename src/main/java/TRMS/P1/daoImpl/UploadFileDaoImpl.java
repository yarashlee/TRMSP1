package TRMS.P1.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import TRMS.P1.daoInterface.UploadFileDao;
import TRMS.P1.pojo.UploadFile;
import TRMS.P1.util.ConnectionUtil;

public class UploadFileDaoImpl implements UploadFileDao {

	private static Logger log = Logger.getRootLogger();

	private PreparedStatement stmt;

	private ConnectionUtil connUtil = new ConnectionUtil();

	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public void createUploadFile(UploadFile uploadFile) throws FileNotFoundException {

		File file = new File("content.pdf");
		FileInputStream fis = new FileInputStream(file);

		String sql = "insert into upload_file (name, content)" + "values(?, pg_read_binary_file(' ? '))";

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, file.getName());
			stmt.setBinaryStream(2, fis, (int) file.length());

			stmt.executeUpdate();

			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			log.info("Dao creating updatefile");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public UploadFileDao readUploadFile(int uploadFileId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UploadFileDao> readAllUploadFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUploadFile(int uploadFileId, UploadFile uploadFile) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUploadFile(int uploadFileId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
