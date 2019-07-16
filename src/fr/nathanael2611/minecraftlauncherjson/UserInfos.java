package fr.nathanael2611.minecraftlauncherjson;

import fr.nathanael2611.json.JSONObject;
import fr.nathanael2611.minecraftlauncherjson.util.Helpers;
import org.apache.commons.io.IOUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * This class is used for manage the user login information.
 *
 * @author Nathanael2611
 */
public class UserInfos {

    /**
     * Used for setup the user info-file.
     */
    public static void setupUserInfoFile() {
        MinecraftLauncher.launcherDir.mkdir();

        if (!MinecraftLauncher.userInfos.exists()) {
            try {
                MinecraftLauncher.userInfos.createNewFile();
                FileWriter writer = new FileWriter(MinecraftLauncher.userInfos);
                writer.write("{}");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get the JSONObject stored in the user info-file.
     */
    public static JSONObject getUserInfosObject() {
        setupUserInfoFile();
        JSONObject object = new JSONObject(Helpers.readFileToString(MinecraftLauncher.userInfos));
        return object;
    }

    /**
     * Get the username stored in the user-file.
     */
    public static String getUsername() {
        JSONObject object = getUserInfosObject();
        String username = null;
        if (object.getString("username").equalsIgnoreCase("notfound")) return "";
        try {
            username = IOUtils.toString(Base64.getDecoder().decode(object.getString("username")), String.valueOf(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            username = "";
        }
        if (username.equalsIgnoreCase("notfound")) username = "";
        return username;
    }

    /**
     * Get the password from the user-file.
     */
    public static String getPassword() {
        JSONObject object = getUserInfosObject();
        String password = null;
        if (object.getString("password").equalsIgnoreCase("notfound")) return "";
        try {
            password = IOUtils.toString(Base64.getDecoder().decode(object.getString("password")), String.valueOf(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            password = "";
        }
        if (password.equalsIgnoreCase("notfound")) password = "";
        return password;
    }

    /**
     * Used for set user infos in the info-file.
     */
    public static void setInfos(String username, String password) {
        JSONObject object = getUserInfosObject();
        try {
            object.put("username", IOUtils.toString(Base64.getEncoder().encode(username.getBytes()), String.valueOf(StandardCharsets.UTF_8)));
            object.put("password", IOUtils.toString(Base64.getEncoder().encode(password.getBytes()), String.valueOf(StandardCharsets.UTF_8)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter(MinecraftLauncher.userInfos);
            writer.write(object.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double getRam() {
        JSONObject object = getUserInfosObject();
        if (object.isNull("ram")) return 1.5;
        if (!(object.getDouble("ram") >= 1.5)) return 1.5;
        return object.getDouble("ram");
    }

    public static void setRam(double ram) {
        JSONObject object = getUserInfosObject();
        object.put("ram", ram);
        try {
            FileWriter writer = new FileWriter(MinecraftLauncher.userInfos);
            writer.write(object.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Used for disconnect the player-account.
     */
    public static void disconnect() {
        setInfos("", "");
    }

}
