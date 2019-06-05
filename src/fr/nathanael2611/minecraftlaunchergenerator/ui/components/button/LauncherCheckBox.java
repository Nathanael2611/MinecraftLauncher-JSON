package fr.nathanael2611.minecraftlaunchergenerator.ui.components.button;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LauncherCheckBox extends JComponent implements MouseListener {

    public LauncherCheckBox(){
        addMouseListener(this);
        repaint();
    }

    boolean isChecked = false;

    @Override
    public void mouseClicked(MouseEvent e) {
        if(isChecked) isChecked = false;
        else isChecked = true;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
