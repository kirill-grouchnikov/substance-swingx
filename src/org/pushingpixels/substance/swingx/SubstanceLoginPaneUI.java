/*
 * Copyright 2005-2010 Kirill Grouchnikov, based on work by
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

import java.awt.*;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;

import org.jdesktop.swingx.JXLoginPane;
import org.jdesktop.swingx.plaf.basic.BasicLoginPaneUI;
import org.pushingpixels.lafwidget.utils.RenderingUtils;
import org.pushingpixels.substance.api.DecorationAreaType;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.internal.painter.BackgroundPaintingUtils;
import org.pushingpixels.substance.internal.painter.DecorationPainterUtils;
import org.pushingpixels.substance.internal.utils.SubstanceColorUtilities;
import org.pushingpixels.substance.internal.utils.SubstanceCoreUtilities;

/**
 * Substance-consistent UI delegate for {@link JXLoginPane}.
 * 
 * @author Kirill Grouchnikov
 */
public class SubstanceLoginPaneUI extends BasicLoginPaneUI {
	protected JXLoginPane loginPanel;

	protected HierarchyListener substanceHierarchyListener;

	// protected ComponentListener substanceComponentListener;

	public static ComponentUI createUI(JComponent comp) {
		SubstanceCoreUtilities.testComponentCreationThreadingViolation(comp);
		return new SubstanceLoginPaneUI((JXLoginPane) comp);
	}

	/**
	 * Creates a new UI component.
	 * 
	 * @param dlg
	 *            Login panel component.
	 */
	public SubstanceLoginPaneUI(JXLoginPane dlg) {
		super(dlg);
		this.loginPanel = dlg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.plaf.ComponentUI#installUI(javax.swing.JComponent)
	 */
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		this.substanceHierarchyListener = new HierarchyListener() {
			public void hierarchyChanged(HierarchyEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						Window window = SwingUtilities
								.getWindowAncestor(loginPanel);
						if (window != null) {
							JComponent titlePane = SubstanceLookAndFeel
									.getTitlePaneComponent(window);
							if (titlePane != null) {
								titlePane.putClientProperty(
										SubstanceLookAndFeel.WATERMARK_VISIBLE,
										Boolean.FALSE);
							}
						}

						loginPanel.setBanner(getBanner());
					}
				});
			}
		};
		this.loginPanel.addHierarchyListener(this.substanceHierarchyListener);
		// this.substanceComponentListener = new ComponentAdapter() {
		// @Override
		// public void componentShown(ComponentEvent e) {
		// SwingUtilities.invokeLater(new Runnable() {
		// public void run() {
		// System.out.println("Recomputed");
		// loginPanel.setImage(getBanner());
		// }
		// });
		// }
		// };
		// this.loginPanel.addComponentListener(this.substanceComponentListener)
		// ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.plaf.ComponentUI#uninstallUI(javax.swing.JComponent)
	 */
	@Override
	public void uninstallUI(JComponent c) {
		this.loginPanel
				.removeHierarchyListener(this.substanceHierarchyListener);
		this.substanceHierarchyListener = null;
		// this.loginPanel.removeComponentListener(this.
		// substanceComponentListener);
		// this.substanceComponentListener = null;
		super.uninstallUI(c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jdesktop.swingx.plaf.basic.BasicLoginPanelUI#getBanner()
	 */
	@Override
	public Image getBanner() {
		Image superResult = super.getBanner();
		if (this.loginPanel.getParent() == null)
			return superResult;

		int width = superResult.getWidth(null);
		int height = superResult.getHeight(null);
		BufferedImage result = SubstanceCoreUtilities.getBlankImage(width,
				height);
		Graphics2D graphics = (Graphics2D) result.getGraphics();

		Icon origIcon = SubstanceCoreUtilities
				.getIcon("resource/32/login-new32.png");
		origIcon = SubstanceCoreUtilities.getThemedIcon(this.loginPanel,
				origIcon);

		SubstanceLookAndFeel.setDecorationType(this.loginPanel,
				DecorationAreaType.HEADER);
		BackgroundPaintingUtils.update(graphics, this.loginPanel, true);
		DecorationPainterUtils.clearDecorationType(this.loginPanel);

		float loginStringX = origIcon.getIconWidth() + 8 + width * .05f;
		float loginStringY = height * .75f;

		Font font = UIManager.getFont("JXLoginPane.bannerFont");
		graphics.setFont(font);
		Graphics2D originalGraphics = graphics;
		if (!loginPanel.getComponentOrientation().isLeftToRight()) {
			originalGraphics = (Graphics2D) graphics.create();
			graphics.scale(-1, 1);
			graphics.translate(-width, 0);
			loginStringX = width
					- origIcon.getIconWidth()
					- 8
					- (((float) font.getStringBounds(
							loginPanel.getBannerText(),
							originalGraphics.getFontRenderContext()).getWidth()) + width * .05f);
		}

		RenderingUtils.installDesktopHints(graphics, this.loginPanel);

		originalGraphics.setColor(SubstanceColorUtilities
				.getForegroundColor(SubstanceCoreUtilities.getSkin(
						this.loginPanel).getEnabledColorScheme(
						DecorationAreaType.HEADER)));
		originalGraphics.drawString(loginPanel.getBannerText(), loginStringX,
				loginStringY);

		int iconY = (height - origIcon.getIconHeight()) / 2;
		if (!loginPanel.getComponentOrientation().isLeftToRight()) {
			origIcon.paintIcon(loginPanel, graphics, width
					- origIcon.getIconWidth() - 8, iconY);
		} else {
			origIcon.paintIcon(loginPanel, graphics, 8, iconY);
		}
		return result;
	}
}
