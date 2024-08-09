package model;

import gui.Suppliers;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SupplierTableModel extends javax.swing.JPanel {

    private String search;
    private Suppliers supplier;
    private String companyId;

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

    public SupplierTableModel() {
        initComponents();
        showGridLines();
        loadSuppliers();
        jTable2.setDefaultRenderer(Object.class, new NoBorderTableCellRenderer());
    }

    public void tableReset() {
        jTable2.removeAll();
        loadSuppliers();
        jTable2.clearSelection();
    }

    private void showGridLines() {
        jTable2.setShowHorizontalLines(true);
        jTable2.setShowVerticalLines(true);
        jTable2.getTableHeader().setOpaque(false);
        jTable2.getTableHeader().setBackground(new Color(119, 82, 254));
        jTable2.getTableHeader().setForeground(Color.WHITE);

    }

    private void loadSuppliers() {
        search = supplierSearch.getText();

        String query = "SELECT * FROM `supplier` INNER JOIN `company` ON (company.id=supplier.company_id) INNER JOIN `status` ON (status.id=supplier.status_id) ";

        if (search.equals("Search supplier") || search.isEmpty() || search == null) {
            query += "";
        } else {
            query += "WHERE `first_name` LIKE '" + search + "%'";
        }
        try {
            ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add("SUP-" + resultSet.getString("supplier_id"));
                vector.add(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
                vector.add(resultSet.getString("email"));
                vector.add(resultSet.getString("mobile"));
                vector.add(resultSet.getString("company.name"));
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
            String nameArray[] = String.valueOf(jTable2.getValueAt(row, 1)).split(" ");
            String suppId[] = String.valueOf(jTable2.getValueAt(row, 0)).split("-");

            supplier.getSupUpdateBtn().setEnabled(true);
            supplier.getSuppDeleteBtn().setEnabled(true);
            supplier.getSupSaveBtn().setEnabled(false);
            supplier.getSuppFName().setEditable(false);
            supplier.getSupLName().setEditable(false);
            supplier.getSupEmail().setEditable(false);
            
            supplier.getSuppFName().setText(nameArray[0]);
            supplier.getSupLName().setText(nameArray[1]);
            supplier.getSuppId().setText(suppId[1]);
            supplier.getSupEmail().setText(String.valueOf(jTable2.getValueAt(row, 2)));
            supplier.getSupMobile().setText(String.valueOf(jTable2.getValueAt(row, 3)));

            supplier.getCompanyName1().setText(String.valueOf(jTable2.getValueAt(row, 4)));
            String name = String.valueOf(jTable2.getValueAt(row, 4));
            getCompanyId(name);

            if (String.valueOf(jTable2.getValueAt(row, 5)).equals("Active")) {
                supplier.getSuppDeleteBtn().setText("Deactive");
            } else {
                supplier.getSuppDeleteBtn().setText("Active");
            }
        }
    }

    private void getCompanyId(String name) {

        try {
            ResultSet rs = MySQL.execute("SELECT `id` FROM `company` WHERE `name`='" + name + "'");

            if (rs.next()) {
                supplier.getCompanyId().setText("COM-" + rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewSupplierPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        supplierSearch = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        viewSupplierPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewSupplierPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        viewSupplierPanel.setLayout(new java.awt.BorderLayout(0, 20));

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier Id", "Name", "Email", "Mobile", "Company", "#"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        supplierSearch.setBackground(new java.awt.Color(240, 240, 240));
        supplierSearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        supplierSearch.setForeground(new java.awt.Color(153, 153, 153));
        supplierSearch.setText("Search supplier");
        supplierSearch.setMargin(new java.awt.Insets(2, 20, 2, 2));
        supplierSearch.setPreferredSize(new java.awt.Dimension(122, 50));
        supplierSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                supplierSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                supplierSearchFocusLost(evt);
            }
        });
        supplierSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                supplierSearchKeyPressed(evt);
            }
        });
        viewSupplierPanel.add(supplierSearch, java.awt.BorderLayout.PAGE_START);

        add(viewSupplierPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        if (supplier != null) {
            getTableSelection(evt);
        } else {
            System.out.println("Null");
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void supplierSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_supplierSearchFocusGained
        supplierSearch.setText("");
    }//GEN-LAST:event_supplierSearchFocusGained

    private void supplierSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_supplierSearchFocusLost
        supplierSearch.setText("Search supplier");
    }//GEN-LAST:event_supplierSearchFocusLost

    private void supplierSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierSearchKeyPressed
        loadSuppliers();
    }//GEN-LAST:event_supplierSearchKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField supplierSearch;
    private javax.swing.JPanel viewSupplierPanel;
    // End of variables declaration//GEN-END:variables
}
