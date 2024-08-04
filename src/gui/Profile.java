package gui;

import com.formdev.flatlaf.FlatClientProperties;

public class Profile extends javax.swing.JPanel {

    public Profile() {
        initComponents();
        loadProfile();
        profilePic.putClientProperty(FlatClientProperties.STYLE, "arc: 999");

    }
    
    private void loadProfile(){
    
        try {
            
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileTop = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        profileContent = new javax.swing.JPanel();
        center = new javax.swing.JPanel();
        ProfileInfo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        addImg = new javax.swing.JButton();
        profilePic = new javax.swing.JPanel();
        profName = new javax.swing.JLabel();
        profEmail = new javax.swing.JLabel();
        profRole = new javax.swing.JLabel();
        profileForm = new javax.swing.JPanel();
        firstPanel = new javax.swing.JPanel();
        TextFieldPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        TextFieldPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        TextFieldPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        secondLine = new javax.swing.JPanel();
        TextFieldPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        TextFieldPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        TextFieldPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        TextFieldPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        TextFieldPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 5));
        setLayout(new java.awt.BorderLayout());

        profileTop.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        profileTop.setPreferredSize(new java.awt.Dimension(1017, 70));
        profileTop.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(119, 82, 254));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-male-user-25 (1).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Profile");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(940, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        profileTop.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(profileTop, java.awt.BorderLayout.PAGE_START);

        profileContent.setBackground(new java.awt.Color(255, 255, 255));
        profileContent.setLayout(new java.awt.BorderLayout());

        center.setLayout(new java.awt.BorderLayout());

        ProfileInfo.setBackground(new java.awt.Color(255, 255, 255));
        ProfileInfo.setPreferredSize(new java.awt.Dimension(617, 400));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-plus-50.png"))); // NOI18N
        addImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(addImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 80, 80));

        profilePic.setBackground(new java.awt.Color(153, 0, 255));

        javax.swing.GroupLayout profilePicLayout = new javax.swing.GroupLayout(profilePic);
        profilePic.setLayout(profilePicLayout);
        profilePicLayout.setHorizontalGroup(
            profilePicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        profilePicLayout.setVerticalGroup(
            profilePicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        jPanel4.add(profilePic, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 230, 230));

        profName.setBackground(new java.awt.Color(102, 102, 102));
        profName.setFont(new java.awt.Font("Microsoft Tai Le", 1, 24)); // NOI18N
        profName.setForeground(new java.awt.Color(102, 102, 102));
        profName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profName.setText("Thipul Damsilu Liyanage");
        jPanel4.add(profName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 322, -1));

        profEmail.setBackground(new java.awt.Color(0, 204, 204));
        profEmail.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        profEmail.setForeground(new java.awt.Color(0, 204, 204));
        profEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profEmail.setText("thipuldamsilu@gmail.com");
        jPanel4.add(profEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 307, -1));

        profRole.setBackground(new java.awt.Color(102, 102, 102));
        profRole.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        profRole.setForeground(new java.awt.Color(102, 102, 102));
        profRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-verified-25.png"))); // NOI18N
        profRole.setText("Admin");
        jPanel4.add(profRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 307, -1));

        javax.swing.GroupLayout ProfileInfoLayout = new javax.swing.GroupLayout(ProfileInfo);
        ProfileInfo.setLayout(ProfileInfoLayout);
        ProfileInfoLayout.setHorizontalGroup(
            ProfileInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileInfoLayout.createSequentialGroup()
                .addContainerGap(271, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        ProfileInfoLayout.setVerticalGroup(
            ProfileInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        center.add(ProfileInfo, java.awt.BorderLayout.PAGE_START);

        profileForm.setLayout(new java.awt.BorderLayout());

        firstPanel.setLayout(new java.awt.GridLayout(1, 3));

        TextFieldPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel1.setText("First Name");

        jTextField1.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        jTextField1.setMargin(new java.awt.Insets(0, 20, 0, 20));

        javax.swing.GroupLayout TextFieldPanelLayout = new javax.swing.GroupLayout(TextFieldPanel);
        TextFieldPanel.setLayout(TextFieldPanelLayout);
        TextFieldPanelLayout.setHorizontalGroup(
            TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TextFieldPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 228, Short.MAX_VALUE))
                    .addComponent(jTextField1))
                .addContainerGap())
        );
        TextFieldPanelLayout.setVerticalGroup(
            TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        firstPanel.add(TextFieldPanel);

        TextFieldPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel3.setText("Last Name");

        jTextField2.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        jTextField2.setMargin(new java.awt.Insets(0, 20, 0, 20));

        javax.swing.GroupLayout TextFieldPanel1Layout = new javax.swing.GroupLayout(TextFieldPanel1);
        TextFieldPanel1.setLayout(TextFieldPanel1Layout);
        TextFieldPanel1Layout.setHorizontalGroup(
            TextFieldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TextFieldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TextFieldPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addContainerGap())
        );
        TextFieldPanel1Layout.setVerticalGroup(
            TextFieldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        firstPanel.add(TextFieldPanel1);

        TextFieldPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel4.setText("Email");

        jTextField3.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        jTextField3.setMargin(new java.awt.Insets(0, 20, 0, 20));

        javax.swing.GroupLayout TextFieldPanel2Layout = new javax.swing.GroupLayout(TextFieldPanel2);
        TextFieldPanel2.setLayout(TextFieldPanel2Layout);
        TextFieldPanel2Layout.setHorizontalGroup(
            TextFieldPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TextFieldPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TextFieldPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addContainerGap())
        );
        TextFieldPanel2Layout.setVerticalGroup(
            TextFieldPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        firstPanel.add(TextFieldPanel2);

        profileForm.add(firstPanel, java.awt.BorderLayout.PAGE_START);

        secondLine.setLayout(new java.awt.GridLayout(1, 5));

        TextFieldPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel5.setText("Mobile");

        jTextField4.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        jTextField4.setMargin(new java.awt.Insets(0, 20, 0, 20));

        javax.swing.GroupLayout TextFieldPanel3Layout = new javax.swing.GroupLayout(TextFieldPanel3);
        TextFieldPanel3.setLayout(TextFieldPanel3Layout);
        TextFieldPanel3Layout.setHorizontalGroup(
            TextFieldPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TextFieldPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TextFieldPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 133, Short.MAX_VALUE))
                    .addComponent(jTextField4))
                .addContainerGap())
        );
        TextFieldPanel3Layout.setVerticalGroup(
            TextFieldPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        secondLine.add(TextFieldPanel3);

        TextFieldPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel6.setText("NIC");

        jTextField5.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        jTextField5.setMargin(new java.awt.Insets(0, 20, 0, 20));

        javax.swing.GroupLayout TextFieldPanel4Layout = new javax.swing.GroupLayout(TextFieldPanel4);
        TextFieldPanel4.setLayout(TextFieldPanel4Layout);
        TextFieldPanel4Layout.setHorizontalGroup(
            TextFieldPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TextFieldPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TextFieldPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                .addContainerGap())
        );
        TextFieldPanel4Layout.setVerticalGroup(
            TextFieldPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        secondLine.add(TextFieldPanel4);

        TextFieldPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel7.setText("Gender");

        jComboBox1.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N

        javax.swing.GroupLayout TextFieldPanel5Layout = new javax.swing.GroupLayout(TextFieldPanel5);
        TextFieldPanel5.setLayout(TextFieldPanel5Layout);
        TextFieldPanel5Layout.setHorizontalGroup(
            TextFieldPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TextFieldPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TextFieldPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 127, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TextFieldPanel5Layout.setVerticalGroup(
            TextFieldPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        secondLine.add(TextFieldPanel5);

        TextFieldPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel8.setText("Password");

        jPasswordField1.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.setMargin(new java.awt.Insets(0, 20, 0, 20));

        javax.swing.GroupLayout TextFieldPanel6Layout = new javax.swing.GroupLayout(TextFieldPanel6);
        TextFieldPanel6.setLayout(TextFieldPanel6Layout);
        TextFieldPanel6Layout.setHorizontalGroup(
            TextFieldPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TextFieldPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TextFieldPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                .addContainerGap())
        );
        TextFieldPanel6Layout.setVerticalGroup(
            TextFieldPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        secondLine.add(TextFieldPanel6);

        TextFieldPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel9.setText("Role");

        jComboBox2.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N

        javax.swing.GroupLayout TextFieldPanel7Layout = new javax.swing.GroupLayout(TextFieldPanel7);
        TextFieldPanel7.setLayout(TextFieldPanel7Layout);
        TextFieldPanel7Layout.setHorizontalGroup(
            TextFieldPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TextFieldPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TextFieldPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 181, Short.MAX_VALUE))
                .addContainerGap())
        );
        TextFieldPanel7Layout.setVerticalGroup(
            TextFieldPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        secondLine.add(TextFieldPanel7);

        profileForm.add(secondLine, java.awt.BorderLayout.CENTER);

        center.add(profileForm, java.awt.BorderLayout.CENTER);

        profileContent.add(center, java.awt.BorderLayout.CENTER);

        add(profileContent, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ProfileInfo;
    private javax.swing.JPanel TextFieldPanel;
    private javax.swing.JPanel TextFieldPanel1;
    private javax.swing.JPanel TextFieldPanel2;
    private javax.swing.JPanel TextFieldPanel3;
    private javax.swing.JPanel TextFieldPanel4;
    private javax.swing.JPanel TextFieldPanel5;
    private javax.swing.JPanel TextFieldPanel6;
    private javax.swing.JPanel TextFieldPanel7;
    private javax.swing.JButton addImg;
    private javax.swing.JPanel center;
    private javax.swing.JPanel firstPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel profEmail;
    private javax.swing.JLabel profName;
    private javax.swing.JLabel profRole;
    private javax.swing.JPanel profileContent;
    private javax.swing.JPanel profileForm;
    private javax.swing.JPanel profilePic;
    private javax.swing.JPanel profileTop;
    private javax.swing.JPanel secondLine;
    // End of variables declaration//GEN-END:variables
}
