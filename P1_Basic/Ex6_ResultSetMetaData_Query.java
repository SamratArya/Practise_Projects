package P1_Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Ex6_ResultSetMetaData_Query {
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/amit";
	String user = "root";
	String pass = "";
	
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	ResultSetMetaData rsmt = null;
	
	int result = 0;
	
	public Ex6_ResultSetMetaData_Query() {
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url , user , pass);
			
			String sql = "select * from employee ";
			
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			rsmt = rs.getMetaData();
			
			System.out.println("Total No of Cols : "+rsmt.getColumnCount());
			System.out.println("Coloumn Type : "+rsmt.getColumnTypeName(2));
			
			psmt.close();
			rs.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		Ex6_ResultSetMetaData_Query e1 = new Ex6_ResultSetMetaData_Query();
	}
	

}
