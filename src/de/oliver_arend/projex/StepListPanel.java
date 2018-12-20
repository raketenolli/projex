package de.oliver_arend.projex;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class StepListPanel extends JPanel {

	public StepListPanel(ParsedStepList stepList) {
		super();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		stepList.stream().forEach((step) -> {
			this.add(new StepLabel(step));
		});
	}
	
}
