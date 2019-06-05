package fr.nathanael2611.minecraftlaunchergenerator.ui.components.button;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LauncherTexturedProgressBar extends LauncherProgressBar {

    BufferedImage emptyTexture;
    BufferedImage fillTexture;

    public LauncherTexturedProgressBar(BufferedImage emptyTexture, BufferedImage fillTexture) {
        this.emptyTexture = emptyTexture;
        this.fillTexture = fillTexture;
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(emptyTexture, 0, 0, getWidth(), getHeight(), this);

        BufferedImage subForeground = emptyTexture.getSubimage(0, 0, (level*getWidth())/maxLevel, getHeight());
        g.drawImage(subForeground, 0, 0, subForeground.getWidth(), subForeground.getHeight(), this);

        //g.drawImage(fillTexture, 0, 0, (level*getWidth())/maxLevel, getHeight(), this);
    }
}
