package fr.nathanael2611.minecraftlaunchergenerator.ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LauncherImage extends JComponent {
    BufferedImage image;
    public LauncherImage(BufferedImage image){
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.drawImage(
                image,
                0, 0,
                getWidth(), getHeight(),
                this
        );
    }
}
