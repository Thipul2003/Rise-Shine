package gui;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import javax.swing.UIManager;

public class Company extends javax.swing.JPanel {

    public Company() {
        initComponents();
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(119, 82, 254));
        jTable1.getTableHeader().setForeground(Color.WHITE);
        registerPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 8");
        viewPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 8");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
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
        companySearch = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        viewCompanyPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        setLayout(new java.awt.BorderLayout());

        registerPanel.setBackground(new java.awt.Color(255, 255, 255));
        registerPanel.setPreferredSize(new java.awt.Dimension(400, 637));
        registerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Company Registration");
        registerPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 25, -1, 45));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField1.setMargin(new java.awt.Insets(2, 20, 2, 20));
        registerPanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 135, 367, 44));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextField2.setMargin(new java.awt.Insets(2, 20, 2, 20));
        registerPanel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 232, 367, 47));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Company Name:");
        registerPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 103, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Company Contact No:");
        registerPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 197, -1, -1));

        jButton3.setBackground(new java.awt.Color(119, 82, 254));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-company-25 (1).png"))); // NOI18N
        registerPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, 49, 45));

        deleteBtn.setBackground(new java.awt.Color(51, 255, 255));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(119, 82, 254));
        deleteBtn.setText("Delete");
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.setEnabled(false);
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        registerPanel.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 180, 51));

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
        registerPanel.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 323, 367, 51));

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
        registerPanel.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 180, 51));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("then UPDATE or DELETE");
        jLabel5.setIconTextGap(20);
        registerPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 370, 30));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-light-on.gif"))); // NOI18N
        jLabel7.setText("Click Save Company Button to SAVE");
        jLabel7.setIconTextGap(20);
        registerPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 380, 30));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-light-on.gif"))); // NOI18N
        jLabel6.setText("Double-Click to select a Company,");
        jLabel6.setIconTextGap(20);
        registerPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 370, 30));

        add(registerPanel, java.awt.BorderLayout.LINE_START);

        viewPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        viewPanel.setLayout(new java.awt.BorderLayout());

        topCompanyBar.setBackground(new java.awt.Color(255, 255, 255));
        topCompanyBar.setPreferredSize(new java.awt.Dimension(624, 140));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Search Company");

        companySearch.setBackground(new java.awt.Color(240, 240, 240));
        companySearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        companySearch.setForeground(new java.awt.Color(153, 153, 153));
        companySearch.setText("Search company");
        companySearch.setMargin(new java.awt.Insets(2, 20, 2, 2));
        companySearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                companySearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                companySearchFocusLost(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(119, 82, 254));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-company-25 (1).png"))); // NOI18N

        javax.swing.GroupLayout topCompanyBarLayout = new javax.swing.GroupLayout(topCompanyBar);
        topCompanyBar.setLayout(topCompanyBarLayout);
        topCompanyBarLayout.setHorizontalGroup(
            topCompanyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topCompanyBarLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(403, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topCompanyBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(companySearch)
                .addContainerGap())
        );
        topCompanyBarLayout.setVerticalGroup(
            topCompanyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topCompanyBarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(topCompanyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(companySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewPanel.add(topCompanyBar, java.awt.BorderLayout.PAGE_START);

        viewCompanyPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewCompanyPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        viewCompanyPanel.setLayout(new java.awt.BorderLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Company Name", "Contact Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        viewCompanyPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        viewPanel.add(viewCompanyPanel, java.awt.BorderLayout.CENTER);

        add(viewPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void companySearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_companySearchFocusGained
        companySearch.setText("");
    }//GEN-LAST:event_companySearchFocusGained

    private void companySearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_companySearchFocusLost
        companySearch.setText("Search Company");
    }//GEN-LAST:event_companySearchFocusLost

    private void saveBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMousePressed
        saveBtn.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_saveBtnMousePressed

    private void saveBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseReleased
        saveBtn.setBackground(new Color(51,255,255));

    }//GEN-LAST:event_saveBtnMouseReleased

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField companySearch;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JPanel topCompanyBar;
    private javax.swing.JButton updateBtn;
    private javax.swing.JPanel viewCompanyPanel;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
