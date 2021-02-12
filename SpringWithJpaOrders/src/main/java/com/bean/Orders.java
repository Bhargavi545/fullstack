package com.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Orders {
@Id
private int oid;
private String pname;
private float price;
private LocalDate orderDate;
private String status;
@Override
public String toString() {
	return "Orders [oid=" + oid + ", pname=" + pname + ", price=" + price + ", orderDate=" + orderDate + ", status="
			+ status + "]";
}
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public LocalDate getOrderDate() {
	return orderDate;
}
public void setOrderDate(LocalDate orderDate) {
	this.orderDate = orderDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
