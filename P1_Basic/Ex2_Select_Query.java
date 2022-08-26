package P1_Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex2_Select_Query {
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/amit";
	String user = "root";
	String pass = "";
	
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	public Ex2_Select_Query() {
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url , user , pass);
			st = con.createStatement();
			
			String sql = "select name , max(age) as 'Highest_Age' from employee";
			
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println("Name : "+rs.getString(1)+" Age : "+rs.getInt(2));
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Ex2_Select_Query e1 = new Ex2_Select_Query();
	}

}
