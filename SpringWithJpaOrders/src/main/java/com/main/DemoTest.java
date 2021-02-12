package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Orders;
import com.service.OrdersService;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		OrdersService es = (OrdersService)ac.getBean("ordersService");
	//	es.getAllOrders().forEach(ord->System.out.println(ord));
//es.delete(2);
//es.update(1,"earrings");
Orders os=new Orders();
os.setOid(3);
os.setPname("lapy");
os.setPrice(100000);
//os.setOrderDate("2030-10-11");
os.setStatus("pending");
System.out.println(os);
	}

}
