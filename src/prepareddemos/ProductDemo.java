package prepareddemos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
class Product
{
	int saveProduct(int i,String n,String cat,float c,int q)
	{
		int x=0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1321","root","root");
			PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?)");
			ps.setInt(1, i);
			ps.setString(2, n);
			ps.setString(3, cat);
			ps.setFloat(4, c);
			ps.setInt(5, q);
			
			x=ps.executeUpdate();
			con.close();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
		return x;
	}
	
	int updateProduct(int i,float c,int q)
	{
		int x=0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1321","root","root");
			PreparedStatement ps=con.prepareStatement("update product set cost=?, qty=? where id=?");
			ps.setFloat(1, c);
			ps.setInt(2, q);
			ps.setInt(3, i);
			System.out.println("before execute x = "+x);
			x=ps.executeUpdate();
			System.out.println("x = "+x);
			con.close();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return x;
	}
	
	
	
	
	
	
	
	void deleteProduct(int i)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1321","root","root");
			PreparedStatement ps=con.prepareStatement("delete from product where id=?");
			ps.setInt(1, i);			
			ps.executeUpdate();			
			con.close();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
	
	
	
	

	void viewProductById(int i)
	{try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1321","root","root");
		PreparedStatement ps=con.prepareStatement("select * from product where id=?");
		ps.setInt(1, i);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"
					+ rs.getFloat(4)+"\t"+rs.getInt(5));
			
		}
		
		con.close();			
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	
	
	
	
	void viewAllProduct()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1321","root","root");
			PreparedStatement ps=con.prepareStatement("select * from product");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"
						+ rs.getFloat(4)+"\t"+rs.getInt(5));
				
			}
			
			con.close();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}





public class ProductDemo {		
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Product p=new Product();		
		do
		{
			System.out.println("1.save\n2.update\n3.delete\n4.view all\n5.view by id\n6.exit");
			System.out.println("enter the choice");
			int ch=sc.nextInt();			
			switch(ch)
			{
			case 1:
				System.out.println("enter the id,name,category ,cost and qty");
				int pid=sc.nextInt();
				String pname=sc.next();
				String pcat=sc.next();
				float pcost=sc.nextFloat();
				int pqty=sc.nextInt();
				int res=p.saveProduct(pid,pname,pcat,pcost,pqty);
				if(res>0)
				{
					System.out.println(res+" row/s inserted");
				}
				else
				{
					System.out.println("error in save()");
				}				
				break;
			case 2:
				System.out.println("enter the id and updated cost and qty");
				pid=sc.nextInt();
				pcost=sc.nextFloat();
				pqty=sc.nextInt();
				res=p.updateProduct(pid,pcost,pqty);
				if(res>0)
				{
					System.out.println(res+" row/s updated");
				}
				else
				{
					System.out.println("error in update()");
				}
				break;
			case 3:
				System.out.println("enter the id ");
				pid=sc.nextInt();
				
				p.deleteProduct(pid);
				System.out.println("deleted");
				break;
			case 4:
				p.viewAllProduct();
				break;
			case 5:
				System.out.println("enter the id");
				int id=sc.nextInt();
				p.viewProductById(id);
				break;
			case 6:
				System.exit(0);;
				break;
				default:
					System.out.println("invalid action");
				
				
			}
			
			
			
		}while(true);

	}
}













