package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Computer;
import model.Customer;

public class ComputerDao {

    public static List<Computer> getAllComputers() {
        List<Computer> computers = new ArrayList<>();
        String query = "SELECT c.id, c.name, c.status, cs.status as status_name, c.cost FROM computers c JOIN computer_status cs  on c.status = cs.id order by id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
            	computers.add(new Computer(
                    rs.getInt("id"),	
                    rs.getString("name"),
                    rs.getInt("status"),
                    rs.getString("status_name"),
                    rs.getDouble("cost")
                    
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return computers;
    }

    public static boolean updateComputerStatus(int computerId, int status) {
    	String query = "UPDATE computers SET status = ? WHERE id = ?" ;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

        	stmt.setInt(1, status);
            stmt.setInt(2, computerId);
            
            
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; 

        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

    public static List<Computer> getAllComputerAndCustomerName() {
        List<Computer> computers = new ArrayList<>();

        String query = """
            SELECT 
                c.id, 
                c.name, 
                c.status, 
                cs.status AS status_name, 
                c.cost, 
                u.customer_name
            FROM 
                computers c
            LEFT JOIN (
                SELECT 
                    ul.computer_id, 
                    cus.name AS customer_name
                FROM (
                    SELECT 
                        ul.computer_id, 
                        ul.customer_id, 
                        ul.end_time, 
                        ROW_NUMBER() OVER (PARTITION BY ul.computer_id ORDER BY ul.id DESC) AS row_num
                    FROM 
                        usage_logs ul
                ) ul
                LEFT JOIN customers cus ON ul.customer_id = cus.id
                WHERE ul.row_num = 1 AND ul.end_time IS NULL
            ) u ON c.id = u.computer_id
            LEFT JOIN computer_status cs ON c.status = cs.id;
            """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Computer computer = new Computer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("status"),
                    rs.getString("status_name"),
                    rs.getDouble("cost"),
                    rs.getString("customer_name")
                );
                computers.add(computer);
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace(); 
        }

        return computers;
    }
    public static double getComputerPriceByComputerId(int computerId) {
        double cost = 0.0; // Khởi tạo biến cost để lưu trữ giá máy tính
        String query = "SELECT cost FROM computers WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, computerId); // Set giá trị cho tham số ?

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cost = rs.getDouble("cost"); // Lấy giá từ ResultSet
                } else {
                    System.out.println("Máy tính với ID " + computerId + " không tìm thấy.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cost;
    }

}
