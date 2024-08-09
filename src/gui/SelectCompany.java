package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class SelectCompany extends javax.swing.JDialog {

    private final AdminDashboard ad;
    private Suppliers supplier;

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

    public SelectCompany(java.awt.Frame parent, boolean modal) {
//        super(parent, modal);
        this.ad = (AdminDashboard) parent;
        initComponents();
        tableSelect();
    }

    private void tableSelect() {
        companyTableModel1.getjTable2().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
    }

    private void jTable2MouseClicked(MouseEvent evt) {
        JTable table = companyTableModel1.getjTable2();
       int row = table.getSelectedRow();
        if (evt.getButton() == 1 && evt.getClickCount() == 2) {
            if (supplier != null) {
                supplier.getCompanyId().setText(String.valueOf(table.getValueAt(row, 0)));
                supplier.getCompanyName1().setText(String.valueOf(table.getValueAt(row, 1)));
                this.dispose();
            } else {
                System.out.println("null");
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewPanel = new javax.swing.JPanel();
        topCompanyBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        reload = new javax.swing.JButton();
        companyTableModel1 = new model.CompanyTableModel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        viewPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        viewPanel.setLayout(new java.awt.BorderLayout());

        topCompanyBar.setBackground(new java.awt.Color(255, 255, 255));
        topCompanyBar.setPreferredSize(new java.awt.Dimension(624, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Search Company");

        jButton2.setBackground(new java.awt.Color(119, 82, 254));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-company-25 (1).png"))); // NOI18N

        reload.setBackground(new java.awt.Color(204, 204, 255));
        reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-refresh-30.png"))); // NOI18N
        reload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topCompanyBarLayout = new javax.swing.GroupLayout(topCompanyBar);
        topCompanyBar.setLayout(topCompanyBarLayout);
        topCompanyBarLayout.setHorizontalGroup(
            topCompanyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topCompanyBarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 502, Short.MAX_VALUE)
                .addComponent(reload, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topCompanyBarLayout.setVerticalGroup(
            topCompanyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topCompanyBarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(topCompanyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reload, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        viewPanel.add(topCompanyBar, java.awt.BorderLayout.PAGE_START);
        viewPanel.add(companyTableModel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(viewPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadActionPerformed
        companyTableModel1.tableReset();
    }//GEN-LAST:event_reloadActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelectCompany dialog = new SelectCompany(new javax.swing.JFrame(), true);
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
    private model.CompanyTableModel companyTableModel1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton reload;
    private javax.swing.JPanel topCompanyBar;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
