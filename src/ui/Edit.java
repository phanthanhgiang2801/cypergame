/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import model.Customer;
import manager.ComputerDao;
import manager.CustomerDao;
import manager.UserDao;
import model.Computer;
import model.User;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;

/**
 *
 * @author ADMIN
 */
public class Edit extends javax.swing.JFrame {
	
	public String _type = "INSERT";
	public Customer _customer = new Customer();
	
    public Edit() {
        initComponents();
    }
    public Edit(Customer customer, String type) {
    	this._customer = customer;
    	this._type = type;
    	initComponents();
    	 name.setText(customer.getName()); 
    	 phonNumber.setText(String.valueOf(customer.getPhonenumber()));
    }
    @SuppressWarnings("unchecked")
                         
    private void initComponents() {

    	
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        jButton3.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\add-icon.png"));
        jButton4 = new javax.swing.JButton();
        jButton4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        jButton4.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Edit-validated-icon.png"));
        jButton5 = new javax.swing.JButton();
        jButton5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        jButton5.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Button-Close-icon.png"));
        jButton6 = new javax.swing.JButton();
        jButton6.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Save-as-icon.png"));
        jButton7 = new javax.swing.JButton();
        
        jButton7.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		ui.Satff lg = new ui.Satff(); 
        		lg.show(); 
        		dispose();
        	}
        });

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Số điện thoại :");

        jLabel2.setText("Họ tên :");

        jButton3.setBackground(new java.awt.Color(153, 255, 153));
        jButton3.setText("ADD");
        
        jButton3.addActionListener(e ->{btnAddAction();} );
        
        jButton4.setBackground(new java.awt.Color(255, 255, 51));
        jButton4.setText("EDIT");
        
        jButton4.addActionListener(e ->{btnEditAction( _customer.getId() );} );


        jButton5.setBackground(new java.awt.Color(255, 204, 204));
        jButton5.setText("DELETE");
        
        jButton5.addActionListener(e ->{btnDeleteAction( _customer.getId() );} );        
        jButton6.setBackground(new java.awt.Color(0, 255, 204));
        

        if ("DELETE".equals(_type)) {
            jButton6.setText("DELETE");
        } else {
            jButton6.setText("SAVE");
        }

        jButton7.setBackground(new java.awt.Color(255, 51, 51));
        
        jButton7.setText("EXIT");
       
        
        name = new JTextField();
        name.setColumns(10);
        
        phonNumber = new JTextField();
        phonNumber.setColumns(10);
        
        lbThongBao = new JLabel("");
        lbThongBao.setForeground(new Color(204, 0, 51));
        lbThongBao.setBackground(new Color(255, 0, 51));

        jButton3.setVisible(false); // ADD
        jButton4.setVisible(false); // EDIT
        jButton5.setVisible(false); // DELETE
        jButton6.setVisible(true); // SAVE
        jButton6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnSaveAction();
        	}
        });
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addGap(58)
        					.addComponent(phonNumber, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        					.addGap(96)
        					.addComponent(jButton7)
        					.addContainerGap())
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel2)
        					.addGap(88)
        					.addComponent(name, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        					.addGap(161))))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(27)
        			.addComponent(jButton3)
        			.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
        			.addComponent(jButton4)
        			.addGap(55)
        			.addComponent(jButton5)
        			.addGap(55)
        			.addComponent(jButton6)
        			.addGap(28))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(181)
        			.addComponent(lbThongBao, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jButton7)
        			.addGap(44)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(name, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        			.addGap(46)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1)
        				.addComponent(phonNumber, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton6)
        				.addComponent(jButton3)
        				.addComponent(jButton5)
        				.addComponent(jButton4))
        			.addGap(53)
        			.addComponent(lbThongBao)
        			.addGap(57))
        );
        
        getContentPane().setLayout(layout);
        setSize(2000, 1500);
        setLocationRelativeTo(null);

        pack();
    }
    
    private void btnAddAction() {
        String a = name.getText().trim();
        
        String phoneText = phonNumber.getText().trim();

        if (!phoneText.matches("\\d+")) {
            lbThongBao.setText("Thêm thất bại!");
            return;
        }

        int b = Integer.parseInt(phoneText);
        
        Customer customer = new Customer(b,a);
        boolean insertCustomer = CustomerDao.insertCustomer(customer);
        if (insertCustomer) {
        	Satff lg = new Satff(); 
			lg.show(); 
			dispose();
        }
        else {
        	lbThongBao.setText("Thêm thất bại");
        }
        	
    }
    private void btnEditAction(int id) {
    	String a = name.getText().trim();
    	String phoneText = phonNumber.getText().trim();
    	
    	if (a.isEmpty() || phoneText.isEmpty()) {
            lbThongBao.setText("Không thể sửa vì thiếu thông tin (Họ tên hoặc Số điện thoại)!");
            return;
        }
    	
    	if (!phoneText.matches("\\d+")) {
            lbThongBao.setText("Sửa thất bại!");
            return;
        }

        int b = Integer.parseInt(phoneText);
        Customer customer = new Customer(id,b,a);
        boolean editCustomer = CustomerDao.editCustomer(customer);
        if (editCustomer) {
            lbThongBao.setText("Sửa thành công!");

        }
        else {
        	lbThongBao.setText("Sửa thất bại!");
        }
        	
    }
    private void btnDeleteAction(int id) {
    	String nameText = name.getText().trim();
        String phoneText = phonNumber.getText().trim();

        if (nameText.isEmpty() || phoneText.isEmpty()) {
            lbThongBao.setText("Không thể xóa vì thiếu thông tin (Họ tên hoặc Số điện thoại)!");
            return;
        }
        int customerId = _customer.getId(); 

        boolean isDeleted = CustomerDao.deleteCustomer(customerId);

        if (isDeleted) {
            lbThongBao.setText("Xóa thành công!");
           
        } else {
            lbThongBao.setText("Xóa thất bại!");
        }
    }

    private void btnSaveAction() {
        switch (_type) {
            case "INSERT":
            	btnAddAction();
                break;
            case "EDIT":
            	btnEditAction(_customer.getId());
                break;
            case "DELETE":
                btnDeleteAction(_customer.getId());
                break;
            default:
                
                break;
        };
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) { 	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit().setVisible(true);
            }
        });
    }
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private JTextField name;
    private JTextField phonNumber;
    private JLabel lbThongBao;
}
