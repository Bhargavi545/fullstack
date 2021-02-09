package com.bean;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
	@Entity
	@Table(name="Bill")
	public class Bill {
		@Id
		private int bid;
		private String bname;
	
		@Column(name="dateofpurchase")
		private LocalDate orderDate;

		public int getBid() {
			return bid;
		}

		public void setBid(int bid) {
			this.bid = bid;
		}

		public String getBname() {
			return bname;
		}

		public void setBname(String bname) {
			this.bname = bname;
		}

		public LocalDate getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}

		@Override
		public String toString() {
			return "Bill [bid=" + bid + ", bname=" + bname + ", orderDate=" + orderDate + "]";
		}
	
	}