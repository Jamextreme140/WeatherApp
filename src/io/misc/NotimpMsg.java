package io.misc;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NotimpMsg extends JDialog implements ActionListener
{

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public NotimpMsg() 
	{
		setTitle("Message");
		setBounds(100, 100, 260, 130);
		getContentPane().setLayout(null);
		
		JLabel lblNoImp = new JLabel("Not implemented");
		lblNoImp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNoImp.setBounds(61, 23, 122, 14);
		getContentPane().add(lblNoImp);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setBounds(97, 57, 50, 26);
		getContentPane().add(btnOk);

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		dispose();
	}
}
