package eggplant;

import java.sql.*;

import eggplant.People.Janitor;
import eggplant.People.Person;
import eggplant.People.Student;
import eggplant.People.Teacher;

public class Database {

	public static void sendToDatabase(Person person) {
		// Driver loaded
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection conn = null;

		try {
			// Database connection and statement instance
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eggplant", "root", "");
			
			if (person instanceof Student) {
				String query = "insert into students (Name, DateOfBirth, Address, Gender, Major, GPA, Credits, Smoker)" + "values (?, ?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement prepStmt = conn.prepareStatement(query);
				
				prepStmt.setString(1, person.getName().toString());
				prepStmt.setString(2, person.getDob());
				prepStmt.setString(3, person.getAddress().toString());
				prepStmt.setString(4, person.getGender());
				prepStmt.setString(5, ((Student) person).getMajor());
				prepStmt.setDouble(6, ((Student) person).getGpa());
				prepStmt.setInt(7, ((Student) person).getCredits());
				prepStmt.setBoolean(8, person.isSmoker());
				
				prepStmt.execute();
				
				conn.close();
				
			} else if (person instanceof Teacher) {
				String query = "insert into teacher (Name, DateOfBirth, Address, Gender, Subject, NumberOfClasses, OfficeNumber, Smoker)" + "values (?, ?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement prepStmt = conn.prepareStatement(query);
				
				prepStmt.setString(1, person.getName().toString());
				prepStmt.setString(2, person.getDob());
				prepStmt.setString(3, person.getAddress().toString());
				prepStmt.setString(4, person.getGender());
				prepStmt.setString(5, ((Teacher) person).getSubject());
				prepStmt.setDouble(6, ((Teacher) person).getNumOfClasses());
				prepStmt.setString(7, ((Teacher) person).getOfficeNum());
				prepStmt.setBoolean(8, person.isSmoker());
				
				prepStmt.execute();
				
				conn.close();
				
			} else if (person instanceof Janitor) {
				String query = "insert into janitor (Name, DateOfBirth, Address, Gender, YearsOfService, HourlyWage, Smoker)" + "values (?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement prepStmt = conn.prepareStatement(query);
				
				prepStmt.setString(1, person.getName().toString());
				prepStmt.setString(2, person.getDob());
				prepStmt.setString(3, person.getAddress().toString());
				prepStmt.setString(4, person.getGender());
				prepStmt.setInt(5, ((Janitor) person).getYearsOfService());
				prepStmt.setDouble(6, ((Janitor) person).getPayNumeric());
				prepStmt.setBoolean(7, person.isSmoker());
				
				prepStmt.execute();
				
				conn.close();	
				
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
