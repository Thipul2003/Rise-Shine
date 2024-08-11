package gui;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import model.MySQL;

public class Profile extends javax.swing.JPanel {

    private final String email;
    private int id;
    private AdminDashboard ad;
    private boolean isValidated;

    public Profile(Integer id, String email) throws Exception {
        initComponents();
        this.id = id;
        this.email = email;
        this.isValidated = false;
        loadProfileDetails();
        setEditable();
        setProfileImg();

    }

    private void setProfileImg() throws Exception {
        ResultSet rs = MySQL.execute("SELECT * FROM `profile_img` WHERE `employee_id`='" + id + "'");
        if (rs.next()) {
            String path = rs.getString("path");
            setImage(path);
        } else {
            File profileFolder = new File("src/Backup/profile");
            profileFolder.mkdir();
            setImage("src/Backup/profile/profile.jpg");
        }
    }

    private void setImage(String path) throws Exception {
        BufferedImage master = ImageIO.read(new File(path));
        int diameter = Math.min(master.getWidth(), master.getHeight());
        BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = mask.createGraphics();
        applyQualityRenderingHints(g2d);
        g2d.fillOval(0, 0, diameter - 1, diameter - 1);
        g2d.dispose();

        BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        g2d = masked.createGraphics();
        applyQualityRenderingHints(g2d);
        int x = (diameter - master.getWidth()) / 2;
        int y = (diameter - master.getHeight()) / 2;
        g2d.drawImage(master, x, y, null);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
        g2d.drawImage(mask, 0, 0, null);
        g2d.dispose();

        updateImage(profilePic, masked);

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                int labelWidth = profilePic.getWidth();
                int labelHeight = profilePic.getHeight();
                Image resizedImage = masked.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                profilePic.setIcon(new ImageIcon(resizedImage));
            }

            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int labelWidth = profilePic.getWidth();
                int labelHeight = profilePic.getHeight();
                Image resizedImage = masked.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                profilePic.setIcon(new ImageIcon(resizedImage));
            }
        }
        );

        jLabel10.setText(path);
    }

    public static void applyQualityRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }

    private static void updateImage(JLabel label, BufferedImage image) {
        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();
        if (labelWidth > 0 && labelHeight > 0) {
            Image resizedImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(resizedImage));
        }
    }

    private void setEditable() {
        f_name.setEditable(false);
        l_name.setEditable(false);
        emailField.setEditable(false);
        nic.setEditable(false);
        mobile.setEditable(true);
        gender.setEnabled(false);
        role.setEnabled(false);
        saveProfile.setEnabled(false);
        jLabel10.setVisible(false);

    }

    private void saveTrigger() {
        saveProfile.setEnabled(true);
    }

    private void loadGender(String name) throws Exception {
        Vector<String> vector = new Vector<>();
        vector.add(name);

        DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
        gender.setModel(model);

    }

    private void loadType(String name) throws Exception {
        Vector<String> vector = new Vector<>();
        vector.add(name);
        DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
        role.setModel(model);

    }

    private void loadProfileDetails() throws Exception {
        ResultSet rs = MySQL.execute("SELECT * FROM `employee` INNER JOIN `employee_type` ON(employee.employee_type_id=employee_type.id) "
                + "INNER JOIN `gender` ON(employee.gender_id=gender.id) WHERE `employee_id`='" + id + "'");

        if (rs.next()) {
            String fName = rs.getString("first_name");
            String lName = rs.getString("first_name");
            String type = rs.getString("employee_type.name");

            f_name.setText(fName);
            l_name.setText(lName);
            profName.setText(fName + " " + lName);
            profEmail.setText(email);
            profRole.setText(type);
            emailField.setText(email);
            nic.setText(rs.getString("nic"));
            mobile.setText(rs.getString("mobile"));
            loadGender(rs.getString("gender.name"));
            password.setText(rs.getString("password"));
            loadType(type);
        }
    }

    public static String getFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex >= 0) {
            return filename.substring(dotIndex + 1);
        } else {
            return "";
        }
    }

    private void saveImage(String path) throws Exception {

        String ext = getFileExtension(path);
        File folder = new File("src\\Backup\\profile");
        folder.mkdir();

        File destinationFile = new File(folder, "" + f_name.getText() + "_" + l_name.getText() + "." + ext);
        String getImage = "src\\\\Backup\\\\profile\\\\" + f_name.getText() + "_" + l_name.getText() + "." + ext;

        BufferedImage image = ImageIO.read(new File(path));
        ImageIO.write(image, ext, destinationFile);

        ResultSet rs = MySQL.execute("SELECT `path` FROM `profile_img` WHERE `employee_id`='" + this.id + "'");

        if (rs.next()) {
            MySQL.execute("UPDATE `profile_img` SET `path`='" + getImage + "' WHERE `employee_id`='" + this.id + "'");
            JLabel l = new JLabel(new ImageIcon("src/img/hurray.gif"));
            l.setText("Profile Updated");
            l.setHorizontalTextPosition(2);
            l.setIconTextGap(20);
            JOptionPane.showMessageDialog(ad, l, "Success", JOptionPane.INFORMATION_MESSAGE);

        } else {
            MySQL.execute("INSERT INTO `profile_img`(`employee_id`,`path`) VALUES('" + id + "','" + getImage + "')");
            JLabel l = new JLabel(new ImageIcon("src/img/hurray.gif"));
            l.setText("Profile Updated");
            l.setHorizontalTextPosition(2);
            l.setIconTextGap(20);
            JOptionPane.showMessageDialog(ad, l, "Success", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void validation() {
        String p = String.valueOf(password.getPassword());
        String m = mobile.getText();
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        if (p.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Password Field is Empty", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (!p.matches(passwordRegex)) {
            JOptionPane.showMessageDialog(ad, "Minimum eight characters,at least one uppercase letter one lowercase letter one number one special character", "Invalid Password", JOptionPane.WARNING_MESSAGE);

        } else if (m.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Mobile Field is Empty", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (!m.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(ad, "Invalid Mobile No", "Invalid", JOptionPane.ERROR_MESSAGE);

        } else {
            isValidated = true;
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
        setImg = new javax.swing.JButton();
        profName = new javax.swing.JLabel();
        profEmail = new javax.swing.JLabel();
        profRole = new javax.swing.JLabel();
        profilePic = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        profileForm = new javax.swing.JPanel();
        firstPanel = new javax.swing.JPanel();
        TextFieldPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        f_name = new javax.swing.JTextField();
        TextFieldPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        l_name = new javax.swing.JTextField();
        TextFieldPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        secondLine = new javax.swing.JPanel();
        TextFieldPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        mobile = new javax.swing.JTextField();
        TextFieldPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        nic = new javax.swing.JTextField();
        TextFieldPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        TextFieldPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        visiblepassword = new javax.swing.JLabel();
        notvisiblePassword = new javax.swing.JLabel();
        TextFieldPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        role = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        saveProfile = new javax.swing.JButton();

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

        setImg.setBackground(new java.awt.Color(204, 255, 255));
        setImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-plus-50.png"))); // NOI18N
        setImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setImgActionPerformed(evt);
            }
        });
        jPanel4.add(setImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 80, 80));

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

        profilePic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profilePic.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                profilePicComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                profilePicComponentShown(evt);
            }
        });
        profilePic.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                profilePicPropertyChange(evt);
            }
        });
        jPanel4.add(profilePic, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 230, 230));

        jLabel10.setText("jLabel10");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 330, -1));

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

        firstPanel.setBackground(new java.awt.Color(255, 255, 255));
        firstPanel.setLayout(new java.awt.GridLayout(1, 3));

        TextFieldPanel.setBackground(new java.awt.Color(255, 255, 255));
        TextFieldPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel1.setText("First Name");

        f_name.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        f_name.setMargin(new java.awt.Insets(0, 20, 0, 20));

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
                    .addComponent(f_name))
                .addContainerGap())
        );
        TextFieldPanelLayout.setVerticalGroup(
            TextFieldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(f_name, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        firstPanel.add(TextFieldPanel);

        TextFieldPanel1.setBackground(new java.awt.Color(255, 255, 255));
        TextFieldPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel3.setText("Last Name");

        l_name.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        l_name.setMargin(new java.awt.Insets(0, 20, 0, 20));

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
                    .addComponent(l_name, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addContainerGap())
        );
        TextFieldPanel1Layout.setVerticalGroup(
            TextFieldPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(l_name, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        firstPanel.add(TextFieldPanel1);

        TextFieldPanel2.setBackground(new java.awt.Color(255, 255, 255));
        TextFieldPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel4.setText("Email");

        emailField.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        emailField.setMargin(new java.awt.Insets(0, 20, 0, 20));

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
                    .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addContainerGap())
        );
        TextFieldPanel2Layout.setVerticalGroup(
            TextFieldPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        firstPanel.add(TextFieldPanel2);

        profileForm.add(firstPanel, java.awt.BorderLayout.PAGE_START);

        secondLine.setBackground(new java.awt.Color(255, 255, 255));
        secondLine.setLayout(new java.awt.GridLayout(1, 5));

        TextFieldPanel3.setBackground(new java.awt.Color(255, 255, 255));
        TextFieldPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel5.setText("Mobile");

        mobile.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        mobile.setMargin(new java.awt.Insets(0, 20, 0, 20));
        mobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mobileKeyTyped(evt);
            }
        });

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
                    .addComponent(mobile))
                .addContainerGap())
        );
        TextFieldPanel3Layout.setVerticalGroup(
            TextFieldPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        secondLine.add(TextFieldPanel3);

        TextFieldPanel4.setBackground(new java.awt.Color(255, 255, 255));
        TextFieldPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel6.setText("NIC");

        nic.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        nic.setMargin(new java.awt.Insets(0, 20, 0, 20));

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
                    .addComponent(nic, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                .addContainerGap())
        );
        TextFieldPanel4Layout.setVerticalGroup(
            TextFieldPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        secondLine.add(TextFieldPanel4);

        TextFieldPanel5.setBackground(new java.awt.Color(255, 255, 255));
        TextFieldPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel7.setText("Gender");

        gender.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N

        javax.swing.GroupLayout TextFieldPanel5Layout = new javax.swing.GroupLayout(TextFieldPanel5);
        TextFieldPanel5.setLayout(TextFieldPanel5Layout);
        TextFieldPanel5Layout.setHorizontalGroup(
            TextFieldPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TextFieldPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        secondLine.add(TextFieldPanel5);

        TextFieldPanel6.setBackground(new java.awt.Color(255, 255, 255));
        TextFieldPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel8.setText("Password");

        password.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        password.setText("jPasswordField1");
        password.setMargin(new java.awt.Insets(0, 20, 0, 20));
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });

        visiblepassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eye-25.png"))); // NOI18N
        visiblepassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        visiblepassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visiblepasswordMouseClicked(evt);
            }
        });

        notvisiblePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-not-visible-25.png"))); // NOI18N
        notvisiblePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notvisiblePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notvisiblePasswordMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                notvisiblePasswordMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                notvisiblePasswordMouseReleased(evt);
            }
        });

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
                    .addGroup(TextFieldPanel6Layout.createSequentialGroup()
                        .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TextFieldPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(visiblepassword)
                            .addComponent(notvisiblePassword))))
                .addContainerGap())
        );
        TextFieldPanel6Layout.setVerticalGroup(
            TextFieldPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addGroup(TextFieldPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TextFieldPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TextFieldPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(TextFieldPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(visiblepassword)
                            .addComponent(notvisiblePassword))))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        secondLine.add(TextFieldPanel6);

        TextFieldPanel7.setBackground(new java.awt.Color(255, 255, 255));
        TextFieldPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel9.setText("Role");

        role.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N

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
                    .addComponent(role, javax.swing.GroupLayout.Alignment.TRAILING, 0, 181, Short.MAX_VALUE))
                .addContainerGap())
        );
        TextFieldPanel7Layout.setVerticalGroup(
            TextFieldPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TextFieldPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        secondLine.add(TextFieldPanel7);

        profileForm.add(secondLine, java.awt.BorderLayout.CENTER);

        center.add(profileForm, java.awt.BorderLayout.CENTER);

        profileContent.add(center, java.awt.BorderLayout.CENTER);

        add(profileContent, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1068, 60));

        saveProfile.setBackground(new java.awt.Color(110, 82, 254));
        saveProfile.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        saveProfile.setForeground(new java.awt.Color(255, 255, 255));
        saveProfile.setText("Save");
        saveProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveProfileMouseExited(evt);
            }
        });
        saveProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(906, Short.MAX_VALUE)
                .addComponent(saveProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void setImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setImgActionPerformed
        try {
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            j.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif", "jfif", "svg"));
            int r = j.showOpenDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {
                String path = String.valueOf(j.getSelectedFile().getAbsolutePath().replace("\\", "/"));
                setImage(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveTrigger();
    }//GEN-LAST:event_setImgActionPerformed

    private void saveProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveProfileMouseEntered

    }//GEN-LAST:event_saveProfileMouseEntered

    private void saveProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveProfileMouseExited

    }//GEN-LAST:event_saveProfileMouseExited

    private void saveProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveProfileActionPerformed
        String Password = String.valueOf(password.getPassword());
        String Mobile = mobile.getText();
        String Path = jLabel10.getText();
        validation();

        if (isValidated) {
            try {
                MySQL.execute("UPDATE `employee` SET `password`='" + Password + "',`mobile`='" + Mobile + "' WHERE `email`='" + this.email + "'");
                saveImage(Path);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_saveProfileActionPerformed

    private void mobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyTyped
        saveTrigger();
    }//GEN-LAST:event_mobileKeyTyped

    private void visiblepasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visiblepasswordMouseClicked

        notvisiblePassword.setVisible(true);
        password.setEchoChar('\u25cf');
        visiblepassword.setVisible(false);
    }//GEN-LAST:event_visiblepasswordMouseClicked

    private void notvisiblePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notvisiblePasswordMouseClicked

        visiblepassword.setVisible(true);
        password.setEchoChar('\u0000');
        notvisiblePassword.setVisible(false);
    }//GEN-LAST:event_notvisiblePasswordMouseClicked

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        saveTrigger();
    }//GEN-LAST:event_passwordKeyTyped

    private void profilePicComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_profilePicComponentShown
    }//GEN-LAST:event_profilePicComponentShown

    private void profilePicComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_profilePicComponentResized

    }//GEN-LAST:event_profilePicComponentResized

    private void profilePicPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_profilePicPropertyChange
    }//GEN-LAST:event_profilePicPropertyChange

    private void notvisiblePasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notvisiblePasswordMousePressed

    }//GEN-LAST:event_notvisiblePasswordMousePressed

    private void notvisiblePasswordMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notvisiblePasswordMouseReleased

    }//GEN-LAST:event_notvisiblePasswordMouseReleased


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
    private javax.swing.JPanel center;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField f_name;
    private javax.swing.JPanel firstPanel;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField l_name;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField nic;
    private javax.swing.JLabel notvisiblePassword;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel profEmail;
    private javax.swing.JLabel profName;
    private javax.swing.JLabel profRole;
    private javax.swing.JPanel profileContent;
    private javax.swing.JPanel profileForm;
    private javax.swing.JLabel profilePic;
    private javax.swing.JPanel profileTop;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JButton saveProfile;
    private javax.swing.JPanel secondLine;
    private javax.swing.JButton setImg;
    private javax.swing.JLabel visiblepassword;
    // End of variables declaration//GEN-END:variables
}
