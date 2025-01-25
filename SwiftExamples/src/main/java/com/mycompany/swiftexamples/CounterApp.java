package com.mycompany.swiftexamples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CounterApp implements ActionListener
{
	private JFrame f;
	private Panel pan;

	private JLabel l1, l2, l3;
	private JButton button;

	private static int counter = 0;

	public CounterApp()
	{
		f = new JFrame("My Counter App");

		pan = new Panel();
		pan.setBackground(Color.BLACK);

		l1 = new JLabel("0");
		l1.setFont(new Font("Serif", Font.BOLD, 100));
	
		l2 = new JLabel("0");
		l2.setFont(new Font("Serif", Font.BOLD, 100));

		l3 = new JLabel("0");
		l3.setFont(new Font("Serif", Font.BOLD, 100));

		button = new JButton("Click Me!");
	}

	public void startApp()
	{
		
		l3.setOpaque(true);

		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.BLACK);

	//	pan.setLayout(new FlowLayout());	// ok not to call
		pan.setLayout(new GridLayout(1, 3));

		pan.add(l1);
		pan.add(l2);
		pan.add(l3);

		f.add(pan, BorderLayout.CENTER);
		f.add(button, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// register your event handler
		button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		counter = Integer.parseInt(l1.getText() + l2.getText() + l3.getText());		
		counter++;

		int hund = counter / 100;		// counter = 123 --> hunds = 1
		int temp = counter % 100;		// temp = 23

		int tens = temp / 10;			// tens = 2
		int ones = temp % 10;			// ones = 3

		l1.setText("" + hund);
		l2.setText("" + tens);
		l3.setText("" + ones);

	}

	public static void main(String args[])
	{
		CounterApp counterApp = new CounterApp();
		counterApp.startApp();
	}
}
