package statementdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo5 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1321","root","root");
			Statement stmt=con.createStatement();
		
			ResultSet rs=stmt.executeQuery("select fullname,per from student");
			
			while(rs.next())
			{
//				System.out.println(rs.getString("fullname")+" "+rs.getFloat("per"));
				System.out.println(rs.getString(1)+" "+rs.getFloat(2));
			}
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
