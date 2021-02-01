package bean;

import java.time.LocalDate;

public class Product {
		private int pid;
		private String pname;
		private float price;
		private LocalDate storeDate;
		
		public Product(int id, String name, int price,LocalDate storeDate) {
			super();
			this.pid = id;
			this.pname = name;
			this.price = price;
			this.storeDate=storeDate;
		}
		public LocalDate getStoreDate() {
			return storeDate;
		}
		public void setStoreDate(String string) {
			this.storeDate = storeDate
					;
		}
		
		public Product() {
			// TODO Auto-generated constructor stu
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
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
		@Override
		public String toString() {
			return "Product [storeDate=" + storeDate + "]";
		}
		/*public void setStoreDate(String string) {
			// TODO Auto-generated method stub
			
		}*/
	
			
		}

	



