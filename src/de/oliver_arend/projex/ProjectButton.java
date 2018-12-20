package de.oliver_arend.projex;

import javax.swing.JRadioButton;

public class ProjectButton extends JRadioButton {

	public ProjectButton(Project project) {
		super();
		this.setToolTipText(project.getTitle());
		this.setSize(this.getPreferredSize());
		this.setLocation(200 + (int) (200 * project.getUrgency()), 200 - (int) (200 * project.getImportance()));
		this.setOpaque(false);
		this.setIcon(new DotIcon(192, 192, 192));
		this.setSelectedIcon(new ActiveDotIcon(192, 192, 192));
		this.addMouseListener(new DragListener());
		this.addMouseMotionListener(new DragListener());
	}
	
}
