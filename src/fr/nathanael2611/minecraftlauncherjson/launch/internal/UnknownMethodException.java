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

/**
 * The Unknown Method Exception
 *
 * <p>
 * Thrown when the given target method is not found
 * </p>
 *
 * @author Litarvan
 * @version 3.0.2-BETA
 * @since 3.0.0-BETA
 * @deprecated
 */
@Deprecated
public class UnknownMethodException extends LaunchException {
    /**
     * The Unknown method exception
     *
     * @param message The message
     */
    public UnknownMethodException(String message) {
        super(message);
    }

    /**
     * The Unknown method exception
     *
     * @param message The message
     * @param t       The cause
     */
    public UnknownMethodException(String message, Throwable t) {
        super(message, t);
    }
}
