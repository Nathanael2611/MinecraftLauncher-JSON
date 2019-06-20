package fr.nathanael2611.minecraftlaunchergenerator.ui;

import fr.nathanael2611.minecraftlaunchergenerator.MinecraftLauncher;

import javax.swing.*;
import java.awt.*;

public class RamSelector extends JDialog{

    public static void showRamSelector(Integer[] rams){
        JDialog dialog = new RamSelector (rams);

        dialog.setVisible(true);


    }

    private JComboBox<Integer> ramBox;

    public RamSelector(Integer[] rams){
        setModal (true);
        setTitle("RamSelector");
        setLocationRelativeTo(null);
        setAlwaysOnTop (true);
        setLayout(null);
        setModalityType (Dialog.ModalityType.APPLICATION_MODAL);
        ramBox = new JComboBox<>(rams);
        add(ramBox);
        new Thread(()->{
            for(; ;){
                ramBox.setBounds(
                        getWidth()       /2 - (getWidth()/4),
                        getHeight()      /2 - (getHeight()/8),
                        getWidth()    /2,
                        getHeight()   /8
                );
            }
        }).start();
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

        System.out.println("pas ouf ouf");
    }
}
