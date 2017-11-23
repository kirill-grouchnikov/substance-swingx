/*
 * Copyright 2005-2016 Kirill Grouchnikov, based on work by
 * Sun Microsystems, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.pushingpixels.substance.swingx;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;

import org.jdesktop.swingx.JXHeader;
import org.jdesktop.swingx.JXTipOfTheDay;
import org.jdesktop.swingx.plaf.UIManagerExt;
import org.jdesktop.swingx.plaf.basic.BasicTipOfTheDayUI;
import org.pushingpixels.substance.api.SubstanceSlices.AnimationFacet;
import org.pushingpixels.substance.api.SubstanceSlices.DecorationAreaType;
import org.pushingpixels.substance.api.SubstanceCortex;
import org.pushingpixels.substance.internal.AnimationConfigurationManager;
import org.pushingpixels.substance.internal.animation.IconGlowTracker;
import org.pushingpixels.substance.internal.utils.SubstanceCoreUtilities;
import org.pushingpixels.substance.internal.utils.icon.GlowingIcon;
import org.pushingpixels.substance.swingx.svg.Dialog_information;

/**
 * Substance-consistent UI delegate for {@link JXTipOfTheDay}.
 * 
 * @author Kirill Grouchnikov
 */
public class SubstanceTipOfTheDayUI extends BasicTipOfTheDayUI {
    static {
        AnimationConfigurationManager.getInstance().allowAnimations(AnimationFacet.ICON_GLOW,
                JXTipOfTheDay.class);
    }

    protected IconGlowTracker iconGlowTracker;

    public static ComponentUI createUI(JComponent comp) {
        SubstanceCoreUtilities.testComponentCreationThreadingViolation(comp);
        return new SubstanceTipOfTheDayUI((JXTipOfTheDay) comp);
    }

    /**
     * Creates a new UI delegate.
     * 
     * @param tip
     *            Tip component.
     */
    public SubstanceTipOfTheDayUI(JXTipOfTheDay tip) {
        super(tip);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jdesktop.swingx.plaf.basic.BasicTipOfTheDayUI#installComponents()
     */
    @Override
    protected void installComponents() {
        tipPane.setLayout(new BorderLayout());

        // tip area
        JPanel mainPane = new JPanel(new BorderLayout());
        JXHeader didYouKnow = new JXHeader();
        didYouKnow.setTitle(
                UIManagerExt.getString("TipOfTheDay.didYouKnowText", tipPane.getLocale()));
        SubstanceCortex.ComponentScope.setDecorationType(didYouKnow, DecorationAreaType.GENERAL);

        Dialog_information origIcon = new Dialog_information();
        origIcon.setDimension(new Dimension(22, 22));
        Icon infoIcon = SubstanceCoreUtilities.shouldUseThemedIconsOnOptionPanes() ? origIcon
                : SubstanceCoreUtilities.getThemedIcon(this.tipPane, origIcon);

        this.iconGlowTracker = new IconGlowTracker(didYouKnow);
        GlowingIcon glowingIcon = new GlowingIcon(infoIcon, this.iconGlowTracker);
        didYouKnow.setIcon(glowingIcon);
        didYouKnow.setDescription("");

        didYouKnow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                iconGlowTracker.play();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                iconGlowTracker.cancel();
            }
        });

        mainPane.add("North", didYouKnow);

        tipArea = new JPanel(new BorderLayout());
        tipArea.setOpaque(false);
        tipArea.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        tipArea.setBackground(UIManager.getColor("TextArea.background"));
        mainPane.add("Center", tipArea);

        tipPane.add("Center", mainPane);
    }
}
