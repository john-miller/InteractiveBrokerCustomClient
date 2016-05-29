package com.miller.ibcc.gui.dashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.miller.ibcc.controller.AuthenticationController;
import com.miller.ibcc.gui.ApplicationFrame.MenuBarItem;
import com.miller.ibcc.gui.SwingContentInjector;

public enum SwingDashboardForm implements DashboardForm {
	
	INSTANCE;
	
	private JPanel pnlMain = new JPanel();
	private MenuBarItem mnbPlaceOrder = new MenuBarItem(){
		@Override
		public String getName() {
			return "Place Order";
		}
		@Override
		public void onAction() {
			
		}
	};
	
	private SwingDashboardForm() {
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AuthenticationController.INSTANCE.authenticateToDashboard();
			}
		});
		pnlMain.add(btnLogout);
	}

	@Override
	public void display() {
		SwingContentInjector.INSTANCE.injectContent(pnlMain, mnbPlaceOrder);
	}
	
	

}
