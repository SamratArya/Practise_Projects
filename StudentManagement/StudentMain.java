package StudentManagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentMain {
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/student_management";
	String user = "root";
	String pass = "";
	
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	Statement st = null;
	
	public StudentMain() {
		
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url , user , pass);
			con.setAutoCommit(false);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String mainSelect = "";
			String checkRepeat = "";
			
			String sql = "" , firstname = "";
			int first = 0;
			
			System.out.println("Hello Guys....How's you're day..!!!");
			System.out.println("---------------------------------");
			System.out.println("\n\n");
			
			while(true)
			{
				System.out.println("Plz select the type what you want");
				System.out.println("<<----------1..Insert---------->>");
				System.out.println("<<----------2..Update---------->>");
				System.out.println("<<----------3..Delete---------->>");
				System.out.println("<<----------4..View------------>>");
				System.out.println("---------------------------------");
				
				mainSelect = br.readLine();
				
				sql = "select * from student";
				psmt = con.prepareStatement(sql);
				rs = psmt.executeQuery();
				
				
				while(rs.next())
				{
					firstname = rs.getString(1);
					first = Integer.parseInt(firstname);
				}
				
				
				if(first <= 0)
				{
					System.err.println("Plz Insert Some Value");
				}
				else
				{
					switch (mainSelect) 
					{
						case "1":
							Student_Insert st_insert = new Student_Insert(psmt , con);
							break;
							
						case "2":
							Student_Update st_update = new Student_Update(psmt , con , rs);
							break;
							
						case "3":
							Student_Delete st_delete = new Student_Delete(psmt , con);
							break;
							
						case "4":
							Student_View st_view = new Student_View(psmt , con);
							break;
							
						default:
							break;
					}
				}

				System.out.println("\n");
				System.out.println("Do you want to repeat the task");
				checkRepeat = br.readLine();
				
				if(checkRepeat.equalsIgnoreCase("n"))
				{
					break;
				}
				
			}
			
			psmt.close();
			con.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		StudentMain s1 = new StudentMain();
	}

}
