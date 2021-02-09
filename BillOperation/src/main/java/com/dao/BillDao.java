package com.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bean.Bill;
import com.bean.Product;

import javax.persistence.Query;


public class BillDao {
	public List<Bill> getAllBill(){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("BillOperation");
		EntityManager manager=emf.createEntityManager();
		Query qry=manager.createQuery("select b from Bill b");
			List<Bill> listOfBill= qry.getResultList();
			return listOfBill;
		}
	public void storeBill(Bill bb) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BillOperation");   // Connection in JDBC 
		EntityManager manager = emf.createEntityManager();					// Statement or PreparedStatement 
			EntityTransaction tran = manager.getTransaction();
				tran.begin();
						manager.persist(bb);					// store the product in DB like insert query 
				tran.commit();
				System.out.println("Record stored successfully..");
	}
	public void deleteBill(int bid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BillOperation");   // Connection in JDBC 
		EntityManager manager = emf.createEntityManager();					// Statement or PreparedStatement 
		EntityTransaction tran = manager.getTransaction();
		
		Bill b= manager.find(Bill.class, bid);			// primary key	if record is available automatically convert record to object 
		if(b==null) {															// select * from product where pid =1
			System.out.println("Product is not present");
		}else {
			tran.begin();
						manager.remove(b);						// delete from product where pid = 1;
			tran.commit();
			System.out.println("Record deleted successfully");
		}
	}
	public void updateBill(Bill bb) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BillOperation");   // Connection in JDBC 
		EntityManager manager = emf.createEntityManager();					// Statement or PreparedStatement 
		EntityTransaction tran = manager.getTransaction();
		
		Bill b	= manager.find(Bill.class,bb.getBid());			// primary key
		if(b==null) {
			System.out.println("Product is not present");
		}else {
			tran.begin();
						b.setBname(b.getBname()+bb.getBname());
						manager.merge(b);									//update price using pid column 
			tran.commit();
			System.out.println("Record updated successfully");
		}
	}
	
	
	}

