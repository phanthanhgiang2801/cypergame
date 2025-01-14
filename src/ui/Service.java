/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import manager.ServiceLogDao;
import model.ServiceLog;
import model.UsageLog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;

/**
 *
 * @author ADMIN
 */
public class Service extends javax.swing.JFrame {

    /**
     * Creates new form Service
     */
	public int _usageId ;
	public String usageLog;
	 public Runnable _loadServiceAction;
	public Service() {
        initComponents();
	}
	public Service(int usageId, Runnable reloadListAction) {
		this._usageId = usageId;
		this._loadServiceAction = reloadListAction; 
        initComponents();

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        textField7 = new java.awt.TextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnMyTomTrung = new java.awt.Button();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnBunBoHue = new java.awt.Button();
        jButton6 = new javax.swing.JButton();
        btnComChienTrung = new java.awt.Button();
        jButton7 = new javax.swing.JButton();
        btnMyCay = new java.awt.Button();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        btnTraChanh = new java.awt.Button();
        btnTraDao = new java.awt.Button();
        btnNuocLoc = new java.awt.Button();
        btnNuocNgot = new java.awt.Button();
        txtMyTomTrung = new java.awt.TextField();
        txtBunBoHue = new java.awt.TextField();
        txtComChienTrung = new java.awt.TextField();
        txtMyCay = new java.awt.TextField();
        txtTraChanh = new java.awt.TextField();
        txtNuocLoc = new java.awt.TextField();
        txtNuocNgot = new java.awt.TextField();
        txtTraDao = new java.awt.TextField();
        jButton12 = new javax.swing.JButton();
        jButton12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		_loadServiceAction.run();
            	dispose();
        	}
        });

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jLabel1.setText("jLabel1");

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 0));
        jButton1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Taskbar-Start-Menu-icon.png")); // NOI18N
        jButton1.setText("ĂN NGON CÙNG CYBER GAME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 23;
        gridBagConstraints.ipadx = 164;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 6, 0, 6);
        getContentPane().add(jButton1, gridBagConstraints);

        jButton2.setBackground(new java.awt.Color(255, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Pork-Chop-Set-icon.png")); // NOI18N
        jButton2.setText("Đồ ăn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 28, 0, 0);
        getContentPane().add(jButton2, gridBagConstraints);

        jButton3.setBackground(new java.awt.Color(255, 204, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ADMIN\\Downloads\\Drink-Coke-icon.png")); // NOI18N
        jButton3.setText("Nước uống");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 114, 0, 0);
        getContentPane().add(jButton3, gridBagConstraints);

        btnMyTomTrung.setActionCommand("10k");
        btnMyTomTrung.addActionListener(e ->{btnOkAction(1, txtMyTomTrung.getText());} );

        btnMyTomTrung.setLabel("OK");
        btnMyTomTrung.setName("10k"); 
        btnMyTomTrung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        gbc_btnMyTomTrung = new java.awt.GridBagConstraints();
        gbc_btnMyTomTrung.gridx = 8;
        gbc_btnMyTomTrung.gridy = 2;
        gbc_btnMyTomTrung.ipady = 4;
        gbc_btnMyTomTrung.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_btnMyTomTrung.insets = new java.awt.Insets(10, 15, 0, 0);
        getContentPane().add(btnMyTomTrung, gbc_btnMyTomTrung);
        btnBunBoHue.addActionListener(e ->{btnOkAction(2, txtBunBoHue.getText());} );

        jButton4.setBackground(new java.awt.Color(255, 204, 204));
        jButton4.setText("Bún bò huế");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 28, 0, 0);
        getContentPane().add(jButton4, gridBagConstraints);
        btnComChienTrung.addActionListener(e ->{btnOkAction(3, txtComChienTrung.getText());} );

        jButton5.setBackground(new java.awt.Color(255, 204, 204));
        jButton5.setText("Mỳ tôm trứng");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 28, 0, 0);
        getContentPane().add(jButton5, gridBagConstraints);
        
        btnBunBoHue.setLabel("OK");
        gbc_btnBunBoHue = new java.awt.GridBagConstraints();
        gbc_btnBunBoHue.gridx = 8;
        gbc_btnBunBoHue.gridy = 3;
        gbc_btnBunBoHue.gridheight = 3;
        gbc_btnBunBoHue.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_btnBunBoHue.insets = new java.awt.Insets(31, 15, 0, 0);
        getContentPane().add(btnBunBoHue, gbc_btnBunBoHue);
        
        jButton6.setBackground(new java.awt.Color(255, 204, 204));
        jButton6.setText("Cơm chiên trứng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 28, 0, 0);
        getContentPane().add(jButton6, gridBagConstraints);

        btnComChienTrung.setLabel("OK");
        gbc_btnComChienTrung = new java.awt.GridBagConstraints();
        gbc_btnComChienTrung.gridx = 8;
        gbc_btnComChienTrung.gridy = 6;
        gbc_btnComChienTrung.gridheight = 3;
        gbc_btnComChienTrung.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_btnComChienTrung.insets = new java.awt.Insets(26, 15, 0, 0);
        getContentPane().add(btnComChienTrung, gbc_btnComChienTrung);
        btnMyCay.addActionListener(e ->{btnOkAction(4, txtMyCay.getText());} );

        jButton7.setBackground(new java.awt.Color(255, 204, 204));
        jButton7.setText("Mỳ cay");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 28, 0, 0);
        getContentPane().add(jButton7, gridBagConstraints);

        btnMyCay.setLabel("OK");
        gbc_btnMyCay = new java.awt.GridBagConstraints();
        gbc_btnMyCay.gridx = 8;
        gbc_btnMyCay.gridy = 9;
        gbc_btnMyCay.gridheight = 3;
        gbc_btnMyCay.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_btnMyCay.insets = new java.awt.Insets(35, 15, 0, 0);
        getContentPane().add(btnMyCay, gbc_btnMyCay);
        btnTraChanh.addActionListener(e ->{btnOkAction(5, txtTraChanh.getText());} );

        jButton8.setBackground(new java.awt.Color(255, 204, 204));
        jButton8.setText("Trà chanh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 109, 0, 0);
        getContentPane().add(jButton8, gridBagConstraints);
        btnTraDao.addActionListener(e ->{btnOkAction(6, txtTraDao.getText());} );

        jButton9.setBackground(new java.awt.Color(255, 204, 204));
        jButton9.setText("Trà đào");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 109, 0, 0);
        getContentPane().add(jButton9, gridBagConstraints);
        btnNuocLoc.addActionListener(e ->{btnOkAction(7, txtNuocLoc.getText());} );
        
        jButton10.setBackground(new java.awt.Color(255, 204, 204));
        jButton10.setText("Nước lọc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 109, 0, 0);
        getContentPane().add(jButton10, gridBagConstraints);
        btnNuocNgot.addActionListener(e ->{btnOkAction(8, txtNuocNgot.getText());} );
        
        jButton11.setBackground(new java.awt.Color(255, 204, 204));
        jButton11.setText("Cách loại nước ngọt");
        jButton11.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 109, 0, 0);
        getContentPane().add(jButton11, gridBagConstraints);

        btnTraChanh.setLabel("OK");
        gbc_btnTraChanh = new java.awt.GridBagConstraints();
        gbc_btnTraChanh.gridx = 21;
        gbc_btnTraChanh.gridy = 2;
        gbc_btnTraChanh.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_btnTraChanh.insets = new java.awt.Insets(14, 27, 0, 0);
        getContentPane().add(btnTraChanh, gbc_btnTraChanh);

        btnTraDao.setLabel("OK");
        gbc_btnTraDao = new java.awt.GridBagConstraints();
        gbc_btnTraDao.gridx = 21;
        gbc_btnTraDao.gridy = 3;
        gbc_btnTraDao.gridheight = 3;
        gbc_btnTraDao.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_btnTraDao.insets = new java.awt.Insets(31, 27, 0, 0);
        getContentPane().add(btnTraDao, gbc_btnTraDao);

        btnNuocLoc.setLabel("OK");
        gbc_btnNuocLoc = new java.awt.GridBagConstraints();
        gbc_btnNuocLoc.gridx = 21;
        gbc_btnNuocLoc.gridy = 6;
        gbc_btnNuocLoc.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_btnNuocLoc.insets = new java.awt.Insets(22, 27, 0, 0);
        getContentPane().add(btnNuocLoc, gbc_btnNuocLoc);

        btnNuocNgot.setLabel("OK");
        gbc_btnNuocNgot = new java.awt.GridBagConstraints();
        gbc_btnNuocNgot.gridx = 21;
        gbc_btnNuocNgot.gridy = 9;
        gbc_btnNuocNgot.gridheight = 2;
        gbc_btnNuocNgot.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_btnNuocNgot.insets = new java.awt.Insets(34, 27, 0, 0);
        getContentPane().add(btnNuocNgot, gbc_btnNuocNgot);
        gbc_txtMyTomTrung = new java.awt.GridBagConstraints();
        gbc_txtMyTomTrung.gridx = 3;
        gbc_txtMyTomTrung.gridy = 2;
        gbc_txtMyTomTrung.gridwidth = 5;
        gbc_txtMyTomTrung.ipadx = 65;
        gbc_txtMyTomTrung.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_txtMyTomTrung.insets = new java.awt.Insets(18, 10, 0, 0);
        getContentPane().add(txtMyTomTrung, gbc_txtMyTomTrung);
        gbc_txtBunBoHue = new java.awt.GridBagConstraints();
        gbc_txtBunBoHue.gridx = 3;
        gbc_txtBunBoHue.gridy = 3;
        gbc_txtBunBoHue.gridwidth = 5;
        gbc_txtBunBoHue.ipadx = 65;
        gbc_txtBunBoHue.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_txtBunBoHue.insets = new java.awt.Insets(31, 10, 0, 0);
        getContentPane().add(txtBunBoHue, gbc_txtBunBoHue);
        gbc_txtComChienTrung = new java.awt.GridBagConstraints();
        gbc_txtComChienTrung.gridx = 3;
        gbc_txtComChienTrung.gridy = 6;
        gbc_txtComChienTrung.gridwidth = 5;
        gbc_txtComChienTrung.ipadx = 65;
        gbc_txtComChienTrung.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_txtComChienTrung.insets = new java.awt.Insets(26, 10, 0, 0);
        getContentPane().add(txtComChienTrung, gbc_txtComChienTrung);
        gbc_txtMyCay = new java.awt.GridBagConstraints();
        gbc_txtMyCay.gridx = 3;
        gbc_txtMyCay.gridy = 9;
        gbc_txtMyCay.gridwidth = 5;
        gbc_txtMyCay.gridheight = 3;
        gbc_txtMyCay.ipadx = 65;
        gbc_txtMyCay.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_txtMyCay.insets = new java.awt.Insets(39, 10, 0, 0);
        getContentPane().add(txtMyCay, gbc_txtMyCay);
        gbc_txtTraChanh = new java.awt.GridBagConstraints();
        gbc_txtTraChanh.gridx = 14;
        gbc_txtTraChanh.gridy = 2;
        gbc_txtTraChanh.gridwidth = 7;
        gbc_txtTraChanh.ipadx = 65;
        gbc_txtTraChanh.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_txtTraChanh.insets = new java.awt.Insets(18, 20, 0, 0);
        getContentPane().add(txtTraChanh, gbc_txtTraChanh);
        gbc_txtNuocLoc = new java.awt.GridBagConstraints();
        gbc_txtNuocLoc.gridx = 14;
        gbc_txtNuocLoc.gridy = 6;
        gbc_txtNuocLoc.gridwidth = 7;
        gbc_txtNuocLoc.ipadx = 65;
        gbc_txtNuocLoc.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_txtNuocLoc.insets = new java.awt.Insets(26, 20, 0, 0);
        getContentPane().add(txtNuocLoc, gbc_txtNuocLoc);
        gbc_txtNuocNgot = new java.awt.GridBagConstraints();
        gbc_txtNuocNgot.gridx = 14;
        gbc_txtNuocNgot.gridy = 9;
        gbc_txtNuocNgot.gridwidth = 7;
        gbc_txtNuocNgot.ipadx = 65;
        gbc_txtNuocNgot.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_txtNuocNgot.insets = new java.awt.Insets(36, 20, 0, 0);
        getContentPane().add(txtNuocNgot, gbc_txtNuocNgot);
        gbc_txtTraDao = new java.awt.GridBagConstraints();
        gbc_txtTraDao.gridx = 14;
        gbc_txtTraDao.gridy = 3;
        gbc_txtTraDao.gridwidth = 7;
        gbc_txtTraDao.gridheight = 3;
        gbc_txtTraDao.ipadx = 65;
        gbc_txtTraDao.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc_txtTraDao.insets = new java.awt.Insets(35, 20, 0, 0);
        getContentPane().add(txtTraDao, gbc_txtTraDao);

        jButton12.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Back-Arrow-icon.png")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.ipady = -5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(52, 31, 28, 0);
        getContentPane().add(jButton12, gridBagConstraints);

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }          
    public void btnOkAction(int serviceId, String quantityText) {
        try {
            int quantity = Integer.parseInt(quantityText);
            ServiceLog serviceLog = new ServiceLog(_usageId, serviceId, quantity);
            boolean insertSvLog = ServiceLogDao.insertServiceLog(serviceLog);
            if (insertSvLog) {
                JOptionPane.showMessageDialog(null, "Thêm nhật ký dịch vụ thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Thêm nhật ký dịch vụ thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }	
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Số lượng phải là một số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
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
            java.util.logging.Logger.getLogger(Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Service().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private java.awt.Button btnMyTomTrung;
    private java.awt.Button btnBunBoHue;
    private java.awt.Button btnComChienTrung;
    private java.awt.Button btnMyCay;
    private java.awt.Button btnTraChanh;
    private java.awt.Button btnTraDao;
    private java.awt.Button btnNuocLoc;
    private java.awt.Button btnNuocNgot;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private java.awt.TextField txtMyTomTrung;
    private java.awt.TextField txtBunBoHue;
    private java.awt.TextField txtComChienTrung;
    private java.awt.TextField txtMyCay;
    private java.awt.TextField txtTraChanh;
    private java.awt.TextField txtNuocLoc;
    private java.awt.TextField textField7;
    private java.awt.TextField txtNuocNgot;
    private java.awt.TextField txtTraDao;
    private GridBagConstraints gbc_btnMyTomTrung;
    private GridBagConstraints gbc_btnBunBoHue;
    private GridBagConstraints gbc_btnComChienTrung;
    private GridBagConstraints gbc_btnMyCay;
    private GridBagConstraints gbc_btnTraChanh;
    private GridBagConstraints gbc_btnTraDao;
    private GridBagConstraints gbc_btnNuocLoc;
    private GridBagConstraints gbc_btnNuocNgot;
    private GridBagConstraints gbc_txtMyTomTrung;
    private GridBagConstraints gbc_txtBunBoHue;
    private GridBagConstraints gbc_txtComChienTrung;
    private GridBagConstraints gbc_txtMyCay;
    private GridBagConstraints gbc_txtTraChanh;
    private GridBagConstraints gbc_txtTraDao;
    private GridBagConstraints gbc_txtNuocLoc;
    private GridBagConstraints gbc_txtNuocNgot;
    // End of variables declaration                   
}

