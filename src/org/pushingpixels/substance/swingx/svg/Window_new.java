package org.pushingpixels.substance.swingx.svg;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.Icon;
import javax.swing.plaf.UIResource;

import org.pushingpixels.substance.internal.hidpi.IsHiDpiAware;
import org.pushingpixels.substance.internal.hidpi.IsResizable;

/**
 * This class has been automatically generated using <a
 * href="https://flamingo.dev.java.net">Flamingo SVG transcoder</a>.
 */
public class Window_new implements Icon, UIResource, IsResizable, IsHiDpiAware {
	/**
	 * Paints the transcoded SVG image on the specified graphics context. You
	 * can install a custom transformation on the graphics context to scale the
	 * image.
	 * 
	 * @param g
	 *            Graphics context.
	 */
	public static void paint(Graphics2D g) {
        Shape shape = null;
        Paint paint = null;
        Stroke stroke = null;
         
        float origAlpha = 1.0f;
        Composite origComposite = ((Graphics2D)g).getComposite();
        if (origComposite instanceof AlphaComposite) {
            AlphaComposite origAlphaComposite = 
                (AlphaComposite)origComposite;
            if (origAlphaComposite.getRule() == AlphaComposite.SRC_OVER) {
                origAlpha = origAlphaComposite.getAlpha();
            }
        }
        
	    AffineTransform defaultTransform_ = g.getTransform();
// 
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0
g.setComposite(AlphaComposite.getInstance(3, 0.56725144f * origAlpha));
AffineTransform defaultTransform__0_0 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_0
paint = new RadialGradientPaint(new Point2D.Double(17.368310928344727, 25.681941986083984), 11.799845f, new Point2D.Double(17.368310928344727, 25.681941986083984), new float[] {0.0f,1.0f}, new Color[] {new Color(0, 0, 0, 255),new Color(0, 0, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(1.9457340240478516f, 0.0f, 0.0f, 0.6272739768028259f, -9.62845516204834f, 24.25921058654785f));
shape = new GeneralPath();
((GeneralPath)shape).moveTo(47.12502, 40.368813);
((GeneralPath)shape).curveTo(47.12667, 44.457054, 36.846928, 47.77151, 24.165659, 47.77151);
((GeneralPath)shape).curveTo(11.484387, 47.77151, 1.2046481, 44.457054, 1.206299, 40.368813);
((GeneralPath)shape).curveTo(1.2046481, 36.28057, 11.484387, 32.966114, 24.165659, 32.966114);
((GeneralPath)shape).curveTo(36.846928, 32.966114, 47.12667, 36.28057, 47.12502, 40.368813);
((GeneralPath)shape).lineTo(47.12502, 40.368813);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_0);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_1 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_1
paint = new LinearGradientPaint(new Point2D.Double(17.880680084228516, 11.072587966918945), new Point2D.Double(17.880680084228516, 21.767578125), new float[] {0.0f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(224, 224, 224, 255)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.797614097595215f, 0.0f, 0.0f, 2.5816709995269775f, -13.889039993286133f, -17.13620948791504f));
shape = new RoundRectangle2D.Double(1.497833013534546, 3.496351480484009, 45.00431442260742, 41.00729751586914, 2.2123091220855713, 2.2123100757598877);
g.setPaint(paint);
g.fill(shape);
paint = new Color(141, 141, 141, 255);
stroke = new BasicStroke(1.0000004f,0,0,4.0f,null,0.0f);
shape = new RoundRectangle2D.Double(1.497833013534546, 3.496351480484009, 45.00431442260742, 41.00729751586914, 2.2123091220855713, 2.2123100757598877);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_1);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_2 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_2
paint = new LinearGradientPaint(new Point2D.Double(13.267746925354004, 7.7190704345703125), new Point2D.Double(13.267746925354004, 12.48076057434082), new float[] {0.0f,1.0f}, new Color[] {new Color(32, 74, 135, 255),new Color(32, 74, 135, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(2.930757999420166f, 0.0f, 0.0f, 2.7985050678253174f, -14.884559631347656f, -18.229450225830078f));
shape = new RoundRectangle2D.Double(3.0, 5.0, 42.0, 7.0, 0.4445417821407318, 0.44454169273376465);
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_2);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_3 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_3
paint = new Color(255, 255, 255, 122);
stroke = new BasicStroke(1.000001f,0,0,4.0f,null,0.0f);
shape = new RoundRectangle2D.Double(2.5085136890411377, 4.507357597351074, 42.97444534301758, 38.97792434692383, 0.8081382513046265, 0.7123106718063354);
g.setPaint(paint);
g.setStroke(stroke);
g.draw(shape);
g.setTransform(defaultTransform__0_3);
g.setComposite(AlphaComposite.getInstance(3, 1.0f * origAlpha));
AffineTransform defaultTransform__0_4 = g.getTransform();
g.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f));
// _0_4
paint = new RadialGradientPaint(new Point2D.Double(55.0, 125.0), 14.375f, new Point2D.Double(55.0, 125.0), new float[] {0.0f,0.5f,1.0f}, new Color[] {new Color(255, 255, 255, 255),new Color(255, 245, 32, 227),new Color(255, 243, 0, 0)}, MultipleGradientPaint.CycleMethod.NO_CYCLE, MultipleGradientPaint.ColorSpaceType.SRGB, new AffineTransform(0.6260870099067688f, 0.0f, 0.0f, 0.6372050046920776f, 4.565217971801758f, -70.8104476928711f));
shape = new GeneralPath();
((GeneralPath)shape).moveTo(48.000004, 8.840175);
((GeneralPath)shape).curveTo(48.000004, 13.899003, 43.970566, 17.999996, 39.000004, 17.999996);
((GeneralPath)shape).curveTo(34.02944, 17.999996, 30.000002, 13.899003, 30.000002, 8.840175);
((GeneralPath)shape).curveTo(30.000002, 3.7813473, 34.02944, -0.31964687, 39.000004, -0.31964687);
((GeneralPath)shape).curveTo(43.970566, -0.31964687, 48.000004, 3.7813473, 48.000004, 8.840175);
((GeneralPath)shape).lineTo(48.000004, 8.840175);
((GeneralPath)shape).closePath();
g.setPaint(paint);
g.fill(shape);
g.setTransform(defaultTransform__0_4);
g.setTransform(defaultTransform__0);
g.setTransform(defaultTransform_);

	}

    /**
     * Returns the X of the bounding box of the original SVG image.
     * 
     * @return The X of the bounding box of the original SVG image.
     */
    public static int getOrigX() {
        return 1;
    }

    /**
     * Returns the Y of the bounding box of the original SVG image.
     * 
     * @return The Y of the bounding box of the original SVG image.
     */
    public static int getOrigY() {
        return 0;
    }

	/**
	 * Returns the width of the bounding box of the original SVG image.
	 * 
	 * @return The width of the bounding box of the original SVG image.
	 */
	public static int getOrigWidth() {
		return 48;
	}

	/**
	 * Returns the height of the bounding box of the original SVG image.
	 * 
	 * @return The height of the bounding box of the original SVG image.
	 */
	public static int getOrigHeight() {
		return 48;
	}

	/**
	 * The current width of this resizable icon.
	 */
	int width;

	/**
	 * The current height of this resizable icon.
	 */
	int height;

	/**
	 * Creates a new transcoded SVG image.
	 */
	public Window_new() {
        this.width = getOrigWidth();
        this.height = getOrigHeight();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.Icon#getIconHeight()
	 */
    @Override
	public int getIconHeight() {
		return height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.Icon#getIconWidth()
	 */
    @Override
	public int getIconWidth() {
		return width;
	}

	@Override
    public void setDimension(Dimension newDimension) {
        this.width = newDimension.width;
        this.height = newDimension.height;
    }
    
    @Override
    public boolean isHiDpiAware() {
        return true;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics,
	 * int, int)
	 */
    @Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.translate(x, y);

		double coef1 = (double) this.width / (double) getOrigWidth();
		double coef2 = (double) this.height / (double) getOrigHeight();
		double coef = Math.min(coef1, coef2);
        g2d.clipRect(0, 0, this.width, this.height);
		g2d.scale(coef, coef);
		paint(g2d);
		g2d.dispose();
	}
}

