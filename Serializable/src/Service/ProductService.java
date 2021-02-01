package Service;
import java.io.Serializable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import bean.Product;
public class ProductService implements Serializable {
	ArrayList <Product>pt=new ArrayList<Product>();
	Product p;
	FileOutputStream fos;
	ObjectOutputStream oos;
	public void addProduct(int pid,String pname,int price) throws IOException {
		p=new Product(pid,pname,price);
		pt.add(p);
		fos=new FileOutputStream("C:\\Users\\Bharghavi\\Documents\\java progrms\\product.txt");
		oos=new ObjectOutputStream(fos);
		oos.writeObject(p);
	}
	public void update(int pid,int price) throws IOException {
		for(Product p:pt) {
			if(pid==p.getPid()) {
				p.setPrice(price);
				fos=new FileOutputStream("C:\\Users\\Bharghavi\\Documents\\java progrms\\Product.txt");
				oos=new ObjectOutputStream(fos);
				oos.writeObject(p);
			
				
			}
		}
		
	}
	public void delete(int pid) throws IOException {
		for(Product p:pt) {
			if(pid==p.getPid()) {
				int i=pt.indexOf(p);
				pt.remove(i);
				fos=new FileOutputStream("C:\\Users\\Bharghavi\\Documents\\java progrms\\product.txt");
				oos=new ObjectOutputStream(fos);
				oos.writeObject(p);
				oos.close();
				fos.close();
			
				
			}
			
		
	}

}
	public ArrayList<Product>display(){
		return pt;
	}
	public int retrieve(int pid) {
		for(Product p:pt) {
			if(pid==p.getPid()) {
				return p.getPrice();
			}
			
	
	}
		return 0;
	
	}
}	
