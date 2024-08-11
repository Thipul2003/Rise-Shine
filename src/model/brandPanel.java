package model;

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

    private void setBlue() {
        main.setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), new Color(119, 82, 254), 1, 50));//[119,82,254]

    }

    private void setRed() {
        main.setBorder(new FlatLineBorder(new Insets(16, 16, 16, 16), Color.red, 3, 50));

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

    public void selected() {

        if (isSelected) {//false
            setRed();
            isSelected = false;

        } else {
            setBlue();
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
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mainMouseExited(evt);
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
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoMouseExited(evt);
            }
        });
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
        brandName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                brandNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                brandNameMouseExited(evt);
            }
        });
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
//            selected();

        }
    }//GEN-LAST:event_mainMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered

    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited

    }//GEN-LAST:event_formMouseExited

    private void mainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMouseEntered
    }//GEN-LAST:event_mainMouseEntered

    private void mainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMouseExited
    }//GEN-LAST:event_mainMouseExited

    private void logoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_logoMouseEntered

    private void logoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_logoMouseExited

    private void brandNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brandNameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_brandNameMouseEntered

    private void brandNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brandNameMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_brandNameMouseExited

//[166, 189]
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandName;
    private javax.swing.JPanel brandSection;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logoSection;
    private javax.swing.JPanel main;
    // End of variables declaration//GEN-END:variables
}
