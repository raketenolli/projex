package de.oliver_arend.projex;

import javax.swing.JLabel;

public class StepLabel extends JLabel {

	public StepLabel(ParsedStep step) {
		super(step.getStep().getDescription(), new StepListIcon(step), LEFT);
		this.setComponentPopupMenu(new StepContextMenu(step));
		this.setBorder(null);
	}
	
}
