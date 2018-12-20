package de.oliver_arend.projex;

import java.util.UUID;

public class Project {

	private String title;
	private UUID id;
	private double urgency;
	private double importance;
	private Category category;

	public Project(String title, double urgency, double importance, Category category) {
		super();
		this.title = title;
		this.id = UUID.randomUUID();
		this.urgency = urgency;
		this.importance = importance;
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public UUID getId() {
		return id;
	}
	public double getUrgency() {
		return urgency;
	}
	public void setUrgency(double urgency) {
		if(urgency < -1.0) { this.urgency = -1.0; }
		else if(urgency > 1.0) { this.urgency = 1.0; }
		else { this.urgency = urgency; }
	}
	public double getImportance() {
		return importance;
	}
	public void setImportance(double importance) {
		if(importance < -1.0) { this.importance = -1.0; }
		else if(importance > 1.0) { this.importance = 1.0; }
		else { this.importance = importance; }
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
