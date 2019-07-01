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
package fr.nathanael2611.minecraftlauncherjson.launch.internal;

import fr.nathanael2611.minecraftlauncherjson.launch.LaunchException;
import fr.nathanael2611.minecraftlauncherjson.launch.external.ExternalLauncher;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * The Internal Launcher
 *
 * <p>
 *     Launcher that directly add the jars to the current one, and then
 *     manually launch the needed class.
 *
 *     A lot faster than the external launching.
 * </p>
 *
 * @author Litarvan
 * @version 3.0.2-BETA
 * @since 3.0.0-BETA
 * @deprecated Use {@link ExternalLauncher} instead, this one isn't compatible with Java 9
 */
@Deprecated
public class InternalLauncher implements ClassInitializer
{
    /**
     * The launch profile (contains all the launch informations)
     *
     * @see InternalLauncher
     */
    private InternalLaunchProfile profile;

    /**
     * The class initializer (initialize the main class)
     *
     * @see ClassInitializer
     */
    private ClassInitializer initializer;

    /**
     * The Internal Launcher
     *
     * @param profile The launch profile (contains the launching informations)
     *
     * @see InternalLaunchProfile
     */
    public InternalLauncher(InternalLaunchProfile profile)
    {
        this(profile, null);
    }

    /**
     * The Internal Launcher
     *
     * @param profile     The launch profile (contains the launching informations)
     * @param initializer The Class Initializer (optional, initialize the main class)
     */
    public InternalLauncher(InternalLaunchProfile profile, ClassInitializer initializer)
    {
        this.profile = profile;
        this.initializer = initializer != null ? initializer : this;
    }

    /**
     * Launch !
     *
     * @return The object returned by the launched method
     *
     * @throws LaunchException If something failed
     */
    public Object launch() throws LaunchException
    {
        System.err.println("##########################################################");
        System.err.println("  WARNING : Internal Launching doesn't work with Java 9");
        System.err.println("  --> YOU SHOULD USE EXTERNAL LAUNCHING INSTEAD");
        System.err.println("##########################################################");

        long start = System.currentTimeMillis();

        if (profile.getClasspath() != null)
            for (File f : profile.getClasspath())
            {
                JarLoader.addToClasspath(f);
            }

        Class<?> theClass;
        try
        {
            theClass = ClassLoader.getSystemClassLoader().loadClass(profile.getTargetClass());
        }
        catch (Exception e)
        {

            return null;
        }


        Method[] methods;
        Method method = null;
        try
        {
            methods = theClass.getDeclaredMethods();
            for (Method m : methods)
                if (m.getName().equals(profile.getTargetMethod()) && Arrays.equals(m.getParameterTypes(), profile.getParametersTypes()))
                {
                    method = m;
                    break;
                }

            if (method == null)
                throw new UnknownMethodException(profile.getTargetMethod());
        }
        catch (Exception e)
        {
            throw e instanceof UnknownMethodException ? (UnknownMethodException) e : new UnknownMethodException(profile.getTargetMethod(), e);
        }


        Object initClass = null;
        if (!Modifier.isStatic(method.getModifiers()))
            try
            {
                initClass = initializer.init(theClass);
            }
            catch (Throwable t)
            {
                throw new LaunchException("Can't initialize the main class", t);
            }

        method.setAccessible(true);

        long totalTime = System.currentTimeMillis() - start;
        int seconds = (int) (totalTime / 1000) % 60;
        int minutes = (int) ((totalTime / (1000 * 60)) % 60);
        int hours = (int) ((totalTime / (1000 * 60 * 60)) % 24);
        String strTime = hours + " hours " + minutes + " minutes " + seconds + " seconds and " + totalTime % 1000 + " milliseconds.";

        try
        {
            return method.invoke(initClass, profile.getParameters());
        }
        catch (InvocationTargetException e)
        {
            Throwable thrown = e.getTargetException();
            if (thrown instanceof ExceptionInInitializerError)
            {
                ExceptionInInitializerError initError = (ExceptionInInitializerError) thrown;
                thrown = initError.getException();
            }
            throw new LaunchException("Invoked method returned an exception", thrown);
        }
        catch (IllegalAccessException e)
        {
            throw new LaunchException("This is not supposed to happen", e);
        }
    }

    /**
     * Return the given launch profile (contains all the launching informations)
     *
     * @return The launch profile
     *
     * @see InternalLaunchProfile
     */
    public InternalLaunchProfile getProfile()
    {
        return profile;
    }

    /**
     * Set the launch profile (contains all the launching informations)
     *
     * @param profile The new launch profile
     *
     * @see InternalLaunchProfile
     */
    public void setProfile(InternalLaunchProfile profile)
    {
        this.profile = profile;
    }

    /**
     * Return the given class initializer (can be null)
     *
     * @return The class initializer
     *
     * @see InternalLaunchProfile
     */
    public ClassInitializer getInitializer()
    {
        return initializer;
    }

    /**
     * Set the class initializer (can be null, initialize the main class)
     *
     * @param initializer The new initializer
     *
     * @see ClassInitializer
     */
    public void setInitializer(ClassInitializer initializer)
    {
        this.initializer = initializer;
    }

    @Override
    public Object init(Class<?> toInit) throws IllegalAccessException, InstantiationException
    {
        return toInit.newInstance();
    }
}
