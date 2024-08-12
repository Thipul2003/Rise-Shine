package model;

import gui.Products;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class ProductTableModel extends javax.swing.JPanel {

    private Products product;
    private String search;

    public void setProduct(Products product) {
        this.product = product;
    }

    public ProductTableModel() {
        initComponents();
        showGridLines();
        loadProducts();
        jTable2.setDefaultRenderer(Object.class, new NoBorderTableCellRenderer());

    }

    public void tableReset() {
        jTable2.removeAll();
        loadProducts();
        jTable2.clearSelection();
    }

    private void showGridLines() {
        jTable2.setShowHorizontalLines(true);
        jTable2.setShowVerticalLines(true);
        jTable2.getTableHeader().setOpaque(false);
        jTable2.getTableHeader().setBackground(new Color(119, 82, 254));
        jTable2.getTableHeader().setForeground(Color.WHITE);

    }

    private void loadProducts() {
        search = productSearch.getText();

        String query = "SELECT * FROM `product` "
                + "INNER JOIN `brand` ON (brand.id=product.brand_id) "
                + "INNER JOIN `category` ON(`category`.`id`=`product`.`category_id`)"
                + "INNER JOIN `status` ON (status.id=product.status_id) ";

        if (search.equals("Search products") || search.isEmpty() || search == null) {
            query += "";
        } else {
            query += "WHERE `product`.`name` LIKE '" + search + "%'";
        }
        try {
            ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add("SUP-" + resultSet.getString("product.id"));
                vector.add(resultSet.getString("product.name"));
                vector.add(resultSet.getString("brand.name"));
                vector.add(resultSet.getString("category.name"));
                vector.add(resultSet.getString("status.name"));
                model.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getTableSelection(MouseEvent evt) {
        if (evt.getButton() == 1 && evt.getClickCount() == 1) {
            int row = jTable2.getSelectedRow();

            product.getProductUpdateBtn().setEnabled(true);
            product.getProductDeleteBtn().setEnabled(true);
            product.getProductSaveBtn().setEnabled(false);
            product.getProductName().setEditable(false);
            product.getSelectBrand().setEnabled(false);
            
            product.getProductID().setText(String.valueOf(jTable2.getValueAt(row, 0)));
            product.getProductName().setText(String.valueOf(jTable2.getValueAt(row, 1)));
            product.getBrandName().setText(String.valueOf(jTable2.getValueAt(row, 2)));
            product.getCategoryName().setText(String.valueOf(jTable2.getValueAt(row, 3)));

            if (String.valueOf(jTable2.getValueAt(row, 4)).equals("Active")) {
                product.getProductDeleteBtn().setText("Deactive");
            } else {
                product.getProductDeleteBtn().setText("Active");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewSupplierPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        productSearch = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        viewSupplierPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewSupplierPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        viewSupplierPanel.setLayout(new java.awt.BorderLayout(0, 20));

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Name", "Brand", "Category", "#"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable2.setRowHeight(40);
        jTable2.setSelectionBackground(new java.awt.Color(119, 82, 254));
        jTable2.setShowHorizontalLines(false);
        jTable2.setShowVerticalLines(false);
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        viewSupplierPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        productSearch.setBackground(new java.awt.Color(240, 240, 240));
        productSearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        productSearch.setForeground(new java.awt.Color(153, 153, 153));
        productSearch.setText("Search products");
        productSearch.setMargin(new java.awt.Insets(2, 20, 2, 2));
        productSearch.setPreferredSize(new java.awt.Dimension(122, 50));
        productSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                productSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                productSearchFocusLost(evt);
            }
        });
        productSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productSearchKeyPressed(evt);
            }
        });
        viewSupplierPanel.add(productSearch, java.awt.BorderLayout.PAGE_START);

        add(viewSupplierPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if (product != null) {
            getTableSelection(evt);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void productSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productSearchFocusGained
        productSearch.setText("");
    }//GEN-LAST:event_productSearchFocusGained

    private void productSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productSearchFocusLost
        productSearch.setText("Search products");
    }//GEN-LAST:event_productSearchFocusLost

    private void productSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productSearchKeyPressed
        loadProducts();
    }//GEN-LAST:event_productSearchKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField productSearch;
    private javax.swing.JPanel viewSupplierPanel;
    // End of variables declaration//GEN-END:variables
}
