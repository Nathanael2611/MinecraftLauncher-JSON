package fr.nathanael2611.minecraftlaunchergenerator;

import fr.nathanael2611.json.JSONArray;
import fr.nathanael2611.json.JSONObject;
import fr.nathanael2611.minecraftlaunchergenerator.auth.AuthenticationException;
import fr.nathanael2611.minecraftlaunchergenerator.ui.LauncherPanel;
import fr.nathanael2611.minecraftlaunchergenerator.ui.RamSelector;
import fr.nathanael2611.minecraftlaunchergenerator.ui.components.LauncherComponent;
import fr.nathanael2611.minecraftlaunchergenerator.util.Helpers;
import fr.nathanael2611.nlib.NLib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URI;

public class ActionHandler {
    public static ActionListener createActionListenerByActionArray(JSONArray actions){
        return e -> {
            for(int i = 0; i < actions.length(); i++){
                JSONObject action = actions.getJSONObject(i);
                final String ACTION = action.getString("type");
                if(ACTION.equalsIgnoreCase("openlink")){
                    try {
                        Desktop.getDesktop().browse(new URI(
                                action.getString("link")
                        ));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }else if(ACTION.equalsIgnoreCase("window-action")){
                    final String TYPE = action.getString("action");
                    if(TYPE.equalsIgnoreCase("reduce")){
                        MinecraftLauncher.frame.setState(1);
                    }else if(TYPE.equalsIgnoreCase("close")){
                        System.exit(0);
                    }
                }else if(ACTION.equalsIgnoreCase("ram-selector")){
                    final String RAMS = action.getString("rams");
                    String[]  stringRams = RAMS.split(",");
                    Integer[] intRams = new Integer[RAMS.length()];
                    for(int index = 0; index < stringRams.length; index++){
                        intRams[index] = Integer.parseInt(stringRams[index]);
                    }
                    RamSelector.showRamSelector(intRams);
                }else if(ACTION.equalsIgnoreCase("launch")){
                    LauncherPanel.enableAll(false);
                    try {
                        MinecraftLauncher.processAuthentification();
                        JOptionPane.showMessageDialog(null, "Bien ! :D");
                    } catch (AuthenticationException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, ex.getErrorModel().getErrorMessage());
                    }
                }
            }
        };
    }

    public static Font getFontFromJSON(JSONObject fontObj){
        if(fontObj == null){
            return new Font("Sans Serif", Font.PLAIN, 20);
        }
        int fontType = Font.PLAIN;
        if(fontObj.getString("type").equalsIgnoreCase("italic")){
            fontType = Font.ITALIC;
        }else if(fontObj.getString("type").equalsIgnoreCase("bold")){
            fontType = Font.BOLD;
        }
        return new Font(
                fontObj.getString("name"),
                fontType,
                fontObj.getInt("size")
        );
    }

    public static void initTextFieldFromJSON(LauncherComponent field, JSONObject options){
        field.setLPosition(
                options.getString("x"),
                options.getString("y")
        );
        field.setLSize(
                options.getString("width"),
                options.getString("height")
        );
        if(options.getBoolean("transparent")){
            field.COMPONENT.setOpaque(false);
            field.COMPONENT.setBackground(NLib.TRANSPARENT);
            field.COMPONENT.setBorder(null);
        }
        field.COMPONENT.setFont(
                ActionHandler.getFontFromJSON(options.getJSONObject("font"))
        );
        field.COMPONENT.setForeground(
                Helpers.parseColor(options.getString("text-color"))
        );
        ((JTextField)field.COMPONENT).setCaretColor(
                Helpers.parseColor(options.getString("caret-color"))
        );
    }
}
