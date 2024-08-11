package gui;

import model.MySQL;
import model.brandPanel;
import com.formdev.flatlaf.ui.FlatLineBorder;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Brands extends javax.swing.JPanel {

    private AdminDashboard ad;

    public JPanel getBrandsSection() {
        return brandsSection;
    }

    public Brands() {
        initComponents();
        loadBrand();
        getbrandCount();

    }

    public void reload() {
        loadBrand();
        getbrandCount();
        brandsSection.repaint();

    }

    private void getbrandCount() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT COUNT(`id`) AS 'count' FROM `brand`");
            if (resultSet.next()) {
                String count = resultSet.getString("count");
                jLabel3.setText("(" + count + ")");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Exception", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void deleteImage(String brand_name) {
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `brand` WHERE `brand`.`name`='" + brand_name + "'");

            if (resultSet.next()) {
                String imagePath = resultSet.getString("img");
                File imageFile = new File(imagePath);
                if (imageFile.exists()) {
                    if (imageFile.delete()) {

                    } else {
                        System.out.println("Failed to delete image");
                    }
                } else {
                    System.out.println("Image file does not exist");
                }

            } else {

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Exception", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void loadBrand() {
        brandsSection.removeAll();

        String brand_search = brandSearch.getText();

        try {
            String query = "SELECT * FROM `brand` ";

            if (brand_search.equals("Search by name") || brand_search.isEmpty()) {
                query += "";
            } else if (!brand_search.isEmpty()) {
                query += "WHERE `brand`.`name` LIKE '" + brand_search + "%'";
            }
            ResultSet resultSet = MySQL.execute(query);

            while (resultSet.next()) {
                String brand_name = resultSet.getString("name");
                String path = resultSet.getString("img");

//                brandDetails.put(resultSet.getString("name"), brand_name);
//                brandDetails.put(resultSet.getString("img"), path);
                brandPanel t = new brandPanel();
                t.setVisible(true);
                t.getBrandName().setText(brand_name);
                ImageIcon image = new ImageIcon(path);
                Image new_img = image.getImage().getScaledInstance(129, 138, Image.SCALE_AREA_AVERAGING);
                t.getLogo().setIcon(new ImageIcon(new_img));

                t.getBrandSection()
                        .addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {

                                if (e.getClickCount() == 1 && e.getButton() == 3) {
                                    if (t.getMain().getBorder() instanceof FlatLineBorder) {
                                        // Get the color of the LineBorder
                                        Color borderColor = ((FlatLineBorder) t.getMain().getBorder()).getLineColor();

                                        // Check if the color is red
                                        if (Color.RED.equals(borderColor)) {
                                            try {
                                                int result = JOptionPane.showConfirmDialog(ad, "Do you want to Delete?", "Confirmation", JOptionPane.YES_NO_OPTION);
                                                if (result == JOptionPane.YES_OPTION) {
                                                    deleteImage(brand_name);
                                                    MySQL.execute("DELETE FROM `brand` WHERE `name`='" + brand_name + "'");
                                                    reload();
                                                    JOptionPane.showMessageDialog(ad, "Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);

                                                } else {
                                                    t.getMain().setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), new Color(119, 82, 254), 1, 50));
                                                }

                                            } catch (Exception ev) {
                                                ev.printStackTrace();
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        );

                t.getLogoSection()
                        .addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e
                            ) {
                                if (e.getClickCount() == 1 && e.getButton() == 3) {

                                    if (t.getMain().getBorder() instanceof FlatLineBorder) {
                                        // Get the color of the LineBorder
                                        Color borderColor = ((FlatLineBorder) t.getMain().getBorder()).getLineColor();

                                        // Check if the color is red
                                        if (Color.RED.equals(borderColor)) {
                                            try {

                                                int result = JOptionPane.showConfirmDialog(ad, "Do you want to Delete?", "Confirmation", JOptionPane.YES_NO_OPTION);
                                                if (result == JOptionPane.YES_OPTION) {
                                                    deleteImage(brand_name);
                                                    MySQL.execute("DELETE FROM `brand` WHERE `name`='" + brand_name + "'");
                                                    reload();
                                                    JOptionPane.showMessageDialog(ad, "Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);

                                                } else {
                                                    t.getMain().setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), new Color(119, 82, 254), 1, 50));
                                                }

                                            } catch (Exception ev) {
                                                ev.printStackTrace();
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        );
                brandsSection.add(t);
                brandsSection.revalidate();
                brandsSection.repaint();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Exception", JOptionPane.WARNING_MESSAGE);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        brandTop = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        searchBtn = new javax.swing.JButton();
        brandSearch = new javax.swing.JTextField();
        info = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panel3 = new javax.swing.JPanel();
        brandsSection = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        brandTop.setBackground(new java.awt.Color(255, 255, 255));
        brandTop.setPreferredSize(new java.awt.Dimension(972, 150));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-tag-25.png"))); // NOI18N
        jLabel2.setText("Brands");
        jLabel2.setIconTextGap(10);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("(0)");

        addButton.setBackground(new java.awt.Color(119, 82, 254));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addButton.setText("+");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.setOpaque(false);
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        jPanel1.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 5, 40, 40));

        brandSearch.setBackground(new java.awt.Color(240, 240, 240));
        brandSearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        brandSearch.setForeground(new java.awt.Color(153, 153, 153));
        brandSearch.setText("Search by name");
        brandSearch.setMargin(new java.awt.Insets(2, 20, 2, 20));
        brandSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                brandSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                brandSearchFocusLost(evt);
            }
        });
        brandSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                brandSearchInputMethodTextChanged(evt);
            }
        });
        brandSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                brandSearchKeyReleased(evt);
            }
        });
        jPanel1.add(brandSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 422, 50));

        info.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-light-on.gif"))); // NOI18N
        info.setText("Left Click to Delete");

        javax.swing.GroupLayout brandTopLayout = new javax.swing.GroupLayout(brandTop);
        brandTop.setLayout(brandTopLayout);
        brandTopLayout.setHorizontalGroup(
            brandTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(brandTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(brandTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(brandTopLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(brandTopLayout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                        .addGap(278, 278, 278)
                        .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        brandTopLayout.setVerticalGroup(
            brandTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(brandTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(brandTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(brandTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(brandTopLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(brandTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, brandTopLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );

        add(brandTop, java.awt.BorderLayout.PAGE_START);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        panel3.setMinimumSize(new java.awt.Dimension(50, 249));
        panel3.setLayout(new java.awt.BorderLayout());

        brandsSection.setLayout(new java.awt.GridLayout(0, 7, 18, 18));
        panel3.add(brandsSection, java.awt.BorderLayout.CENTER);

        jScrollPane2.setViewportView(panel3);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void brandSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brandSearchFocusGained

        brandSearch.setText(null);
    }//GEN-LAST:event_brandSearchFocusGained

    private void brandSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brandSearchFocusLost
        brandSearch.setText("Search by name");
    }//GEN-LAST:event_brandSearchFocusLost

    private void brandSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_brandSearchInputMethodTextChanged
        // TODO add your handling code here:
        //loadBrand();
    }//GEN-LAST:event_brandSearchInputMethodTextChanged

    private void brandSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brandSearchKeyReleased
        // TODO add your handling code here:
        loadBrand();
    }//GEN-LAST:event_brandSearchKeyReleased

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        // loadBrand();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        AddBrand ab = new AddBrand(ad, true);
        ab.setBrand(this);
        ab.setVisible(true);

    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField brandSearch;
    private javax.swing.JPanel brandTop;
    public javax.swing.JPanel brandsSection;
    public static javax.swing.JLabel info;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel3;
    private javax.swing.JButton searchBtn;
    // End of variables declaration//GEN-END:variables
}
