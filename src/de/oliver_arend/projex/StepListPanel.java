package de.oliver_arend.projex;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class StepListPanel extends JPanel {

	public StepListPanel(List<Step> stepList) {
		super();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		stepList.forEach((step) -> {
			this.add(new StepLabel(step));
		});
	}
	
}
