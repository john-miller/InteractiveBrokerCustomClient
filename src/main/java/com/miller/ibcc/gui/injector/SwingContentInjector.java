package com.miller.ibcc.gui.injector;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import com.miller.ibcc.gui.SwingApplicationFrame;

public enum SwingContentInjector implements ContentInjector<Component>{
	
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
