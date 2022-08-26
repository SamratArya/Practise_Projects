package P1_Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex4_Update_Query {
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/amit";
	String user = "root";
	String pass = "";
	
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	int result = 0;
	
	public Ex4_Update_Query() {
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url , user , pass);
			st = con.createStatement();
			
			String sql = "update employee set age = 27 where name = 'Arya' ";
			
			result = st.executeUpdate(sql);
			
			System.out.println("Values has been updated..."+result);
			
//			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Ex4_Update_Query e1 = new Ex4_Update_Query();
	}

}
