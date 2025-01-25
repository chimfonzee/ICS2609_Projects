package com.mycompany.swiftexamples;

import java.awt.*;
import javax.swing.*;

public class RGBJList
{
	private JFrame f;
	private JLabel label;

	public RGBJList()
	{
		f = new JFrame("JList Color Example");		
	}

	public void startApp()
	{
		f.setLayout(new FlowLayout());

		// Creating a JList means first creating a list model then
		// populating that list model with data elements.
		// You can think of a list model as a holder of items, 
		// and the JList as the displayer
		DefaultListModel<String> listModel = new DefaultListModel<>();

		listModel.addElement("Red");
		listModel.addElement("Green");
		listModel.addElement("Blue");

		JList<String> colorList = new JList<>();
		colorList.setModel(listModel);
		colorList.setSelectedIndex(0);

		label = new JLabel();
		label.setText("Colors: ");
		
		f.add(label);
		f.add(colorList);

		f.setBounds(200, 200, 300, 200);
		f.setVisible(true);
	}

	public static void main(String args[])
	{
		RGBJList rgb = new RGBJList();
		rgb.startApp();
	}
}



