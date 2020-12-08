package TRMS.P1;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import TRMS.P1.util.ConnectionUtil;

public class ConnectionUtilTest {
	
	private ConnectionUtil connectionUtil = new ConnectionUtil();

	@Test
	public void test() throws SQLException {
		Connection conn = connectionUtil.getConnection();
		conn.close();
	}

}
