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

	public boolean isParent() {
		return parent;
	}

	public void setParent(boolean parent) {
		this.parent = parent;
	}

	public boolean isChild() {
		return child;
	}

	public void setChild(boolean child) {
		this.child = child;
	}

	public boolean isPredecessor() {
		return predecessor;
	}

	public void setPredecessor(boolean predecessor) {
		this.predecessor = predecessor;
	}

	public boolean isSuccessor() {
		return successor;
	}

	public void setSuccessor(boolean successor) {
		this.successor = successor;
	}

	public boolean isParentSuccessor() {
		return parentSuccessor;
	}

	public void setParentSuccessor(boolean parentSuccessor) {
		this.parentSuccessor = parentSuccessor;
	}

	public boolean isPredecessorChild() {
		return predecessorChild;
	}

	public void setPredecessorChild(boolean predecessorChild) {
		this.predecessorChild = predecessorChild;
	}

	public List<Integer> getBypasses() {
		return bypasses;
	}

	public void setBypasses(List<Integer> bypasses) {
		this.bypasses = bypasses;
	}
	
}