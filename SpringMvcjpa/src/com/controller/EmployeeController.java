package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Employee;
import com.service.EmployeeService;
@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
//@RequestMapping(value="store",method=RequestMethod.POST)

/*public ModelAndView storeEmployeeDetails(HttpServletRequest req,Employee emp){
emp.setId(Integer.parseInt(req.getParameter("id")));
emp.setName(req.getParameter("name"));
emp.setSalary(Float.parseFloat(req.getParameter("salary")));
ModelAndView mvn=new ModelAndView();
 String res=employeeService.storeEmployee(emp);
System.out.println(res);
mvn.setViewName("EmployeeStore.jsp");
return mvn;*/

/*@RequestMapping(value="delete",method=RequestMethod.POST)
public ModelAndView deleteEmployeeDetails(HttpServletRequest req,int id){
	ModelAndView mvn=new ModelAndView();
	 String res=employeeService.deleteEmployee(id);
	 mvn.setViewName("Employeedelete.jsp");
	 return mvn;	
}*/
/*@RequestMapping(value="update",method=RequestMethod.POST)
public ModelAndView deleteEmployeeDetails(HttpServletRequest req,int id,String name){
	ModelAndView mvn=new ModelAndView();
	 String res=employeeService.updateEmployee(id,name);
	 mvn.setViewName("Employeeupdate.jsp");
	 return mvn;
	
}*/

@RequestMapping(value="retrive",method=RequestMethod.GET)
public ModelAndView getAllEmployee(HttpServletRequest req){
	ModelAndView mvn=new ModelAndView();
	List<Employee>listOfemp=employeeService.getAllEmployee();
	listOfemp.forEach(emp->System.out.println(emp));
	mvn.setViewName("retrive.jsp");
return mvn;
}

}
