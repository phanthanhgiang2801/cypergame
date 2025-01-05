package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Computer;

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
}
