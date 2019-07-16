package fr.nathanael2611.minecraftlauncherjson.ui;

import fr.nathanael2611.minecraftlauncherjson.MinecraftLauncher;
import fr.nathanael2611.minecraftlauncherjson.ui.components.WindowMover;
import fr.nathanael2611.nlib.NLib;

import javax.swing.*;

public class LauncherFrame extends JFrame {

    public LauncherFrame() {
        //Define the launcher-title
        setTitle(MinecraftLauncher.launcher_name);
        //Define the launcher size
        setSize(MinecraftLauncher.base_width, MinecraftLauncher.base_height);
        setResizable(MinecraftLauncher.isResizable);
        setLocationRelativeTo(null);

        //Define the launcher-panel with all components
        JPanel panel = new LauncherPanel();
        setContentPane(panel);

        /* Set the icon of the launcher */
        setIconImage(MinecraftLauncher.icon);

        /* If the frame has a mover, add a mover to the frame */
        if (MinecraftLauncher.has_mover) {
            WindowMover mover = new WindowMover(this);
            this.addMouseListener(mover);
            this.addMouseMotionListener(mover);
        }

        /* Define if the frame is decorated */
        setUndecorated(MinecraftLauncher.undecorated);

        if (MinecraftLauncher.background_color == NLib.TRANSPARENT || MinecraftLauncher.background_type.equalsIgnoreCase("image")) {
            setBackground(NLib.TRANSPARENT);
        }

        /* After all */
        setVisible(true);
    }

}
