package com.mycompany.awtexamples;

import java.awt.*;

public class BorderLayoutExample
{
	private Frame f;
	private Button bNorth, bSouth, bCenter, bWest, bEast;

	public BorderLayoutExample()
	{
		f = new Frame("BorderLayout Example");

		bNorth = new Button("North");
		bSouth = new Button("South");	
		bCenter = new Button("Center");
		bWest = new Button("West");
		bEast = new Button("East");
	}

	public void startApp()
	{
		// frames are using BorderLayout by default, 
		// there's no need to change the layout manager
		// of the Frame f;
		
		f.add(bNorth, BorderLayout.NORTH);
		f.add(bSouth, BorderLayout.SOUTH);
		f.add(bCenter, BorderLayout.CENTER);
		f.add(bWest, BorderLayout.WEST);
		f.add(bEast, BorderLayout.EAST);

		f.setSize(400, 200);
		f.setVisible(true);
	}

	public static void main(String args[])
	{
		BorderLayoutExample be = new BorderLayoutExample();
		be.startApp();
	}
}


