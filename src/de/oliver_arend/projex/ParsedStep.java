package de.oliver_arend.projex;

import java.util.List;

public class ParsedStep {

	private Step step;
	private int level;
	private boolean parent;
	private boolean child;
	private boolean predecessor;
	private boolean successor;
	private boolean parentSuccessor;
	private boolean predecessorChild;
	private List<Integer> bypasses;
	
	public ParsedStep(Step step, int level) {
		this.step = step;
		this.level = level;
	}

	public Step getStep() {
		return step;
	}

	public void setStep(Step step) {
		this.step = step;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean hasParent() {
		return parent;
	}

	public void setHasParent(boolean parent) {
		this.parent = parent;
	}

	public boolean hasChild() {
		return child;
	}

	public void setHasChild(boolean child) {
		this.child = child;
	}

	public boolean hasPredecessor() {
		return predecessor;
	}

	public void setHasPredecessor(boolean predecessor) {
		this.predecessor = predecessor;
	}

	public boolean hasSuccessor() {
		return successor;
	}

	public void setHasSuccessor(boolean successor) {
		this.successor = successor;
	}

	public boolean hasParentSuccessor() {
		return parentSuccessor;
	}

	public void setHasParentSuccessor(boolean parentSuccessor) {
		this.parentSuccessor = parentSuccessor;
	}

	public boolean hasPredecessorChild() {
		return predecessorChild;
	}

	public void setHasPredecessorChild(boolean predecessorChild) {
		this.predecessorChild = predecessorChild;
	}

	public List<Integer> getBypasses() {
		return bypasses;
	}

	public void setBypasses(List<Integer> bypasses) {
		this.bypasses = bypasses;
	}
	
}