package de.oliver_arend.projex;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class WindowWithButtons {
	
	public static void showApp() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {}

		JFrame frame;
		frame = new JFrame("Projex");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

		ProjectTreeView projectTreeView = new ProjectTreeView();
		MatrixPanel matrixPanel = new MatrixPanel();
		StepListPanelScroller stepListPanelScroller = new StepListPanelScroller(); 
		
		frame.add(projectTreeView);
		frame.add(matrixPanel);
		frame.add(stepListPanelScroller);
		
		frame.pack();
		frame.setLocation(460, 368);
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
