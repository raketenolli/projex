package de.oliver_arend.projex;

import javax.swing.JLabel;

public class StepLabel extends JLabel {

	public StepLabel(Step step) {
		super(step.getDescription(), new StepListIcon(step), LEFT);
	}
	
}
