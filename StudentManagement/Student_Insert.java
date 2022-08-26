package StudentManagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student_Insert {
	
	public Student_Insert(PreparedStatement psmt , Connection con) {
		
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String sql;
			String firstname  , lastname  , roll  , ages  , address  , gender ;
			int rollno , age;
			String answer;
			String onceMore;
			
			sql = "insert into student values(?,?,?,?,?,?)";
			
			psmt = con.prepareStatement(sql);
			
			while(true)
			{
					
				System.out.println("Enter the firstname : ");
				firstname = br.readLine();
				
				System.out.println("Enter the lastname : ");
				lastname = br.readLine();
				
				System.out.println("Enter the rollno : ");
				roll = br.readLine();
				rollno = Integer.parseInt(roll);
				
				System.out.println("Enter the age : ");
				ages = br.readLine();
				age = Integer.parseInt(ages);
				
				System.out.println("Enter the address : ");
				address = br.readLine();
				
				System.out.println("Enter the gender : ");
				gender = br.readLine();
				
				psmt.setString(1, firstname);
				psmt.setString(2, lastname);
				psmt.setInt(3, rollno);
				psmt.setInt(4, age);
				psmt.setString(5, address);
				psmt.setString(6, gender);
				
				psmt.executeUpdate();
				
				
				System.out.println("commit/rollback");
				answer = br.readLine();
				
				if(answer.equalsIgnoreCase("commit"))
				{
					con.commit();
				}
				
				if(answer.equalsIgnoreCase("rollback"))
				{
					con.rollback();
				}
				
				System.out.println("Are you want to insert more data.. ");
				onceMore = br.readLine();
				
				if(onceMore.equalsIgnoreCase("n"))
				{
					break;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement psmt = null;
		
		Student_Insert st_insert = new Student_Insert(psmt , con);
	}

}
