package de.oliver_arend.projex;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class StepListIconImage {

	private BufferedImage image;
	private final int iconHeight = 24;
    private final Color incompleteColor = new Color(192, 192, 192);
    private final Color completeColor = new Color(0, 112, 192);
	
    private void setRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }

	public StepListIconImage(
			int level, 
			boolean isCompleted,
			boolean hasParent, 
			boolean isParentCompleted, 
			boolean hasPredecessor, 
			boolean isPredecessorCompleted, 
			boolean hasSuccessor, 
			boolean isSuccessorCompleted) {
		image = new BufferedImage(this.iconHeight * (level + 1), this.iconHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        setRenderingHints(g2d);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        drawParent(g2d, level, hasParent, isParentCompleted, hasPredecessor);
        drawPredecessor(g2d, level, hasPredecessor, isCompleted);
        drawSuccessor(g2d, level, hasSuccessor, isSuccessorCompleted);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        drawStep(g2d, level, isCompleted);
	}
	
	private void drawParent(Graphics2D g2d, int level, boolean hasParent, boolean isParentCompleted, boolean hasPredecessor) {
		if(hasParent && !hasPredecessor) {
			g2d.setColor(drawColor(isParentCompleted));
			g2d.drawLine(this.iconHeight*level, 0, this.iconHeight*level+this.iconHeight/2, this.iconHeight/2);
		}
	}
	
	private void drawPredecessor(Graphics2D g2d, int level, boolean hasPredecessor, boolean isCompleted) {
		if(hasPredecessor) {
			g2d.setColor(drawColor(isCompleted));
			g2d.drawLine(this.iconHeight*level+this.iconHeight/2, 0, this.iconHeight*level+this.iconHeight/2, this.iconHeight/2);
		}
	}
	
	private void drawSuccessor(Graphics2D g2d, int level, boolean hasSuccessor, boolean isSuccessorCompleted) {
		if(hasSuccessor) {
			g2d.setColor(drawColor(isSuccessorCompleted));
			g2d.drawLine(this.iconHeight*level+this.iconHeight/2, this.iconHeight/2, this.iconHeight*level+this.iconHeight/2, this.iconHeight);
		}
	}
	
	private void drawStep(Graphics2D g2d, int level, boolean isCompleted) {
		g2d.setColor(drawColor(isCompleted));
		g2d.fillOval(this.iconHeight*level+this.iconHeight/4, this.iconHeight/4, this.iconHeight/2, this.iconHeight/2);
	}
	
	private Color drawColor(boolean complete) {
		if(complete) { return completeColor; }
		else { return incompleteColor; }
	}
	
    public BufferedImage getImage() {
		return this.image;
	}
	
}
