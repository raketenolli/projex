package de.oliver_arend.projex;

import javax.swing.ImageIcon;

public class StepListIcon extends ImageIcon {
	
	public StepListIcon(Step step) {
		super();
		
		int level = step.getLevel();
		boolean isCompleted = step.isCompleted();
		boolean hasParent = step.hasParent();
		boolean isParentCompleted = false;
		if(hasParent) { isParentCompleted = step.getParent().isCompleted(); }
		boolean hasPredecessor = step.hasPredecessor();
		boolean isPredecessorCompleted = false;
		if(hasPredecessor) { isPredecessorCompleted = step.getPredecessor().isCompleted(); }
		boolean hasSuccessor = step.hasSuccessor();
		boolean isSuccessorCompleted = false;
		if(hasSuccessor) { isSuccessorCompleted = step.getSuccessor().isCompleted(); }
		
		this.setImage(new StepListIconImage(level, isCompleted, hasParent, isParentCompleted, hasPredecessor, isPredecessorCompleted, hasSuccessor, isSuccessorCompleted).getImage());
	}

}
