package com.mycompany.swiftexamples;

import java.awt.*;
import javax.swing.*;

public class RGBCheckBox
{
	private JFrame f;
	private JButton b;
	private JCheckBox red, green, blue;

	public RGBCheckBox()
	{
		f = new JFrame ("JCheckBox Example");
		b = new JButton("Click Me!");

		red = new JCheckBox(" Red ");
		green = new JCheckBox(" Green ");
		blue = new JCheckBox(" Blue ");
	}
	
	public void startApp()
	{
		f.setLayout(new GridLayout(4, 1));

		red.setSelected(true);
		blue.setSelected(true);

		f.add(red);
		f.add(green);
		f.add(blue);
		f.add(b);

		f.setBounds(100, 100, 300, 200);
		f.setVisible(true);
	}

	public static void main(String args[])
	{
		RGBCheckBox rgb = new RGBCheckBox();
		rgb.startApp();
	}
}
