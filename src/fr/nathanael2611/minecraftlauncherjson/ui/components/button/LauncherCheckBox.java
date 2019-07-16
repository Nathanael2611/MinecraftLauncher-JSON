package fr.nathanael2611.minecraftlauncherjson.ui.components.button;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LauncherCheckBox extends JComponent implements MouseListener {

    boolean isChecked = false;

    public LauncherCheckBox() {
        addMouseListener(this);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        isChecked = !isChecked;
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
