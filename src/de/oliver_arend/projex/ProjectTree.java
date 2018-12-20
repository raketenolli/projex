package de.oliver_arend.projex;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class ProjectTree {

	private JTree projectTree;
	private DefaultMutableTreeNode root;
	private DefaultMutableTreeNode currentProjects;
	private DefaultMutableTreeNode somedayProjects;
	private DefaultMutableTreeNode doneProjects;
	
	public ProjectTree() {
		this.root = new DefaultMutableTreeNode("Root");
		this.projectTree = new JTree(this.root);
		
		this.projectTree.setCellRenderer(new ProjectTreeNodeRenderer());
		
		this.currentProjects = new DefaultMutableTreeNode("Current projects");
		this.root.add(this.currentProjects);

		this.somedayProjects = new DefaultMutableTreeNode("Someday maybe");
		this.root.add(this.somedayProjects);
		
		this.doneProjects = new DefaultMutableTreeNode("Finished projects");
		this.root.add(this.doneProjects);
	}
	
	public JTree getTree() {
		return this.projectTree;
	}
	
	public void update() {
		for(Project project : DataProvider.getProjectList(Category.CURRENT)) {
			this.currentProjects.add(new ProjectTreeNode(project));
		}
		
		for(Project project : DataProvider.getProjectList(Category.SOMEDAYMAYBE)) {
			this.somedayProjects.add(new ProjectTreeNode(project));
		}
		
		for(Project project : DataProvider.getProjectList(Category.DONE)) {
			this.doneProjects.add(new ProjectTreeNode(project));
		}

		for (int i = 0; i < projectTree.getRowCount(); i++) {
			this.projectTree.expandRow(i);
		}		

		this.projectTree.setRootVisible(false);
		this.projectTree.setOpaque(false);
	}
	
}
