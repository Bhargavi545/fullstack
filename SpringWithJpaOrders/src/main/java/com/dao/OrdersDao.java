package com.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Orders;

@Repository
public class OrdersDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	
	
	public List<Orders> getAllOrders() {
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select o from Orders o");
		List<Orders> listOfOrders = qry.getResultList();
		return listOfOrders;

	}
	public int  store(Orders os) {
		EntityManager manager=emf.createEntityManager();
		EntityTransaction trn=manager.getTransaction();
		//Orders os=manager.find(Orders.class,oid);
		try {
			trn.begin();
			manager.persist(os);
			trn.commit();
		}catch(Exception e) {
			return 2;
		}
		Orders o=manager.find(Orders.class,os.getOid());
		if(o!=null) {
			return 1;
		}else {
			return 0;
		}
	}

	
	
	
	public int delete(int oid) {
		EntityManager manager=emf.createEntityManager();
		EntityTransaction trn=manager.getTransaction();
		Orders os=manager.find(Orders.class,oid);
		if(os==null) {
			return 0;
		}
		else {
			trn.begin();
			manager.remove(os);
			trn.commit();
			return 1;
		}
	}
	public int update(int oid,String pname) {
		EntityManager manager=emf.createEntityManager();
		EntityTransaction trn=manager.getTransaction();
		Orders os=manager.find(Orders.class,oid);
		if(os==null) {
			return 0;
		}
		else {
			trn.begin();
			os.setPname(pname);
			trn.commit();
			return 1;
		}
	}
	
	
	/*public int storeDetails(int oid,String pname,float price) {
		try {
			//EntityManager manager = emf.createEntityManager();
			//Query qry = manager.createQuery("select o from Orders o");

			Connection con= emf.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into Orders values(?,?,?)");
			pstmt.setInt(1, oid);
			pstmt.setString(2, pname);
			pstmt.setFloat(3, price);	
			int res = pstmt.executeUpdate();
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}*/
	/*public int deleteDetails(int id) {
		try {
			Connection con=ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from employee where id=?");
			pstmt.setInt(1, id);
			int res = pstmt.executeUpdate();
			return res;
		}
		catch(Exception e)
		{
			return 0;
		}*/
	

}
