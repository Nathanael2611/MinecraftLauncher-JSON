package fr.nathanael2611.nlib;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NLib {


    public static final Color TRANSPARENT = new Color(0, 0, 0, 0);


    public static String resourcePath;

    public static String getResourcePath() {
        return resourcePath;
    }

    public static void setResourcePath(String resourcePath) {
        NLib.resourcePath = resourcePath.endsWith("/") ? resourcePath.substring(0, resourcePath.length() - 1) : resourcePath;
    }

    public static BufferedImage getImage(String resource) {
        try {
            return ImageIO.read(NLib.class.getResourceAsStream(getResourcePath() + "/" + resource));
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't load the given image (" + getResourcePath() + "/" + resource + ") : " + e);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Can't load the given image (" + getResourcePath() + "/" + resource + ") : " + e);
        }
    }

    public static File getResource(String resource) {
        try {
            return new File(getResourcePath() + "/" + resource);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Can't load the given image (" + getResourcePath() + "/" + resource + ") : " + e);
        }
    }

    public static AudioInputStream getAudioClip(String resource) {
        AudioInputStream inputStream;
        try {
            inputStream = AudioSystem.getAudioInputStream(NLib.class.getResourceAsStream(getResourcePath() + "/" + resource));
            return inputStream;
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void drawCenteredString(Graphics g, String str, Rectangle parent) {
        FontMetrics fm = g.getFontMetrics();
        Point centerPos = getStringCenterPos(parent, str, fm, g);
        g.drawString(str, (int) centerPos.getX(), (int) centerPos.getY());
    }

    public static Point getStringCenterPos(Rectangle parent, String str, FontMetrics fontMetrics, Graphics g) {
        Rectangle2D stringBounds = fontMetrics.getStringBounds(str, g);
        double x = ((parent.getWidth() - stringBounds.getWidth()) / 2);
        double y = ((parent.getHeight() - stringBounds.getHeight()) / 2 + fontMetrics.getAscent());
        return new Point((int) x, (int) y);
    }

    public static void fillColoredRect(Graphics g, JComponent component, Color color) {
        g.setColor(color);
        g.fillRect(0, 0, component.getWidth(), component.getHeight());
    }

    public static void playSound(String sound) {
        new Thread() {
            public void run() {
                Clip clip = null;
                try {
                    clip = AudioSystem.getClip();
                    clip.open(getAudioClip(sound));

                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clip.start();
            }
        }.start();
    }


}