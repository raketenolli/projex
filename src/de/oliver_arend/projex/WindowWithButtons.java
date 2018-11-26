package de.oliver_arend.projex;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

public class WindowWithButtons {
	
	public static void showApp() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {}

		DragListener drag = new DragListener();
		
		JFrame frame;
		frame = new JFrame("Projex");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel matrixPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.black);
				g.drawLine(200, 380, 200, 20);
				g.drawLine(20, 200, 380, 200);
			}
		};
		matrixPanel.setLayout(null);
		matrixPanel.setPreferredSize(new Dimension(400, 400));
		matrixPanel.setBorder(BorderFactory.createTitledBorder("Project matrix"));

		frame.setLocation(760, 400);
		
		JRadioButton buttonA = new JRadioButton();
		buttonA.setToolTipText("Build a rocket");
		buttonA.setSize(buttonA.getPreferredSize());
		buttonA.setLocation(100, 100);
		buttonA.setOpaque(false);
		buttonA.setIcon(new DotIcon(192, 0, 0));
		buttonA.setSelectedIcon(new ActiveDotIcon(192, 0, 0));
		buttonA.addMouseListener(drag);
		buttonA.addMouseMotionListener(drag);
		
		JRadioButton buttonB = new JRadioButton();
		buttonB.setToolTipText("Fix CNC mill");
		buttonB.setSize(buttonB.getPreferredSize());
		buttonB.setLocation(200, 100);
		buttonB.setOpaque(false);
		buttonB.setIcon(new DotIcon(255, 255, 0));
		buttonB.setSelectedIcon(new ActiveDotIcon(255, 255, 0));
		buttonB.addMouseListener(drag);
		buttonB.addMouseMotionListener(drag);
		
		JRadioButton buttonC = new JRadioButton();
		buttonC.setToolTipText("Fix 3D Printer");
		buttonC.setSize(buttonC.getPreferredSize());
		buttonC.setLocation(200, 200);
		buttonC.setOpaque(false);
		buttonC.setIcon(new DotIcon(0, 0, 128));
		buttonC.setSelectedIcon(new ActiveDotIcon(0, 0, 128));
		buttonC.addMouseListener(drag);
		buttonC.addMouseMotionListener(drag);
		
		ButtonGroup allProjects = new ButtonGroup();
		allProjects.add(buttonA);
		allProjects.add(buttonB);
		allProjects.add(buttonC);
		
		matrixPanel.add(buttonA);
		matrixPanel.add(buttonB);
		matrixPanel.add(buttonC);
		
		frame.add(matrixPanel);
		
		frame.pack();
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
