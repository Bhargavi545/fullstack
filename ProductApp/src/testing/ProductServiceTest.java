/**
 * 
 */
package testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Product;
import service.ProductService;

/**
 * @author Bharghavi
 *
 */
public class ProductServiceTest {
	static ProductService ps;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ps=new ProductService();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AfterClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("BeforeClass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("AfterClass");
	}

	/**
	 * Test method for {@link service.ProductService#Displayallproduct()}.
	 */
	@Test
	public void testDisplayallproduct() {
		List<Product> listofproduct = ps.Displayallproduct();
		assertEquals(3,listofproduct.size());

	}

	/**
	 * Test method for {@link service.ProductService#Addproduct(bean.Product)}.
	 */
	@Test
	public void testAddproduct() {
		Product p=new Product();
		p.setPid(2);
		p.setPname("box");
		p.setPrice(1700);
		String res=ps.Addproduct(p);
		String msg="Recored Added Successfully";
		assertEquals(msg,res);
	}

	/**
	 * Test method for {@link service.ProductService#Updateproduct(bean.Product)}.
	 */
	@Test
	public void testUpdateproduct() {
		Product p=new Product();
		p.setPid(104);
		p.setPrice(1200);
		String res	= ps.Updateproduct(p);
		assertEquals("Product Updated Successfully", res);
	}

	/**
	 * Test method for {@link service.ProductService#DeleteProduct(bean.Product)}.
	 */
	@Test
	public void testDeleteProduct() {
		Product p=new Product();
		p.setPid(104);
		String res=ps.DeleteProduct(p);
		assertEquals("Product deleted",res);

	
	}

	/**
	 * Test method for {@link service.ProductService#DisplayProductBYPriceASC()}.
	 */
	@Test
	public void testDisplayProductBYPriceASC() {
		List<Product> listofproduct=ps.DisplayProductBYPriceASC();
		assertEquals(2, listofproduct.size());
		Product p= listofproduct.get(0);
		assertEquals("gold", p.getPname());
		Product p1= listofproduct.get(1);
		assertEquals("silver", p1.getPname());
		Product p2= listofproduct.get(2);
		assertEquals("TV", p2.getPname());		
	}

	/**
	 * Test method for {@link service.ProductService#DisplayProductBYPriceDESC()}.
	 */
	@Test
	public void testDisplayProductBYPriceDESC() {
		List<Product> listofproduct=ps.DisplayProductBYPriceDESC();
		assertEquals(3, listofproduct.size());
		Product p= listofproduct.get(0);
		assertEquals("TV", p.getPname());
		Product p1= listofproduct.get(1);
		assertEquals("gold", p1.getPname());
		Product p2= listofproduct.get(2);
		assertEquals("silver", p2.getPname());	
	}

	/**
	 * Test method for {@link service.ProductService#DisplayProductBYNameASC()}.
	 */
	@Test
	public void testDisplayProductBYNameASC() {
		List<Product> listofproduct=ps.DisplayProductBYNameASC();
		assertEquals(3, listofproduct.size());
		Product p= listofproduct.get(0);
		assertEquals("gold", p.getPname());
			}

}
