package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;

@Repository
public class EmployeeDao {
	
@Autowired
EntityManagerFactory emf;
public int storeEmployee(Employee emp) {
EntityManager manager=emf.createEntityManager();
EntityTransaction tran=manager.getTransaction();
tran.begin();
  manager.persist(emp);
tran.commit();
Employee e=manager.find(Employee.class,emp.getId());
if(e!=null) {
	return 1;
}else {
	return 0;
}
}
public int deleteEmployee(int id) {
	EntityManager manager=emf.createEntityManager();
	EntityTransaction trn=manager.getTransaction();
	Employee e=manager.find(Employee.class,id);
	if(e==null) {
		return 0;
	}
	else {
		trn.begin();
		manager.remove(e);
		trn.commit();
		return 1;
	}
}
public int updateEmployee(int id,String name) {
	EntityManager manager=emf.createEntityManager();
	EntityTransaction trn=manager.getTransaction();
	Employee e=manager.find(Employee.class,id);
	if(e==null) {
		return 0;
	}
	else {
		trn.begin();
		e.setName(name);
		trn.commit();
		return 1;
	}
}
public List<Employee> getAllEmployee(){
	EntityManager manager=emf.createEntityManager();
	Query qry=manager.createQuery("select  e from Employee e");
	List<Employee> listOfemp=qry.getResultList();
	return listOfemp;
}
}