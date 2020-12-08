package TRMS.P1.service;

import java.util.List;

import TRMS.P1.pojo.Employee;

public interface EmployeeService {
	
	public Employee readEmployee(int employeeId);

	public List<Employee> readAllEmployees();
	
	public List<Employee> readAllEmployeesByReportTo(int reportsTo);

	public Employee updateEmployee(int employeeId, Employee employee);

	public List<Employee> readAllEmployeesById(int employeeId);

}
