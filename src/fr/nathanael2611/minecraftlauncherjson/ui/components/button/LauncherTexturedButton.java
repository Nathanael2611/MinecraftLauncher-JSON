package fr.nathanael2611.minecraftlauncherjson.ui.components.button;


import fr.nathanael2611.nlib.NLib;

import java.awt.*;
import java.awt.image.BufferedImage;

import static fr.nathanael2611.nlib.NLib.drawCenteredString;

public class LauncherTexturedButton extends LauncherButton {

    BufferedImage texture;
    BufferedImage textureHover;
    BufferedImage textureDisabled;

    public LauncherTexturedButton(BufferedImage texture) {
        this.texture = texture;
        this.textureHover = texture;
        this.textureDisabled = texture;
    }

    public LauncherTexturedButton(BufferedImage texture, BufferedImage textureHover) {
        this.texture = texture;
        this.textureHover = textureHover;
        this.textureDisabled = textureHover;
    }

    public LauncherTexturedButton(BufferedImage texture, BufferedImage textureHover, BufferedImage textureDisabled) {
        this.texture = texture;
        this.textureHover = textureHover;
        this.textureDisabled = textureDisabled;
    }


    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        setOpaque(false);
        setBackground(NLib.TRANSPARENT);
        Image buttonTexture;

        if (isEnabled()) {
            if (isHover()) buttonTexture = this.textureHover;
            else buttonTexture = this.texture;
        } else buttonTexture = this.textureDisabled;

        g.drawImage(buttonTexture, 0, 0, getWidth(), getHeight(), this);

        if (getTextColor() != null) g.setColor(getTextColor());
        drawCenteredString(g, getText(), this.getBounds());
        g.setColor(null);

    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
        repaint();
    }

    public BufferedImage getTextureHover() {
        return textureHover;
    }

    public void setTextureHover(BufferedImage textureHover) {
        this.textureHover = textureHover;
        repaint();
    }

    public BufferedImage getTextureDisabled() {
        return textureDisabled;
    }

    public void setTextureDisabled(BufferedImage textureDisabled) {
        this.textureDisabled = textureDisabled;
        repaint();
    }
}
