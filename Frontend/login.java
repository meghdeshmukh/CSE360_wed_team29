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
			createAcc = new JButton("Create Account!");
			createAcc.setPreferredSize(new Dimension(200,60));
			
			setLayout(null);
			Dimension size = email.getPreferredSize();
			Dimension size1 = password.getPreferredSize();
			Dimension size2 = aemail.getPreferredSize();
			Dimension size3 = apassword.getPreferredSize();
			Dimension size4 = resturantName.getPreferredSize();
			Dimension size5 = create.getPreferredSize();
			Dimension size6 = login.getPreferredSize();
			Dimension size7 = createAcc.getPreferredSize();
			
			email.setBounds(115, 220, size.width, size.height);
			password.setBounds(115, 150, size1.width, size1.height);
			aemail.setBounds(250, 220, size2.width, size2.height);
			apassword.setBounds(250, 150, size3.width, size3.height);
			resturantName.setBounds(330, 70, size4.width, size4.height);
			create.setBounds(140, 350, size5.width, size5.height);
			login.setBounds(320, 275, size6.width, size6.height);
			createAcc.setBounds(310, 400, size7.width, size7.height);
			
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
			
			setBackground(new Color(136, 196, 235));
			setPreferredSize(new Dimension(770, 485));
			
			
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
