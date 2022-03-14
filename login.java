import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

		public JLabel email, password, create, resturantName;
		private JTextField aemail, apassword;
		private JButton login, createAcc;
		
		public login() {
			Font mainFont = new Font("SF-Pro", Font.ITALIC, 13);
			
			resturantName = new JLabel("Welcome to ---!");
			email = new JLabel("Email: ");
			password = new JLabel("Password: ");
			create = new JLabel("Don't have an account? click here to sign up!");
			
			resturantName.setFont(mainFont);
			email.setFont(mainFont);
			password.setFont(mainFont);
			create.setFont(mainFont);
			
			aemail = new JTextField(10);
			apassword = new JTextField(10);
			
			login = new JButton("Login");
			createAcc = new JButton("Create Account!");
			
			
			setLayout(null);
			Dimension size = email.getPreferredSize();
			Dimension size1 = password.getPreferredSize();
			Dimension size2 = aemail.getPreferredSize();
			Dimension size3 = apassword.getPreferredSize();
			Dimension size4 = resturantName.getPreferredSize();
			Dimension size5 = create.getPreferredSize();
			Dimension size6 = login.getPreferredSize();
			Dimension size7 = createAcc.getPreferredSize();
			
			email.setBounds(28, 100, size.width, size.height);
			password.setBounds(28, 60, size1.width, size1.height);
			aemail.setBounds(100, 40, size2.width, size2.height);
			apassword.setBounds(100, 80, size3.width, size3.height);
			resturantName.setBounds(20, 180, size4.width, size4.height);
			create.setBounds(50, 100, size5.width, size5.height);
			login.setBounds(80, 200, size6.width, size6.height);
			createAcc.setBounds(200, 250, size7.width, size7.height);
			
			login.addActionListener(new Buttonlistener());
			createAcc.addActionListener(new Buttonlistener());
			
			add(resturantName);
			add(email);
			add(aemail);
			add(password);
			add(apassword);
			add(login);
			add(create);
			add(createAcc);
			
			setBackground(Color.lightGray);
			setPreferredSize(new Dimension(800, 500));
			
			
		}
		
		private class Buttonlistener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == createAcc) {
			
					
					JFrame frame = new JFrame("Groccery Store");
					frame.getContentPane().add(new CreateAcc());
					frame.pack();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
			}
			
		}
		
}
