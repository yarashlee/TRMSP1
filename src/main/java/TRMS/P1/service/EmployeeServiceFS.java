package TRMS.P1.service;

import java.util.List;

import org.apache.log4j.Logger;

import TRMS.P1.daoImpl.EmployeeDaoImpl;
import TRMS.P1.daoInterface.EmployeeDao;
import TRMS.P1.pojo.Employee;

public class EmployeeServiceFS implements EmployeeService {

	EmployeeDao employeeDao = new EmployeeDaoImpl();

	private static Logger log = Logger.getRootLogger();

	@Override
	public Employee readEmployee(int employeeId) {
		log.info("Employee Service --> Read Employee by ID");
		return employeeDao.readEmployee(employeeId);
	}

	@Override
	public List<Employee> readAllEmployees() {
		log.info("Employee Service --> Read All Employees");
		return employeeDao.readAllEmployees();
	}

	@Override
	public Employee updateEmployee(int employeeId, Employee employee) {
		log.info("Employee Service --> update employees");
		employeeDao.updateEmployee(employeeId, employee);
		return employee;
	}

	@Override
	public List<Employee> readAllEmployeesById(int employeeId) {
		log.info("Employee Service --> readAllEmployeesById");
		return employeeDao.readAllEmployeesById(employeeId);
	}

	@Override
	public List<Employee> readAllEmployeesByReportTo(int reportsTo) {
		log.info("Form employee --> read employee by reports to");
		return employeeDao.readAllEmployeesByReportTo(reportsTo);
	}
}
