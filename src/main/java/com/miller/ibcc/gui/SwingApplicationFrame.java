package com.miller.ibcc.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.miller.ibcc.menu.MenuBarItem;

/**
 * Swing implementation of the application frame
 *
 * Created on May 27, 2016 3:20:23 PM
 * @author Jonathan Miller
 */
public enum SwingApplicationFrame implements ApplicationFrame {

	INSTANCE;
	
	private JFrame frmMain = new JFrame();
	private JPanel pnlMain = new JPanel(new BorderLayout());
	private JPanel pnlContent = new JPanel();
	private JMenuBar mnubarMain = new JMenuBar();
	private JMenu mnuFile = new JMenu("File");
	private JMenu mnuOptions = new JMenu("Options");
	private JMenuItem mnuItemExit = new JMenuItem("Exit");
	private JMenu mnuSettings = new JMenu("Settings");
	
	private SwingApplicationFrame() {
		frmMain.setTitle("IB Custom Client");
		mnubarMain.add(mnuFile);
		mnubarMain.add(mnuOptions);
		mnubarMain.add(mnuSettings);
		mnuFile.add(mnuItemExit);
		pnlMain.add(pnlContent, BorderLayout.CENTER);
		mnuItemExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmMain.dispose();
			}
		});
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pnlMain.add(mnubarMain, BorderLayout.NORTH);
		frmMain.add(pnlMain);
	}
	
	@Override
	public void display() {
		frmMain.setSize(800, 600);
		frmMain.setLocationRelativeTo(null);
		frmMain.setVisible(true);
	}

	@Override
	public Object getContainer() {
		return pnlContent;
	}

	@Override
	public void setThirdPartyMenuBarItems(MenuBarItem... menuBarItems) {
		
		/* Remove all third party menu items */
		mnuOptions.removeAll();
		
		for(final MenuBarItem menuBarItem : menuBarItems) {
			JMenuItem newItem = new JMenuItem(menuBarItem.getName());
			newItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menuBarItem.onAction();
				}
			});
			mnuOptions.add(newItem);
		}
	}

}
