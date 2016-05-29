package com.miller.ibcc.gui.login;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.miller.ibcc.gui.SwingContentInjector;

/**
 * Swing implementation of the login form
 *
 * Created on May 27, 2016 3:07:54 PM
 * @author Jonathan Miller
 */
public enum SwingClientAuthForm implements ClientAuthForm {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(SwingClientAuthForm.class);
	private JPanel pnlMain = new JPanel(new BorderLayout());
	private JPanel pnlInput = new JPanel(new GridLayout(3, 2));
	private JPanel pnlButtons = new JPanel(new GridLayout(3, 1));
	private JButton btnSignIn = new JButton("Sign In");
	private JButton btnCancel = new JButton("Cancel");
	private JLabel lblClientId = new JLabel("Client Id");
	private JLabel lblHost = new JLabel("Host");
	private JCheckBox chbxSave = new JCheckBox("Remember Me");
	private JLabel lblPort = new JLabel("Port");
	private JTextField txtClientId = new JTextField();
	private JTextField txtHost = new JTextField();
	private JTextField txtPort = new JTextField();
	private ClientAuthListener currentListener;
	
	private SwingClientAuthForm() {
		pnlInput.add(lblClientId);
		pnlInput.add(txtClientId);
		pnlInput.add(lblHost);
		pnlInput.add(txtHost);
		pnlInput.add(lblPort);
		pnlInput.add(txtPort);
		pnlButtons.add(btnSignIn);
		pnlButtons.add(chbxSave);
		pnlButtons.add(btnCancel);
		pnlMain.add(pnlInput, BorderLayout.CENTER);
		pnlMain.add(pnlButtons, BorderLayout.SOUTH);
		pnlMain.setBorder(BorderFactory.createTitledBorder("Login"));
		
		btnSignIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							currentListener.onAuth(
									Integer.parseInt(txtClientId.getText()), 
									txtHost.getText(), 
									Integer.parseInt(txtPort.getText()));
						} catch(NumberFormatException e2) {
							logger.error("Could not parse value", e2);
						}
					}
				}).start();
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						currentListener.onCancel();
					}
				}).start();
			}
		});
		
	}
	
	@Override
	public void display(final ClientAuthListener listener) {
		
		/* Set the current listener */
		currentListener = listener;
				
		/* Inject content into frame */
		SwingContentInjector.INSTANCE.injectContent(pnlMain);
	}

	@Override
	public boolean isSave() {
		return chbxSave.isSelected();
	}

	@Override
	public void setSave(boolean save) {
		chbxSave.setSelected(save);
	}

	@Override
	public int getPort() {
		try {
			return Integer.parseInt(txtPort.getText());
		} catch(NumberFormatException e2) {
			e2.printStackTrace();
		}
		return 0;
	}

	@Override
	public void setPort(int port) {
		txtPort.setText(String.valueOf(port));
	}

	@Override
	public int getClientId() {
		try {
			return Integer.parseInt(txtClientId.getText());
		} catch(NumberFormatException e2) {
			e2.printStackTrace();
		}
		return 0;
	}

	@Override
	public void setClientId(int clientId) {
		txtClientId.setText(String.valueOf(clientId));
	}

	@Override
	public String getHost() {
		return txtHost.getText();
	}

	@Override
	public void setHost(String host) {
		txtHost.setText(host);
	}

	

}
