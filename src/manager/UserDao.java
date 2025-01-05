package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {
	
	  public static User login (String userName, String password) {
	        String query = "SELECT * FROM users WHERE username = ? AND password = ? LIMIT 1";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)	) 
	        {
	        	   stmt.setString(1, userName); 
	    	       stmt.setString(2, password); 
	        
	            ResultSet rs = stmt.executeQuery();
		        List<User> user = new ArrayList<>();
	            while (rs.next()) {
	            	user.add(new User(
	                        rs.getString("username"),
	                        rs.getInt("password")
	                       
	                ));
	            }
	            if(user.isEmpty()) {
		           return null;
	            }
	            return user.get(0);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;

	        }
	    }
	  
	  public static List<User> searchStudents(String keyword) {
	        List<User> students = new ArrayList<>();
	        String query = "SELECT * FROM user WHERE username LIKE ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(query)) {

	            stmt.setString(1, "%" + keyword + "%");
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                students.add(new User(
	                        rs.getString("username"),
	                        rs.getInt("password")
	                       
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return students;
	    }
}