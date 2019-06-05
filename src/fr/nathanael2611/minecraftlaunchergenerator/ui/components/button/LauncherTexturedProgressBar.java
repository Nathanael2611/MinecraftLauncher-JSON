package fr.nathanael2611.minecraftlaunchergenerator.ui.components.button;

import java.awt.*;

public class LauncherTexturedProgressBar extends LauncherProgressBar {

    Image emptyTexture;
    Image fillTexture;


    public LauncherTexturedProgressBar(Image emptyTexture, Image fillTexture) {
        this.emptyTexture = emptyTexture;
        this.fillTexture = fillTexture;
    }

    @Override
    public void paintComponent(Graphics g){

        g.drawImage(emptyTexture, 0, 0, getWidth(), getHeight(), this);

        g.drawImage(fillTexture, 0, 0, (level*getWidth())/maxLevel, getHeight(), this);

    }
}
