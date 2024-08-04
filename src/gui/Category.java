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

public class Category extends javax.swing.JPanel {

    private AdminDashboard ad;

    public Category() {
        initComponents();
        loadCategory();
        getCategoryCount();
    }

    public void reload() {
        loadCategory();
        getCategoryCount();
        jPanel1.repaint();
    }

    private void getCategoryCount() {
        try {
            ResultSet resultSet = MySQL.execute("SELECT COUNT(`id`) AS 'count' FROM `category`");
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
            ResultSet resultSet = MySQL.execute("SELECT * FROM `category` WHERE `category`.`name`='" + brand_name + "'");

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

    private void loadCategory() {
        jPanel1.removeAll();

        String category_search = categorySearch.getText();

        try {
            String query = "SELECT * FROM `category` ";

            if (category_search.equals("Search by name") || category_search.isEmpty()) {
                query += "";
            } else if (!category_search.isEmpty()) {
                query += "WHERE `category`.`name` LIKE '" + category_search + "%'";
            }
            ResultSet resultSet = MySQL.execute(query);

            while (resultSet.next()) {
                String category_name = resultSet.getString("name");
                String path = resultSet.getString("img");

//                brandDetails.put(resultSet.getString("name"), brand_name);
//                brandDetails.put(resultSet.getString("img"), path);
                brandPanel t = new brandPanel();
                t.setVisible(true);
                t.getBrandName().setText(category_name);
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
                                                    deleteImage(category_name);
                                                    MySQL.execute("DELETE FROM `category` WHERE `name`='" + category_name + "'");
                                                    reload();
                                                    JOptionPane.showMessageDialog(ad, "Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);

                                                } else {
                                                    t.getMain().setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), new Color(119, 82, 254), 1, 50));//[153,220,79]
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
                                                    deleteImage(category_name);
                                                    MySQL.execute("DELETE FROM `category` WHERE `name`='" + category_name + "'");
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
                jPanel1.add(t);
                jPanel1.revalidate();
                jPanel1.repaint();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Exception", JOptionPane.WARNING_MESSAGE);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        brandTop = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        searchBtn = new javax.swing.JButton();
        categorySearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        brandTop.setBackground(new java.awt.Color(255, 255, 255));
        brandTop.setPreferredSize(new java.awt.Dimension(972, 150));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-category-25.png"))); // NOI18N
        jLabel2.setText("Category");
        jLabel2.setIconTextGap(10);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("(0)");

        addButton.setBackground(new java.awt.Color(153, 220, 79));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addButton.setText("+");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        info.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-light-on.gif"))); // NOI18N
        info.setText("left Click to Delete");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        jPanel2.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 5, 40, 40));

        categorySearch.setBackground(new java.awt.Color(240, 240, 240));
        categorySearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        categorySearch.setForeground(new java.awt.Color(153, 153, 153));
        categorySearch.setText("Search by name");
        categorySearch.setMargin(new java.awt.Insets(2, 20, 2, 20));
        categorySearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                categorySearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                categorySearchFocusLost(evt);
            }
        });
        categorySearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                categorySearchInputMethodTextChanged(evt);
            }
        });
        categorySearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                categorySearchKeyReleased(evt);
            }
        });
        jPanel2.add(categorySearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 50));

        javax.swing.GroupLayout brandTopLayout = new javax.swing.GroupLayout(brandTop);
        brandTop.setLayout(brandTopLayout);
        brandTopLayout.setHorizontalGroup(
            brandTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(brandTopLayout.createSequentialGroup()
                .addGroup(brandTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(brandTopLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(brandTopLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(brandTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(brandTopLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(brandTopLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 435, Short.MAX_VALUE)
                        .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
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
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(brandTopLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(brandTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, brandTopLayout.createSequentialGroup()
                                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))))))
        );

        add(brandTop, java.awt.BorderLayout.PAGE_START);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        jPanel1.setMinimumSize(new java.awt.Dimension(50, 249));
        jPanel1.setLayout(new java.awt.GridLayout(0, 7, 20, 20));
        jScrollPane2.setViewportView(jPanel1);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void categorySearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_categorySearchFocusGained
        categorySearch.setText("");
    }//GEN-LAST:event_categorySearchFocusGained

    private void categorySearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_categorySearchFocusLost
        categorySearch.setText("Search by name");
    }//GEN-LAST:event_categorySearchFocusLost

    private void categorySearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_categorySearchInputMethodTextChanged
    }//GEN-LAST:event_categorySearchInputMethodTextChanged

    private void categorySearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categorySearchKeyReleased
        loadCategory();
    }//GEN-LAST:event_categorySearchKeyReleased

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
    }//GEN-LAST:event_searchBtnActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        AddCategory ac = new AddCategory(ad, true);
        ac.setCategory(this);
        ac.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel brandTop;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField categorySearch;
    public static javax.swing.JLabel info;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton searchBtn;
    // End of variables declaration//GEN-END:variables
}
