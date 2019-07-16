package fr.nathanael2611.minecraftlauncherjson.ui.components.button;

import java.awt.*;

public class LauncherTexturedCheckBox extends LauncherCheckBox {

    Image unCheckedTexture;
    Image checkedTexture;

    public LauncherTexturedCheckBox(Image unCheckedTexture, Image checkedTexture) {
        this.unCheckedTexture = unCheckedTexture;
        this.checkedTexture = checkedTexture;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image texture = null;

        if (isChecked) {
            texture = checkedTexture;
        } else {
            texture = unCheckedTexture;
        }

        g.drawImage(texture, 0, 0, getWidth(), getHeight(), this);


    }


    public Image getUnCheckedTexture() {
        return unCheckedTexture;
    }

    public void setUnCheckedTexture(Image unCheckedTexture) {
        this.unCheckedTexture = unCheckedTexture;
        repaint();
    }

    public Image getCheckedTexture() {
        return checkedTexture;
    }

    public void setCheckedTexture(Image checkedTexture) {
        this.checkedTexture = checkedTexture;
        repaint();
    }
}
