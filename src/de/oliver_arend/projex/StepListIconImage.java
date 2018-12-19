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
			StepState state,
			boolean hasParent, 
			StepState parentState,
			boolean hasChild,
			StepState childState,
			boolean hasPredecessor, 
			StepState predecessorState, 
			boolean hasSuccessor, 
			StepState successorState) {
		image = new BufferedImage(this.iconHeight * (level + 1) + 2, this.iconHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        setRenderingHints(g2d);
        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        drawParent(g2d, level, hasParent, parentState, hasPredecessor);
        drawChild(g2d, level, hasChild, childState);
        drawPredecessor(g2d, level, state, hasPredecessor, predecessorState);
        drawSuccessor(g2d, level, hasSuccessor, successorState);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        drawStep(g2d, level, state);
	}
	
	private void drawParent(Graphics2D g2d, int level, boolean hasParent, StepState parentState, boolean hasPredecessor) {
		if(hasParent && !hasPredecessor) {
			g2d.setColor(drawColor(parentState));
			g2d.drawLine(this.iconHeight*level, 0, this.iconHeight*level+this.iconHeight/2, this.iconHeight/2);
		}
	}
	
	private void drawChild(Graphics2D g2d, int level, boolean hasChild, StepState childState) {
		if(hasChild) {
			g2d.setColor(drawColor(childState));
			g2d.drawLine(this.iconHeight*level+this.iconHeight/2, this.iconHeight/2, this.iconHeight*(level+1), this.iconHeight);
		}
	}
	
	private void drawPredecessor(Graphics2D g2d, int level, StepState state, boolean hasPredecessor, StepState predecessorState) {
		if(hasPredecessor) {
			g2d.setColor(drawColor(StepState.atLeastOneNew(state, predecessorState)));
			g2d.drawLine(this.iconHeight*level+this.iconHeight/2, 0, this.iconHeight*level+this.iconHeight/2, this.iconHeight/2);
		}
	}
	
	private void drawSuccessor(Graphics2D g2d, int level, boolean hasSuccessor, StepState successorState) {
		if(hasSuccessor) {
			g2d.setColor(drawColor(successorState));
			g2d.drawLine(this.iconHeight*level+this.iconHeight/2, this.iconHeight/2, this.iconHeight*level+this.iconHeight/2, this.iconHeight);
		}
	}
	
	private void drawStep(Graphics2D g2d, int level, StepState state) {
		if(state == StepState.NEW || state == StepState.COMPLETED) {
			g2d.setColor(drawColor(state));
			g2d.fillOval(this.iconHeight*level+this.iconHeight/4, this.iconHeight/4, this.iconHeight/2, this.iconHeight/2);
		} else {
			g2d.setColor(incompleteColor);
			g2d.fillOval(this.iconHeight*level+this.iconHeight/4, this.iconHeight/4, this.iconHeight/2, this.iconHeight/2);
			g2d.setColor(completeColor);
			g2d.drawOval(this.iconHeight*level+this.iconHeight/4, this.iconHeight/4, this.iconHeight/2, this.iconHeight/2);
		}
	}
	
	private Color drawColor(StepState state) {
		if(state != StepState.NEW) { return completeColor; }
		else { return incompleteColor; }
	}
	
    public BufferedImage getImage() {
		return this.image;
	}
	
}
