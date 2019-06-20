package fr.nathanael2611.minecraftlaunchergenerator.ui;

import fr.nathanael2611.minecraftlaunchergenerator.MinecraftLauncher;
import fr.nathanael2611.minecraftlaunchergenerator.ui.components.LauncherComponent;
import fr.nathanael2611.nlib.NLib;

import javax.swing.*;
import java.awt.*;

public class LauncherPanel extends JPanel {

    public LauncherPanel(){
        setLayout(null);

        /* Set the opacity to 0 if the background is transparent */
        if(MinecraftLauncher.background_color == NLib.TRANSPARENT || MinecraftLauncher.background_type.equalsIgnoreCase("image")){
            setOpaque(false);
        }
        /*
         * Add the component to panel.
         */
        for(LauncherComponent component : MinecraftLauncher.COMPONENT_LIST){
            add(component.COMPONENT);

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(MinecraftLauncher.background_type.equalsIgnoreCase("image")){
            g.drawImage(
                    MinecraftLauncher.background_image,
                    0,
                    0,getWidth(),
                    getHeight(),
                    this
            );
        }else if(MinecraftLauncher.background_color.getRGB() != NLib.TRANSPARENT.getRGB()){
            g.setColor(MinecraftLauncher.background_color);
            g.fillRect(
                    0,
                    0,
                    getWidth(),
                    getHeight()
            );
        }

        for(LauncherComponent component : MinecraftLauncher.COMPONENT_LIST){
            component.setAutomaticBounds();
        }
    }
}
