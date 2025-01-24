package com.mycompany.eventlistenerexamples;

import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator implements ActionListener
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

		// register your event handler to your UI (event source)
		bAdd.addActionListener(this);
		bSub.addActionListener(this);
		bMul.addActionListener(this);
		bDiv.addActionListener(this);
		bClear.addActionListener(this);

		f.addWindowListener(new MyCloseButtonHandler());
	}

	// event handler
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		double num1 = 0.0, num2 = 0.0, num3 = 0.0;

		if (tf1.getText() != null && tf2.getText() != null)
		{
			num1 = Double.parseDouble(tf1.getText());
			num2 = Double.parseDouble(tf2.getText());

			if (source == bAdd)
			{
				num3 = num1 + num2;
			}
			else if (source == bSub)
			{
				num3 = num1 - num2;
			}
			else if (source == bMul)
			{
				num3 = num1 * num2;
			}
			else if (source == bDiv)
			{
				num3 = num1 / num2;
			}
			else if (source == bClear)
			{
				tf1.setText("0.0");
				tf2.setText("0.0");	
				tf3.setText("0.0");				
			}
			else {}		// do nothing
			// tf3.setText(new Double(num3).toString());
			tf3.setText("" + num3);
		}		
	}

	private class MyCloseButtonHandler extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	}

	public static void main(String args[])
	{
		SimpleCalculator sc = new SimpleCalculator();
		sc.startApp();
	}
}
