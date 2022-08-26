package P1_Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex5_PreparedStatement_Query {
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/amit";
	String user = "root";
	String pass = "";
	
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	int result = 0;
	
	public Ex5_PreparedStatement_Query() {
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url , user , pass);
			
			String sql = "insert into employee values(?,?,?,?)";
			
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, "Shiva");
			psmt.setString(2, "Dadri");
			psmt.setInt(3, 25);
			psmt.setInt(4, 1015);
			
			result = psmt.executeUpdate();
			System.out.println("Row has been inserted "+result);
			
			psmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Ex5_PreparedStatement_Query e1 = new Ex5_PreparedStatement_Query();
	}

}
