import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class viewProfile extends JPanel{
	
	//the frame we work in
	JFrame theFrame;
	
	menu myMenu;
	
	//the panel
	JPanel thePanel = this;
	
	//the customer
	customer theCustomer;
	
	//JButton
	JButton backButton;
	JButton editButton;
	
	//JLabel
	JLabel profileLabel;
	JLabel usernameLabel;
	JLabel fullnameLabel;
	JLabel emailLabel;
	JLabel passwordLabel;
	JLabel phoneLabel;
	JLabel paymentLabel;
	
	JTextField usernameTF;
	JTextField fullnameTF;
	JTextField emailTF;
	JTextField passwordTF;
	JTextField phoneTF;
	
	
	public viewProfile(JFrame frame, customer customer, menu menu) {
		theFrame = frame;
		theCustomer = customer;
		myMenu = menu;
		
		Font mainFont = new Font("Futura", Font.ITALIC, 25);
		Font smallFont = new Font("Futura", Font.ITALIC, 13);
		
		setBackground(new Color(139,196,235));  
		
		//Button Dimensions
		Dimension buttonDimension = new Dimension(90,30);
		backButton = new JButton("Back");
		backButton.setFont(mainFont);
		backButton.addActionListener(new ButtonListener());
		backButton.setPreferredSize(buttonDimension);
		editButton = new JButton("Edit");
		editButton.setFont(smallFont);
		editButton.addActionListener(new ButtonListener());
		editButton.setPreferredSize(buttonDimension);
		editButton.setBackground(new Color(235, 73, 52));
		
		//Labels
		profileLabel = new JLabel("Profile");
		profileLabel.setFont(mainFont);
		usernameLabel = new JLabel("Username");
		fullnameLabel = new JLabel("Full Name");
		emailLabel = new JLabel("Email");
		passwordLabel = new JLabel("Password");
		phoneLabel = new JLabel("Phone");
		paymentLabel = new JLabel("Payment Methods");
		
		//Textfields
		usernameTF = new JTextField(25);
		usernameTF.setText(theCustomer.username);
		usernameTF.setEditable(false);
		fullnameTF = new JTextField(25);
		fullnameTF.setText(theCustomer.fullname);
		fullnameTF.setEditable(false);
		emailTF = new JTextField(25);
		emailTF.setText(theCustomer.email);
		emailTF.setEditable(false);
		passwordTF = new JTextField(25);
		passwordTF.setText(theCustomer.password);
		passwordTF.setEditable(false);
		phoneTF = new JTextField(25);
		phoneTF.setText(theCustomer.phone);
		phoneTF.setEditable(false);
		
		setLayout(new GridLayout(0,1));
		
		add(new JPanel());
		
		JPanel profileRow = new JPanel(new BorderLayout());
		profileRow.add(backButton, BorderLayout.WEST);
		JPanel spacing = new JPanel();
		spacing.add(profileLabel);
		profileRow.add(spacing, BorderLayout.CENTER);
		profileRow.add(editButton, BorderLayout.EAST);
		add(profileRow);
		
		add(new JPanel());
		
		JPanel usernameRow = new JPanel();
		usernameRow.add(usernameLabel);
		usernameRow.add(usernameTF);
		add(usernameRow);
		
		JPanel fullnameRow = new JPanel();
		fullnameRow.add(fullnameLabel);
		fullnameRow.add(fullnameTF);
		add(fullnameRow);
		
		JPanel emailRow = new JPanel();
		emailRow.add(emailLabel);
		emailRow.add(emailTF);
		add(emailRow);
		
		JPanel passwordRow = new JPanel();
		passwordRow.add(passwordLabel);
		passwordRow.add(passwordTF);
		add(passwordRow);
		
		JPanel phoneRow = new JPanel();
		phoneRow.add(phoneLabel);
		phoneRow.add(phoneTF);
		add(phoneRow);
		
		if(theCustomer.payments.length > 0) {
			add(paymentLabel);
			for(int i = 0; i < theCustomer.payments.length; i++) {
				JPanel row = new JPanel();
				row.add(new JLabel("Method #" + Integer.toString(i+1)));
				JTextField paymentMethod = new JTextField(12);
				String type = theCustomer.payments[i].cardType;
				String acnt = theCustomer.payments[i].accountNumber;
				String lastFour;
				if(acnt.length()>3)
					lastFour = acnt.substring(acnt.length()-4);
				else
					lastFour = "INVALID";
				paymentMethod.setText(type + "-" + lastFour);
				paymentMethod.setEditable(false);
				row.add(paymentMethod);
				add(row);
			}
			}
	}
	
	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == backButton) {
				customerMenu theMenu = new customerMenu(theFrame, theCustomer, myMenu);
				theFrame.remove(thePanel);
				theFrame.add(theMenu);
				theFrame.invalidate();
				theFrame.validate();
			}
			else if(e.getSource() == editButton) {
				editProfile newEditProfilePanel = new editProfile(theFrame, theCustomer, myMenu);
				theFrame.remove(thePanel);
				theFrame.add(newEditProfilePanel);
				theFrame.invalidate();
				theFrame.validate();
			}
		}
	}
}
