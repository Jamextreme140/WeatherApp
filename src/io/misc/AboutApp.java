package io.misc;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class AboutApp extends JDialog implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AboutApp() 
	{
		setTitle("About");
		setBounds(100, 100, 350, 200);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 334, 161);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("WeatherApp");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setBounds(10, 11, 105, 33);
		contentPanel.add(lblTitle);
		
		JLabel lblVersion = new JLabel("Version 1.0");
		lblVersion.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblVersion.setBounds(10, 44, 74, 14);
		contentPanel.add(lblVersion);
		
		JLabel lblMP = new JLabel("Main Programmer: Jaime Humberto Macias Bustamante");
		lblMP.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblMP.setBounds(10, 103, 314, 14);
		contentPanel.add(lblMP);
		
		JLabel lblDisclaimer = new JLabel("only for testing/research");
		lblDisclaimer.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblDisclaimer.setForeground(Color.LIGHT_GRAY);
		lblDisclaimer.setBounds(185, 11, 139, 14);
		contentPanel.add(lblDisclaimer);
		
		JLabel lblC = new JLabel("(c) Copyright JMXT140  2021 - 2023");
		lblC.setBounds(10, 80, 201, 14);
		contentPanel.add(lblC);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(this);
		btnClose.setBounds(122, 128, 89, 23);
		contentPanel.add(btnClose);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		dispose();
	}
}
