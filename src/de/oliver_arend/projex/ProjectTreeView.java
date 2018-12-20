package de.oliver_arend.projex;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

public class ProjectTreeView extends JScrollPane {

	private ProjectTree projectTree;
	
	public ProjectTreeView() {
		super();
		projectTree = new ProjectTree();
		projectTree.update();
		this.setViewportView(projectTree.getTree());
		this.setBorder(BorderFactory.createTitledBorder("Project list"));
		this.setPreferredSize(new Dimension(200, 400));
	}
	
}
