package fr.nathanael2611.minecraftlauncherjson.ui.components.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LauncherButton extends JButton implements MouseListener {

    private Color textColor = null;
    private String text;
    private boolean hover;
    private boolean clicked;

    public LauncherButton() {
        addMouseListener(this);
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
        repaint();
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        clicked = true;
        repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        clicked = false;
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        hover = true;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        hover = false;
        repaint();
    }


    public boolean isHover() {
        return hover;
    }

    public boolean isClicked() {
        return clicked;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


    }
}
