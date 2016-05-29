package com.miller.ibcc.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Arrays;

import javax.swing.JPanel;

import com.miller.ibcc.gui.ApplicationFrame.MenuBarItem;

public enum SwingContentInjector {
	
	INSTANCE;
	
	public void injectContent(Component component, MenuBarItem... items) {
		
		JPanel pnlParent = (JPanel) SwingApplicationFrame.INSTANCE.getContainer();
		pnlParent.removeAll();
		pnlParent.add(component, BorderLayout.CENTER);
		pnlParent.invalidate();
		pnlParent.validate();
		pnlParent.repaint();
		
		SwingApplicationFrame.INSTANCE.setThirdPartyMenuBarItems(Arrays.asList(items));
	}

}
