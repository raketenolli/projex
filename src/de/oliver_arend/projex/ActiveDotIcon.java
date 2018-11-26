package de.oliver_arend.projex;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class ActiveDotIcon extends DotIcon {
	
	Color contrast;

	public ActiveDotIcon(int r, int g, int b) {
		super(r, g, b);
		double Y = 0.299 * r + 0.587 * g + 0.114 * b;
		if(Y > 128.0) { contrast = Color.BLACK; }
		else { contrast = Color.WHITE; }
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y) {
		super.paintIcon(c, g, x, y);
		g.setColor(contrast);
		g.fillOval(x+2, y+2, super.getIconHeight()-4, super.getIconWidth()-4);
	}
	
}
