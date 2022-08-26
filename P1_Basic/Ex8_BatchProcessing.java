package P1_Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex8_BatchProcessing {
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/amit";
	String user = "root";
	String pass = "";
	
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	public Ex8_BatchProcessing() {
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url , user , pass);
			st = con.createStatement();
			
			String sql = "insert into employee values('Gaurav' , 'Bhopal' , 25 , 1018)";
			String sql2 = "insert into employee values('Tanvi' , 'Indore' , 27 , 1019)";
			
			st.addBatch(sql);
			st.addBatch(sql2);
			
			st.executeBatch();
			
			System.out.println("Values has been inserted");
			
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Ex8_BatchProcessing e1 = new Ex8_BatchProcessing();
	}

}
