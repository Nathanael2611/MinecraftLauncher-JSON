package fr.nathanael2611.minecraftlauncherjson.ui.components.button;

import javax.swing.*;

public class LauncherProgressBar extends JComponent {


    int level;
    int maxLevel;



    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        repaint();
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
        repaint();

    }
}
