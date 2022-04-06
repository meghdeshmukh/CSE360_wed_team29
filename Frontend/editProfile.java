package Frontend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Backend.Application;
import Backend.Customer;
import Backend.Payment;


//Implemented

@SuppressWarnings("serial")
public class editProfile extends JScrollPane{
	
	//JFrame we are working in
	JFrame myFrame;
	editProfile thisPanel = this;
	Application myApplication;
	
	//Panels
	JPanel mainPane;
	
	//ArrayLists
	ArrayList<Payment> payments = new ArrayList<Payment>();
	
	//Customer accessing menu
	Customer myCustomer;
	
	//Buttons
	public JButton cancelButton;
	public JButton saveButton;
	public JButton morePayment;
	
	//Labels
	private JLabel profileLabel;
	private JLabel userNameLabel;
	private JLabel fullNameLabel; 
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JLabel phoneLabel;
	private JLabel paymentLabel;
	
	//Textfield
	private JTextField userNameTF;
	private JTextField fullNameTF;
	private JTextField emailTF;
	private JTextField passwordTF;
	private JTextField phoneTF;
	
	
	public editProfile(JFrame theFrame, Application application, Customer theCustomer) {
		//create a new customer object with the same information as the the original customer
		//this customer object will be the object we change as we interact
		myCustomer = theCustomer;
		
		//the frame we interact with
		myFrame = theFrame;
		myApplication = application;
		
		mainPane = new JPanel();
		mainPane.setLayout(new GridLayout(0,1));
		
		Font mainFont = new Font("Futura", Font.ITALIC, 25);
		Font smallFont = new Font("Futura", Font.ITALIC, 13);
		
		//Payment setup
		for(int i = 0; i < myCustomer.getPayments().size(); i++) {
			Payment srcPay = myCustomer.getPayments().get(i);
			Payment payment = new Payment(srcPay.getCardType(), srcPay.getAccountNumber(), srcPay.getCardHolderName(), srcPay.getExpireDate(),srcPay.getCVV(), srcPay.getAddressOne(), srcPay.getAddressTwo(), srcPay.getCity(), srcPay.getState(), srcPay.getZIP());
			payments.add(payment);
		}
		
		//Button setup
		Dimension buttonDimension = new Dimension(90,30);
		cancelButton = new JButton("Cancel");
		cancelButton.setFont(smallFont);
		cancelButton.addActionListener(new ButtonListener());
		cancelButton.setPreferredSize(buttonDimension);
		saveButton = new JButton("Submit");
		saveButton.setFont(smallFont);
		saveButton.addActionListener(new ButtonListener());
		saveButton.setPreferredSize(buttonDimension);
		saveButton.setBackground(new Color(235, 73, 52));
		morePayment = new JButton("Add another payment method");
		morePayment.setFont(smallFont);
		morePayment.addActionListener(new ButtonListener());
		morePayment.setBorderPainted(false);
		morePayment.setContentAreaFilled(false);
		morePayment.setForeground(Color.GREEN);
		
		//Label setup
		profileLabel = new JLabel("Edit Profile");
		profileLabel.setFont(mainFont);
		userNameLabel = new JLabel("Username");
		fullNameLabel = new JLabel("Full Name");
		emailLabel = new JLabel("Email");
		passwordLabel = new JLabel("Password");
		phoneLabel = new JLabel("Phone");
		paymentLabel = new JLabel("Payment Methods");
		paymentLabel.setFont(new Font("Futura", Font.PLAIN, 18));
		
		//Textfield setup
		userNameTF = new JTextField(25);
		userNameTF.setText(myCustomer.getUsername());
		fullNameTF = new JTextField(25);
		fullNameTF.setText(myCustomer.getName());
		emailTF = new JTextField(25);
		emailTF.setText(myCustomer.getEmail());
		passwordTF = new JTextField(25);
		passwordTF.setText(myCustomer.getPassword());
		phoneTF = new JTextField(25);
		phoneTF.setText(myCustomer.getPhone());
		
		updateProfileMenu();
		
		setSize(new Dimension(myFrame.getWidth(), myFrame.getHeight()));
		this.getViewport().add(mainPane);
		this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.getVerticalScrollBar().setUnitIncrement(10);
		
		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			viewProfile newViewProfilePanel;
			if(e.getSource() == cancelButton) {
				
				newViewProfilePanel = new viewProfile(myFrame, myApplication, myCustomer);
				myFrame.remove(thisPanel);
				myFrame.add(newViewProfilePanel);
				myFrame.invalidate();
				myFrame.validate();
			}
			else if(e.getSource() == saveButton) {
				saveInformation();
				newViewProfilePanel = new viewProfile(myFrame, myApplication, myCustomer);
				myFrame.remove(thisPanel);
				myFrame.add(newViewProfilePanel);
				myFrame.invalidate();
				myFrame.validate();
			}
			else if(e.getSource() == morePayment) {
				Payment newPayment= new Payment("", "", "", "", 0,"", "", "", "", 0);
				payments.add(newPayment);
				updateProfileMenu();
			}
		}
	}
	
	public void updateProfileMenu() {
		//Font Setup
		mainPane.removeAll();
		JPanel editProfileRow = new JPanel();
		JPanel usernameRow = new JPanel();
		JPanel fullnameRow = new JPanel();
		JPanel emailRow = new JPanel();
		JPanel passwordRow = new JPanel();
		JPanel phoneRow = new JPanel();
		
		mainPane.add(new JPanel());
		editProfileRow.setLayout(new BorderLayout());
		editProfileRow.add(cancelButton, BorderLayout.WEST);
		JPanel centerPanel = new JPanel();
		centerPanel.add(profileLabel);
		editProfileRow.add(centerPanel, BorderLayout.CENTER);
		editProfileRow.add(saveButton, BorderLayout.EAST);
		mainPane.add(editProfileRow);
		mainPane.add(new JPanel());
		usernameRow.add(userNameLabel);
		usernameRow.add(userNameTF);
		mainPane.add(usernameRow);
		fullnameRow.add(fullNameLabel);
		fullnameRow.add(fullNameTF);
		mainPane.add(fullnameRow);
		emailRow.add(emailLabel);
		emailRow.add(emailTF);
		mainPane.add(emailRow);
		passwordRow.add(passwordLabel);
		passwordRow.add(new JLabel(" "));
		passwordRow.add(passwordTF);
		mainPane.add(passwordRow);
		phoneRow.add(phoneLabel);
		phoneRow.add(phoneTF);
		mainPane.add(phoneRow);		
		
		if(payments.size() > 0) {
			JPanel indent = new JPanel();
			indent.add(paymentLabel);
			mainPane.add(indent);
			for(int i = 0; i < payments.size(); i++) {
				Payment currentPayment = payments.get(i);
				
				JPanel methodRow = new JPanel();
				JLabel method = new JLabel("Method " + Integer.toString(i + 1));
				JButton removeButton = new JButton("Delete");
				int index = i;
				removeButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						payments.remove(index);	
						updateProfileMenu();
					}						
				});
				removeButton.setBackground(Color.RED);
				methodRow.add(method);
				methodRow.add(removeButton);
				mainPane.add(methodRow);
				
				JLabel typeLab = new JLabel("Type");
				JTextField typeTF = new JTextField(25);
				typeTF.setText(currentPayment.getCardType());
				connect(typeTF, currentPayment, 0);
				JPanel typeRow = new JPanel();
				typeRow.add(typeLab);
				typeRow.add(typeTF);
				mainPane.add(typeRow);
				
				JLabel accountLab = new JLabel("Account Number");
				JTextField accTF = new JTextField(25);
				accTF.setText(currentPayment.getAccountNumber());
				connect(accTF, currentPayment, 1);
				JPanel accountRow = new JPanel();
				accountRow.add(accountLab);
				accountRow.add(accTF);
				mainPane.add(accountRow);
				
				JLabel nameLab = new JLabel("Name");
				JTextField nameTF = new JTextField(25);
				nameTF.setText(currentPayment.getCardHolderName());
				connect(nameTF, currentPayment, 2);
				JPanel nameRow = new JPanel();
				nameRow.add(nameLab);
				nameRow.add(nameTF);
				mainPane.add(nameRow);
				
				JLabel expLab = new JLabel("Expiration Date");
				JTextField expTF = new JTextField(25);
				expTF.setText(currentPayment.getExpireDate());
				connect(expTF, currentPayment, 3);
				JPanel expRow = new JPanel();
				expRow.add(expLab);
				expRow.add(expTF);
				mainPane.add(expRow);
				
				JLabel cvvLab = new JLabel("CVV");
				JTextField cvvTF = new JTextField(25);
				cvvTF.setText(Integer.toString(currentPayment.getCVV()));	
				connect(cvvTF, currentPayment, 4);
				JPanel cvvRow = new JPanel();
				cvvRow.add(cvvLab);
				cvvRow.add(cvvTF);
				mainPane.add(cvvRow);
				
				JLabel addressOneLab = new JLabel("Address 1");
				JTextField adrsOneTF = new JTextField(25);
				adrsOneTF.setText(currentPayment.getAddressOne());
				connect(adrsOneTF, currentPayment, 5);
				JPanel addressOneRow = new JPanel();
				addressOneRow.add(addressOneLab);
				addressOneRow.add(adrsOneTF);
				mainPane.add(addressOneRow);
				
				JLabel addressTwoLab = new JLabel("Address 2 (Optional)");
				JTextField adrsTwoTF = new JTextField(25);
				adrsTwoTF.setText(currentPayment.getAddressTwo());
				connect(adrsTwoTF, currentPayment, 6);
				JPanel addressTwoRow = new JPanel();
				addressTwoRow.add(addressTwoLab);
				addressTwoRow.add(adrsTwoTF);
				mainPane.add(addressTwoRow);
				
				JLabel cityLab = new JLabel("City");
				JTextField cityTF = new JTextField(25);
				cityTF.setText(currentPayment.getCity());
				connect(cityTF, currentPayment, 7);
				JPanel cityRow = new JPanel();
				cityRow.add(cityLab);
				cityRow.add(cityTF);
				mainPane.add(cityRow);
				
				JLabel stateLab = new JLabel("State");
				JTextField stateTF = new JTextField(25);
				stateTF.setText(currentPayment.getState());
				connect(stateTF, currentPayment, 8);
				JPanel stateRow = new JPanel();
				stateRow.add(stateLab);
				stateRow.add(stateTF);
				mainPane.add(stateRow);
				
				JLabel zipLab = new JLabel("Zip Code");
				JTextField zipTF = new JTextField(25);
				zipTF.setText(Integer.toString(currentPayment.getZIP()));
				connect(zipTF, currentPayment, 9);
				JPanel zipRow = new JPanel();
				zipRow.add(zipLab);
				zipRow.add(zipTF);
				mainPane.add(zipRow);
				
				mainPane.add(new JPanel());
				
			}
		}	
		else
			mainPane.add(new JPanel());
	
		JPanel addPaymentRow = new JPanel();
		addPaymentRow.add(morePayment);
		mainPane.add(addPaymentRow);
		
		mainPane.add(new JPanel());
	
		myFrame.invalidate();
		myFrame.validate();
	}
	
	private void saveInformation() {
		myCustomer.changeEmail(emailTF.getText());
		myCustomer.changeUsername(userNameTF.getText());
		myCustomer.changeName(fullNameTF.getText());
		myCustomer.changePhone(phoneTF.getText());
		myCustomer.changePassword(passwordTF.getText());
		myCustomer.changePhone(phoneTF.getText());
		List<Payment> customerPayments = myCustomer.getPayments();
		customerPayments.clear();
		for(int i = 0; i < payments.size(); i++) {
			customerPayments.add(payments.get(i));
		}
	}
	
	private void connect(JTextField textfield, Payment paymentComp, int comp) {
		textfield.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updatePayment();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				updatePayment();	
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				updatePayment();	
			}
			public void updatePayment() {
				if(comp == 0) 
					paymentComp.setCardType(textfield.getText());
				else if(comp == 1)
					paymentComp.setAccountNumber(textfield.getText());
				else if(comp == 2)
					paymentComp.setCardHolderName(textfield.getText());
				else if(comp == 3)
					paymentComp.setExpireDate(textfield.getText());
				else if(comp == 4) {
					try{
						paymentComp.setCVV(Integer.parseInt(textfield.getText()));
					}
					catch(NumberFormatException e) {
						paymentComp.setCVV(-1);
					}
				}
				else if(comp == 5)
					paymentComp.setAddressOne(textfield.getText());
				else if(comp == 6)
					paymentComp.setAddressTwo(textfield.getText());
				else if(comp == 7)
					paymentComp.setCity(textfield.getText());
				else if(comp == 8)
					paymentComp.setState(textfield.getText());
				else if(comp == 9) {
					try {
						paymentComp.setZIP(Integer.parseInt(textfield.getText()));
					}
					catch(NumberFormatException e) {
						paymentComp.setZIP(-1);
					}
				}
			}
		});
	}
	
	
}