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

		DragListener drag = new DragListener();
		
		JFrame frame;
		frame = new JFrame("Projex");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

		List<Step> stepList = new ArrayList<Step>();
		Step information = new Step("Information phase", 0, null, null, null);
		Step scaleDrawings = new Step("Scale drawings", 1, information, null, null);
		Step getPhotos = new Step("Get photos", 2, scaleDrawings, null, null);
		Step convertToDrawings = new Step("Convert photos to drawings", 2, scaleDrawings, getPhotos, null);
		getPhotos.setSuccessor(convertToDrawings);
		Step cadDrawings = new Step("CAD drawings", 1, information, scaleDrawings, null);
		scaleDrawings.setSuccessor(cadDrawings);
		Step material = new Step("Material phase", 0, null, information, null);
		information.setSuccessor(material);
		information.setCompleted(true);
		scaleDrawings.setCompleted(true);
		getPhotos.setCompleted(true);
		stepList.add(information);
		stepList.add(scaleDrawings);
		stepList.add(getPhotos);
		stepList.add(convertToDrawings);
		stepList.add(cadDrawings);
		stepList.add(material);

		stepListPanel = new StepListPanel(stepList);
		stepListPanel.setPreferredSize(new Dimension(300, 160));
		
		frame.add(stepListPanel);
		frame.pack();
		frame.setLocation(800, 450);
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
