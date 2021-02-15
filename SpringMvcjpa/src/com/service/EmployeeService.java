package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;

@Service
public class EmployeeService {
	@Autowired
EmployeeDao employeeDao;
public String storeEmployee(Employee emp) {
	if(employeeDao.storeEmployee(emp)>0) {
		return "successful";
		
	}else {
		return "failed";
	}
}
public String deleteEmployee(int id) {
	if(employeeDao.deleteEmployee(id)>0) {
		return "deleted successfully";
	}else {
		return "deleted failed";
	}
	
}
public String updateEmployee(int id, String name) {
	if(employeeDao.updateEmployee(id,name)>0) {
		return( "updated successfully");
	}else {
		return("record not available");
	}
	
}
public List<Employee> getAllEmployee(){
	return employeeDao.getAllEmployee().stream().collect(Collectors.toList());
}
}

