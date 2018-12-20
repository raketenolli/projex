package de.oliver_arend.projex;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

class StepContextMenuListener implements PopupMenuListener {
	public void popupMenuCanceled(PopupMenuEvent popupMenuEvent) {
    }

	public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent) {
	}

	public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent) {
	}
}

public class StepContextMenu extends JPopupMenu {

	private ParsedStep step;
	private JMenuItem addSuccessor;
	private JMenuItem addPredecessor;
	private JMenuItem addChild;
	private JMenuItem deleteStep;
	private JMenuItem toggleStepState;

	public StepContextMenu(ParsedStep step) {
		this.step = step;
		this.addPredecessor = new JMenuItem("Add predecessor");
		this.addSuccessor = new JMenuItem("Add successor");
		this.addChild = new JMenuItem("Add child");
		this.deleteStep = new JMenuItem("Delete step");
		this.toggleStepState = new JMenuItem("Toggle step state");
		if(step.hasChild()) {
			deleteStep.setEnabled(false);
			toggleStepState.setEnabled(false);
		}
		this.add(addPredecessor);
		this.add(addSuccessor);
		this.add(addChild);
		this.add(deleteStep);
		this.add(toggleStepState);
		this.addPopupMenuListener(new StepContextMenuListener());
	}
	
}
