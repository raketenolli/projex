package de.oliver_arend.projex;

import java.util.UUID;

public class Step {

    /**
     * Step class
     *
     * @param description A text describing what should happen in this step
     * @param parent A UUID that identifies the parent of the newly created step
     * @param predecessor A UUID that identifies the predecessor of the newly created step
     */
	
	private UUID id;
	private String description;
	private UUID parent;
	private UUID predecessor;
	private StepState state;
	
	public Step(String description, UUID parent, UUID predecessor) {
		this.id = UUID.randomUUID();
		this.description = description;
		this.parent = parent;
		this.predecessor = predecessor;
		this.state = StepState.NEW;
	}
	
	public UUID getId() {
		return this.id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UUID getParent() {
		return parent;
	}

	public void setParent(UUID parent) {
		this.parent = parent;
	}
	
	public boolean hasParent() {
		return this.parent != null;
	}

	public UUID getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(UUID predecessor) {
		this.predecessor = predecessor;
	}
	
	public boolean hasPredecessor() {
		return this.predecessor != null;
	}

	public StepState getState() {
		return state;
	}

	public void setState(StepState state) {
		this.state = state;
	}
	
}
