package  main;
import com.bean.Bill;
import com.dao.BillDao;

import java.time.LocalDate;
//import java.time.LocalDate;
import java.util.List;
		public class Demo {

			public static void main(String[] args) {
				// TODO Auto-generated method stub
				BillDao bd=new BillDao();
				List<Bill> listOfBill=bd.getAllBill();
				System.out.println("Number of Bills are "+listOfBill.size());

				listOfBill.forEach(b1->System.out.println(b1));
				
				/*for(Bill bb:listOfBill) {
					System.out.println(bb);
				}*/
				/*Bill b = new Bill();
				b.setBid(2);
				b.setBname("suresh");
				LocalDate OrderDate = LocalDate.now();
				b.setOrderDate(OrderDate);

				bd.storeBill(b);*/
				//Delete Product Details 
				//bd.deleteBill(1);

				//Update Query 
	           Bill b = new Bill();
				b.setBid(2);
				b.setBname("hari");
				
				bd.updateBill(b);
				

			
				
			}
}