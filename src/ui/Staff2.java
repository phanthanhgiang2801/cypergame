/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;

import model.Customer;
import manager.CustomerDao;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author ADMIN
 */
public class Staff2 extends javax.swing.JFrame {

	public Customer customer = new Customer();
    /**
     * Creates new form Member
     */
    public Staff2() {
        initComponents();
        loadCustomers();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">       
    
    
    
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.addMouseListener(new MouseAdapter() {
        });
        jTable1 = new javax.swing.JTable();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int selectedRow = jTable1.getSelectedRow(); // lấy chỉ số index
                if (selectedRow >= 0) { // Ensure a valid row is selected
                	
                	int id = (int )jTable1.getValueAt(selectedRow, 0);
                    String nameValue = (String) jTable1.getValueAt(selectedRow, 1).toString(); // 
                    int phoneNumberValue = (int) jTable1.getValueAt(selectedRow, 2); // Column index 2 for phone number
                    
                    customer = new Customer(id , phoneNumberValue, nameValue );

                }
            }
        });
        
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ui.Edit lg = new ui.Edit(); 
				lg.show(); 
				dispose();
        	}
        });
        jButton8.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Edit-validated-icon.png"));
        jButton3 = new javax.swing.JButton();
        jButton3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		gui.Main lg = new gui.Main(); 
				lg.show(); 
				dispose();
        	}
        });
        
        jButton3.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Back-Arrow-icon.png"));

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jTable1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                		 "ID", "Họ tên", "Số điện thoại"
                }
            ) {
                boolean[] canEdit = new boolean[]{
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
        
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(153, 255, 204));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\Downloads\\123414.jpg")); // NOI18N
        jButton2.setText("Danh sách hội viên");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 255, 204));
        jButton6.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Load-Balancer-icon.png")); // NOI18N
        jButton6.setText("Nạp tiền");

        jButton7.setBackground(new java.awt.Color(255, 102, 255));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jButton7.setText("Quản lý tài khoản");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(102, 255, 102));
        jButton8.setText("Chỉnh sửa");

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        
        JButton jButton8_1 = new JButton();
        jButton8_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                btnEditCustomer();
        	}
        });
        jButton8_1.setText("Chỉnh sửa");
        jButton8_1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Edit-validated-icon.png"));
        jButton8_1.setBackground(new Color(102, 255, 102));
        
        jButton8_2 = new JButton();
        jButton8_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnDeleteCustomer();
        	}
        });
        jButton8_2.setText("Chỉnh sửa");
        jButton8_2.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Edit-validated-icon.png"));
        jButton8_2.setBackground(new Color(102, 255, 102));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButton7, GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
        					.addGap(198)
        					.addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
        					.addGap(58)
        					.addComponent(jButton8_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton8_2, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        					.addGap(0, 13, Short.MAX_VALUE)))
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jButton2)
        			.addGap(0, 784, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jButton8_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButton7, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
        							.addGap(18)
        							.addComponent(jButton2))
        						.addComponent(jButton8_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        
    
    private void btnEditCustomer() {
    	Edit editForm = new Edit(customer, "EDIT");
        
        editForm.setVisible(true);
        dispose(); // Close the current form
    }
    private void btnDeleteCustomer() {
    	Edit editForm = new Edit(customer, "DELETE");
        
        editForm.setVisible(true);
        dispose(); // Close the current form
    }
    private void loadCustomers() {
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        table.setRowCount(0);
        List<Customer> listCustommer = CustomerDao.getAllCustomer();
        for (Customer ct : listCustommer) {
        	table.addRow(new Object[]{
                ct.getId(),
                ct.getName(),
                ct.getPhonenumber()                
            });
        }
    }
   

    /**
     * @param args the command line arguments
     */
 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Staff2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private JButton jButton8_2;
}
