package fr.nathanael2611.minecraftlaunchergenerator;

import fr.nathanael2611.json.JSONArray;
import fr.nathanael2611.json.JSONObject;
import fr.nathanael2611.minecraftlaunchergenerator.ui.LauncherFrame;
import fr.nathanael2611.minecraftlaunchergenerator.ui.components.LauncherComponent;
import fr.nathanael2611.minecraftlaunchergenerator.ui.components.button.*;
import fr.nathanael2611.minecraftlaunchergenerator.util.Helpers;
import fr.nathanael2611.nlib.NLib;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MinecraftLauncher {

    public static String launcher_name;

    public static int base_width;
    public static int base_height;
    public static boolean isResizable;

    public static String background_type;
    public static String background_value;
    public static Color background_color;
    public static Image background_image;

    public static Image icon;

    public static boolean has_mover = false;
    public static boolean undecorated = false;


    public static final ArrayList<LauncherComponent> COMPONENT_LIST = new ArrayList<>();



    public static void main(String[] args) {
        new MinecraftLauncher("http://kyrgon.fr/nathanael2611/minecraftlaunchergenerator/test.json");
    }

    public static JFrame frame;

    public MinecraftLauncher(String URL){
        JSONObject infos;

        try {
            infos = new JSONObject(Helpers.readJsonFromUrl(URL));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JPanel(), "Impossible de se connecter à l'adresse du launcher...");
            return;
        }

        launcher_name = infos.getString("launcher-name");
        has_mover     = infos.getBoolean("has-window-mover");
        undecorated   = infos.getBoolean("undecorated");

        {
            //SIZE
            JSONObject sizeInfos = infos.getJSONObject("base-size");
            base_width  = sizeInfos.getInt("width");
            base_height = sizeInfos.getInt("height");
            isResizable = sizeInfos.getBoolean("resizable");
        }
        //ICON
        try {
            icon = ImageIO.read(new URL(infos.getString("icon")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        {
            //BACKGROUND
            JSONObject backgroundInfos = infos.getJSONObject("background");
            background_type  = backgroundInfos.getString("type");
            background_value = backgroundInfos.getString("value");
            if(background_type.equalsIgnoreCase("image")){
                try {
                    background_image = ImageIO.read(new URL(background_value));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                if(background_value.equalsIgnoreCase("transparent")){
                    background_color = NLib.TRANSPARENT;
                }else {
                    background_color = Color.decode(background_value);
                }
            }
        }

        JSONArray components = infos.getJSONArray("components");
        for(int i = 0; i < components.length(); i++){
            JSONObject component = components.getJSONObject(i);
            LauncherComponent theComponent = null;
            final String TYPE = component.getString("type");

            if(TYPE.contains("button")){
                if(TYPE.equalsIgnoreCase("button")){
                    theComponent = new LauncherComponent(
                            new JButton()
                    );
                }else if(TYPE.equalsIgnoreCase("colored-button")){
                    theComponent = new LauncherComponent(
                            new LauncherColoredButton(
                                    Color.decode(component.getString("color")),
                                    Color.decode(component.getString("color-hover")),
                                    Color.decode(component.getString("color-disabled"))
                            )
                    );
                }else if(TYPE.equalsIgnoreCase("textured-button")){
                    theComponent = new LauncherComponent(
                            new LauncherTexturedButton(
                                    Helpers.getImageFromLink(component.getString("texture")),
                                    Helpers.getImageFromLink(component.getString("texture-hover")),
                                    Helpers.getImageFromLink(component.getString("texture-disabled"))
                            )
                    );
                }
                JButton btn = (JButton)theComponent.COMPONENT;
                if(!component.getBoolean("border"))btn.setBorder(null);
                btn.setText(component.getString("text"));
                btn.addActionListener(ActionHandler.createActionListenerByActionArray(
                        component.getJSONArray("actions")
                ));
            }else if(TYPE.contains("progress-bar")){
                if(TYPE.equalsIgnoreCase("textured-progress-bar")){
                    theComponent = new LauncherComponent(
                            new LauncherTexturedProgressBar(
                                    Helpers.getImageFromLink("empty-texture"),
                                    Helpers.getImageFromLink("filled-texture")
                            )
                    );
                }else if(TYPE.equalsIgnoreCase("colored-progress-bar")){
                    theComponent = new LauncherComponent(
                            new LauncherColoredProgressBar(
                                    Color.decode(component.getString("empty-color")),
                                    Color.decode(component.getString("filled-color"))
                            )
                    );

                }
                LauncherProgressBar progressBar = (LauncherProgressBar) theComponent.COMPONENT;
                progressBar.setLevel(0);
                progressBar.setMaxLevel(100);
            }

            theComponent.setLPosition(component.getString("x"), component.getString("y"));
            theComponent.setLSize(component.getString("width"), component.getString("height"));
            COMPONENT_LIST.add(theComponent);
        }

        //ALL TEXTFIELDS ;)
        {
            JSONObject confidentialityOptions = infos.getJSONObject("confidentiality-options");
            {
                JSONObject usernameFieldOptions   = confidentialityOptions.getJSONObject("username-field");
                LauncherComponent usernameField = new LauncherComponent(
                        new JTextField()
                );
                ActionHandler.initTextFieldFromJSON(
                        usernameField, usernameFieldOptions
                );
                COMPONENT_LIST.add(usernameField);
            }
            {
                JSONObject passwordFieldOptions   = confidentialityOptions.getJSONObject("password-field");
                LauncherComponent passwordField = new LauncherComponent(
                        new JPasswordField()
                );
                ActionHandler.initTextFieldFromJSON(
                        passwordField, passwordFieldOptions
                );
                COMPONENT_LIST.add(passwordField);
            }

        }

        frame = new LauncherFrame();

    }

}
