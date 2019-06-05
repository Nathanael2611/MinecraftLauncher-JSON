package fr.nathanael2611.minecraftlaunchergenerator;

import fr.nathanael2611.json.JSONArray;
import fr.nathanael2611.json.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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
                }
            }
        };
    }
}
