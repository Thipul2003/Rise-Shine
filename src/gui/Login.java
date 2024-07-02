package gui;

import Model.MySQL;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        initial();
    }

    private void initial() {
        emailInvalidIcon.setVisible(false);
        passwordInvalidIcon.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        leftImg = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        visiblepassword = new javax.swing.JLabel();
        notvisiblePassword = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        emailInvalidIcon = new javax.swing.JLabel();
        passwordInvalidIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        leftPanel.setBackground(new java.awt.Color(204, 0, 51));
        leftPanel.setPreferredSize(new java.awt.Dimension(565, 559));
        leftPanel.setLayout(new javax.swing.BoxLayout(leftPanel, javax.swing.BoxLayout.LINE_AXIS));

        leftImg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        leftImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LoginGiff.gif"))); // NOI18N
        leftImg.setPreferredSize(new java.awt.Dimension(560, 662));
        leftPanel.add(leftImg);

        getContentPane().add(leftPanel, java.awt.BorderLayout.LINE_START);

        rightPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightPanel.setPreferredSize(new java.awt.Dimension(560, 662));
        rightPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/RISE.gif"))); // NOI18N
        rightPanel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, -20, -1, 220));

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        emailLabel.setText("Email/Mobile");
        rightPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        passwordLabel.setText("Password");
        rightPanel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        emailTextField.setBackground(new java.awt.Color(153, 255, 255));
        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        emailTextField.setMargin(new java.awt.Insets(2, 20, 2, 20));
        emailTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailTextFieldFocusGained(evt);
            }
        });
        emailTextField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                emailTextFieldInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        rightPanel.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 400, 50));

        visiblepassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-eye-25.png"))); // NOI18N
        visiblepassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        visiblepassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visiblepasswordMouseClicked(evt);
            }
        });
        rightPanel.add(visiblepassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 425, -1, -1));

        notvisiblePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-not-visible-25.png"))); // NOI18N
        notvisiblePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notvisiblePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notvisiblePasswordMouseClicked(evt);
            }
        });
        rightPanel.add(notvisiblePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 425, -1, -1));

        passwordTextField.setBackground(new java.awt.Color(153, 255, 255));
        passwordTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordTextField.setMargin(new java.awt.Insets(2, 20, 2, 50));
        rightPanel.add(passwordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, 400, 50));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("SignIn");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        rightPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 440, 50));

        emailInvalidIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-warning-48.png"))); // NOI18N
        rightPanel.add(emailInvalidIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, -1));

        passwordInvalidIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-warning-48.png"))); // NOI18N
        rightPanel.add(passwordInvalidIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

        getContentPane().add(rightPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldFocusGained

    private void emailTextFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_emailTextFieldInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_emailTextFieldInputMethodTextChanged

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        //jButton1.setBackground(new Color(0, 153, 255));

    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String email = emailTextField.getText();
        String password = String.valueOf(passwordTextField.getPassword());
        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        String mobileRegex = "^07[01245678]{1}[0-9]{7}$";
        boolean isvalidated = false;

        if (password.isEmpty()) {//password field
            passwordTextField.grabFocus();
        } else if (!password.matches(passwordRegex)) {
            passwordInvalidIcon.setVisible(true);
        } else {
            passwordInvalidIcon.setVisible(false);

        }

        if (email.isEmpty()) { //Email field
            emailTextField.grabFocus();
        } else if (!email.matches(emailRegex)) {
            emailInvalidIcon.setVisible(true);
        } else {
            emailInvalidIcon.setVisible(false);
        }

        if (!email.isEmpty() && !password.isEmpty() && password.matches(passwordRegex) && email.matches(emailRegex)) {
            isvalidated = true;
        }
        if (isvalidated) {
            try {
                ResultSet resultSet = MySQL.execute("SELECT * FROM employee WHERE `email`='" + email + "' AND `password`='" + password + "'");
                
                if(resultSet.next()){
                    String employee_email = resultSet.getString("email");
                    
                    AdminDashboard db = new AdminDashboard(employee_email);
                    db.setVisible(true);
                    this.dispose();
                    
                }else{
                    JOptionPane.showMessageDialog(this, "Invalid Email or Password", "Invalid", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void visiblepasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visiblepasswordMouseClicked

        notvisiblePassword.setVisible(true);
        passwordTextField.setEchoChar('\u25cf');
        visiblepassword.setVisible(false);
    }//GEN-LAST:event_visiblepasswordMouseClicked

    private void notvisiblePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notvisiblePasswordMouseClicked

        visiblepassword.setVisible(true);
        passwordTextField.setEchoChar('\u0000');
        notvisiblePassword.setVisible(false);
    }//GEN-LAST:event_notvisiblePasswordMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        UIManager.put("ToggleButton.selectedBackground", new Color(119, 82, 254));
        UIManager.put("ToggleButton.hoverBackground", new Color(95, 186, 255));
        UIManager.put("ToggleButton.selectedForeground", new Color(255, 255, 255));
        UIManager.put("ToggleButton.pressedBackground", new Color(27, 155, 255));
        UIManager.put("Button.arc", 200);
        UIManager.put("Button.boldText", true);
        UIManager.put("Button.borderWidth", 0);
        UIManager.put("TextComponent.arc", 999);
        UIManager.put("Component.focusWidth", 0);
        UIManager.put("ScrollBar.thumbArc", 999);
        UIManager.put("ScrollBar.width", 8);
        UIManager.put("ScrollBar.borderWidth", 0);
        UIManager.put("ScrollBar.hoverThumbColor", new Color(153, 51, 255));//[153,51,255]
        UIManager.put("[style]Panel.myRoundPanel",
                "[light]background: tint(@background,50%);"
                + "[dark]background: shade(@background,15%);"
                + "[light]border: 16,16,16,16,shade(@background,10%),,12;"
                + "[dark]border: 16,16,16,16,tint(@background,10%),,12");

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailInvalidIcon;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel leftImg;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel notvisiblePassword;
    private javax.swing.JLabel passwordInvalidIcon;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel visiblepassword;
    // End of variables declaration//GEN-END:variables
}
