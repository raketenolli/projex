package de.oliver_arend.projex;

import javax.swing.ImageIcon;

public class StepListIcon extends ImageIcon {
	
	public StepListIcon(Step step) {
		super();
		
		int level = step.getLevel();
		StepState state = step.getState();
		boolean hasParent = step.hasParent();
		StepState parentState = StepState.NEW;
		if(hasParent) { parentState = step.getParent().getState(); }
		boolean hasChild = step.hasChild();
		StepState childState = StepState.NEW;
		if(hasChild) { childState = step.getChild().getState(); }
		boolean hasPredecessor = step.hasPredecessor();
		StepState predecessorState = StepState.NEW;
		if(hasPredecessor) { predecessorState = step.getPredecessor().getState(); }
		boolean hasSuccessor = step.hasSuccessor();
		StepState successorState = StepState.NEW;
		if(hasSuccessor) { successorState = step.getSuccessor().getState(); }
		
		this.setImage(new StepListIconImage(level, state, hasParent, parentState, hasChild, childState, hasPredecessor, predecessorState, hasSuccessor, successorState).getImage());
	}

}
