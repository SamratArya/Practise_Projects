package P1_Basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex1_Check {
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/amit";
	String user = "root";
	String pass = "";
	
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	
	public Ex1_Check() {
		
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url , user , pass);
			st = con.createStatement();
			
			String sql = "select * from employee";
			
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println("Name : "+rs.getString(1)+" Address : "+rs.getString(2)+" Age : "+rs.getInt(3)+" Id : "+rs.getInt(4));
			}
			
			rs.close();
			st.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Ex1_Check e1 = new Ex1_Check();
	}

}
