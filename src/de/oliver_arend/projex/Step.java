package de.oliver_arend.projex;

public class Step {

	private String description;
	private int level;
	private Step parent;
	private Step predecessor;
	private Step successor;
	private boolean isCompleted;
	
	public Step(String description, int level, Step parent, Step predecessor, Step successor) {
		this.description = description;
		this.level = level;
		this.parent = parent;
		this.predecessor = predecessor;
		this.successor = successor;
		this.isCompleted = false;
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

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
}
