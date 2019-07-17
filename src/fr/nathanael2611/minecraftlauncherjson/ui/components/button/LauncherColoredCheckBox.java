package fr.nathanael2611.minecraftlauncherjson.ui.components.button;

import fr.nathanael2611.nlib.NLib;

import java.awt.*;

public class LauncherColoredCheckBox extends LauncherCheckBox {

    Color unCheckedColor;
    Color checkedColor;

    public LauncherColoredCheckBox(Color unCheckedColor, Color checkedColor) {
        this.unCheckedColor = unCheckedColor;
        this.checkedColor = checkedColor;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isChecked) {
            NLib.fillColoredRect(g, this, checkedColor);
        } else {
            NLib.fillColoredRect(g, this, unCheckedColor);
        }


    }


    public Color getUnCheckedColor() {
        return unCheckedColor;
    }

    public void setUnCheckedColor(Color unCheckedColor) {
        this.unCheckedColor = unCheckedColor;
        repaint();
    }

    public Color getCheckedColor() {
        return checkedColor;
    }

    public void setCheckedColor(Color checkedColor) {
        this.checkedColor = checkedColor;
        repaint();
    }
}
