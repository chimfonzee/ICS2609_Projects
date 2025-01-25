package com.mycompany.swiftexamples;

import java.awt.*;
import javax.swing.*;

public class RGBRadioButton
{
	private JFrame f;
	private JButton b;
	private JRadioButton red, green, blue;

	public RGBRadioButton()
	{
		f = new JFrame("RGBJRadioButton Example");

		red = new JRadioButton(" Red ");
		green = new JRadioButton(" Green ");
		blue = new JRadioButton(" Blue ");
		
		b = new JButton("Click Me!");
	}

	public void startApp()
	{
		f.setLayout(new GridLayout(4, 1));

		red.setSelected(true);

		f.add(red);
		f.add(green);
		f.add(blue);

		ButtonGroup colorGroup = new ButtonGroup();

		colorGroup.add(red);
		colorGroup.add(green);
		colorGroup.add(blue);

		f.add(b);
		
		f.setBounds(200, 200, 300, 200);
		f.setVisible(true);
	}

	public static void main(String args[])
	{
		RGBRadioButton rgb = new RGBRadioButton();
		rgb.startApp();
	}
}
