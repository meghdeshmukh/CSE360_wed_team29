package Frontend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Backend.Application;
import Backend.Customer;

/*
 * functions implemented
 */

@SuppressWarnings("serial")
public class viewProfile extends JPanel{
	
	//the frame we work in
	JFrame theFrame;
	
	Application myApplication;
	
	//the panel
	JPanel thePanel = this;
	
	//the customer
	Customer theCustomer;
	
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
	
	
	public viewProfile(JFrame frame, Application application, Customer customer) {
		theFrame = frame;
		theCustomer = customer;
		myApplication = application;

		
		Font mainFont = new Font("Futura", Font.ITALIC, 25);
		Font smallFont = new Font("Futura", Font.PLAIN, 18); 
		
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
		
		paymentLabel.setFont(smallFont);
		
		//Textfields
		usernameTF = new JTextField(25);
		usernameTF.setText(theCustomer.getUsername());
		usernameTF.setEditable(false);
		fullnameTF = new JTextField(25);
		fullnameTF.setText(theCustomer.getName());
		fullnameTF.setEditable(false);
		emailTF = new JTextField(25);
		emailTF.setText(theCustomer.getEmail());
		emailTF.setEditable(false);
		passwordTF = new JTextField(25);
		passwordTF.setText(theCustomer.getPassword());
		passwordTF.setEditable(false);
		phoneTF = new JTextField(25);
		phoneTF.setText(theCustomer.getPhone());
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
		
		if(theCustomer.getPayments().size() > 0) {
			JPanel indent = new JPanel();
			indent.add(paymentLabel);
			add(indent);
			for(int i = 0; i < theCustomer.getPayments().size(); i++) {
				JPanel row = new JPanel();
				row.add(new JLabel("Method #" + Integer.toString(i+1)));
				JTextField paymentMethod = new JTextField(12);
				paymentMethod.setText(theCustomer.getPayments().get(i).getCardName());
				paymentMethod.setEditable(false);
				row.add(paymentMethod);
				add(row);
			}
		}
		
		if(theCustomer.getCoupons().size() > 0) {
			JPanel row = new JPanel();
			JLabel labelCoupon = new JLabel("Owned Coupons");
			labelCoupon.setFont(smallFont);
			row.add(labelCoupon);
			add(row);
			int i = 1;
			for(Double coupon : theCustomer.getCoupons()) {
				JPanel couponRow = new JPanel();
				JLabel couponIdentifier = new JLabel("Coupon #" + Integer.toString(i));
				JTextField couponAmount = new JTextField(25);
				couponAmount.setText(String.format("$%.2f", coupon));
				couponAmount.setEditable(false);
				couponRow.add(couponIdentifier);
				couponRow.add(couponAmount);
				add(couponRow);
				i++;
				
			}
		}
	}
	
	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == backButton) {
				customerMenu theMenu = new customerMenu(theFrame, myApplication, theCustomer);
				theFrame.remove(thePanel);
				theFrame.add(theMenu);
				theFrame.invalidate();
				theFrame.validate();
			}
			else if(e.getSource() == editButton) {
				editProfile newEditProfilePanel = new editProfile(theFrame, myApplication, theCustomer);
				theFrame.remove(thePanel);
				theFrame.add(newEditProfilePanel);
				theFrame.invalidate();
				theFrame.validate();
			}
		}
	}
}
