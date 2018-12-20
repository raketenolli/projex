package de.oliver_arend.projex;

import javax.swing.tree.DefaultMutableTreeNode;

public class ProjectTreeNode extends DefaultMutableTreeNode {

	private Project project;
	
	public ProjectTreeNode(Project project) {
		super(project.getTitle());
		this.project = project;
	}
	
	public Project getProject() {
		return this.project;
	}
	
}
