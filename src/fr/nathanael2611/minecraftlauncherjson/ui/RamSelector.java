package fr.nathanael2611.minecraftlauncherjson.ui;

import fr.nathanael2611.minecraftlauncherjson.UserInfos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RamSelector extends JDialog{

    public static void showRamSelector(Double[] rams){
        JDialog dialog = new RamSelector (rams);

        dialog.setVisible(true);


    }

    private JComboBox ramBox;

    public RamSelector(Double[] rams){
        setModal (true);
        setTitle("RamSelector");
        setLocationRelativeTo(null);
        setAlwaysOnTop (true);
        setSize(300, 100);
        setLayout(null);
        setResizable(false);
        setModalityType (Dialog.ModalityType.APPLICATION_MODAL);
        ramBox = new JComboBox<>(rams);
        ramBox.setSelectedItem(UserInfos.getRam());
        add(ramBox);
        ramBox.setBounds(
                getWidth()       /2 - (getWidth()/4),
                getHeight()      /2 - (getHeight()/4),
                getWidth()    /2,
                getHeight()   /4
        );
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                UserInfos.setRam((Double) ramBox.getSelectedItem());
            }
        });
    }
}
