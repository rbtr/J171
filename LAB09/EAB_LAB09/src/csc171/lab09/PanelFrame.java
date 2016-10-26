package csc171.lab09;

import javax.swing.*;
import java.awt.*;

/**
 * Logger.java
 * 
 * Version 1.0 
 * Copyright Evan Baker
 * Course: CSC 171 SPRING 2015 
 * Assignment: LAB 09
 * Author: Evan Baker
 * Lab Session: TR 0940-1055
 * Lab TA: Stephen Cohen 
 * Last Revised: 4/3/15
 *
 * This class is a child of JFrame that creates a Magenta, 500x500 panel
 */

 class PanelFrame extends JFrame {

 	public PanelFrame() {
 		Container content = getContentPane();
 		content.setLayout(new BorderLayout());
 		JPanel panel = new JPanel();
 		setBackground(Color.MAGENTA);
 		content.add(panel);

 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	}

	public static void main(String[] args) {
		PanelFrame panelFrame = new PanelFrame();
		panelFrame.setSize(500, 500);
		panelFrame.setVisible(true);
	}
 }