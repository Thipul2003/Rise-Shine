package gui;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.MySQL;
import model.brandPanel;

public class SelectCategory extends javax.swing.JDialog {

    public SelectCategory(java.awt.Frame parent, boolean modal) {
//        super(parent, modal);
        initComponents();
        loadCategory();
    }

    public SelectCategory() {
        initComponents();
        loadCategory();
    }

    private void loadCategory() {
        brandsSection.removeAll();

        String category_search = categorySearch.getText();

        try {
            String query = "SELECT * FROM `category` ";

            if (category_search.equals("Search category") || category_search.isEmpty()) {
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

                                if (e.getClickCount() == 2 && e.getButton() == 1) {

                                }

                            }
                        }
                        );

                t.getLogoSection()
                        .addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e
                            ) {
                                if (e.getClickCount() == 2 && e.getButton() == 1) {

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

        topSection = new javax.swing.JPanel();
        topCompanyBar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        categorySearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        panel3 = new javax.swing.JPanel();
        brandsSection = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(1206, 763));

        topSection.setBackground(new java.awt.Color(255, 255, 255));
        topSection.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 20, 20));
        topSection.setLayout(new java.awt.BorderLayout(0, 5));

        topCompanyBar.setBackground(new java.awt.Color(255, 255, 255));
        topCompanyBar.setPreferredSize(new java.awt.Dimension(624, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Select Category");

        jButton2.setBackground(new java.awt.Color(119, 82, 254));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-category-25 (1).png"))); // NOI18N

        info.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-light-on.gif"))); // NOI18N
        info.setText("Double-Click to Select");

        javax.swing.GroupLayout topCompanyBarLayout = new javax.swing.GroupLayout(topCompanyBar);
        topCompanyBar.setLayout(topCompanyBarLayout);
        topCompanyBarLayout.setHorizontalGroup(
            topCompanyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topCompanyBarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 848, Short.MAX_VALUE)
                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topCompanyBarLayout.setVerticalGroup(
            topCompanyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topCompanyBarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(topCompanyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(topCompanyBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        topSection.add(topCompanyBar, java.awt.BorderLayout.PAGE_START);

        categorySearch.setForeground(new java.awt.Color(153, 153, 153));
        categorySearch.setText("Search category");
        categorySearch.setMargin(new java.awt.Insets(0, 20, 0, 20));
        categorySearch.setPreferredSize(new java.awt.Dimension(14, 40));
        categorySearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                categorySearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                categorySearchFocusLost(evt);
            }
        });
        categorySearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                categorySearchKeyTyped(evt);
            }
        });
        topSection.add(categorySearch, java.awt.BorderLayout.CENTER);

        getContentPane().add(topSection, java.awt.BorderLayout.PAGE_START);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        panel3.setMinimumSize(new java.awt.Dimension(50, 249));
        panel3.setLayout(new java.awt.BorderLayout());

        brandsSection.setLayout(new java.awt.GridLayout(0, 5, 18, 18));
        panel3.add(brandsSection, java.awt.BorderLayout.CENTER);

        jScrollPane2.setViewportView(panel3);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void categorySearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_categorySearchFocusGained
        categorySearch.setText(null);
    }//GEN-LAST:event_categorySearchFocusGained

    private void categorySearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_categorySearchFocusLost
        categorySearch.setText("Search category");
    }//GEN-LAST:event_categorySearchFocusLost

    private void categorySearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categorySearchKeyTyped
        loadCategory();
    }//GEN-LAST:event_categorySearchKeyTyped

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelectCategory dialog = new SelectCategory(new javax.swing.JFrame(), true);
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
    public javax.swing.JPanel brandsSection;
    private javax.swing.JTextField categorySearch;
    public static javax.swing.JLabel info;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel topCompanyBar;
    private javax.swing.JPanel topSection;
    // End of variables declaration//GEN-END:variables
}
