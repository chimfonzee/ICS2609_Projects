package com.mycompany.eventlistenerexamples;

import java.awt.*;

public class MyGUI
{
	private Frame f;
	private Button b;

	public MyGUI()
	{
		f = new Frame("Delegation Event Model");
		b = new Button("Click me!");
	}

	public void startApp()
	{
		f.add(b);
		f.pack();
		f.setVisible(true);

		// register your event handler
		b.addActionListener(new MyEvent());
		b.addActionListener(new MyEventToo());
	}

	public static void main(String args[])
	{
		MyGUI m = new MyGUI();
		m.startApp();
	}
}
