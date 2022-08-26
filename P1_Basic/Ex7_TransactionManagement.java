package P1_Basic;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;

import java.io.*;;

public class Ex7_TransactionManagement {
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/amit";
	String user = "root";
	String pass = "";
	
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public Ex7_TransactionManagement() {
		
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url , user , pass);
			con.setAutoCommit(false);
			
			String sql = "insert into employee values(?,?,?,?)";
			
			psmt = con.prepareStatement(sql);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
			
			while(true)
			{
				System.out.println("Enter the name");
				String name = br.readLine();
				
				System.out.println("Enter the address");
				String address = br.readLine();
				
				System.out.println("Enter the age");
				String age1 = br.readLine();
				int age = Integer.parseInt(age1);
				
				System.out.println("Enter the ID");
				String id1 = br.readLine();
				int id = Integer.parseInt(id1);
				
				psmt.setString(1, name);
				psmt.setString(2, address);
				psmt.setInt(3, age);
				psmt.setInt(4, id);
				
				psmt.executeUpdate();
				
				System.out.println("commit/rollback");
				String answer = br.readLine();
				
				if(answer.equals("commit"))
				{
					con.commit();
				}
				
				if(answer.equals("rollback"))
				{
					con.rollback();
				}
				
				
				System.out.println("Are you want to add more records y/n");
				String value = br.readLine();
				
				if(value.equals("n") || value.equals("N"))
				{
					break;
				}
				
			}
			
			con.commit();
			con.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Ex7_TransactionManagement e1 = new Ex7_TransactionManagement();
	}

}
