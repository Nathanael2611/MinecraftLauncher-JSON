package fr.nathanael2611.minecraftlauncherjson;

import fr.nathanael2611.minecraftlauncherjson.launch.minecraft.GameType;
import fr.nathanael2611.minecraftlauncherjson.launch.minecraft.GameVersion;

/**
 * Used for manage different parts of the launcher config
 */
public class ConfigManager {
    public static GameVersion parseGameVersion(String version) {
        if (version.equalsIgnoreCase("1.7.10")) {
            return new GameVersion(version, GameType.V1_7_10);
        } else {
            return new GameVersion(version, GameType.V1_8_HIGHER);
        }
    }
}
