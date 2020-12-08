package TRMS.P1.daoInterface;

import java.util.List;

import TRMS.P1.pojo.Employee;

public interface EmployeeDao {
	

		public int logIn(String username, String password);

		public void createEmployee(Employee employee);

		public Employee readEmployee(int employeeId);

		public List<Employee> readAllEmployees();

		public List<Employee> readAllEmployeesByReportTo(int reportsTo);

		public int updateEmployee(int employeeId, Employee employee);

		public int deleteEmployee(int employeeId);

		public List<Employee> readAllEmployeesById(int employeeId);

	
}
