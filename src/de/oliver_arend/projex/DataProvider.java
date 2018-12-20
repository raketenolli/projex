package de.oliver_arend.projex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataProvider {

	private static List<Step> stepList = new ArrayList<Step>();
	private static List<Project> projectList = new ArrayList<Project>();
	
	private static void populateProjectList() {
		Project rocket = new Project("Build a rocket", 0.2, 0.5, Category.CURRENT);
		Project printer3d = new Project("Fix 3D printer", 0.6, 0.3, Category.CURRENT);
		Project cncMill = new Project("Fix CNC mill", -0.3, -0.2, Category.CURRENT);
		Project airplane = new Project("Build an airplane", -0.8, 0.5, Category.SOMEDAYMAYBE);
		projectList.add(rocket);
		projectList.add(printer3d);
		projectList.add(cncMill);
		projectList.add(airplane);
	}

	public static List<Project> getProjectList() {
		if(projectList == null || projectList.isEmpty()) { populateProjectList(); }
		return projectList;
	}
	
	public static List<Project> getProjectList(Category category) {
		if(projectList == null || projectList.isEmpty()) { populateProjectList(); }
		List<Project> filteredProjectList = new ArrayList<Project>();
		filteredProjectList = projectList.stream().filter(project -> project.getCategory() == category).collect(Collectors.toList());
		return filteredProjectList;
	}
	
	public static List<Step> getStepList() {
		if(stepList == null || stepList.isEmpty()) {
			Step information = new Step("Information phase", null, null);
			Step scaleDrawings = new Step("Scale drawings", information.getId(), null);
			Step getPhotos = new Step("Get photos", scaleDrawings.getId(), null);
			Step convertToDrawings = new Step("Convert photos to drawings", scaleDrawings.getId(), getPhotos.getId());
			Step cadDrawings = new Step("CAD drawings", information.getId(), scaleDrawings.getId());
			Step paintScheme = new Step("Create paint scheme", information.getId(), scaleDrawings.getId());
			Step material = new Step("Material phase", null, information.getId());
			Step getHardware = new Step("Get hardware", material.getId(), null); 
			Step getMotorMount = new Step("Get Motor mount tube", material.getId(), null);
			Step getWoodenRods = new Step("Get wooden rods (3 mm)", material.getId(), null);
			Step cncMillStep = new Step("Fix CNC mill", null, null);
			Step rnd1 = new Step("rnd1", null, null);
			Step rnd2 = new Step("rnd2", null, null);
			Step rnd3 = new Step("rnd3", null, null);
			Step rnd4 = new Step("rnd4", null, null);
			Step rnd5 = new Step("rnd5", null, null);
			Step rnd6 = new Step("rnd6", null, null);
			
			information.setState(StepState.STARTED);
			scaleDrawings.setState(StepState.STARTED);
			getPhotos.setState(StepState.COMPLETED);
			stepList.add(information);
			stepList.add(material);
			stepList.add(cncMillStep);
			stepList.add(scaleDrawings);
			stepList.add(convertToDrawings);
			stepList.add(getPhotos);
			stepList.add(cadDrawings);
			stepList.add(paintScheme);
			stepList.add(getHardware);
			stepList.add(getMotorMount);
			stepList.add(getWoodenRods);
			stepList.add(rnd1);
			stepList.add(rnd2);
			stepList.add(rnd3);
			stepList.add(rnd4);
			stepList.add(rnd5);
			stepList.add(rnd6);
		}
		return stepList;
	}
	
}
