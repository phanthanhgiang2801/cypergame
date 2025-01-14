package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Computer;
import model.Customer;

public class CustomerDao {
    public static List<Customer> getAllCustomer() {
        List<Customer> ls = new ArrayList<>();
        String query = "SELECT * FROM customers ";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

               while (rs.next()) {
               	ls.add(new Customer(
                       rs.getInt("id"),
                       rs.getInt("phone_number"),
                       rs.getString("name")

                   ));
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return ls;
       }
    public static List<Customer> getAllCustomer1(String name) {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customers WHERE name LIKE ?";  

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%"+ name + "%");  
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                customers.add(new Customer(
                        rs.getInt("id"),
                        rs.getInt("phone_number"),
                        rs.getString("name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    public static boolean insertCustomer(Customer customer) {
        String query = "INSERT INTO customers (phone_number, name) VALUES ( ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, customer.getPhonenumber());
            stmt.setString(2, customer.getName());


            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; 

        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
    
    public static boolean editCustomer(Customer customer) {
        String query = "UPDATE customers SET phone_number = ? , name = ? WHERE id = ?" ;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, customer.getPhonenumber());
            stmt.setString(2, customer.getName());
            stmt.setInt(3, customer.getId());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; 

        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
    public static boolean deleteCustomer( int id) {
        String query = "DELETE FROM customers WHERE id = ?" ;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id );

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; 

        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

	public static List<Computer> getAllComputers() {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Customer> searchCustomers(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}
   }
