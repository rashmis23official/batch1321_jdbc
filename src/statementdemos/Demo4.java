package statementdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo4 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1321","root","root");
			Statement stmt=con.createStatement();
		
			ResultSet rs=stmt.executeQuery("select * from student");
			
			while(rs.next())
			{
//System.out.println(rs.getString("roll")+" "+rs.getString("fullname")+" "+rs.getFloat("per")+" "+rs.getString("address"));
System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getFloat(4)+" "+rs.getString(3));
				
			
			}
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
