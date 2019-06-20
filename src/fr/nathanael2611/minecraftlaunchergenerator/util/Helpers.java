package fr.nathanael2611.minecraftlaunchergenerator.util;

import fr.nathanael2611.nlib.NLib;

import javax.imageio.ImageIO;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * This class contain a lot of useful things
 */
public class Helpers {

    /**
     * Useful for read the content of a file.
     */
    public static String readFileToString(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();
            return stringBuilder.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "ERROR";
    }

    public static String readJsonFromUrl(String url) throws IOException, IOException {
        URL urlObject;
        URLConnection uc;
        StringBuilder parsedContentFromUrl = new StringBuilder();
        urlObject = new URL(url);
        uc = urlObject.openConnection();
        uc.connect();
        uc = urlObject.openConnection();
        uc.addRequestProperty("User-Agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        uc.getInputStream();
        InputStream is = uc.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        int ch;
        while ((ch = in.read()) != -1) {
            parsedContentFromUrl.append((char) ch);
        }
        return parsedContentFromUrl.toString();
    }

    public static int stringToInteger(String calc){
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String code = "eval("+calc+")";
        try {
            return (int) Math.round(Double.valueOf(engine.eval(code).toString()));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.err.println("Error while eval "+calc+" !!!! Return value will be 0.");
        return 0;
    }

    public static BufferedImage getImageFromLink(String link){
        try {
            return ImageIO.read(new URL(link));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }


    public static Color parseColor(String color){
        if(color.equalsIgnoreCase("notfound"))return Color.BLACK;
        if(color.equalsIgnoreCase("transparent")){
            return NLib.TRANSPARENT;
        }
        return Color.decode(color);
    }

}
