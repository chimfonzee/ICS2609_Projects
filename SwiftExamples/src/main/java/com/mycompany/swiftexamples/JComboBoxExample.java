package com.mycompany.swiftexamples;

import javax.swing.*;
import java.awt.event.*;

public class JComboBoxExample
{
	private JFrame f;
	private JButton b;
	private JComboBox<String> cb;
	private JLabel label;
	private String colorList[];

	public JComboBoxExample()
	{
		f = new JFrame("JComboBox List Example");
		label = new JLabel();
		colorList = new String[] {"Red", "Green", "Blue", "Yellow", "Purple"};
		cb = new JComboBox<>(colorList);

		cb.setBounds(50, 100, 90, 20);

		label.setHorizontalAlignment(JLabel.CENTER);
		label.setSize(400, 100);

		b = new JButton("Show");
		b.setBounds(200, 100, 75, 20);
	}

	public void startApp()
	{
		f.setLayout(null);
		f.add(cb);
		f.add(label);
		f.add(b);

		f.setSize(350, 350);

		f.setVisible(true);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{
				String str = "My Color List: " + cb.getItemAt(cb.getSelectedIndex());
				label.setText(str);
			}
		});
	}
	
	public static void main(String args[])
	{
		JComboBoxExample jcbe = new JComboBoxExample();
		jcbe.startApp();
	}
}

