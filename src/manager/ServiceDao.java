package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Service;


public class ServiceDao {

public static List<Service> getAllServices() {
    List<Service> ls = new ArrayList<>();
    String query = "SELECT s.name, sl.quantity"
    		+ "FROM service_logs sl"
    		+ "JOIN services s ON sl.service_id = s.id"
    		+ "JOIN usage_logs u ON sl.usage_id = u.id";
    try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()) {
           while (rs.next()) {
           	ls.add(new Service(
                   rs.getInt("id"),
                   rs.getString("name"),
                   rs.getDouble("price")

               ));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return ls;
   }
}