package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import manager.ComputerDao;
import model.Computer;

/**
 * Giao diện JFrame hiển thị danh sách phòng máy.
 * 
 * @author ADMIN
 */
public class ListComputer1 extends JFrame {

    /**
     * Phương thức khởi tạo JFrame.
     */
    public ListComputer1() {
        initComponents();
    }

    /**
     * Khởi tạo và cấu hình các thành phần giao diện.
     */
    private void initComponents() {
        // Thiết lập JFrame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh sách phòng máy");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Tiêu đề của giao diện
        JLabel titleLabel = new JLabel("Danh sách phòng máy");
        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 16));
        titleLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Drives-Computer-alt-2-Metro-icon.png"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER; // Căn giữa tiêu đề
        add(titleLabel, gbc);

        // Các nút trạng thái (Máy trống, Máy đang sử dụng, Máy đang bảo trì)
        JButton buttonEmpty = new JButton("Máy trống");
        buttonEmpty.setBackground(new Color(102, 255, 102));
        JButton buttonInUse = new JButton("Máy đang sử dụng");
        buttonInUse.setBackground(new Color(51, 102, 255));
        JButton buttonMaintenance = new JButton("Máy đang bảo trì");
        buttonMaintenance.setBackground(new Color(255, 255, 51));

        gbc.gridy = 1;
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        add(buttonEmpty, gbc); // Thêm nút "Máy trống"

        gbc.gridx = 1;
        add(buttonInUse, gbc); // Thêm nút "Máy đang sử dụng"

        gbc.gridx = 2;
        add(buttonMaintenance, gbc); // Thêm nút "Máy đang bảo trì"

        // Lấy danh sách dữ liệu các máy từ cơ sở dữ liệu
        List<Computer> computers = ComputerDao.getAllComputers();

        // Hiển thị danh sách các máy trong giao diện
        int columns = 5; // Số cột hiển thị các máy
        int rowOffset = 2; // Dòng bắt đầu hiển thị danh sách máy

        for (int i = 0; i < computers.size(); i++) {
            Computer computer = computers.get(i);

            // Tạo và cấu hình JPanel cho từng máy
            JPanel computerPanel = new JPanel();
            computerPanel.setPreferredSize(new Dimension(131, 112));
            computerPanel.setLayout(new GridBagLayout());
            computerPanel.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, Color.BLACK));

            // Đặt màu nền của JPanel theo trạng thái của máy
            switch (computer.getStatus()) {
                case 1 -> computerPanel.setBackground(new Color(51, 102, 255)); // Máy đang sử dụng
                case 2 -> computerPanel.setBackground(new Color(102, 255, 102)); // Máy trống
                case 3 -> computerPanel.setBackground(new Color(255, 255, 51));  // Máy đang bảo trì
                default -> computerPanel.setBackground(Color.LIGHT_GRAY);        // Trạng thái không xác định
            }

            // Thêm nhãn tên máy và trạng thái vào JPanel
            JLabel computerLabel = new JLabel(computer.getName() + " - " + computer.getStatusName());
            computerLabel.setHorizontalAlignment(JLabel.CENTER);
            computerPanel.add(computerLabel);

            // Xác định vị trí đặt JPanel trong lưới GridBagLayout
            gbc.gridx = i % columns; // Cột của máy
            gbc.gridy = rowOffset + i / columns; // Dòng của máy
            gbc.insets = new Insets(10, 10, 10, 10); // Khoảng cách giữa các JPanel
            add(computerPanel, gbc); // Thêm JPanel vào giao diện
        }

        // Làm mới giao diện và hiển thị JFrame ở giữa màn hình
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Phương thức main để chạy ứng dụng.
     * 
     * @param args danh sách tham số dòng lệnh
     */
    public static void main(String[] args) {
        /* Cài đặt giao diện Nimbus */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ListComputer1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Khởi chạy giao diện */
        java.awt.EventQueue.invokeLater(() -> new ListComputer1().setVisible(true));
    }
}
