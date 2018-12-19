package de.oliver_arend.projex;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class ParsedStepList {
	
	private List<ParsedStep> parsedStepList;

	private static void parseStepList(UUID parent, List<Step> stepList, List<ParsedStep> parsedStepList, int currentLevel) {
		stepList.stream()
			.filter(step -> (step.getParent() == parent && step.getPredecessor() == null))
			.forEach(step -> {
				parsedStepList.add(new ParsedStep(step, currentLevel + 1));
				parseStepList(step.getId(), stepList, parsedStepList, currentLevel + 1);
				stepList.stream()
					.filter(succStep -> (succStep.getParent() == parent && succStep.getPredecessor() == step.getId()))
					.forEach(succStep -> {
						parsedStepList.add(new ParsedStep(succStep, currentLevel + 1));
						parseStepList(succStep.getId(), stepList, parsedStepList, currentLevel + 1);
					});
				
			});
	}
	
	public ParsedStepList(List<Step> stepList) {
		this.parsedStepList = new ArrayList<ParsedStep>();
		parseStepList(null, stepList, parsedStepList, -1);
	}
	
	public List<ParsedStep> getList() {
		return this.parsedStepList;
	}
	
	public Stream<ParsedStep> stream() {
		return this.parsedStepList.stream();
	}
	
	public static void main(String[] args) {
		List<Step> stepList = new ArrayList<Step>();
		Step information = new Step("Information phase", null, null);
		Step scaleDrawings = new Step("Scale drawings", information.getId(), null);
		Step getPhotos = new Step("Get photos", scaleDrawings.getId(), null);
		Step convertToDrawings = new Step("Convert photos to drawings", scaleDrawings.getId(), getPhotos.getId());
		Step cadDrawings = new Step("CAD drawings", information.getId(), scaleDrawings.getId());
		Step paintScheme = new Step("Create paint scheme", information.getId(), scaleDrawings.getId());
		Step material = new Step("Material phase", null, information.getId());
		Step cncMill = new Step("Fix CNC mill", null, null);
		
		information.setState(StepState.STARTED);
		scaleDrawings.setState(StepState.STARTED);
		getPhotos.setState(StepState.COMPLETED);
		stepList.add(information);
		stepList.add(material);
		stepList.add(cncMill);
		stepList.add(scaleDrawings);
		stepList.add(convertToDrawings);
		stepList.add(getPhotos);
		stepList.add(cadDrawings);
		stepList.add(paintScheme);
		
		ParsedStepList parsedStepList = new ParsedStepList(stepList);
		parsedStepList.stream().forEach(step -> { System.out.println(step.getLevel() + ": " + step.getStep().getDescription()); });
	}
}
