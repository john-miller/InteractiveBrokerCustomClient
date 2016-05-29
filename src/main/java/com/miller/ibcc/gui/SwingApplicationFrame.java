package com.miller.ibcc.gui;

import javax.swing.JFrame;

/**
 * Swing implementation of the application frame
 *
 * Created on May 27, 2016 3:20:23 PM
 * @author Jonathan Miller
 */
public enum SwingApplicationFrame implements ApplicationFrame {

	INSTANCE;
	
	private JFrame frmMain = new JFrame();
	
	private SwingApplicationFrame() {
		frmMain.setTitle("IB Custom Client");
	}
	
	@Override
	public void display() {
		frmMain.pack();
		frmMain.setVisible(true);
	}

	@Override
	public Object getContainer() {
		return frmMain;
	}

}
