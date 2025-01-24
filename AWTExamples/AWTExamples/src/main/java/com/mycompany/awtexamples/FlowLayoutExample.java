package com.mycompany.awtexamples;

import java.awt.*;

public class FlowLayoutExample
{
	private Frame f;
	private Button bAdd, bSub, bMul, bDiv;

	public FlowLayoutExample()
	{
		f = new Frame("FlowLayout Example");

		bAdd = new Button("+");
		bSub = new Button("-");
		bMul = new Button("*");
		bDiv = new Button("/");
	}

	public void startApp()
	{
		f.setLayout(new FlowLayout());

		f.add(bAdd);
		f.add(bSub);
		f.add(bMul);
		f.add(bDiv);

		f.setSize(200, 200);
		f.setVisible(true);
	}
	
	public static void main(String args[])
	{
		FlowLayoutExample fe = new FlowLayoutExample();
		fe.startApp();
	}
}


