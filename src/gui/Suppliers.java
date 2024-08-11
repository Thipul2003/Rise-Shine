package gui;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.MySQL;

public class Suppliers extends javax.swing.JPanel {

    private AdminDashboard ad;
    private boolean isValidated = false;
    private String f_name;
    private String l_name;
    private String email;
    private String mobile;
    private String company;
    private String company_id;
    private String supplierId;

    public Suppliers() {
        initComponents();
        supplierTableModel1.setSupplier(this);
        suppId.setVisible(false);

    }

    public JTextField getCompanyId() {
        return companyId;
    }

    public JTextField getCompanyName1() {
        return companyName1;
    }

    public JTextField getSuppFName() {
        return suppFName;
    }

    public JTextField getSupLName() {
        return supLName;
    }

    public JTextField getSupEmail() {
        return supEmail;
    }

    public JTextField getSupMobile() {
        return supMobile;
    }

    public JButton getSupSaveBtn() {
        return supSaveBtn;
    }

    public JButton getSupUpdateBtn() {
        return supUpdateBtn;
    }

    public JButton getSuppDeleteBtn() {
        return suppDeleteBtn;
    }

    public JLabel getSuppId() {
        return suppId;
    }

    private void reset() {
        companyName1.setText("None");
        companyId.setText("None");
        suppFName.setText("");
        supLName.setText("");
        supEmail.setText("");
        supMobile.setText("");
        suppDeleteBtn.setEnabled(false);
        supUpdateBtn.setEnabled(false);
        supSaveBtn.setEnabled(true);
        supplierTableModel1.tableReset();
        isValidated = false;
        suppFName.setEditable(true);
        supLName.setEditable(true);
        supEmail.setEditable(true);
    }

    private void validation() {
        f_name = suppFName.getText();
        l_name = supLName.getText();
        email = supEmail.getText();
        mobile = supMobile.getText();
        company = companyName1.getText();
        try {
            String array[] = companyId.getText().split("-");
            company_id = array[1];
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ad, "Select a Company", "Error", JOptionPane.ERROR_MESSAGE);

        }
        supplierId = suppId.getText();
        String numderRegex = "0((11)|(2(1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}";
        String mobileRegex = "^07[01245678]{1}[0-9]{7}$";
        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";

        if (companyId.equals("None")) {
            JOptionPane.showMessageDialog(ad, "Select a Company", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (company.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Select a Company", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (f_name.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "First Name Field is Empty", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (l_name.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Last Name Field is Empty", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Email Field is Empty", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (!email.matches(emailRegex)) {
            JOptionPane.showMessageDialog(ad, "Invalid Email Address", "Invalid", JOptionPane.WARNING_MESSAGE);

        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Mobile Field is Empty", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (!mobile.matches(mobileRegex)) {
            JOptionPane.showMessageDialog(ad, "Invalid Mobile No", "Invalid", JOptionPane.WARNING_MESSAGE);

        } else {
            isValidated = true;
        }

    }

    private void saveSupplier() {
        validation();
        if (isValidated) {
            try {
                ResultSet resultSet = MySQL.execute("SELECT * FROM `supplier` WHERE `first_name`='" + f_name + "' AND `last_name`='" + l_name + "' AND `email` ='" + email + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(ad, "Supplier Already Registered", "Invalid", JOptionPane.WARNING_MESSAGE);

                } else {
                    MySQL.execute("INSERT INTO `supplier`(`first_name`,`last_name`,`mobile`,`email`,`company_id`,`status_id`) "
                            + "VALUES('" + f_name + "','" + l_name + "','" + mobile + "','" + email + "','" + company_id + "','1')");
                    JOptionPane.showMessageDialog(ad, "Supplier Registered", "Success", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateSupplier() {
        validation();
        if (isValidated) {
            try {
                MySQL.execute("UPDATE `supplier` SET `mobile`='" + mobile + "' WHERE `supplier_id`='" + supplierId + "'");
                JOptionPane.showMessageDialog(ad, "Company Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                reset();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void changeStatus() {
        validation();
        if (isValidated) {
            try {
                if (suppDeleteBtn.getText().equals("Deactive")) {
                    MySQL.execute("UPDATE `supplier` SET `status_id`='2' WHERE `supplier_id`='" + supplierId + "'");
                    JOptionPane.showMessageDialog(ad, "Supplier Deactivated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                } else {
                    MySQL.execute("UPDATE `supplier` SET `status_id`='1' WHERE `supplier_id`='" + supplierId + "'");
                    JOptionPane.showMessageDialog(ad, "Supplier Activated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        supLName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        suppDeleteBtn = new javax.swing.JButton();
        supSaveBtn = new javax.swing.JButton();
        supUpdateBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        selectCompany = new javax.swing.JButton();
        companyId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        companyName1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        suppFName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        supEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        supMobile = new javax.swing.JTextField();
        suppId = new javax.swing.JLabel();
        viewPanel = new javax.swing.JPanel();
        topCompanyBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        supplierTableModel1 = new model.SupplierTableModel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        setLayout(new java.awt.BorderLayout());

        registerPanel.setBackground(new java.awt.Color(255, 255, 255));
        registerPanel.setPreferredSize(new java.awt.Dimension(450, 637));
        registerPanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Supplier Registration");
        registerPanel.add(jLabel1);
        jLabel1.setBounds(90, 25, 160, 45);

        supLName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        supLName.setMargin(new java.awt.Insets(2, 20, 2, 20));
        supLName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                supLNameKeyPressed(evt);
            }
        });
        registerPanel.add(supLName);
        supLName.setBounds(240, 310, 200, 47);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Last Name");
        registerPanel.add(jLabel3);
        jLabel3.setBounds(240, 280, 115, 17);

        jButton3.setBackground(new java.awt.Color(119, 82, 254));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-supplier-25 (1).png"))); // NOI18N
        registerPanel.add(jButton3);
        jButton3.setBounds(25, 25, 49, 45);

        suppDeleteBtn.setBackground(new java.awt.Color(227, 235, 192));
        suppDeleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        suppDeleteBtn.setForeground(new java.awt.Color(255, 51, 51));
        suppDeleteBtn.setText("Deactive");
        suppDeleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        suppDeleteBtn.setEnabled(false);
        suppDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppDeleteBtnActionPerformed(evt);
            }
        });
        registerPanel.add(suppDeleteBtn);
        suppDeleteBtn.setBounds(230, 660, 180, 60);

        supSaveBtn.setBackground(new java.awt.Color(51, 255, 255));
        supSaveBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        supSaveBtn.setForeground(new java.awt.Color(119, 82, 254));
        supSaveBtn.setText("Save Supplier");
        supSaveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supSaveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                supSaveBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                supSaveBtnMouseReleased(evt);
            }
        });
        supSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supSaveBtnActionPerformed(evt);
            }
        });
        registerPanel.add(supSaveBtn);
        supSaveBtn.setBounds(40, 590, 367, 60);

        supUpdateBtn.setBackground(new java.awt.Color(51, 255, 255));
        supUpdateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        supUpdateBtn.setForeground(new java.awt.Color(119, 82, 254));
        supUpdateBtn.setText("Update");
        supUpdateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supUpdateBtn.setEnabled(false);
        supUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supUpdateBtnActionPerformed(evt);
            }
        });
        registerPanel.add(supUpdateBtn);
        supUpdateBtn.setBounds(40, 660, 180, 60);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("then UPDATE or DELETE");
        jLabel5.setIconTextGap(20);
        registerPanel.add(jLabel5);
        jLabel5.setBounds(30, 810, 370, 30);

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-light-on.gif"))); // NOI18N
        jLabel7.setText("Click Save Supplier Button to SAVE");
        jLabel7.setIconTextGap(20);
        registerPanel.add(jLabel7);
        jLabel7.setBounds(40, 750, 380, 30);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-light-on.gif"))); // NOI18N
        jLabel6.setText("Left-Click to select a Supplier,");
        jLabel6.setIconTextGap(20);
        registerPanel.add(jLabel6);
        jLabel6.setBounds(30, 790, 370, 30);

        selectCompany.setBackground(new java.awt.Color(204, 204, 255));
        selectCompany.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        selectCompany.setForeground(new java.awt.Color(0, 0, 153));
        selectCompany.setText("Select Company");
        selectCompany.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCompanyActionPerformed(evt);
            }
        });
        registerPanel.add(selectCompany);
        selectCompany.setBounds(20, 92, 210, 50);

        companyId.setBackground(new java.awt.Color(255, 255, 255));
        companyId.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        companyId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        companyId.setText("None");
        companyId.setEnabled(false);
        registerPanel.add(companyId);
        companyId.setBounds(250, 90, 190, 50);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Company Name:");
        registerPanel.add(jLabel4);
        jLabel4.setBounds(20, 180, 115, 17);

        companyName1.setBackground(new java.awt.Color(255, 255, 255));
        companyName1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        companyName1.setEnabled(false);
        companyName1.setMargin(new java.awt.Insets(2, 20, 2, 20));
        companyName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                companyName1KeyPressed(evt);
            }
        });
        registerPanel.add(companyName1);
        companyName1.setBounds(20, 210, 420, 47);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("First Name");
        registerPanel.add(jLabel8);
        jLabel8.setBounds(20, 280, 74, 17);

        suppFName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        suppFName.setMargin(new java.awt.Insets(2, 20, 2, 20));
        suppFName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                suppFNameKeyPressed(evt);
            }
        });
        registerPanel.add(suppFName);
        suppFName.setBounds(20, 310, 200, 47);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Email");
        registerPanel.add(jLabel9);
        jLabel9.setBounds(20, 370, 36, 17);

        supEmail.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        supEmail.setMargin(new java.awt.Insets(2, 20, 2, 20));
        supEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                supEmailKeyPressed(evt);
            }
        });
        registerPanel.add(supEmail);
        supEmail.setBounds(20, 400, 420, 47);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("First Name");
        registerPanel.add(jLabel10);
        jLabel10.setBounds(20, 280, 74, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Contact no");
        registerPanel.add(jLabel12);
        jLabel12.setBounds(20, 470, 115, 17);

        supMobile.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        supMobile.setMargin(new java.awt.Insets(2, 20, 2, 20));
        supMobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                supMobileKeyPressed(evt);
            }
        });
        registerPanel.add(supMobile);
        supMobile.setBounds(20, 500, 200, 47);

        suppId.setText("jLabel11");
        registerPanel.add(suppId);
        suppId.setBounds(260, 510, 48, 16);

        add(registerPanel, java.awt.BorderLayout.LINE_START);

        viewPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        viewPanel.setLayout(new java.awt.BorderLayout());

        topCompanyBar.setBackground(new java.awt.Color(255, 255, 255));
        topCompanyBar.setPreferredSize(new java.awt.Dimension(624, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Search Supplier");

        jButton2.setBackground(new java.awt.Color(119, 82, 254));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-supplier-25 (1).png"))); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-refresh-30.png"))); // NOI18N
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topCompanyBarLayout = new javax.swing.GroupLayout(topCompanyBar);
        topCompanyBar.setLayout(topCompanyBarLayout);
        topCompanyBarLayout.setHorizontalGroup(
            topCompanyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topCompanyBarLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 500, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topCompanyBarLayout.setVerticalGroup(
            topCompanyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topCompanyBarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(topCompanyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        viewPanel.add(topCompanyBar, java.awt.BorderLayout.PAGE_START);
        viewPanel.add(supplierTableModel1, java.awt.BorderLayout.CENTER);

        add(viewPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void supLNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supLNameKeyPressed

    }//GEN-LAST:event_supLNameKeyPressed

    private void suppDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppDeleteBtnActionPerformed
        changeStatus();
    }//GEN-LAST:event_suppDeleteBtnActionPerformed

    private void supSaveBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supSaveBtnMousePressed
        supSaveBtn.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_supSaveBtnMousePressed

    private void supSaveBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supSaveBtnMouseReleased
        supSaveBtn.setBackground(new Color(51, 255, 255));
    }//GEN-LAST:event_supSaveBtnMouseReleased

    private void supSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supSaveBtnActionPerformed
        saveSupplier();
    }//GEN-LAST:event_supSaveBtnActionPerformed

    private void supUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supUpdateBtnActionPerformed
        updateSupplier();
    }//GEN-LAST:event_supUpdateBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void companyName1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_companyName1KeyPressed

    }//GEN-LAST:event_companyName1KeyPressed

    private void suppFNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suppFNameKeyPressed

    }//GEN-LAST:event_suppFNameKeyPressed

    private void supEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supEmailKeyPressed

    }//GEN-LAST:event_supEmailKeyPressed

    private void supMobileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supMobileKeyPressed

    }//GEN-LAST:event_supMobileKeyPressed

    private void selectCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCompanyActionPerformed
        SelectCompany sc = new SelectCompany(ad, false);
        sc.setVisible(true);
        sc.setSupplier(this);
    }//GEN-LAST:event_selectCompanyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField companyId;
    private javax.swing.JTextField companyName1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JButton selectCompany;
    private javax.swing.JTextField supEmail;
    private javax.swing.JTextField supLName;
    private javax.swing.JTextField supMobile;
    private javax.swing.JButton supSaveBtn;
    private javax.swing.JButton supUpdateBtn;
    private javax.swing.JButton suppDeleteBtn;
    private javax.swing.JTextField suppFName;
    private javax.swing.JLabel suppId;
    private model.SupplierTableModel supplierTableModel1;
    private javax.swing.JPanel topCompanyBar;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
