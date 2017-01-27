package com.restfulwebservicespringBoot.service;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.restfulwebservicespringBoot.domain.Employee;

@Service
public class EmployeeService {

	static int uniqueId = 0;
	static Set<Employee> empSet;

	static {
		empSet = new HashSet<Employee>();
		Employee emp = null;
		for (int i = 1; i <=10; i++) {
			double sal = new SecureRandom().nextInt(400) * 200;
			emp = new Employee(getUniqueId(), "Employee" + i, sal);
			empSet.add(emp);
		}
	}

	public static Set<Employee> getEmpSet() {
		return empSet;
	}

	public static void addEmpSet(Employee emp) {
		empSet.add(emp);
	}

	public static int getUniqueId() {
		return ++uniqueId;
	}
}
