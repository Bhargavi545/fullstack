package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Orders;
import com.dao.OrdersDao;
@Service
public class OrdersService {
	@Autowired
	OrdersDao OrdersDao;
	
	public List<Orders> getAllOrders() {
				return OrdersDao.getAllOrders().stream().filter(ord->ord.getPrice()>100).collect(Collectors.toList());
	
}
	public void  store(Orders os) {
		if(OrdersDao.store(os)> 0) {
			System.out.println("added successfully");
		}
		else {
			System.out.println("adding failed");
		}
	}
	public void delete(int oid) {
		if(OrdersDao.delete(oid)>0) {
			System.out.println( "deleteded successfully");
		}else {
			System.out.println("record not available");
		}
	}
	public void update(int oid, String pname) {
		if(OrdersDao.update(oid,pname)>0) {
			System.out.println( "updated successfully");
		}else {
			System.out.println("record not available");
		}
	}

}
