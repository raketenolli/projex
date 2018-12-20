package de.oliver_arend.projex;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

public class StepListPanelScroller extends JScrollPane {
	
	private ParsedStepList parsedStepList;
    private StepListPanel stepListPanel;
	
    public StepListPanelScroller() {
    	super();
    	parsedStepList = new ParsedStepList(DataProvider.getStepList());
    	stepListPanel = new StepListPanel(parsedStepList);
    	this.setViewportView(stepListPanel);
    	this.setBorder(BorderFactory.createTitledBorder("Project implementation steps"));
    	this.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);
    	this.setPreferredSize(new Dimension(400, 400));
    }
    
}
