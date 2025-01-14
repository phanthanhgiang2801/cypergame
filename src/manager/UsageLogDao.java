package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import model.Computer;
import model.Customer;
import model.UsageLog;

public class UsageLogDao {
    public static List<UsageLog> getAllUsageLogs() {
        List<UsageLog> usageLogs = new ArrayList<>();
        String query = "SELECT ul.*, c.name AS computer_name, cus.name AS customer_name " +
                "FROM usage_logs ul " +
                "INNER JOIN computer c ON ul.computer_id = c.id " +
                "INNER JOIN customer cus ON ul.customer_id = cus.id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
            	usageLogs.add(new UsageLog(
                        rs.getInt("id"),
                        rs.getInt("customer_id"),
                        rs.getString("computer_name"),// Include customer ID
                        rs.getInt("computer_id"),
                        rs.getString("customer_name"),
                        rs.getDate("start_time"),
                        rs.getDate("end_time")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usageLogs;
    }
    public static boolean insertUsageLog(UsageLog  usageLog) {
        String query = "INSERT INTO usage_logs (computer_id, customer_id, start_time) VALUES ( ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

        	stmt.setInt(1, usageLog.getComputerId()); 
            stmt.setInt(2, usageLog.getCustomerId()); 
            stmt.setTimestamp(3, new java.sql.Timestamp(usageLog.getStartTime().getTime())); 

            int rowsInserted = stmt.executeUpdate();
            if(rowsInserted > 0) {
            	System.out.println( usageLog.getComputerId());
            	 boolean computer = ComputerDao.updateComputerStatus(usageLog.getComputerId(), 1);
            }
            return rowsInserted > 0; 

        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
    public static UsageLog getUsageLogByComputerId(int computerId) {
        UsageLog usageLog = null;
        String query = """
            SELECT 
                ul.*, 
                c.name AS computer_name, 
                cus.name AS customer_name
            FROM 
                usage_logs ul
            INNER JOIN 
                computers c ON ul.computer_id = c.id
            INNER JOIN 
                customers cus ON ul.customer_id = cus.id
            WHERE 
                ul.computer_id = ? 
                AND ul.end_time IS NULL
            ORDER BY 
                ul.id DESC
            LIMIT 1
            """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, computerId); // Set the computerId parameter

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usageLog = new UsageLog(
                        rs.getInt("id"),
                        rs.getInt("customer_id"),
                        rs.getString("customer_name"),
                        rs.getInt("computer_id"),
                        rs.getString("computer_name"),
                        rs.getTimestamp("start_time"),
                        rs.getTimestamp("end_time")
                    );
                }
            }
        } catch (SQLException e) {
            // Log the error properly
            System.err.println("SQL Error: " + e.getMessage());
        }

        return usageLog;
    }
    

    public static boolean updateEndtimeByUsageId(int usageId, Date endTime) {
        String query = "UPDATE usage_logs SET end_time = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Convert endTime to java.sql.Date (assuming it's a Date object)
            if (endTime != null) {
                ZoneId zoneId = ZoneId.systemDefault();
                GregorianCalendar calendar = GregorianCalendar.from(endTime.toInstant().atZone(zoneId));
                java.sql.Date sqlDate = new java.sql.Date(calendar.getTimeInMillis());
                stmt.setDate(1, sqlDate);
            } else {
                // Handle null endTime (e.g., set it to null in the database)
                stmt.setDate(1, null);
            }

            stmt.setInt(2, usageId);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}



