package fr.nathanael2611.minecraftlauncherjson.ui.components.button;

import fr.nathanael2611.nlib.NLib;

import java.awt.*;

public class LauncherColoredProgressBar extends LauncherProgressBar {


    Color emptyColor;
    Color fillColor;


    public LauncherColoredProgressBar(Color emptyColor, Color fillColor) {
        this.emptyColor = emptyColor;
        this.fillColor = fillColor;
    }

    @Override
    public void paintComponent(Graphics g){

        NLib.fillColoredRect(g,this, emptyColor);
        g.setColor(fillColor);
        g.fillRect(0, 0, (level*getWidth())/maxLevel, getHeight());

    }

}
