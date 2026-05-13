package statementdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1321","root","root");
			Statement stmt=con.createStatement();
			int x=stmt.executeUpdate("insert into student value('567','Ramesh','pune',89)");
			System.out.println(x+ " row are inserted");
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}		
	}
}
