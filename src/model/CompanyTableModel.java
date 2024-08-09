package model;

import gui.Company;
import gui.SelectCompany;
import gui.Suppliers;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CompanyTableModel extends javax.swing.JPanel {

    private Company company;
    private Suppliers supplier;

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

    public JTable getjTable2() {
        return jTable2;
    }

    public CompanyTableModel() {
        initComponents();
        loadCompany();
        jTable2.setDefaultRenderer(Object.class, new NoBorderTableCellRenderer());
        showGridLines();
    }

    public void tableReset() {
        jTable2.removeAll();
        loadCompany();
        jTable2.clearSelection();
    }

    private void showGridLines() {
        jTable2.setShowHorizontalLines(true);
        jTable2.setShowVerticalLines(true);
        jTable2.getTableHeader().setOpaque(false);
        jTable2.getTableHeader().setBackground(new Color(119, 82, 254));
        jTable2.getTableHeader().setForeground(Color.WHITE);

    }

    private void loadCompany() {
        String company_search = companySearch.getText();
        String query = "SELECT * FROM `company` INNER JOIN `status` ON (status.id=company.status_id) ";
        try {
            if (company_search.equals("Search company") || company_search.isEmpty()) {
                query += "";
            } else {
                query += "WHERE `company`.`name` LIKE '" + company_search + "%'";
            }

            ResultSet resultSet = MySQL.execute(query);

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();
                vector.add("COM-" + resultSet.getString("id"));
                vector.add(resultSet.getString("company.name"));
                vector.add(resultSet.getString("contact"));
                vector.add(resultSet.getString("status.name"));

                model.addRow(vector);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getTableSelection(MouseEvent evt) {
        int row = jTable2.getSelectedRow();

        if (evt.getButton() == 1 && evt.getClickCount() == 1) {
            if (company != null) {
                company.getUpdateBtn().setEnabled(true);
                company.getDeleteBtn().setEnabled(true);
                company.getSaveBtn().setEnabled(false);
                company.getCompanyName().setText(String.valueOf(jTable2.getValueAt(row, 1)));
                company.getCompanyContact().setText(String.valueOf(jTable2.getValueAt(row, 2)));
                company.getCompanyName().setEditable(false);

                if (String.valueOf(jTable2.getValueAt(row, 3)).equals("Active")) {
                    company.getDeleteBtn().setText("Deactive");
                } else {
                    company.getDeleteBtn().setText("Active");
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewCompanyPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        companySearch = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        viewCompanyPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewCompanyPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        viewCompanyPanel.setLayout(new java.awt.BorderLayout(0, 20));

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Company Name", "Contact Number", "#"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        viewCompanyPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        companySearch.setBackground(new java.awt.Color(240, 240, 240));
        companySearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        companySearch.setForeground(new java.awt.Color(153, 153, 153));
        companySearch.setText("Search company");
        companySearch.setMargin(new java.awt.Insets(2, 20, 2, 2));
        companySearch.setPreferredSize(new java.awt.Dimension(118, 50));
        companySearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                companySearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                companySearchFocusLost(evt);
            }
        });
        companySearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                companySearchKeyPressed(evt);
            }
        });
        viewCompanyPanel.add(companySearch, java.awt.BorderLayout.PAGE_START);

        add(viewCompanyPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        getTableSelection(evt);
    }//GEN-LAST:event_jTable2MouseClicked

    private void companySearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_companySearchFocusGained
        companySearch.setText("");
    }//GEN-LAST:event_companySearchFocusGained

    private void companySearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_companySearchFocusLost
        companySearch.setText("Search company");
    }//GEN-LAST:event_companySearchFocusLost

    private void companySearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_companySearchKeyPressed
        loadCompany();
    }//GEN-LAST:event_companySearchKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField companySearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel viewCompanyPanel;
    // End of variables declaration//GEN-END:variables
}
