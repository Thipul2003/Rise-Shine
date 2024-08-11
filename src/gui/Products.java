package gui;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.MySQL;

public class Products extends javax.swing.JPanel {

    private boolean isValidated = false;
    private AdminDashboard ad;
    private String product;
    private String brand;
    private String category;
    private String productId;
    private int brand_id;
    private int category_id;

    public Products() {
        initComponents();
        productTableModel1.setProduct(this);
        brandName.setEditable(false);
        categoryName.setEditable(false);
        product_id.setVisible(false);
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

    public JButton getProductUpdateBtn() {
        return ProductUpdateBtn;
    }

    public JButton getProductSaveBtn() {
        return ProductSaveBtn;
    }

    public JButton getProductDeleteBtn() {
        return ProductDeleteBtn;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public JLabel getProduct_id() {
        return product_id;
    }

    public JButton getAddBrand() {
        return addBrand;
    }

    public JButton getAddCategory() {
        return addCategory;
    }
    

    private void reset() {
        productName.setText("");
        product_id.setText("None");
        brandName.setText("");
        categoryName.setText("");
        ProductDeleteBtn.setEnabled(false);
        ProductUpdateBtn.setEnabled(false);
        ProductSaveBtn.setEnabled(true);
        addBrand.setEnabled(true);
        productTableModel1.tableReset();
        productName.setEditable(true);
        isValidated = false;

    }

    private void validation() {
        product = productName.getText();
        brand = brandName.getText();
        category = categoryName.getText();

        if (product.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Product Name is Empty", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (brand.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Select a Brand", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (category.isEmpty()) {
            JOptionPane.showMessageDialog(ad, "Select a Category", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            isValidated = true;
        }

    }

    private void saveproduct() {
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

    private void getProductId() throws Exception {
        try {
            String array[] = product_id.getText().split("-");
            productId = array[1];
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void updateproduct() {
        validation();

        if (isValidated) {
            try {
                getProductId();
                MySQL.execute("UPDATE `product` SET `category_id`='" + category_id + "' WHERE `id`='" + productId + "'");
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
                getProductId();
                if (ProductDeleteBtn.getText().equals("Deactive")) {
                    MySQL.execute("UPDATE `product` SET `status_id`='2' WHERE `id`='" + productId + "'");
                    JOptionPane.showMessageDialog(ad, "product Deactivated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                } else {
                    MySQL.execute("UPDATE `product` SET `status_id`='1' WHERE `id`='" + productId + "'");
                    JOptionPane.showMessageDialog(ad, "product Activated", "Success", JOptionPane.INFORMATION_MESSAGE);
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
        categoryName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        ProductDeleteBtn = new javax.swing.JButton();
        ProductSaveBtn = new javax.swing.JButton();
        ProductUpdateBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        productName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        brandName = new javax.swing.JTextField();
        addCategory = new javax.swing.JButton();
        addBrand = new javax.swing.JButton();
        product_id = new javax.swing.JLabel();
        viewPanel = new javax.swing.JPanel();
        topCompanyBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        productTableModel1 = new model.ProductTableModel();

        setLayout(new java.awt.BorderLayout());

        registerPanel.setBackground(new java.awt.Color(255, 255, 255));
        registerPanel.setPreferredSize(new java.awt.Dimension(450, 637));
        registerPanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Manage Products");
        registerPanel.add(jLabel1);
        jLabel1.setBounds(90, 25, 128, 45);

        categoryName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        categoryName.setForeground(new java.awt.Color(153, 153, 153));
        categoryName.setMargin(new java.awt.Insets(2, 20, 2, 20));
        categoryName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                categoryNameKeyPressed(evt);
            }
        });
        registerPanel.add(categoryName);
        categoryName.setBounds(20, 350, 250, 47);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Category");
        registerPanel.add(jLabel3);
        jLabel3.setBounds(20, 320, 115, 17);

        jButton3.setBackground(new java.awt.Color(119, 82, 254));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-products-25 (1).png"))); // NOI18N
        registerPanel.add(jButton3);
        jButton3.setBounds(25, 25, 49, 45);

        ProductDeleteBtn.setBackground(new java.awt.Color(227, 235, 192));
        ProductDeleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ProductDeleteBtn.setForeground(new java.awt.Color(255, 51, 51));
        ProductDeleteBtn.setText("Deactive");
        ProductDeleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ProductDeleteBtn.setEnabled(false);
        ProductDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductDeleteBtnActionPerformed(evt);
            }
        });
        registerPanel.add(ProductDeleteBtn);
        ProductDeleteBtn.setBounds(230, 540, 180, 60);

        ProductSaveBtn.setBackground(new java.awt.Color(51, 255, 255));
        ProductSaveBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ProductSaveBtn.setForeground(new java.awt.Color(119, 82, 254));
        ProductSaveBtn.setText("Save Product");
        ProductSaveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ProductSaveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ProductSaveBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ProductSaveBtnMouseReleased(evt);
            }
        });
        ProductSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductSaveBtnActionPerformed(evt);
            }
        });
        registerPanel.add(ProductSaveBtn);
        ProductSaveBtn.setBounds(40, 470, 367, 60);

        ProductUpdateBtn.setBackground(new java.awt.Color(51, 255, 255));
        ProductUpdateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ProductUpdateBtn.setForeground(new java.awt.Color(119, 82, 254));
        ProductUpdateBtn.setText("Update");
        ProductUpdateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ProductUpdateBtn.setEnabled(false);
        ProductUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductUpdateBtnActionPerformed(evt);
            }
        });
        registerPanel.add(ProductUpdateBtn);
        ProductUpdateBtn.setBounds(40, 540, 180, 60);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("then UPDATE or DELETE");
        jLabel5.setIconTextGap(20);
        registerPanel.add(jLabel5);
        jLabel5.setBounds(30, 690, 370, 30);

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-light-on.gif"))); // NOI18N
        jLabel7.setText("Click Save Product Button to SAVE");
        jLabel7.setIconTextGap(20);
        registerPanel.add(jLabel7);
        jLabel7.setBounds(40, 630, 380, 30);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-light-on.gif"))); // NOI18N
        jLabel6.setText("Left-Click to select a Product,");
        jLabel6.setIconTextGap(20);
        registerPanel.add(jLabel6);
        jLabel6.setBounds(30, 670, 370, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Product Name");
        registerPanel.add(jLabel4);
        jLabel4.setBounds(20, 100, 99, 17);

        productName.setBackground(new java.awt.Color(255, 255, 255));
        productName.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        productName.setMargin(new java.awt.Insets(2, 20, 2, 20));
        productName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productNameKeyPressed(evt);
            }
        });
        registerPanel.add(productName);
        productName.setBounds(20, 130, 420, 47);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Brand");
        registerPanel.add(jLabel8);
        jLabel8.setBounds(20, 220, 42, 17);

        brandName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        brandName.setForeground(new java.awt.Color(153, 153, 153));
        brandName.setMargin(new java.awt.Insets(2, 20, 2, 20));
        brandName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                brandNameKeyPressed(evt);
            }
        });
        registerPanel.add(brandName);
        brandName.setBounds(20, 250, 250, 47);

        addCategory.setBackground(new java.awt.Color(153, 220, 79));
        addCategory.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        addCategory.setForeground(new java.awt.Color(255, 255, 255));
        addCategory.setText("Select Category");
        addCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCategoryActionPerformed(evt);
            }
        });
        registerPanel.add(addCategory);
        addCategory.setBounds(280, 350, 160, 50);

        addBrand.setBackground(new java.awt.Color(119, 82, 254));
        addBrand.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        addBrand.setForeground(new java.awt.Color(255, 255, 255));
        addBrand.setText("Select Brand");
        addBrand.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBrandActionPerformed(evt);
            }
        });
        registerPanel.add(addBrand);
        addBrand.setBounds(280, 250, 160, 50);

        product_id.setBackground(new java.awt.Color(204, 204, 204));
        product_id.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        product_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        product_id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        registerPanel.add(product_id);
        product_id.setBounds(301, 76, 130, 40);

        add(registerPanel, java.awt.BorderLayout.LINE_START);

        viewPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        viewPanel.setLayout(new java.awt.BorderLayout());

        topCompanyBar.setBackground(new java.awt.Color(255, 255, 255));
        topCompanyBar.setPreferredSize(new java.awt.Dimension(624, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Search Products");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 613, Short.MAX_VALUE)
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

    private void ProductDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductDeleteBtnActionPerformed
        changeStatus();
    }//GEN-LAST:event_ProductDeleteBtnActionPerformed

    private void ProductSaveBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductSaveBtnMousePressed
        ProductSaveBtn.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_ProductSaveBtnMousePressed

    private void ProductSaveBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductSaveBtnMouseReleased
        ProductSaveBtn.setBackground(new Color(51, 255, 255));
    }//GEN-LAST:event_ProductSaveBtnMouseReleased

    private void ProductSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductSaveBtnActionPerformed
        saveproduct();
    }//GEN-LAST:event_ProductSaveBtnActionPerformed

    private void ProductUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductUpdateBtnActionPerformed
        updateproduct();
    }//GEN-LAST:event_ProductUpdateBtnActionPerformed

    private void productNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productNameKeyPressed

    }//GEN-LAST:event_productNameKeyPressed

    private void brandNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brandNameKeyPressed

    }//GEN-LAST:event_brandNameKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void addBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBrandActionPerformed
        SelectBrand brand = new SelectBrand();
        brand.setVisible(true);
        brand.setProduct(this);
    }//GEN-LAST:event_addBrandActionPerformed

    private void addCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCategoryActionPerformed
        SelectCategory category = new SelectCategory();
        category.setVisible(true);
        category.setProduct(this);
    }//GEN-LAST:event_addCategoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ProductDeleteBtn;
    private javax.swing.JButton ProductSaveBtn;
    private javax.swing.JButton ProductUpdateBtn;
    private javax.swing.JButton addBrand;
    private javax.swing.JButton addCategory;
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
    private javax.swing.JTextField productName;
    private model.ProductTableModel productTableModel1;
    private javax.swing.JLabel product_id;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JPanel topCompanyBar;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
