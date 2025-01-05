package ui;

import javax.swing.*;

import model.Computer;
import manager.ComputerDao;
import manager.CustomerDao;

import java.awt.*;
import java.util.List;

public class ListComputer2 extends JFrame {

    public ListComputer2() {
        // Cấu hình JFrame
        setTitle("Danh sách máy tính");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Hiển thị dữ liệu
        displayComputers();
    }

    private void displayComputers() {
        List<Computer> computers =ComputerDao.getAllComputers();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Khoảng cách giữa các ô

        for (int i = 0; i < computers.size(); i++) {
            Computer computer = computers.get(i);

            // Tạo JPanel cho từng máy tính
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(250, 150));
            panel.setLayout(new GridBagLayout());

            // Đặt màu nền dựa trên trạng thái
            switch (computer.getStatus()) {
                case 1 -> panel.setBackground(new Color(51, 102, 255)); // Đang sử dụng
                case 2 -> panel.setBackground(new Color(102, 255, 102)); // Trống
                case 3 -> panel.setBackground(new Color(255, 255, 51));  // Bảo trì
                default -> panel.setBackground(Color.LIGHT_GRAY);        // Không xác định
            }

            // Thêm nhãn tên và trạng thái
            JLabel nameLabel = new JLabel(computer.getName()); 
            JLabel statusLabel = new JLabel("Trạng thái: " + computer.getStatusName());
            panel.add(nameLabel);
            panel.add(statusLabel);


            
            // Đặt vị trí cho JPanel trong GridBagLayout
            gbc.gridx = i % 5; // 5 cột
            gbc.gridy = i / 5; // Số hàng tự động tăng
            add(panel, gbc);
        }

        // Làm mới giao diện
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ListComputer2 frame = new ListComputer2();
            frame.setVisible(true);
        });
    }
}
