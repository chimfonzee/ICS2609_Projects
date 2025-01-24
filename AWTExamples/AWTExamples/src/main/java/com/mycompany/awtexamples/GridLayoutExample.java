package com.mycompany.awtexamples;

import java.awt.*;

public class GridLayoutExample
{
	private Frame f;
	private Button b1, b2, b3, b4, b5, b6;

	public GridLayoutExample()
	{
		f = new Frame("GridLayout Example");

		b1 = new Button("B1");
		b2 = new Button("B2");
		b3 = new Button("B3");
		b4 = new Button("B4");
		b5 = new Button("B5");
		b6 = new Button("B6");
	}

	public void startApp()
	{
		// to set the layout manager of our Frame f;
		f.setLayout(new GridLayout(3, 2));

		// put all the buttons inside the frame, 
		// left --> right
		// top --> bottom

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		// f.add(b5);
		// f.add(b6);

		f.pack();
		f.setVisible(true);
	}

	public static void main(String args[])
	{
		GridLayoutExample ge = new GridLayoutExample();
		ge.startApp();
	}
}
