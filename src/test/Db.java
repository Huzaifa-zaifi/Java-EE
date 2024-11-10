package test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db {
	static Connection connection;
	
	// Creating connection with Database
	public static String connection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5454/Mydb";
		String user = "postgres";
		String pass = "root";
	    
		connection = DriverManager.getConnection(url, user, pass);
	
	    if(connection != null) {
	        return "Connected to the PostgreSQL server successfully." ;
	    } 
	    else{
	        return "Connection failded.";
	        
	    }
	}
	
	// Adding Logic
	public static String add(Student st) throws SQLException {
		
		String q = "insert into students(\"rollNo\",\"Name\", \"bonafide\") values(?,?,?)";
		PreparedStatement p = connection.prepareStatement(q);
		p.setInt(1, st.getRoll());
		p.setString(2, st.getName());
		p.setBoolean(3, st.getB());
		
		p.executeUpdate();
		return "Successfully added";
	}
	
	// Delete Logic
	public static String delete(int r) throws SQLException {
		String q = "delete from students where \"rollNo\" = ?";
		PreparedStatement p = connection.prepareStatement(q);
		p.setInt(1, r);
		p.executeUpdate();
		return "Successfully Deleted";
	}
	
	
	
	// Update logic
	public static String update(String name, int roll, Boolean f) throws SQLException {
		String q = "update students set \"Name\" = ?, \"bonafide\" = ? where \"rollNo\" = ? ";
		PreparedStatement p = connection.prepareStatement(q);
		p.setString(1, name);
		p.setBoolean(2, f);
		p.setInt(3, roll);
		p.executeUpdate();
		return "Successfully Updated";
	}
	
	
	
	// Showing record logic
	public static void show() throws SQLException {
		String q = "select * from students;";
		Statement s = connection.createStatement();
		ResultSet sc = s.executeQuery(q);
		while(sc.next()) {
			System.out.println("RollNo: "+sc.getInt("rollNO"));
			System.out.println("Name: "+sc.getString(2));
			System.out.println("Bonafide: "+sc.getBoolean(3));
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		}
	}
}