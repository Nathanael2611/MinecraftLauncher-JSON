/*
 * Copyright 2015-2016 Adrien "Litarvan" Navratil
 *
 * This file is part of the OpenLauncherLib.

 * The OpenLauncherLib is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The OpenLauncherLib is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the OpenLauncherLib.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.nathanael2611.minecraftlauncherjson.launch;

import java.lang.reflect.Field;

/**
 * The Java Util
 *
 * <p>
 *     Contains some useful things about the launching
 * </p>
 *
 * @author Litarvan
 * @version 3.0.4
 * @since 3.0.0-BETA
 */
public class JavaUtil
{
    /**
     * Return the special default VM arguments
     *
     * @return The special VM args
     */
    public static String[] getSpecialArgs()
    {
        return new String[]{"-XX:-UseAdaptiveSizePolicy", "-XX:+UseConcMarkSweepGC"};
    }

    /**
     * Create an argument for the mac dock name
     *
     * @param name The name to set
     *
     * @return The generated argument
     */
    public static String macDockName(String name)
    {
        return "-Xdock:name=" + name;
    }

    /**
     * Return the java executable path
     *
     * @return The java command
     */
    public static String getJavaCommand()
    {
        if(useCustomJRE){
            return custom_java_path;
        }
        if (System.getProperty("os.name").toLowerCase().contains("win"))
            return "\"" + System.getProperty("java.home") + "\\bin\\java" + "\"";

        return System.getProperty("java.home") + "/bin/java";
    }

    private static boolean useCustomJRE = false;
    private static String custom_java_path = "";
    public static void setCustomJRE(String path){
        custom_java_path = path;
        useCustomJRE = true;
    }

    /**
     * Manually set the Java Library Path
     *
     * @param path The new library path
     * @throws Exception If it failed
     */
    public static void setLibraryPath(String path) throws Exception
    {
        System.setProperty("java.library.path", path);

        Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
        fieldSysPath.setAccessible(true);
        fieldSysPath.set(null, null);
    }
}
