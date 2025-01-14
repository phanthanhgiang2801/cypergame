package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.Main;
import manager.ComputerDao;
import manager.CustomerDao;
import manager.UsageLogDao;
import model.Computer;
import model.Customer;
import model.UsageLog;

/**
 * Giao diện JFrame hiển thị danh sách phòng máy.
 * 
 * @author ADMIN
 */
public class ListComputer1 extends JFrame {
	private int _customerId = 0;

    /**
     * Phương thức khởi tạo JFrame.
     */
    public ListComputer1() {
        initComponents();
    }

    public ListComputer1(int customerId) {
		// TODO Auto-generated constructor stub
    	this._customerId = customerId;
    	initComponents();
	}

    /**
     * Khởi tạo và cấu hình các thành phần giao diện.
     */
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh sách phòng máy");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Danh sách phòng máy");
        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 16));
        titleLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Drives-Computer-alt-2-Metro-icon.png"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER; 
        add(titleLabel, gbc);

        JButton buttonEmpty = new JButton("Máy trống");
        buttonEmpty.setBackground(new Color(102, 255, 102));
        JButton buttonInUse = new JButton("Máy đang sử dụng");
        buttonInUse.setBackground(new Color(51, 102, 255));
        JButton buttonMaintenance = new JButton("Máy đang bảo trì");
        buttonMaintenance.setBackground(new Color(255, 255, 51));

        gbc.gridy = 1;
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        add(buttonEmpty, gbc); 

        gbc.gridx = 1;
        add(buttonInUse, gbc); 

        gbc.gridx = 2;
        add(buttonMaintenance, gbc); 

        
        List<Computer> computers = ComputerDao.getAllComputers();

        
        int columns = 5; 
        int rowOffset = 2; 

        for (int i = 0; i < computers.size(); i++) {
        	Computer computer = computers.get(i);

            JPanel computerPanel = new JPanel();
            
            computerPanel.setPreferredSize(new Dimension(131, 112));
            computerPanel.setLayout(new BoxLayout(computerPanel, BoxLayout.Y_AXIS)); 
            computerPanel.setBorder(new javax.swing.border.MatteBorder(1, 1, 1, 1, Color.BLACK));
            computerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            computerPanel.setAlignmentY(Component.CENTER_ALIGNMENT);


            switch (computer.getStatus()) {
                case 1 -> computerPanel.setBackground(new Color(51, 102, 255));
                case 2 -> computerPanel.setBackground(new Color(255, 102, 102)); 
                case 3 -> computerPanel.setBackground(new Color(255, 255, 51));
                default -> computerPanel.setBackground(Color.LIGHT_GRAY);
            }

            JLabel computerLabel = new JLabel(computer.getName());
            computerLabel.setHorizontalAlignment(JLabel.CENTER);
            computerLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
            computerPanel.add(computerLabel);

            JLabel statusLabel = new JLabel(computer.getStatusName());
            statusLabel.setHorizontalAlignment(JLabel.CENTER);
            statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
            computerPanel.add(statusLabel); 

            gbc.gridx = i % columns;
            gbc.gridy = rowOffset + i / columns;
            gbc.insets = new Insets(10, 10, 10, 10);
            add(computerPanel, gbc);
            
            computerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                		rentComputer( _customerId,  computer.getId(), computer.getStatus());
                	}  	
                    }
                
            );
        }

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(255, 102, 102));
        gbc.gridx = 0;
        gbc.gridy = rowOffset + (computers.size() / columns) + 1;
        gbc.gridwidth = 3;
        add(backButton, gbc); 

        backButton.addActionListener(e -> {
            
            dispose(); 
            new Main().setVisible(true);  
        });
        pack();
        setLocationRelativeTo(null);
    }

    private void rentComputer(int customerId , int computerId, int status) 	{
    	 if(status == 2 ) {
    		 UsageLog usageLog = new UsageLog(customerId, computerId, new java.sql.Timestamp(System.currentTimeMillis()));
             boolean insertusagelog = UsageLogDao.insertUsageLog(usageLog);
             if (insertusagelog) {
            	 javax.swing.JOptionPane.showMessageDialog(
         	            this,
         	            "Thêm thành công", 
         	            "Thành công", 
         	            javax.swing.JOptionPane.NO_OPTION 
         	        );

            	
             	Satff staff = new Satff(); 
             	staff.show(); 
     			dispose();
             }
             else {
            	 javax.swing.JOptionPane.showMessageDialog(
            	            this,
            	            "Thêm thất bại! Vui lòng thử lại.", 
            	            "Lỗi", 
            	            javax.swing.JOptionPane.ERROR_MESSAGE 
            	        );
             }
    	 } else {
    		 if (status == 1) {
    			 javax.swing.JOptionPane.showMessageDialog(
    	     	            this,
    	     	            "Máy đã có người dử dụng", 
    	     	            "Thông báo", 
    	     	            javax.swing.JOptionPane.ERROR_MESSAGE 
    	     	        );
    		 }
    		 else {
    			 javax.swing.JOptionPane.showMessageDialog(
    	     	            this,
    	     	            "Máy đang bảo trì", 
    	     	            "Thông báo", 
    	     	            javax.swing.JOptionPane.ERROR_MESSAGE 
    	     	        );
    		 }
    		 
    	 }
    	 
         	
    }

    
    /**
     * Phương thức main để chạy ứng dụng.
     * 
     * @param args danh sách tham số dòng lệnh
     */
    public static void main(String[] args) {
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
