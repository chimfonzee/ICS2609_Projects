package com.mycompany.swiftexamples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Counter implements ActionListener
{
	private JFrame f;
	private Panel pan;

	private JLabel l1, l2;
	private JLabel l3;
	private JButton button;

	private static int counter = 0;

	public Counter()
	{
		f = new JFrame("Counter");

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
		// Center the Frame to the screen

		f.setLocationRelativeTo(null);

		l3.setOpaque(true);
		l1.setForeground(Color.WHITE);
		l2.setForeground(Color.WHITE);
		l3.setForeground(Color.BLACK);
		pan.setLayout(new FlowLayout());
		pan.add(l1);
		pan.add(l2);
		pan.add(l3);

		f.add(pan, BorderLayout.CENTER);
		f.add(button, BorderLayout.SOUTH);
		f.setVisible(true);
		f.pack();
		
		// closes the frame
		// f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae)
	{
		update();
	}

	public void update()
	{

		counter = Integer.parseInt(l1.getText() + l2.getText() + l3.getText());
		counter++;
		int hundreds = counter / 100;
		int temp = counter % 100;
		int tens = temp / 10;
		int ones = temp % 10;
		l1.setText("" + hundreds);
		l2.setText("" + tens);
		l3.setText("" + ones);
	}

	public static void main(String args[])
	{
		Counter c = new Counter();
		c.startApp();
	}
}
