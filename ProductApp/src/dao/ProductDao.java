package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;
import resource.DBResource;
import resource.DBResource;

public class ProductDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	Statement stmt;
	
	public List<Product> Displayallproduct()
	{
		List<Product> listofproduct=new ArrayList<>();
		try
		{
			con = DBResource.getDbConnection();
			pstmt = con.prepareStatement("select * from product");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getFloat(3));
				listofproduct.add(p);
			}
			
		}
		catch(Exception e)
		{
			
		}
		return listofproduct;
	}
	
	
	public int Addproduct(Product pp)
	{
		try
		{
			con=DBResource.getDbConnection();
			pstmt=con.prepareStatement("insert into product values(?,?,?)");
			pstmt.setInt(1, pp.getPid());
			pstmt.setString(2, pp.getPname());
			pstmt.setFloat(3, pp.getPrice());
			int res1=pstmt.executeUpdate();	
			return res1;
		}
		catch(Exception e)
		{
			return 0;
		}
		
	}
	
	public int Updateproduct(Product pp)
	{
		try
		{
			con=DBResource.getDbConnection();
			pstmt=con.prepareStatement("Update product set price=? where pid=?");
			pstmt.setFloat(1, pp.getPrice());
			pstmt.setInt(2, pp.getPid());
			int res1=pstmt.executeUpdate();
			return res1;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
	public int DeleteProduct(Product pp)
	{
		try
		{
			con=DBResource.getDbConnection();
			pstmt=con.prepareStatement("delete from product where pid=?");
			pstmt.setInt(1, pp.getPid());
			int res1=pstmt.executeUpdate();
			return res1;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	
	
	
	

}