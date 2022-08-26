package StudentManagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student_Update {
	
	
//	public void checkRoll(Connection con , PreparedStatement psmt , ResultSet rs)
//	{
//		try
//		{
//			String db_roll = "";
//			int db_rollno = 0;
//			
//			String sql = "select rollno from the employee";
//			psmt = con.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			
//			while(rs.next())
//			{
//				db_roll = rs.getString(1);
//				db_rollno = Integer.parseInt(db_roll);
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	
	public Student_Update(PreparedStatement psmt , Connection con , ResultSet rs) {
		
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Plz select what you want to update..");
			System.out.println("<<----------Firstname---------->>");
			System.out.println("<<----------Lastname----------->>");
			System.out.println("<<----------Roll No------------>>");
			System.out.println("<<----------Age---------------->>");
			System.out.println("<<----------Address------------>>");
			System.out.println("<<----------Gender------------->>");
			System.out.println("---------------------------------");
			
			String subSelect = br.readLine();
	
			
			//update via firstname
			if(subSelect.equalsIgnoreCase("firstname"))
			{
				String sql;
				String firstname = "" , rollno = "";
				int roll = 0;
				String answer = "";
				String onceMore = "";
				int db_roll = 0;
				String db_rollno = "";
				while(true)
				{
					sql = "update student set firstname = ? where rollno = ?";
					psmt = con.prepareStatement(sql);
					
					rs = psmt.executeQuery();
					while(rs.next())
					{
						db_rollno = rs.getString("rollno");
						db_roll = Integer.parseInt(db_rollno);
					}
					
					
					if(roll != db_roll)
					{
						System.out.println("Given Rollno is not present in the database");
					}
					else
					{
						System.out.println("Enter the rollno : ");
						rollno = br.readLine();
						roll = Integer.parseInt(rollno);
						
						System.out.println("Enter the new updated firstname : ");
						firstname = br.readLine();
						
						psmt.setString(1, firstname);
						psmt.setInt(2, roll);
						
						psmt.executeUpdate();
						
						System.out.println("Values has been updated");
						System.out.println("-----------------------");
						
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
						
						System.out.println("Are you want to update more data.. ");
						onceMore = br.readLine();
						
						if(onceMore.equalsIgnoreCase("n"))
						{
							break;
						}
					}	
					
				}
			}
			
			//update via lastname
			else if(subSelect.equalsIgnoreCase("lastname"))
			{
				String sql;
				String lastname = "" , rollno = "";
				int roll;
				String answer = "";
				String onceMore = "";
				while(true)
				{
					sql = "update student set lastname = ? where rollno = ?";
					psmt = con.prepareStatement(sql);
					
					System.out.println("Enter the rollno : ");
					rollno = br.readLine();
					roll = Integer.parseInt(rollno);
					
					System.out.println("Enter the new updated lastname : ");
					lastname = br.readLine();
					
					psmt.setString(1, lastname);
					psmt.setInt(2, roll);
					
					psmt.executeUpdate();
					
					System.out.println("Values has been updated");
					System.out.println("-----------------------");
					
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
					
					System.out.println("Are you want to update more data.. ");
					onceMore = br.readLine();
					
					if(onceMore.equalsIgnoreCase("n"))
					{
						break;
					}
				}
			}
			
			//update via rollno
			else if(subSelect.equalsIgnoreCase("rollno"))
			{
				String sql;
				String rollno = "" , rollnos = "";
				int prevroll , newroll;
				String answer = "";
				String onceMore = "";
				while(true)
				{
					sql = "update student set rollno = ? where rollno = ?";
					psmt = con.prepareStatement(sql);
					
					System.out.println("Enter the rollno : ");
					rollno = br.readLine();
					prevroll = Integer.parseInt(rollno);
					
					System.out.println("Enter the new updated rollno : ");
					rollnos = br.readLine();
					newroll  = Integer.parseInt(rollnos);
					
					if(prevroll == newroll)
					{
						throw new ArithmeticException("<<-------Roll No should be unique------->>");
					}
					else
					{
						psmt.setInt(1, prevroll);
						psmt.setInt(2, newroll);
						psmt.executeUpdate();
						
						System.out.println("Values has been updated");
						System.out.println("-----------------------");
						
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
					}
					
					
					System.out.println("Are you want to update more data.. ");
					onceMore = br.readLine();
					
					if(onceMore.equalsIgnoreCase("n"))
					{
						break;
					}
				}
			}
			
			//update via age
			else if(subSelect.equalsIgnoreCase("age"))
			{
				String sql;
				String roll = "" , ages = "";
				int age , rollno;
				String answer = "";
				String onceMore = "";
				while(true)
				{
					sql = "update student set age = ? where rollno = ?";
					psmt = con.prepareStatement(sql);
					
					System.out.println("Enter the rollno : ");
					roll = br.readLine();
					rollno = Integer.parseInt(roll);
					
					System.out.println("Enter the new updated age : ");
					ages = br.readLine();
					age  = Integer.parseInt(ages);
					
					
					psmt.setInt(1, age);
					psmt.setInt(2, rollno);
					psmt.executeUpdate();
					
					System.out.println("Values has been updated");
					System.out.println("-----------------------");
					
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
	
					System.out.println("Are you want to update more data.. ");
					onceMore = br.readLine();
					
					if(onceMore.equalsIgnoreCase("n"))
					{
						break;
					}
				}
			
			}
			
			//update via address
			else if(subSelect.equalsIgnoreCase("address"))
			{
				String sql;
				String address = "" , rollno = "";
				int roll;
				String answer = "";
				String onceMore = "";
				while(true)
				{
					sql = "update student set address = ? where rollno = ?";
					psmt = con.prepareStatement(sql);
					
					System.out.println("Enter the rollno : ");
					rollno = br.readLine();
					roll = Integer.parseInt(rollno);
					
					System.out.println("Enter the new updated address : ");
					address = br.readLine();
					
					psmt.setString(1, address);
					psmt.setInt(2, roll);
					psmt.executeUpdate();
					
					System.out.println("Values has been updated");
					System.out.println("-----------------------");
					
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
					
					System.out.println("Are you want to update more data.. ");
					onceMore = br.readLine();
					
					if(onceMore.equalsIgnoreCase("n"))
					{
						break;
					}
				}
			}

			//update via gender
			else if(subSelect.equalsIgnoreCase("gender"))
			{
				String sql;
				String gender = "" , rollno = "";
				int roll;
				String answer = "";
				String onceMore = "";
				while(true)
				{
					sql = "update student set gender = ? where rollno = ?";
					psmt = con.prepareStatement(sql);
					
					System.out.println("Enter the rollno : ");
					rollno = br.readLine();
					roll = Integer.parseInt(rollno);
					
					System.out.println("Enter the new updated gender : ");
					gender = br.readLine();
					
					psmt.setString(1, gender);
					psmt.setInt(2, roll);
					psmt.executeUpdate();
					
					System.out.println("Values has been updated");
					System.out.println("-----------------------");
					
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
					
					System.out.println("Are you want to update more data.. ");
					onceMore = br.readLine();
					
					if(onceMore.equalsIgnoreCase("n"))
					{
						break;
					}
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
		ResultSet rs = null;
		
		Student_Update st_update = new Student_Update(psmt , con , rs);
	}

}
