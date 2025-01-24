package com.mycompany.awtexamples;

import java.awt.*;

public class SampleFrame
{
	// attributes
	private Frame f;

	// constructor
	public SampleFrame()
	{
		f = new Frame("My First GUI App");
	}

	// methods
	public void startApp()
	{
		f.setBackground(Color.YELLOW);
		f.setSize(200, 200);
		f.setVisible(true);
	}

	public static void main(String args[])
	{
		SampleFrame sf = new SampleFrame();
		sf.startApp();
	}
}
