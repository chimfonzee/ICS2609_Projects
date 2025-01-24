package com.mycompany.eventlistenerexamples;

import java.awt.event.*;

public class MyEvent implements ActionListener {
	public void actionPerformed(ActionEvent e)  {
		System.out.println("I was clicked!");
	}
}
