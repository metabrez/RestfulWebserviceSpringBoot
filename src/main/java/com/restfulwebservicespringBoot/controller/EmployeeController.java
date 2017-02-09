package com.restfulwebservicespringBoot.controller;
import java.util.Iterator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.restfulwebservicespringBoot.domain.Employee;
import com.restfulwebservicespringBoot.service.EmployeeService;
import com.restfulwebservicespringBoot.util.ServiceResponse;

@RestController
@RequestMapping(value = "/secure", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/allEmployee", method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse> allEmployee() {
		@SuppressWarnings("static-access")
		Set<Employee> employees = employeeService.getEmpSet();
		ServiceResponse response = new ServiceResponse(true, "All employees");
		response.addParam("AllEmployee", employees);
		return new ResponseEntity<ServiceResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse> employeeById(@PathVariable int employeeId) {
		Iterator<Employee> it = EmployeeService.getEmpSet().iterator();
		while (it.hasNext()) {
			Employee emp = (Employee) it.next();
			if (emp.getId() == employeeId) {
				ServiceResponse response = new ServiceResponse(true, "Employee with id: " + employeeId);
				response.addParam("EmployeeById", emp);
				return new ResponseEntity<ServiceResponse>(response, HttpStatus.OK);
			}
		}
		ServiceResponse response = new ServiceResponse(true, "Employee with id: " + employeeId + " not avilable");
		return new ResponseEntity<ServiceResponse>(response, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.DELETE)
	public ResponseEntity<ServiceResponse> deleteEmployeeById(@PathVariable int employeeId) {

		Iterator<Employee> it = EmployeeService.getEmpSet().iterator();
		while (it.hasNext()) {
			Employee emp = it.next();
			if (emp.getId() == employeeId) {
				it.remove();
				ServiceResponse response = new ServiceResponse(true, "Employee with id: " + employeeId + " is deleted");
				return new ResponseEntity<ServiceResponse>(response, HttpStatus.OK);
			}
		}
		ServiceResponse response = new ServiceResponse(true,
				"Employee with id: " + employeeId + " is not avilable to delete");
		return new ResponseEntity<ServiceResponse>(response, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<ServiceResponse> addEmployeeWithPost(@RequestBody Employee emp) {
		Employee tempEmp = emp;
		int id = EmployeeService.getUniqueId();
		tempEmp.setId(id);
		EmployeeService.addEmpSet(tempEmp);
		ServiceResponse response = new ServiceResponse(true, "Employee Added Successfuly");
		response.addParam(id + "", tempEmp);
		return new ResponseEntity<ServiceResponse>(response, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.PUT)
	public ResponseEntity<ServiceResponse> addEmployeeWithPut(@PathVariable int employeeId, @RequestBody Employee emp) {
		Iterator<Employee> it = EmployeeService.getEmpSet().iterator();
		while (it.hasNext()) {
			Employee tempEmp = (Employee) it.next();
			if (tempEmp.getId() == employeeId) {
				tempEmp.setId(employeeId);
				tempEmp.setName(emp.getName());
				tempEmp.setSalary(emp.getSalary());
				ServiceResponse repsonse = new ServiceResponse(true,
						"Employee with id " + employeeId + " is updated Successfully");
				repsonse.addParam(tempEmp.getId() + "", tempEmp);
				return new ResponseEntity<ServiceResponse>(repsonse, HttpStatus.OK);
			}
		}
		ServiceResponse response = new ServiceResponse(true, "Employee with id: " + employeeId + " not avilable");
		return new ResponseEntity<ServiceResponse>(response, HttpStatus.NOT_FOUND);
	}

}
