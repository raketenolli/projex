package de.oliver_arend.projex;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

class StepListContextMenuListener implements PopupMenuListener {
	public void popupMenuCanceled(PopupMenuEvent popupMenuEvent) {
    }

	public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent) {
	}

	public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent) {
	}
}

public class StepListContextMenu extends JPopupMenu {

	private JMenuItem newStep;

	public StepListContextMenu() {
		this.newStep = new JMenuItem("New step");
		this.add(newStep);
		this.addPopupMenuListener(new StepListContextMenuListener());
	}
	
}
