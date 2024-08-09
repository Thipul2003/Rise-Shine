package gui;

import model.MySQL;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Company extends javax.swing.JPanel {

    private boolean isValidated = false;
    private String company_name;
    private String contact;
    private AdminDashboard ad;

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public JButton getUpdateBtn() {
        return updateBtn;
    }

    public JButton getDeleteBtn() {
        return deleteBtn;
    }

    public JTextField getCompanyName() {
        return companyName;
    }

    public JTextField getCompanyContact() {
        return companyContact;
    }

    public Company() {
        initComponents();
        registerPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        viewPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 12");
        companyTableModel1.setCompany(this);
    }

    private void reset() {
        companyName.setText("");
        companyContact.setText("");
        deleteBtn.setEnabled(false);
        updateBtn.setEnabled(false);
        saveBtn.setEnabled(true);
        companyName.setEditable(true);
        companyTableModel1.tableReset();
        isValidated = false;
    }

    private void validation() {
        company_name = companyName.getText();
        contact = companyContact.getText();
        String numderRegex = "0((11)|(2(1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))[0-9]{7}";
//        String specialCharacterRegex = ".*[^a-zA-Z''].*";

        if (company_name.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Company Field is Empty", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (contact.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Contact Field is Empty", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (!contact.matches(numderRegex)) {
            JOptionPane.showMessageDialog(ad, "Invalid Contact No", "Invalid", JOptionPane.WARNING_MESSAGE);

        } else {
            isValidated = true;
        }

    }

    private void saveCompany() {
        validation();
        if (isValidated) {
            try {
                ResultSet resultSet = MySQL.execute("SELECT * FROM `company` WHERE `name`='" + company_name + "' OR `contact`='" + contact + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(ad, "Company Already Exist", "Invalid", JOptionPane.WARNING_MESSAGE);

                } else {
                    MySQL.execute("INSERT INTO `company`(`name`,`contact`,`status_id`) VALUES('" + company_name + "','" + contact + "','1')");
                    JOptionPane.showMessageDialog(ad, "Company Registered", "Success", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateCompany() {
        validation();
        if (isValidated) {
            try {
                MySQL.execute("UPDATE `company` SET `contact`='" + contact + "' WHERE `name`='" + company_name + "'");
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
                if (deleteBtn.getText().equals("Deactive")) {
                    MySQL.execute("UPDATE `company` SET `status_id`='2' WHERE `name`='" + company_name + "'");
                    JOptionPane.showMessageDialog(ad, "Company Deactivated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                } else {
                    MySQL.execute("UPDATE `company` SET `status_id`='1' WHERE `name`='" + company_name + "'");
                    JOptionPane.showMessageDialog(ad, "Company Activated", "Success", JOptionPane.INFORMATION_MESSAGE);
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
        companyName = new javax.swing.JTextField();
        companyContact = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        viewPanel = new javax.swing.JPanel();
        topCompanyBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        companyTableModel1 = new model.CompanyTableModel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        setLayout(new java.awt.BorderLayout());

        registerPanel.setBackground(new java.awt.Color(255, 255, 255));
        registerPanel.setPreferredSize(new java.awt.Dimension(400, 637));
        registerPanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Company Registration");
        registerPanel.add(jLabel1);
        jLabel1.setBounds(79, 25, 165, 45);

        companyName.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        companyName.setMargin(new java.awt.Insets(2, 20, 2, 20));
        companyName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                companyNameKeyPressed(evt);
            }
        });
        registerPanel.add(companyName);
        companyName.setBounds(21, 135, 367, 44);

        companyContact.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        companyContact.setMargin(new java.awt.Insets(2, 20, 2, 20));
        companyContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                companyContactKeyPressed(evt);
            }
        });
        registerPanel.add(companyContact);
        companyContact.setBounds(21, 232, 367, 47);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Company Name:");
        registerPanel.add(jLabel3);
        jLabel3.setBounds(21, 103, 115, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Company Contact No:");
        registerPanel.add(jLabel4);
        jLabel4.setBounds(21, 197, 154, 17);

        jButton3.setBackground(new java.awt.Color(119, 82, 254));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-company-25 (1).png"))); // NOI18N
        registerPanel.add(jButton3);
        jButton3.setBounds(25, 25, 49, 45);

        deleteBtn.setBackground(new java.awt.Color(51, 255, 255));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(119, 82, 254));
        deleteBtn.setText("Deactive");
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.setEnabled(false);
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        registerPanel.add(deleteBtn);
        deleteBtn.setBounds(210, 390, 180, 51);

        saveBtn.setBackground(new java.awt.Color(51, 255, 255));
        saveBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(119, 82, 254));
        saveBtn.setText("Save Company");
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                saveBtnMouseReleased(evt);
            }
        });
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        registerPanel.add(saveBtn);
        saveBtn.setBounds(21, 323, 367, 51);

        updateBtn.setBackground(new java.awt.Color(51, 255, 255));
        updateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(119, 82, 254));
        updateBtn.setText("Update");
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.setEnabled(false);
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        registerPanel.add(updateBtn);
        updateBtn.setBounds(20, 390, 180, 51);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("then UPDATE or DELETE");
        jLabel5.setIconTextGap(20);
        registerPanel.add(jLabel5);
        jLabel5.setBounds(0, 540, 370, 30);

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-light-on.gif"))); // NOI18N
        jLabel7.setText("Click Save Company Button to SAVE");
        jLabel7.setIconTextGap(20);
        registerPanel.add(jLabel7);
        jLabel7.setBounds(10, 480, 380, 30);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-light-on.gif"))); // NOI18N
        jLabel6.setText("Left-Click to select a Company,");
        jLabel6.setIconTextGap(20);
        registerPanel.add(jLabel6);
        jLabel6.setBounds(0, 520, 370, 30);

        add(registerPanel, java.awt.BorderLayout.LINE_START);

        viewPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        viewPanel.setLayout(new java.awt.BorderLayout());

        topCompanyBar.setBackground(new java.awt.Color(255, 255, 255));
        topCompanyBar.setPreferredSize(new java.awt.Dimension(624, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Search Company");

        jButton2.setBackground(new java.awt.Color(119, 82, 254));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-company-25 (1).png"))); // NOI18N

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
            .addGroup(topCompanyBarLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
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
        viewPanel.add(companyTableModel1, java.awt.BorderLayout.CENTER);

        add(viewPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMousePressed
        saveBtn.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_saveBtnMousePressed

    private void saveBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseReleased
        saveBtn.setBackground(new Color(51, 255, 255));

    }//GEN-LAST:event_saveBtnMouseReleased

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        saveCompany();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        updateCompany();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        changeStatus();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void companyNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_companyNameKeyPressed

    }//GEN-LAST:event_companyNameKeyPressed

    private void companyContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_companyContactKeyPressed

    }//GEN-LAST:event_companyContactKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField companyContact;
    private javax.swing.JTextField companyName;
    private model.CompanyTableModel companyTableModel1;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JPanel topCompanyBar;
    private javax.swing.JButton updateBtn;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
