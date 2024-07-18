package gui;

import Model.MySQL;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class AddBrand extends javax.swing.JDialog {

    private Brands brand;

    public void setBrand(Brands brand) {
        this.brand = brand;
    }
    

    public AddBrand(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void reset() {
        Brand_name.setText("");
        jtextfield2.setText("No file Selected");
        this.dispose();
    }

    public static String getFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex >= 0) {
            return filename.substring(dotIndex + 1);
        } else {
            return "";
        }
    }

    private void save_InsertImage(String brand_name) {

        String imagePath = jtextfield2.getText();
        String ext = getFileExtension(imagePath);
        File destinationFile = new File("src\\Backup\\Brands\\" + Brand_name.getText() + "." + ext);
        String getImage = "src\\\\Backup\\\\Brands\\\\" + Brand_name.getText() + "." + ext;

        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            ImageIO.write(image, ext, destinationFile);
            try {
                MySQL.execute("INSERT INTO `brand`(`name`,`img`) VALUES('" + brand_name + "','" + getImage + "')");
            } catch (Exception e) {
                e.printStackTrace();

            }

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Brand_name = new javax.swing.JTextField();
        jtextfield2 = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        logo_space = new javax.swing.JPanel();
        pic_frame = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        msg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setText("Brand Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setText("Brand Logo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-folder.gif"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 242, 50, 40));

        Brand_name.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Brand_name.setMargin(new java.awt.Insets(2, 15, 2, 15));
        jPanel1.add(Brand_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 280, 43));

        jtextfield2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jtextfield2.setText("No file selected");
        jtextfield2.setMargin(new java.awt.Insets(2, 15, 2, 40));
        jtextfield2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtextfield2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtextfield2FocusLost(evt);
            }
        });
        jtextfield2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextfield2ActionPerformed(evt);
            }
        });
        jPanel1.add(jtextfield2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 280, 43));

        addBtn.setBackground(new java.awt.Color(204, 102, 255));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addBtn.setText("Add");
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 337, 48));

        logo_space.setBackground(new java.awt.Color(245, 231, 231));
        logo_space.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pic_frame.setBackground(new java.awt.Color(255, 255, 255));
        pic_frame.setLayout(new java.awt.BorderLayout());

        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-image-96.png"))); // NOI18N
        pic_frame.add(img, java.awt.BorderLayout.CENTER);

        logo_space.add(pic_frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 100, 270, 350));

        jPanel1.add(logo_space, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 430, 534));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 30, 530));

        msg.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 260, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Brand Registration");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 240, 40));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            j.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif", "jfif", "svg"));
            // invoke the showsOpenDialog function to show the save dialog
            int r = j.showOpenDialog(null);

            // if the user selects a file
            if (r == JFileChooser.APPROVE_OPTION) {

                String path = String.valueOf(j.getSelectedFile().getAbsolutePath().replace("\\", "\\\\"));
                jtextfield2.setText(path);

                //set and scale image
                ImageIcon image = new ImageIcon(String.valueOf(j.getSelectedFile().getAbsolutePath()));
                Image new_img = image.getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
                img.setIcon(new ImageIcon(new_img));

                msg.setText("");

            } // if the user cancelled the operation
            else {
                msg.setText("the user cancelled the operation");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtextfield2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtextfield2FocusGained

    }//GEN-LAST:event_jtextfield2FocusGained

    private void jtextfield2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtextfield2FocusLost

    }//GEN-LAST:event_jtextfield2FocusLost

    private void jtextfield2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextfield2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextfield2ActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        String brand_name = Brand_name.getText();
        String pic_path = jtextfield2.getText();

        if (brand_name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Empty name field", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (pic_path.equals("No file selected")) {
            JOptionPane.showMessageDialog(this, "No image Selected", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            try {
                ResultSet resultSet = MySQL.execute("SELECT * FROM `brand` WHERE `name`='" + brand_name + "'");
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(this, "Brand Already Exist", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {
                    save_InsertImage(brand_name);
                    reset();
                    if (brand != null) {
                        brand.reload();
                    }
                    JOptionPane.showMessageDialog(this, "Brand added", "Succesfull", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }//GEN-LAST:event_addBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBrand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddBrand dialog = new AddBrand(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Brand_name;
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jtextfield2;
    private javax.swing.JPanel logo_space;
    private javax.swing.JLabel msg;
    private javax.swing.JPanel pic_frame;
    // End of variables declaration//GEN-END:variables
}
