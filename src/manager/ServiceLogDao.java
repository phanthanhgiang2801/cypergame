package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ServiceLog;

public class ServiceLogDao {
	public static boolean insertServiceLog(ServiceLog servicelog) {
        String query = "INSERT INTO service_logs (usage_id, service_id, quantity) VALUES ( ?, ?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, servicelog.getUsageId());
            stmt.setInt(2, servicelog.getServiceId());
            stmt.setInt(3, servicelog.getQuantity());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; 
        

        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
	
	public static List<ServiceLog> getAllServiceLogsByUsageId(int usageId) {
	    List<ServiceLog> ls = new ArrayList<>();
	    String query = "SELECT s.name, sl.quantity, s.price "
	    		+ "FROM service_logs sl "
	    		+ "JOIN services s ON sl.service_id = s.id where usage_id = ?";
	    
	    try (Connection conn = DatabaseConnection.getConnection();
	    		PreparedStatement stmt = conn.prepareStatement(query)) {
	    		stmt.setInt(1, usageId); 
	            ResultSet rs = stmt.executeQuery();
	           while (rs.next()) {
	        	   ls.add(new ServiceLog(
	        		   rs.getString("name"),
	                   rs.getInt("quantity"),
	                   rs.getDouble("price") * Double.parseDouble(String.valueOf(rs.getInt("quantity")))
	                   ))
	            ;
	           }
	       } catch (SQLException e) {
	           e.printStackTrace();
	       }
	       return ls;
	   }
	public static double getServicePriceByUsageId(int usageId) {
	    double totalPrice = 0.0; 

	    String query = "SELECT sl.quantity, s.price "
	                + "FROM service_logs sl "
	                + "JOIN services s ON sl.service_id = s.id "
	                + "WHERE usage_id = ?";

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, usageId);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            // Tính tổng giá tiền
	            do {
	                int quantity = rs.getInt("quantity");
	                double price = rs.getDouble("price");
	                totalPrice += quantity * price;
	            } while (rs.next());
	        } else {
	            System.out.println("Không tìm thấy dịch vụ nào cho usage_id = " + usageId);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return totalPrice;
	}

}


