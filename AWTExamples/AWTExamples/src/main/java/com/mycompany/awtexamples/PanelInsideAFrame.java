package com.mycompany.awtexamples;

import java.awt.*;

public class PanelInsideAFrame {
	private Frame f;
	private Panel p;

	public PanelInsideAFrame() {
		f = new Frame("Panel in a Frame");
		p = new Panel();
	}

	public void startApp() {
		f.setSize(400, 200);
		f.setBackground(Color.YELLOW);

		p.setSize(100, 100);
		p.setBackground(new Color(255, 0, 255));

		// frame won't be using any layout managers --> null
		f.setLayout(null);
		f.add(p);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		PanelInsideAFrame pan = new PanelInsideAFrame();
		pan.startApp();
	}
}


