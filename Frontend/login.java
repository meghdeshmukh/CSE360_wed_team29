import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class login extends JPanel {

		JFrame myFrame;
		Application myApplication;
		Cart myCart;
		login myPanel = this;
	
		public JLabel email, password, create, resturantName;
		private JTextField aemail, apassword;
		private JButton login, createAcc;
		
		public login(JFrame frame, Application application, Cart cart) {
			myFrame = frame;
			myApplication = application;
			myCart = cart;
			
			Font mainFont = new Font("Futura", Font.ITALIC, 25);
			
			resturantName = new JLabel("Welcome to ---!");
			email = new JLabel("Email ");
			password = new JLabel("Password ");
			create = new JLabel("Don't have an account? click here to sign up!");
			
			resturantName.setFont(mainFont);
			email.setFont(mainFont);
			password.setFont(mainFont);
			create.setFont(mainFont);
			
			aemail = new JTextField(25);
			apassword = new JTextField(25);
			
			login = new JButton("Login");
			login.setPreferredSize(new Dimension(180,60));
			login.addActionListener(new ButtonListener());
			createAcc = new JButton("Create Account!");
			createAcc.setPreferredSize(new Dimension(200,60));
			createAcc.addActionListener(new ButtonListener());
			
			
			setLayout(new BorderLayout());
			
			JPanel center = new JPanel(new GridLayout(0,1));
			JPanel row = new JPanel();
			
			center.add(new JLabel());
			
			row.add(resturantName);
			center.add(row);
			
			row = new JPanel();
			row.add(email);
			row.add(aemail);
			center.add(row);
			
			row = new JPanel();
			row.add(password);
			row.add(apassword);
			center.add(row);
			
			row = new JPanel();
			row.add(login);
			center.add(row);
			
			row = new JPanel();
			row.add(create);
			center.add(row);
			
			row = new JPanel();
			row.add(createAcc);
			center.add(row);
			
			center.add(new JLabel());
			
			add(center, BorderLayout.CENTER);
		}
		
		private class ButtonListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == createAcc) {
					signup signupRequest = new signup(myFrame, myApplication, myCart);
					myFrame.remove(myPanel);
					myFrame.add(signupRequest);
					myFrame.invalidate();
					myFrame.validate();
				}
				else if(e.getSource() == login) {
					
				}
			}
			
		}
		
}
