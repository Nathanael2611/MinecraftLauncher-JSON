package fr.nathanael2611.minecraftlauncherjson.ui.components;

import javax.swing.*;
import java.awt.*;

public class LauncherLabel extends JComponent {
    private String text;
    private boolean centered;

    public LauncherLabel() {
        this("", false);
    }

    public LauncherLabel(String text, boolean centered) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getForeground());
        /*if(centered){
            NLib.drawCenteredString(
                    g,
            );
        }else{*/
        g.drawString(
                this.text,
                getX(),
                getY()
        );
        /*}*/
    }
}
