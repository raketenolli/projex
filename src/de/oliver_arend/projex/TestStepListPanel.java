package de.oliver_arend.projex;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class TestStepListPanel {

	private static StepListPanel stepListPanel;
	
	public static void showApp() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {}

		JFrame frame;
		frame = new JFrame("Projex");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

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

		stepListPanel = new StepListPanel(parsedStepList);
		stepListPanel.setPreferredSize(new Dimension(320, 240));
		
		frame.add(stepListPanel);
		frame.pack();
		frame.setLocation(800, 430);
		frame.setVisible(true);
	}
	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showApp();
            }
        });
    }

}
