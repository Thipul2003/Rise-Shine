package Model;

import com.formdev.flatlaf.ui.FlatLineBorder;
import gui.Brands;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class brandPanel extends javax.swing.JPanel {

    private boolean isSelected = false;

    Brands b;

    public void setB(Brands b) {
        this.b = b;
    }

    public JPanel getMain() {
        return main;
    }

    public JLabel getBrandName() {
        return brandName;
    }

    public JLabel getLogo() {
        return logo;
    }

    public JPanel getLogoSection() {
        return logoSection;
    }

    public JPanel getBrandSection() {
        return brandSection;
    }

    
    
    

    public brandPanel() {
        initComponents();
        main.setBackground(Color.white);
        UIManager.put("[style]Panel.main",
                "[light]background: tint(@background,50%);"
                + "[dark]background: shade(@background,15%);"
                + "[light]border: 16,16,16,16,shade(@background,10%),,12;"
                + "[dark]border: 16,16,16,16,tint(@background,10%),,12");
        selected();
    }

    private void selected() {

        if (isSelected) {//false
            main.setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), Color.red, 3, 50));
            isSelected = false;

        } else {
            main.setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), new Color(119, 82, 254), 1, 50));//[119,82,254]
            isSelected = true;

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        logoSection = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        brandSection = new javax.swing.JPanel();
        brandName = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPreferredSize(new java.awt.Dimension(50, 249));

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMouseClicked(evt);
            }
        });

        logoSection.setBackground(new java.awt.Color(255, 255, 255));
        logoSection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoSectionMouseClicked(evt);
            }
        });
        logoSection.setLayout(new java.awt.BorderLayout());

        logo.setBackground(new java.awt.Color(255, 255, 255));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoSection.add(logo, java.awt.BorderLayout.CENTER);

        brandSection.setBackground(new java.awt.Color(255, 255, 255));
        brandSection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brandSectionMouseClicked(evt);
            }
        });
        brandSection.setLayout(new java.awt.BorderLayout());

        brandName.setBackground(new java.awt.Color(255, 255, 255));
        brandName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        brandName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        brandName.setText("jLabel1");
        brandSection.add(brandName, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brandSection, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(logoSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoSection, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brandSection, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(main);
    }// </editor-fold>//GEN-END:initComponents

    private void brandSectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brandSectionMouseClicked
        if (evt.getClickCount() == 1 && evt.getButton() == 3) {
            selected();

        }
    }//GEN-LAST:event_brandSectionMouseClicked

    private void logoSectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoSectionMouseClicked
        if (evt.getClickCount() == 1 && evt.getButton() == 3) {
            selected();

        }
    }//GEN-LAST:event_logoSectionMouseClicked

    private void mainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMouseClicked
       if (evt.getClickCount() == 1 && evt.getButton() == 3) {
            selected();

        }
    }//GEN-LAST:event_mainMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandName;
    private javax.swing.JPanel brandSection;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logoSection;
    private javax.swing.JPanel main;
    // End of variables declaration//GEN-END:variables
}
