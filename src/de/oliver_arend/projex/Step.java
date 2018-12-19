package de.oliver_arend.projex;

public class Step {

	private String description;
	private int level;
	private Step parent;
	private Step child;
	private Step predecessor;
	private Step successor;
	private StepState state;
	
	public Step(String description, int level, Step parent, Step child, Step predecessor, Step successor) {
		this.description = description;
		this.level = level;
		this.parent = parent;
		this.child = child;
		this.predecessor = predecessor;
		this.successor = successor;
		this.state = StepState.NEW;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Step getParent() {
		return parent;
	}

	public void setParent(Step parent) {
		this.parent = parent;
	}
	
	public boolean hasParent() {
		return this.parent != null;
	}

	public Step getChild() {
		return child;
	}

	public void setChild(Step child) {
		this.child = child;
	}
	
	public boolean hasChild() {
		return this.child != null;
	}

	public Step getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Step predecessor) {
		this.predecessor = predecessor;
	}
	
	public boolean hasPredecessor() {
		return this.predecessor != null;
	}

	public Step getSuccessor() {
		return successor;
	}

	public void setSuccessor(Step successor) {
		this.successor = successor;
	}
	
	public boolean hasSuccessor() {
		return this.successor != null;
	}

	public StepState getState() {
		return state;
	}

	public void setState(StepState state) {
		this.state = state;
	}
	
}
