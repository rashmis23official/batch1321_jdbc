package statementdemos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo2 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1321","root","root");
			Statement stmt=con.createStatement();
			int x=stmt.executeUpdate("update student set per=78 where roll='123'");
			
			
			System.out.println(x+ " row are updated");
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
