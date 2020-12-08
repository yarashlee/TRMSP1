package TRMS.P1.controller;

import java.util.List;

import org.apache.log4j.Logger;

import TRMS.P1.pojo.Employee;
import TRMS.P1.service.EmployeeService;
import TRMS.P1.service.EmployeeServiceFS;
import io.javalin.http.Context;

public class EmployeeController {
	
	EmployeeService employeeService = new EmployeeServiceFS();

	private static Logger log = Logger.getRootLogger();

	public void getEmployee(Context ctx) {

		log.info("Employee Controller --> read an employee * id");

		int employeeId = Integer.parseInt(ctx.formParam("employeeId"));

		ctx.html(employeeService.readEmployee(employeeId).toString());

	}

	public void getAllEmployees(Context ctx) {

		log.info("Employee Controller --> read all employee");
	
		List<Employee> getAllEmployees = employeeService.readAllEmployees();
		
		ctx.json(getAllEmployees);

	}

	public void updateEmployee(Context ctx) {

		log.info("Employee Controller --> update employee");

		System.out.println("Responding update employee request");

		int employeeId = Integer.parseInt(ctx.formParam("employeeId"));

		String title = ctx.formParam("title");

		int reportTo = Integer.parseInt(ctx.formParam("reportTo"));

		String firstName = ctx.formParam("firstName");

		String middleName = ctx.formParam("middleName");

		String lastName = ctx.formParam("lastName");

		String dateBirth = ctx.formParam("dateBirth");

		String phoneNumber = ctx.formParam("phoneNumber");

		String email = ctx.formParam("email");

		String address = ctx.formParam("address");

		String city = ctx.formParam("city");

		String state = ctx.formParam("state");

		String country = ctx.formParam("country");

		String postalCode = ctx.formParam("postalCode");

		Employee employee = new Employee(employeeId, title, reportTo, firstName, middleName, lastName, dateBirth,
				phoneNumber, email, address, city, state, country, postalCode);

		employeeService.updateEmployee(employeeId, employee);

		ctx.html(Integer.toString(employee.getEmployeeId()));

	}
	
	public void getAllEmployeesByReportsTo(Context ctx) {
		
		int employeeId = ctx.cookieStore("id");
		
		List<Employee> getEmployeeByReporsToList = employeeService.readAllEmployeesByReportTo(employeeId);
		
		ctx.json(getEmployeeByReporsToList);
		
	}

	public void getAllEmployeesById(Context ctx) {

		log.info("Employee Controller --> read all employee");

		int employeeId = ctx.cookieStore("id");
		
		List<Employee> getEmployeeList = employeeService.readAllEmployeesById(employeeId);
		
		ctx.json(getEmployeeList);

	}

}
