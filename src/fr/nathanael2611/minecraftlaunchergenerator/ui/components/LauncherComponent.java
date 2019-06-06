package fr.nathanael2611.minecraftlaunchergenerator.ui.components;

import fr.nathanael2611.minecraftlaunchergenerator.util.Helpers;

import javax.swing.*;

public class LauncherComponent {

    String posX = "0";
    String posY = "0";

    String widthX = "0";
    String heightY = "0";

    public final JComponent COMPONENT;

    public LauncherComponent(final JComponent COMPONENT){
        this.COMPONENT = COMPONENT;
    }

    public String getPosX() {
        return posX;
    }

    public String getPosY() {
        return posY;
    }

    public void setLPosition(String posX, String posY){
        this.posX = posX;
        this.posY = posY;
    }

    public void setLSize(String widthX, String heightY){
        this.widthX  = widthX;
        this.heightY = heightY;
    }

    public String getWidthX() {
        return widthX;
    }

    public String getHeightY() {
        return heightY;
    }

    public void setAutomaticBounds(){
        String x = posX;
        String y = posY;
        String width = widthX;
        String height = heightY;
        if(posX.toUpperCase().contains("WIDTH"))
            x = posX.replaceAll("WIDTH", String.valueOf(COMPONENT.getParent().getWidth()));
        if(posY.toUpperCase().contains("WIDTH"))
            y = posY.replaceAll("WIDTH", String.valueOf(COMPONENT.getParent().getWidth()));
        if(widthX.toUpperCase().contains("WIDTH"))
            width = widthX.replaceAll("WIDTH", String.valueOf(COMPONENT.getParent().getWidth()));
        if(heightY.toUpperCase().contains("WIDTH"))
            height = heightY.replaceAll("WIDTH", String.valueOf(COMPONENT.getParent().getWidth()));

        if(posX.toUpperCase().contains("HEIGHT"))
            x = x.replaceAll("HEIGHT", String.valueOf(COMPONENT.getParent().getHeight()));
        if(posY.toUpperCase().contains("HEIGHT"))
            y = y.replaceAll("HEIGHT", String.valueOf(COMPONENT.getParent().getHeight()));
        if(widthX.toUpperCase().contains("HEIGHT"))
            width = width.replaceAll("HEIGHT", String.valueOf(COMPONENT.getParent().getHeight()));
        if(heightY.toUpperCase().contains("HEIGHT"))
            height = height.replaceAll("HEIGHT", String.valueOf(COMPONENT.getParent().getHeight()));
        COMPONENT.setBounds(
                Helpers.stringToInteger(x),
                Helpers.stringToInteger(y),
                Helpers.stringToInteger(width),
                Helpers.stringToInteger(height)
        );

    }
}
