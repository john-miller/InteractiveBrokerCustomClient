package com.miller.ibcc.gui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

public enum SwingContentInjector {
	
	INSTANCE;
	
	public void injectContent(Component component) {
		JPanel pnlParent = (JPanel) SwingApplicationFrame.INSTANCE.getContainer();
		pnlParent.removeAll();
		pnlParent.add(component, BorderLayout.CENTER);
		pnlParent.invalidate();
		pnlParent.validate();
		pnlParent.repaint();
	}

}
