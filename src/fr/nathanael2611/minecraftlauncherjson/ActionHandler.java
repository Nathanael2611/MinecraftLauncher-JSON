package fr.nathanael2611.minecraftlauncherjson;

import fr.nathanael2611.json.JSONArray;
import fr.nathanael2611.json.JSONObject;
import fr.nathanael2611.minecraftlauncherjson.auth.AuthenticationException;
import fr.nathanael2611.minecraftlauncherjson.launch.LaunchException;
import fr.nathanael2611.minecraftlauncherjson.ui.LauncherPanel;
import fr.nathanael2611.minecraftlauncherjson.ui.RamSelector;
import fr.nathanael2611.minecraftlauncherjson.ui.components.LauncherComponent;
import fr.nathanael2611.minecraftlauncherjson.util.Helpers;
import fr.nathanael2611.nlib.NLib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URI;

public class ActionHandler {
    public static ActionListener createActionListenerByActionArray(JSONArray actions) {
        return e -> {
            for (int i = 0; i < actions.length(); i++) {
                JSONObject action = actions.getJSONObject(i);
                final String ACTION = action.getString("type");
                if (ACTION.equalsIgnoreCase("openlink")) {
                    try {
                        Desktop.getDesktop().browse(new URI(
                                action.getString("link")
                        ));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (ACTION.equalsIgnoreCase("window-action")) {
                    final String TYPE = action.getString("action");
                    if (TYPE.equalsIgnoreCase("reduce")) {
                        MinecraftLauncher.frame.setState(1);
                    } else if (TYPE.equalsIgnoreCase("close")) {
                        System.exit(0);
                    }
                } else if (ACTION.equalsIgnoreCase("ram-selector")) {
                    JSONArray ramArray = action.getJSONArray("rams");
                    Double[] doubleRam = new Double[ramArray.length()];
                    for (int ii = 0; ii < ramArray.length(); ii++) {
                        doubleRam[ii] = ramArray.getDouble(ii);
                    }
                    RamSelector.showRamSelector(doubleRam);
                } else if (ACTION.equalsIgnoreCase("launch")) {
                    String username = "";
                    String password = "";
                    for (LauncherComponent component : MinecraftLauncher.COMPONENT_LIST) {
                        if (component.COMPONENT instanceof JTextField && username.equalsIgnoreCase("")) {
                            username = ((JTextField) component.COMPONENT).getText();
                        }
                        if (component.COMPONENT instanceof JPasswordField && password.equalsIgnoreCase("")) {
                            password = ((JPasswordField) component.COMPONENT).getText();
                        }
                    }
                    UserInfos.setInfos(username, password);
                    Thread t = new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            LauncherPanel.enableAll(false);
                            try {
                                MinecraftLauncher.processAuthentification();
                            } catch (AuthenticationException ex) {
                                ex.printStackTrace();
                                LauncherPanel.enableAll(true);
                                JOptionPane.showMessageDialog(null, ex.getErrorModel().getErrorMessage());
                                return;
                            }

                            try {
                                MinecraftLauncher.processUpdate();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            try {
                                MinecraftLauncher.processLaunch();
                            } catch (LaunchException ex) {
                                ex.printStackTrace();
                            }
                        }
                    };

                    t.start();

                }
            }
        };
    }

    public static Font getFontFromJSON(JSONObject fontObj) {
        if (fontObj == null) {
            return new Font("Sans Serif", Font.PLAIN, 20);
        }
        int fontType = Font.PLAIN;
        if (fontObj.getString("type").equalsIgnoreCase("italic")) {
            fontType = Font.ITALIC;
        } else if (fontObj.getString("type").equalsIgnoreCase("bold")) {
            fontType = Font.BOLD;
        }
        return new Font(
                fontObj.getString("name"),
                fontType,
                fontObj.getInt("size")
        );
    }

    public static void initTextFieldFromJSON(LauncherComponent field, JSONObject options) {
        field.setLPosition(
                options.getString("x"),
                options.getString("y")
        );
        field.setLSize(
                options.getString("width"),
                options.getString("height")
        );
        if (options.getBoolean("transparent")) {
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
        ((JTextField) field.COMPONENT).setCaretColor(
                Helpers.parseColor(options.getString("caret-color"))
        );
    }
}
