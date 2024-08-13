package gui;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.MySQL;

public class Products extends javax.swing.JPanel {

    private AdminDashboard ad;
    private boolean isValidated;
    private String product;
    private String category;
    private String brand;
    private String product_id;
    private int brand_id;
    private int category_id;

    public Products() {
        initComponents();
        productTableModel1.setProduct(this);
        productID.setVisible(false);
    }

    public JTextField getProductName() {
        return productName;
    }

    public JTextField getBrandName() {
        return brandName;
    }

    public JTextField getCategoryName() {
        return categoryName;
    }

    public JButton getProductSaveBtn() {
        return productSaveBtn;
    }

    public JButton getProductUpdateBtn() {
        return productUpdateBtn;
    }

    public JButton getProductDeleteBtn() {
        return productDeleteBtn;
    }

    public JButton getSelectBrand() {
        return selectBrand;
    }

    public JButton getSelectCategory() {
        return selectCategory;
    }

    public JLabel getProductID() {
        return productID;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    
    

    private void reset() {
        productName.setText("");
        brandName.setText("");
        categoryName.setText("");
        productDeleteBtn.setEnabled(false);
        productUpdateBtn.setEnabled(false);
        productSaveBtn.setEnabled(true);
        selectBrand.setEnabled(true);
        productTableModel1.tableReset();
        isValidated = false;
        productName.setEditable(true);
    }

    private void validation() {
        product = productName.getText();
        brand = brandName.getText();
        category = categoryName.getText();

        if (product.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Select a Product", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (brand.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Select a Brand", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (category.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Select a Category", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            isValidated = true;
        }

    }

    private void saveProduct() {
        validation();
        if (isValidated) {
            try {
                ResultSet resultSet = MySQL.execute("SELECT * FROM `product` WHERE `name`='" + product + "' AND `brand_id`='" + brand_id + "' AND `category_id` ='" + category_id + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(ad, "Product Already Registered", "Invalid", JOptionPane.WARNING_MESSAGE);

                } else {
                    MySQL.execute("INSERT INTO `product`(`name`,`brand_id`,`category_id`,`status_id`) "
                            + "VALUES('" + product + "','" + brand_id + "','" + category_id + "','1')");
                    JOptionPane.showMessageDialog(ad, "Product Registered", "Success", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateProduct() {
        validation();
        if (isValidated) {
            try {
                getProductId();
                MySQL.execute("UPDATE `product` SET `category_id`='" + category_id + "' WHERE `id`='" + product_id + "'");
                JOptionPane.showMessageDialog(ad, "Product Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
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
                getProductId();
                if (productDeleteBtn.getText().equals("Deactive")) {
                    MySQL.execute("UPDATE `product` SET `status_id`='2' WHERE `id`='" + product_id + "'");
                    JOptionPane.showMessageDialog(ad, "Product Deactivated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                } else {
                    MySQL.execute("UPDATE `product` SET `status_id`='1' WHERE `id`='" + product_id + "'");
                    JOptionPane.showMessageDialog(ad, "Product Activated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void getProductId() {
        String array[] = productID.getText().split("-");
        product_id = array[1];
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        categoryName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        productDeleteBtn = new javax.swing.JButton();
        productSaveBtn = new javax.swing.JButton();
        productUpdateBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        productName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        brandName = new javax.swing.JTextField();
        selectCategory = new javax.swing.JButton();
        selectBrand = new javax.swing.JButton();
        productID = new javax.swing.JLabel();
        viewPanel = new javax.swing.JPanel();
        topCompanyBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        productTableModel1 = new model.ProductTableModel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        setLayout(new java.awt.BorderLayout());

        registerPanel.setBackground(new java.awt.Color(255, 255, 255));
        registerPanel.setPreferredSize(new java.awt.Dimension(450, 637));
        registerPanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Manage Product");
        registerPanel.add(jLabel1);
        jLabel1.setBounds(90, 25, 120, 45);

        categoryName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        categoryName.setEnabled(false);
        categoryName.setMargin(new java.awt.Insets(2, 20, 2, 20));
        categoryName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                categoryNameKeyPressed(evt);
            }
        });
        registerPanel.add(categoryName);
        categoryName.setBounds(20, 340, 230, 47);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Category");
        registerPanel.add(jLabel3);
        jLabel3.setBounds(20, 310, 115, 17);

        jButton3.setBackground(new java.awt.Color(119, 82, 254));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-products-25 (1).png"))); // NOI18N
        registerPanel.add(jButton3);
        jButton3.setBounds(25, 25, 49, 45);

        productDeleteBtn.setBackground(new java.awt.Color(227, 235, 192));
        productDeleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        productDeleteBtn.setForeground(new java.awt.Color(255, 51, 51));
        productDeleteBtn.setText("Deactive");
        productDeleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productDeleteBtn.setEnabled(false);
        productDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productDeleteBtnActionPerformed(evt);
            }
        });
        registerPanel.add(productDeleteBtn);
        productDeleteBtn.setBounds(230, 550, 180, 60);

        productSaveBtn.setBackground(new java.awt.Color(51, 255, 255));
        productSaveBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        productSaveBtn.setForeground(new java.awt.Color(119, 82, 254));
        productSaveBtn.setText("Save Product");
        productSaveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productSaveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                productSaveBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                productSaveBtnMouseReleased(evt);
            }
        });
        productSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productSaveBtnActionPerformed(evt);
            }
        });
        registerPanel.add(productSaveBtn);
        productSaveBtn.setBounds(40, 480, 367, 60);

        productUpdateBtn.setBackground(new java.awt.Color(51, 255, 255));
        productUpdateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        productUpdateBtn.setForeground(new java.awt.Color(119, 82, 254));
        productUpdateBtn.setText("Update");
        productUpdateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productUpdateBtn.setEnabled(false);
        productUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productUpdateBtnActionPerformed(evt);
            }
        });
        registerPanel.add(productUpdateBtn);
        productUpdateBtn.setBounds(40, 550, 180, 60);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("then UPDATE or DELETE");
        jLabel5.setIconTextGap(20);
        registerPanel.add(jLabel5);
        jLabel5.setBounds(30, 700, 370, 30);

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-light-on.gif"))); // NOI18N
        jLabel7.setText("Click Save Product Button to SAVE");
        jLabel7.setIconTextGap(20);
        registerPanel.add(jLabel7);
        jLabel7.setBounds(40, 640, 380, 30);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-light-on.gif"))); // NOI18N
        jLabel6.setText("Left-Click to select a Product,");
        jLabel6.setIconTextGap(20);
        registerPanel.add(jLabel6);
        jLabel6.setBounds(20, 680, 382, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Product Name");
        registerPanel.add(jLabel4);
        jLabel4.setBounds(20, 100, 115, 17);

        productName.setBackground(new java.awt.Color(255, 255, 255));
        productName.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        productName.setMargin(new java.awt.Insets(2, 20, 2, 20));
        productName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productNameKeyPressed(evt);
            }
        });
        registerPanel.add(productName);
        productName.setBounds(20, 130, 410, 47);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Brand");
        registerPanel.add(jLabel8);
        jLabel8.setBounds(20, 210, 42, 17);

        brandName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        brandName.setEnabled(false);
        brandName.setMargin(new java.awt.Insets(2, 20, 2, 20));
        brandName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                brandNameKeyPressed(evt);
            }
        });
        registerPanel.add(brandName);
        brandName.setBounds(20, 240, 230, 47);

        selectCategory.setBackground(new java.awt.Color(153, 220, 79));
        selectCategory.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        selectCategory.setForeground(new java.awt.Color(255, 255, 255));
        selectCategory.setText("Select Category");
        selectCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCategoryActionPerformed(evt);
            }
        });
        registerPanel.add(selectCategory);
        selectCategory.setBounds(270, 340, 160, 50);

        selectBrand.setBackground(new java.awt.Color(119, 82, 254));
        selectBrand.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        selectBrand.setForeground(new java.awt.Color(255, 255, 255));
        selectBrand.setText("Select Brand");
        selectBrand.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBrandActionPerformed(evt);
            }
        });
        registerPanel.add(selectBrand);
        selectBrand.setBounds(270, 240, 160, 50);

        productID.setText("jLabel9");
        registerPanel.add(productID);
        productID.setBounds(330, 90, 100, 16);

        add(registerPanel, java.awt.BorderLayout.LINE_START);

        viewPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        viewPanel.setLayout(new java.awt.BorderLayout());

        topCompanyBar.setBackground(new java.awt.Color(255, 255, 255));
        topCompanyBar.setPreferredSize(new java.awt.Dimension(624, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Search Product");

        jButton2.setBackground(new java.awt.Color(119, 82, 254));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-products-25 (1).png"))); // NOI18N

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 469, Short.MAX_VALUE)
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
        viewPanel.add(productTableModel1, java.awt.BorderLayout.CENTER);

        add(viewPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void categoryNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoryNameKeyPressed

    }//GEN-LAST:event_categoryNameKeyPressed

    private void productDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productDeleteBtnActionPerformed
        changeStatus();
    }//GEN-LAST:event_productDeleteBtnActionPerformed

    private void productSaveBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productSaveBtnMousePressed
        productSaveBtn.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_productSaveBtnMousePressed

    private void productSaveBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productSaveBtnMouseReleased
        productSaveBtn.setBackground(new Color(51, 255, 255));
    }//GEN-LAST:event_productSaveBtnMouseReleased

    private void productSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productSaveBtnActionPerformed
        saveProduct();
    }//GEN-LAST:event_productSaveBtnActionPerformed

    private void productUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productUpdateBtnActionPerformed
        updateProduct();
    }//GEN-LAST:event_productUpdateBtnActionPerformed

    private void productNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productNameKeyPressed

    }//GEN-LAST:event_productNameKeyPressed

    private void brandNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brandNameKeyPressed

    }//GEN-LAST:event_brandNameKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void selectBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBrandActionPerformed
        SelectBrand brand = new SelectBrand();
        brand.setVisible(true);
        brand.setProduct(this);
    }//GEN-LAST:event_selectBrandActionPerformed

    private void selectCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCategoryActionPerformed
        SelectCategory category = new SelectCategory();
        category.setVisible(true);
        category.setProduct(this);
    }//GEN-LAST:event_selectCategoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField brandName;
    private javax.swing.JTextField categoryName;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton productDeleteBtn;
    private javax.swing.JLabel productID;
    private javax.swing.JTextField productName;
    private javax.swing.JButton productSaveBtn;
    private model.ProductTableModel productTableModel1;
    private javax.swing.JButton productUpdateBtn;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JButton selectBrand;
    private javax.swing.JButton selectCategory;
    private javax.swing.JPanel topCompanyBar;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
