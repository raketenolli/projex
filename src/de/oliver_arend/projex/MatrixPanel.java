package de.oliver_arend.projex;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class MatrixPanel extends JPanel {
	
	private List<ProjectButton> projectButtonList = new ArrayList<ProjectButton>();

	public MatrixPanel() {
		super();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(400, 400));
		this.setBorder(BorderFactory.createTitledBorder("Project matrix"));

		ButtonGroup allProjects = new ButtonGroup();
		
		DataProvider.getProjectList().stream().forEach(project -> {
			ProjectButton projectButton = new ProjectButton(project); 
			projectButtonList.add(projectButton);
			allProjects.add(projectButton);
			this.add(projectButton);
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawLine(200, 380, 200, 20);
		g.drawLine(20, 200, 380, 200);
	}
	
}
