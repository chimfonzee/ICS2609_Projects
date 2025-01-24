package com.mycompany.eventlistenerexamples;

import java.awt.event.*;

public class MyEventToo implements ActionListener {
	public void actionPerformed(ActionEvent e)  {
		System.out.println("I was piggy backing!");
	}
}
