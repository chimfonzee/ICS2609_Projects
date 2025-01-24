package com.mycompany.eventlistenerexamples;

import java.awt.*;

public class LambdaVersion
{
	private Frame f;
	private Button b;

	public LambdaVersion()
	{
		f = new Frame("Event Handler");
		b = new Button("Click Me!");
	}

	public void startApp()
	{
		f.add(b);
		f.pack();
		f.setVisible(true);

	//	b.addActionListener( 
	//	   e -> System.out.println("Handled by Lambda Expression")
	//	);

		b.addActionListener( 
		   e -> {
		      System.out.println("My Event Handler");
		      System.out.println("Handled by Lambda Expression");
		   }
		);


	}
	public static void main(String args[])
	{
		LambdaVersion m = new LambdaVersion();
		m.startApp();
	}
}
