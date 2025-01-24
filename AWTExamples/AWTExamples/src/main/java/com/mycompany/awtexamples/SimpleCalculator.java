package com.mycompany.awtexamples;

import java.awt.*;

public class SimpleCalculator
{
	// Containers
	private Frame f;
	private Panel p1, p2, p3, p4;

	// Components
	private Label l1, l2, l3;
	private TextField tf1, tf2, tf3;
	private Button bAdd, bSub, bMul, bDiv, bClear;

	public SimpleCalculator()
	{
		// container
		f = new Frame("My First GUI App");

		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();

		// components
		l1 = new Label("First: ");
		l2 = new Label("Second: ");
		l3 = new Label("Result: ");

		tf1 = new TextField("0.0", 15);
		tf2 = new TextField("0.0", 15);
		tf3 = new TextField("0.0", 15);

		bAdd = new Button("+");
		bSub = new Button("-");
		bMul = new Button("*");
		bDiv = new Button("/");
		bClear = new Button("C");
	}

	public void startApp()
	{
		// use the default layout manager for all panels,
		// use the FlowLayout.

		p1.add(l1);
		p1.add(tf1);
		
		p2.add(l2);
		p2.add(tf2);

		p3.add(l3);
		p3.add(tf3);

		p4.add(bAdd);
		p4.add(bSub);
		p4.add(bMul);
		p4.add(bDiv);
		p4.add(bClear);
	
		// change the layout manager for our Frame f;
		// use GridLayout(4, 1);
		f.setLayout(new GridLayout(4, 1));

		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);

		f.pack();
		f.setVisible(true);
	}

	public static void main(String args[])
	{
		SimpleCalculator sc = new SimpleCalculator();
		sc.startApp();
	}
}
