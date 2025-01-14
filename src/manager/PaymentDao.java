package manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import model.Payment;
import model.ServiceLog;
import model.User;

public class PaymentDao {
    public static boolean insertPayment(Payment payment) {
        String query = "INSERT INTO payments (usage_id, payment_date, amount) VALUES (?, ?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, payment.getUsageId());

            // Convert payment.getPaymentDate() to java.sql.Date
            if (payment.getPaymentDate() != null) {
                ZoneId zoneId = ZoneId.systemDefault();
                GregorianCalendar calendar = GregorianCalendar.from(payment.getPaymentDate().toInstant().atZone(zoneId));
                java.sql.Date sqlDate = new java.sql.Date(calendar.getTimeInMillis());
                stmt.setDate(2, sqlDate);
            } else {
                // Handle null payment date (e.g., set it to null in the database)
                stmt.setDate(2, null);
            }

            stmt.setDouble(3, payment.getAmount());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}