package TRMS.P1.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import TRMS.P1.daoInterface.EmployeeDao;
import TRMS.P1.pojo.Employee;
import TRMS.P1.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	private static Logger log = Logger.getRootLogger();

	private PreparedStatement stmt;

	private ConnectionUtil connUtil = new ConnectionUtil();

	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public int logIn(String username, String password) {
		int rows = 0;

		String sql = "select * from login where username=? and password=? ;";

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, (username));
			stmt.setString(2, (password));
			ResultSet rs = stmt.executeQuery();
			log.info(" result set " + rs);

			while (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				// employee.setEmployeeId(userId);
				log.info(" Employee dao authenticated " + employee_id);
				return employee_id;
			}

			// rows=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		log.info("Employee dao ----- Failed to authenticate " + username);
		return 0;
	}

	@Override
	public void createEmployee(Employee employee) {
		String sql = "insert into employee (title, reports_to, first_name, middle_name, last_name, date_birth,"
				+ "phone_number, email, address, city, state, country, postal_code)"
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, employee.getTitle());
			stmt.setInt(2, employee.getReportTo());
			stmt.setString(3, employee.getFirstName());
			stmt.setString(4, employee.getMiddleName());
			stmt.setString(5, employee.getLastName());
			stmt.setDate(6, Date.valueOf(employee.getDateBirth()));
			stmt.setString(7, employee.getPhoneNumber());
			stmt.setString(8, employee.getEmail());
			stmt.setString(9, employee.getAddress());
			stmt.setString(10, employee.getCity());
			stmt.setString(11, employee.getState());
			stmt.setString(12, employee.getCountry());
			stmt.setString(13, employee.getPostalCode());

			stmt.executeUpdate();

			log.info("Dao creating employee");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Employee readEmployee(int employeeId) {
		String sql = "select * from employee where employee_id =" + employeeId;

		Employee employee = new Employee();

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read employee by id = " + employeeId);

			while (rs.next()) {

				employeeId = rs.getInt("employee_id");
				String title = rs.getString("title");
				int reportTo = rs.getInt("reports_to");
				String firstName = rs.getString("first_name");
				String middleName = rs.getString("middle_name");
				String lastName = rs.getString("last_name");
				String dateBirth = rs.getString("date_birth");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String country = rs.getString("country");
				String postalCode = rs.getString("postal_code");

				employee.setEmployeeId(employeeId);
				employee.setTitle(title);
				employee.setReportTo(reportTo);
				employee.setFirstName(firstName);
				employee.setMiddleName(middleName);
				employee.setLastName(lastName);
				employee.setDateBirth(dateBirth);
				employee.setPhoneNumber(phoneNumber);
				employee.setEmail(email);
				employee.setAddress(address);
				employee.setCity(city);
				employee.setState(state);
				employee.setCountry(country);
				employee.setPostalCode(postalCode);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> readAllEmployees() {
		List<Employee> employeeList = new ArrayList();

		String sql = "select * from employee";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read all employees");

			while (rs.next()) {

				Employee employee = new Employee();

				int employeeId = rs.getInt("employee_id");
				String title = rs.getString("title");
				int reportTo = rs.getInt("reports_to");
				String firstName = rs.getString("first_name");
				String middleName = rs.getString("middle_name");
				String lastName = rs.getString("last_name");
				String dateBirth = rs.getString("date_birth");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String country = rs.getString("country");
				String postalCode = rs.getString("postal_code");

				employee.setEmployeeId(employeeId);
				employee.setTitle(title);
				employee.setReportTo(reportTo);
				employee.setFirstName(firstName);
				employee.setMiddleName(middleName);
				employee.setLastName(lastName);
				employee.setDateBirth(dateBirth);
				employee.setPhoneNumber(phoneNumber);
				employee.setEmail(email);
				employee.setAddress(address);
				employee.setCity(city);
				employee.setState(state);
				employee.setCountry(country);
				employee.setPostalCode(postalCode);

				employeeList.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public List<Employee> readAllEmployeesByReportTo(int reportsTo) {
		List<Employee> employeeList = new ArrayList();

		String sql = "select employee_id, first_name, middle_name, last_name, phone_number, email " + "from employee "
				+ "where reports_to = ?";
		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, reportsTo);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read all employees by report to");

			while (rs.next()) {

				Employee employee = new Employee();

				int employeeId = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String middleName = rs.getString("middle_name");
				String lastName = rs.getString("last_name");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");

				employee.setEmployeeId(employeeId);
				employee.setFirstName(firstName);
				employee.setMiddleName(middleName);
				employee.setLastName(lastName);
				employee.setPhoneNumber(phoneNumber);
				employee.setEmail(email);

				employeeList.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public int updateEmployee(int employeeId, Employee employee) {
		String sql = "update employee "
				+ "set title = ?, reports_to = ?, first_name = ?, middle_name = ?, last_name = ?, date_birth =?,"
				+ "phone_number = ?, email = ?, address = ?, city = ?, state = ?, country = ?, postal_code = ?"
				+ "where employee_id = ?";

		int rows = 0;

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);

			stmt.setString(1, employee.getTitle());
			stmt.setInt(2, employee.getReportTo());
			stmt.setString(3, employee.getFirstName());
			stmt.setString(4, employee.getMiddleName());
			stmt.setString(5, employee.getLastName());
			stmt.setDate(6, Date.valueOf(employee.getDateBirth()));
			stmt.setString(7, employee.getPhoneNumber());
			stmt.setString(8, employee.getEmail());
			stmt.setString(9, employee.getAddress());
			stmt.setString(10, employee.getCity());
			stmt.setString(11, employee.getState());
			stmt.setString(12, employee.getCountry());
			stmt.setString(13, employee.getPostalCode());
			stmt.setInt(14, employee.getEmployeeId());

			rows = stmt.executeUpdate();

			log.info("Dao updating event by eventId = " + employeeId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int deleteEmployee(int employeeId) {
		String sql = "delete from employee where employee_id = ?";

		int rowsToDelete = 0;

		try (Connection conn = connUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, employeeId);

			rowsToDelete = stmt.executeUpdate();

			log.info("Dao deleting employee by employeeId = " + employeeId);

			if (rowsToDelete == 0) {
				System.out.println("No rows to delete.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsToDelete;
	}

	@Override
	public List<Employee> readAllEmployeesById(int employeeId) {
		List<Employee> employeeList = new ArrayList();

		String sql = "select first_name, middle_name, last_name, date_birth, phone_number, email, address, city, state, country, postal_code "
				+ "from employee " + "where employee_id = ?;";

		try (Connection conn = connUtil.getConnection()) {

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, employeeId);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read all employees");

			while (rs.next()) {

				Employee employee = new Employee();

				String firstName = rs.getString("first_name");
				String middleName = rs.getString("middle_name");
				String lastName = rs.getString("last_name");
				String dateBirth = rs.getString("date_birth");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String country = rs.getString("country");
				String postalCode = rs.getString("postal_code");

				employee.setFirstName(firstName);
				employee.setMiddleName(middleName);
				employee.setLastName(lastName);
				employee.setDateBirth(dateBirth);
				employee.setPhoneNumber(phoneNumber);
				employee.setEmail(email);
				employee.setAddress(address);
				employee.setCity(city);
				employee.setState(state);
				employee.setCountry(country);
				employee.setPostalCode(postalCode);

				employeeList.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
	}

}
