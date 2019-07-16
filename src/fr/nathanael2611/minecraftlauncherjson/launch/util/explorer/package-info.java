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

/**
 * The Explorer API
 *
 * <p>
 * Powerful API to manipulate the file easier and faster than usual.
 * </p>
 * <p>
 * Code example : Getting the jars in a given directory
 * <p>
 * Without the API :
 *
 * <pre>{@code
 *     List<File> finalFiles = new ArrayList<File>();
 *
 *     File directory = new File("directory");
 *     if (!directory.exists() || !directory.isDirectory())
 *         throw new Exception("D:");
 *
 *     File[] files = directory.listFiles();
 *     if (files == null)
 *         throw new Exception("Empty directory !");
 *
 *     for (File f : files)
 *        if (f.getName().endsWith(".jar") && !f.isDirectory())
 *            finalFiles.add(f);
 *
 *     // Working, but not recursively :/
 * }</pre>
 * <p>
 * With the API :
 *
 * <pre>{@code
 *     List<File> finalFiles = Explorer.dir("directory").allRecursive().files().match("^(.*\.((jar)$))*$").get();
 *     // And this is recursive ! It also drop a FailException (extends RuntimeException) if something failed !
 * }</pre>
 *
 * @author Litarvan
 * @version 3.0.2-BETA
 * @see fr.nathanael2611.minecraftlauncherjson.launch.FailException
 * @since 3.0.0-BETA
 */
package fr.nathanael2611.minecraftlauncherjson.launch.util.explorer;