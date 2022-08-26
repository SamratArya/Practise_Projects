package StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student_View {
	
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public Student_View(PreparedStatement psmt , Connection con) {
		
		try
		{
			String sql = "select * from student ";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next())
			{
				System.out.println("FirstName : "+rs.getString(1)+" LastName : "+rs.getString(2)+" RollNo : "+rs.getInt(3)+" Age : "+rs.getInt(4)+" Address : "+rs.getString(5)+" Gender : "+rs.getString(6));
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		Student_View st_view = new Student_View(psmt , con);
	}

}
