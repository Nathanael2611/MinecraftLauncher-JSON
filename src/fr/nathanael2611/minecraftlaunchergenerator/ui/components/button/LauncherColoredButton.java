package fr.nathanael2611.minecraftlaunchergenerator.ui.components.button;

import fr.nathanael2611.nlib.NLib;

import java.awt.*;

public class LauncherColoredButton extends LauncherButton {

    Color color;
    Color colorHover;
    Color colorDisabled;



    public LauncherColoredButton(Color color){
        this.color = color;
        this.colorHover = colorHover;
        this.colorDisabled = colorDisabled;
    }
    public LauncherColoredButton(Color color, Color colorHover){
        this.color = color;
        this.colorHover = colorHover;
        this.colorDisabled = colorDisabled;
    }
    public LauncherColoredButton(Color color, Color colorHover, Color colorDisabled){
        this.color = color;
        this.colorHover = colorHover;
        this.colorDisabled = colorDisabled;
    }


    @Override
    public void paintComponent(Graphics g){
        //super.paintComponent(g);
        setOpaque(false);
        setBackground(NLib.TRANSPARENT);
        Color buttonColor;

        if(isEnabled()){
            if(isHover())buttonColor = this.colorHover;
            else buttonColor = this.color;
        }else buttonColor = this.colorDisabled;

        NLib.fillColoredRect(g, this, buttonColor);

        if(getText() !=null) {
            g.setColor(Color.black);
            if (getTextColor() != null) g.setColor(getTextColor());
            NLib.drawCenteredString(g, getText(), this.getBounds());
        }

    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    public Color getColorHover() {
        return colorHover;
    }

    public void setColorHover(Color colorHover) {
        this.colorHover = colorHover;
        repaint();
    }

    public Color getColorDisabled() {
        return colorDisabled;
    }

    public void setColorDisabled(Color colorDisabled) {
        this.colorDisabled = colorDisabled;
        repaint();
    }
}
