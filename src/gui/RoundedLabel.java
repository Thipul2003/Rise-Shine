/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RoundedLabel extends JLabel {
    private Image image;

    public RoundedLabel(Image image) {
        this.image = image;
        this.setPreferredSize(new Dimension(150, 150));  // Example size
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (image != null) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Create a rounded shape
            Ellipse2D.Double clip = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
            g2.setClip(clip);

            // Draw the image
            g2.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            g2.dispose();
        } else {
            super.paintComponent(g);
        }
    }
}
