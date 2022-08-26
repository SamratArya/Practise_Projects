package StudentManagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student_Delete {
	
	ResultSet rs = null;
	
	public Student_Delete(PreparedStatement psmt , Connection con) {
		
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Plz select what you want to delete");
			System.out.println("<<----------VIA----------------->>");
			System.out.println("<<----------Firstname----------->>");
			System.out.println("<<----------Lastname------------>>");
			System.out.println("<<----------Roll No------------->>");
			System.out.println("<<----------Age----------------->>");
			System.out.println("<<----------Address------------->>");
			System.out.println("<<----------Gender-------------->>");
			System.out.println("----------------------------------");
			System.out.println("<<---PRESS D::ALL THE VALUES---->>");
			System.out.println("----------------------------------");

			
			String subSelect = br.readLine();
			
			//IF records is empty 
			if(subSelect.isEmpty())
			{
				System.out.println("All Data has been deleted..");
			}
			else
			{
				//delete via firstname
				if(subSelect.equalsIgnoreCase("firstname"))
				{
					String sql = "";
					String firstname = "" , answer = "" , onceMore = "";
					while(true)
					{
						sql = "delete from student where firstname = ?";
						psmt = con.prepareStatement(sql);
						
						System.out.println("Enter the firstname which you want to delete ");
						firstname = br.readLine();
						
						psmt.setString(1, firstname);
						psmt.executeUpdate();
						
						System.out.println("Values has been deleted");
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
				
				//delete via lastname
				else if(subSelect.equalsIgnoreCase("lastname"))
				{
					String sql = "";
					String lastname = "" , answer = "" , onceMore = "";
					while(true)
					{
						sql = "delete from student where lastname = ?";
						psmt = con.prepareStatement(sql);
						
						System.out.println("Enter the lastname which you want to delete ");
						lastname = br.readLine();
						
						psmt.setString(1, lastname);
						psmt.executeUpdate();
						
						System.out.println("Values has been deleted");
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
				
				//delete via rollno
				else if(subSelect.equalsIgnoreCase("rollno"))
				{
					String sql = "";
					String rollnos = "" , answer = "" , onceMore = "";
					int rollno;
					while(true)
					{
						sql = "delete from student where rollno = ?";
						psmt = con.prepareStatement(sql);
						
						System.out.println("Enter the firstname which you want to delete ");
						rollnos = br.readLine();
						rollno = Integer.parseInt(rollnos);
						
						psmt.setInt(1, rollno);
						psmt.executeUpdate();
						
						System.out.println("Values has been deleted");
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
				
				//delete via age
				else if(subSelect.equalsIgnoreCase("age"))
				{
					String sql = "";
					String firstname = "" , answer = "" , onceMore = "" , rollnos = "";
					int rollno;
					
					System.out.println("Here you have to enter name and age to delete the particular record");
					
					while(true)
					{
						sql = "delete from student where rollno = ? and firstname";
						psmt = con.prepareStatement(sql);
						
						System.out.println("Enter the firstname ");
						firstname = br.readLine();

						System.out.println("Enter the rollno ");
						rollnos = br.readLine();
						rollno = Integer.parseInt(rollnos);
						
						psmt.setInt(1, rollno);
						psmt.setString(2, firstname);
						psmt.executeUpdate();
						
						System.out.println("Values has been deleted");
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
				
				//delete via address
				else if(subSelect.equalsIgnoreCase("address"))
				{
					String sql = "";
					String address = "" , answer = "" , onceMore = "";
					while(true)
					{
						sql = "delete from student where address = ?";
						psmt = con.prepareStatement(sql);
						
						System.out.println("Enter the address which you want to delete ");
						address = br.readLine();
						
						psmt.setString(1, address);
						psmt.executeUpdate();
						
						System.out.println("Values has been deleted");
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
				
				//delete via gender
				else if(subSelect.equalsIgnoreCase("gender"))
				{
					String sql = "";
					String gender = "" , firstname = "" ,  answer = "" , onceMore = "";
					
					String first = "" , gen = "";
					while(true)
					{
						sql = "delete from student where firstname = ? and gender = ? ";
						psmt = con.prepareStatement(sql);
						
						System.out.println("Here you have to put student firstname and gender of its to delete ");
						System.out.println("-------------------------------------------------------------------");
						System.out.println("Enter the firstname : ");
						firstname = br.readLine();
						System.out.println("Enter the gender : ");
						gender = br.readLine();
						
						rs = psmt.executeQuery();
						while(rs.next())
						{
							first = rs.getString("firstname");
							gen = rs.getString("gender");
						}
						
						
						
						psmt.setString(1, firstname);
						psmt.setString(2, gender);
						psmt.executeUpdate();
						
						System.out.println("Values has been deleted");
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
				else if(subSelect.equalsIgnoreCase("d"))
				{
					String answer , onceMore;
					
					String sql = "delete from student";
					psmt = con.prepareStatement(sql);
					psmt.executeUpdate();
					
					System.out.println("All the records has been deleted");
					
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
		
		Student_Delete st_delete = new Student_Delete(psmt , con);
	}

}
