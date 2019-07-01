package fr.nathanael2611.minecraftlauncherjson.bootstrap;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

public class Bootloader extends JPanel {
    public static final File MINECRAFLAUNCHERJSON_DIR = getMinecraftLauncherJSONDir();
    public static Bootloader instance;
    JProgressBar progressBar = new JProgressBar();
    static JFrame frame;
    public static String updateLink = "";
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!MINECRAFLAUNCHERJSON_DIR.exists())MINECRAFLAUNCHERJSON_DIR.mkdir();
        File linkFile = new File(Bootloader.class.getResource("/fr/nathanael2611/minecraftlauncherjson/bootstrap/update-link.txt").getFile());
        updateLink = readFileToString(linkFile);
        System.out.println("[MinecraftLauncher-JSON] Starting bootloader...");
        instance = new Bootloader();
    }

    /**
     * Bootstrap constructor
     */
    public Bootloader() {
        frame = new JFrame();
        frame.setContentPane(this);
        frame.setSize(340, 100);
        frame.setTitle("Mise à jour du launcher...");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        setLayout(null);

        progressBar.setBounds(4, 2, getWidth() - 8, 30);
        progressBar.setMaximum(1000);
        progressBar.setValue(100);
        progressBar.setIndeterminate(true);
        progressBar.setStringPainted(false);
        add(progressBar);

        frame.setVisible(true);

        new Thread(() -> {
            update();
            launch();
        }).start();

    }

    /**
     * Used for launch the Launcher
     */
    public static void launch() {
        System.out.println("[MinecraftLauncher-JSON] Launching...");

        try {
            Runtime.getRuntime().exec(
                    "java -jar " + new File(MINECRAFLAUNCHERJSON_DIR, "/MinecraftLauncherJSON.jar") + " " + updateLink
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    /**
     * Download the launcher and it dependencies
     */
    public static void update() {
        System.out.println("[MinecraftLauncher-JSON] Getting the last version from github...");
        try (
                BufferedInputStream bis = new BufferedInputStream(new URL(
                        "https://github.com/Nathanael2611/MinecraftLauncher-JSON/raw/master/latest/MinecraftLauncherJSON.jar"
                ).openStream()
        );
             FileOutputStream fos = new FileOutputStream(
                     new File(MINECRAFLAUNCHERJSON_DIR, "MinecraftLauncherJSON.jar")
             )) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = bis.read(data, 0, 1024)) != -1) {
                fos.write(data, 0, byteContent);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Impossible de mettre à jour le launcher...");
            e.printStackTrace(System.out);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        progressBar.setBounds(8, getHeight() / 2 - progressBar.getHeight() / 2, getWidth() - 16, 30);
        g.setFont(new Font("sgsergseg", Font.PLAIN, 12));
        g.drawString("Powered by MinecraftLauncher.JSON", 1, getHeight()-3);
    }

    public static File getMinecraftLauncherJSONDir()
    {
        String name = "MinecraftLauncher-JSON";
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win"))
            return new File(System.getProperty("user.home") + "\\AppData\\Roaming\\." + name);
        else if (os.contains("mac"))
            return new File(System.getProperty("user.home") + "/Library/Application Support/" + name);
        else
            return new File(System.getProperty("user.home") + "/." + name);
    }

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
}