package edu.pitt.is1017.spaceinvaders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterGUI {

	private JFrame frame;
	private JLabel lblFirstName;
	private JTextField txtFirstName;
	private JLabel lblLastName;
	private JTextField txtLastName;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblPassword;
	private JTextField txtPassword;
	private JLabel lblConfirmPassword;
	private JTextField txtConfirmPassword;
	private JButton btnRegister;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI window = new RegisterGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Space Invaders - Registration");
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblFirstName.setBounds(30, 50, 90, 16);
		frame.getContentPane().add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(200, 50, 225, 28);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblLastName.setBounds(30, 100, 90, 16);
		frame.getContentPane().add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(200, 100, 225, 28);
		frame.getContentPane().add(txtLastName);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblEmail.setBounds(30, 150, 90, 16);
		frame.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(200, 150, 225, 28);
		frame.getContentPane().add(txtEmail);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPassword.setBounds(30, 200, 90, 16);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(200, 200, 225, 28);
		frame.getContentPane().add(txtPassword);
		
		lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblConfirmPassword.setBounds(30, 250, 135, 16);
		frame.getContentPane().add(lblConfirmPassword);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBounds(200, 250, 225, 28);
		frame.getContentPane().add(txtConfirmPassword);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lastName = txtLastName.getText();
				String firstName = txtFirstName.getText();
				String email = txtEmail.getText();
				String password = txtPassword.getText();
				
				User u = new User(lastName, firstName, email, password);
			}
		});
		btnRegister.setBounds(200, 315, 100, 29);
		frame.getContentPane().add(btnRegister);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(325, 315, 100, 29);
		frame.getContentPane().add(btnCancel);
		
	}

}
