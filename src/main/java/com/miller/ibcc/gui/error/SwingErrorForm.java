package com.miller.ibcc.gui.error;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.miller.ibcc.domain.Error;
import com.miller.ibcc.gui.SwingContentInjector;

public enum SwingErrorForm implements ErrorForm {
	
	INSTANCE;
	
	private JPanel pnlMain = new JPanel(new BorderLayout());
	private TitledBorder border = BorderFactory.createTitledBorder(new LineBorder(Color.black));
	private JLabel lblErrorName = new JLabel();
	
	private SwingErrorForm() {
		pnlMain.add(lblErrorName, BorderLayout.NORTH);
		pnlMain.setBorder(border);
		pnlMain.setMinimumSize(new Dimension(600, 600));
	}
	
	@Override
	public void displayError(Error error) {
		border.setTitle(error.getName());
		lblErrorName.setText(error.getName());
		
		SwingContentInjector.INSTANCE.injectContent(pnlMain);
	}

}
