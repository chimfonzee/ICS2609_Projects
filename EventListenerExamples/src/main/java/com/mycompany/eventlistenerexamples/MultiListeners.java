package com.mycompany.eventlistenerexamples;

import java.awt.*;
import java.awt.event.*;

public class MultiListeners implements MouseListener, MouseMotionListener
{
	private Frame f;
 	private TextField tf;
	private Label label;

	public MultiListeners() 
	{
    		f = new Frame("I have Two listeners example");
    		tf = new TextField(30);
    		label = new Label("Click and drag the mouse");
	}

  	public void startApp() 
	{
    		f.add(label, BorderLayout.NORTH);
    		f.add(tf, BorderLayout.SOUTH);

		f.setSize(300, 200);
		f.setVisible(true);

		// event handler registration
    		f.addMouseMotionListener(this);
    		f.addMouseListener(this);

		// f.addWindowListener(this);
		f.addWindowListener(new MyCloseButtonHandler());
 	}

  	// The event handlers
    	public void mouseDragged(MouseEvent e) 
	{
    		String s = "Mouse dragging:  X = " + e.getX()
                		+ " Y = " + e.getY();
    		tf.setText(s);
  	}

  	public void mouseEntered(MouseEvent e) 
	{
    		String s = "Mighty Mouse is coming in..";
    		tf.setText(s);
  	}

  	public void mouseExited(MouseEvent e) 
	{
    		String s = "The mouse has left the building";
    		tf.setText(s);
  	}

  	// All unused event handlers still needs to be overridden
	public void mouseMoved(MouseEvent e) 
	{}
  	public void mousePressed(MouseEvent e) 
	{}
  	public void mouseClicked(MouseEvent e) 
	{}
  	public void mouseReleased(MouseEvent e) 
	{}
  	
	private class MyCloseButtonHandler extends WindowAdapter 
	{

		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
	}

	public static void main(String args[]) 
	{
    		MultiListeners ml = new MultiListeners();
    		ml.startApp();
  	}
}


