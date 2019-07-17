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
package fr.nathanael2611.minecraftlauncherjson.launch.util.ramselector;

import javax.swing.*;

/**
 * The Abstract Option Frame
 *
 * <p>
 * The base class to use with the Ram Selector to select RAM.
 * </p>
 *
 * @author Litarvan
 * @version 3.0.2-BETA
 * @since 3.0.0-BETA
 */
public abstract class AbstractOptionFrame extends JFrame {
    /**
     * The current RAM Selector
     */
    private RamSelector selector;

    /**
     * The Abstract Option Frame
     *
     * @param selector The current RAM Selector
     */
    public AbstractOptionFrame(RamSelector selector) {
        this.selector = selector;
    }

    /**
     * Return the current RAM Selector
     *
     * @return The current RAM selector
     */
    public RamSelector getSelector() {
        return selector;
    }

    /**
     * Return the selected RAM (as index of RamSelector.RAM_ARRAY)
     *
     * @return The selected RAM index
     * @see #setSelectedIndex(int)
     */
    public abstract int getSelectedIndex();

    /**
     * Set the selected RAM (as index of RamSelector.RAM_ARRAY)
     *
     * @param index The selected RAM index
     * @see #getSelectedIndex()
     */
    public abstract void setSelectedIndex(int index);
}
