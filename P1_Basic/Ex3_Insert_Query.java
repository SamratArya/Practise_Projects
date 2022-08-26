package P1_Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex3_Insert_Query {
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/amit";
	String user = "root";
	String pass = "";
	
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	int result = 0;
	
	public Ex3_Insert_Query() {
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url , user , pass);
			st = con.createStatement();
			
			String sql = "insert into employee values('Amarkant' , 'Nashik' , 24 , 1014)";
			
			result = st.executeUpdate(sql);
			
			System.out.println("Values has been inserted..."+result);
			
			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Ex3_Insert_Query e1 = new Ex3_Insert_Query();
	}

}
