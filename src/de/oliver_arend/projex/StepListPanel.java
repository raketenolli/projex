package de.oliver_arend.projex;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class StepListPanel extends JPanel {

	public StepListPanel(ParsedStepList stepList) {
		super();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(null);
		this.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		this.setComponentPopupMenu(new StepListContextMenu());
		
		stepList.stream().forEach((step) -> {
			this.add(new StepLabel(step));
		});
	}

}
