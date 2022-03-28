import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


//need to add functionality from function

public class editProfile extends JScrollPane{
	
	//JFrame we are working in
	JFrame myFrame;
	editProfile thisPanel = this;
	menu myMenu;
	
	//Panels
	JPanel mainPane;
	JPanel paymentPanels[];
	//Customer accessing menu
	customer realCustomer;
	customer editedCustomer;
	
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
	
	
	public editProfile(JFrame theFrame, customer theCustomer, menu menu) {
		//create a new customer object with the same information as the the original customer
		//this customer object will be the object we change as we interact
		realCustomer = theCustomer;
		editedCustomer = new customer();
		copyInformation(editedCustomer, realCustomer);
		
		//the frame we interact with
		myFrame = theFrame;
		myMenu = menu;
		setBackground(new Color(139,196,235));   
		
		//Font Setup
		Font mainFont = new Font("Futura", Font.ITALIC, 25);
		Font smallFont = new Font("Futura", Font.ITALIC, 13);
		
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
		
		//Textfield setup
		userNameTF = new JTextField(25);
		userNameTF.setText(editedCustomer.username);
		connectCustomerToTextField(userNameTF);
		fullNameTF = new JTextField(25);
		fullNameTF.setText(editedCustomer.fullname);
		connectCustomerToTextField(fullNameTF);
		emailTF = new JTextField(25);
		emailTF.setText(editedCustomer.email);
		connectCustomerToTextField(emailTF);
		passwordTF = new JTextField(25);
		passwordTF.setText(editedCustomer.password);
		connectCustomerToTextField(passwordTF);
		phoneTF = new JTextField(25);
		phoneTF.setText(editedCustomer.phone);
		connectCustomerToTextField(phoneTF);
		
		mainPane = new JPanel();
		mainPane.setLayout(new GridLayout(0,1));
		
		JPanel editProfileRow = new JPanel();
		JPanel usernameRow = new JPanel();
		JPanel fullnameRow = new JPanel();
		JPanel emailRow = new JPanel();
		JPanel passwordRow = new JPanel();
		JPanel phoneRow = new JPanel();
		
		//int horizontalOffset = 
		
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
		
		
		if(editedCustomer.payments.length > 0) {
				mainPane.add(paymentLabel);
				for(int i = 0; i < editedCustomer.payments.length; i++) {
					payment currentPayment = editedCustomer.payments[i];
					
					JPanel methodRow = new JPanel();
					JLabel method = new JLabel("Method " + Integer.toString(i + 1));
					JButton removeButton = new JButton("Delete");
					removeButton.setBackground(Color.RED);
					methodRow.add(method);
					methodRow.add(removeButton);
					mainPane.add(methodRow);
					
					JLabel accountLab = new JLabel("Account Number");
					JTextField accTF = new JTextField(25);
					accTF.setText(currentPayment.accountNumber);
					connectCustomerToTextField(accTF, currentPayment, 1);
					JPanel accountRow = new JPanel();
					accountRow.add(accountLab);
					accountRow.add(accTF);
					mainPane.add(accountRow);
					
					JLabel nameLab = new JLabel("Name");
					JTextField nameTF = new JTextField(25);
					nameTF.setText(currentPayment.name);
					connectCustomerToTextField(nameTF, currentPayment, 2);
					JPanel nameRow = new JPanel();
					nameRow.add(nameLab);
					nameRow.add(nameTF);
					mainPane.add(nameRow);
					
					JLabel expLab = new JLabel("Expiration Date");
					JTextField expTF = new JTextField(25);
					expTF.setText(currentPayment.expireDate);
					connectCustomerToTextField(expTF, currentPayment, 3);
					JPanel expRow = new JPanel();
					expRow.add(expLab);
					expRow.add(expTF);
					mainPane.add(expRow);
					
					JLabel cvvLab = new JLabel("CVV");
					JTextField cvvTF = new JTextField(25);
					cvvTF.setText(currentPayment.cvv);
					connectCustomerToTextField(cvvTF, currentPayment, 4);
					JPanel cvvRow = new JPanel();
					cvvRow.add(cvvLab);
					cvvRow.add(cvvTF);
					mainPane.add(cvvRow);
					
					JLabel addressOneLab = new JLabel("Address 1");
					JTextField adrsOneTF = new JTextField(25);
					adrsOneTF.setText(currentPayment.address1);
					connectCustomerToTextField(adrsOneTF, currentPayment, 5);
					JPanel addressOneRow = new JPanel();
					addressOneRow.add(addressOneLab);
					addressOneRow.add(adrsOneTF);
					mainPane.add(addressOneRow);
					
					JLabel addressTwoLab = new JLabel("Address 2 (Optional)");
					JTextField adrsTwoTF = new JTextField(25);
					adrsTwoTF.setText(currentPayment.address2);
					connectCustomerToTextField(adrsTwoTF, currentPayment, 6);
					JPanel addressTwoRow = new JPanel();
					addressTwoRow.add(addressTwoLab);
					addressTwoRow.add(adrsTwoTF);
					mainPane.add(addressTwoRow);
					
					JLabel cityLab = new JLabel("City");
					JTextField cityTF = new JTextField(25);
					cityTF.setText(currentPayment.city);
					connectCustomerToTextField(cityTF, currentPayment, 7);
					JPanel cityRow = new JPanel();
					cityRow.add(cityLab);
					cityRow.add(cityTF);
					mainPane.add(cityRow);
					
					JLabel stateLab = new JLabel("State");
					JTextField stateTF = new JTextField(25);
					stateTF.setText(currentPayment.state);
					connectCustomerToTextField(stateTF, currentPayment, 8);
					JPanel stateRow = new JPanel();
					stateRow.add(stateLab);
					stateRow.add(stateTF);
					mainPane.add(stateRow);
					
					JLabel zipLab = new JLabel("Zip Code");
					JTextField zipTF = new JTextField(25);
					zipTF.setText(currentPayment.zip);
					connectCustomerToTextField(zipTF, currentPayment, 9);
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
		
		setSize(new Dimension(myFrame.getWidth(), myFrame.getHeight()));
		this.getViewport().add(mainPane);
		this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			viewProfile newViewProfilePanel;
			if(e.getSource() == cancelButton) {
				
				newViewProfilePanel = new viewProfile(myFrame, realCustomer, myMenu);
				myFrame.remove(thisPanel);
				myFrame.add(newViewProfilePanel);
				myFrame.invalidate();
				myFrame.validate();
			}
			else if(e.getSource() == saveButton) {
				copyInformation(realCustomer, editedCustomer);
				newViewProfilePanel = new viewProfile(myFrame, realCustomer, myMenu);
				myFrame.remove(thisPanel);
				myFrame.add(newViewProfilePanel);
				myFrame.invalidate();
				myFrame.validate();
				
			}
		}
	}
	
	private void copyInformation(customer destination, customer source) {
		destination.email = source.email;
		destination.fullname = source.fullname;
		destination.password = source.password;
		destination.phone = source.phone;
		destination.username = source.username;
		for(int i = 0; i < source.payments.length; i++) {
			destination.payments[i].accountNumber = source.payments[i].accountNumber;
			destination.payments[i].address1 = source.payments[i].address1;
			destination.payments[i].address2 = source.payments[i].address2;
			destination.payments[i].cardType = source.payments[i].cardType;
			destination.payments[i].city = source.payments[i].city;
			destination.payments[i].cvv = source.payments[i].cvv;
			destination.payments[i].expireDate = source.payments[i].expireDate;
			destination.payments[i].name = source.payments[i].name;
			destination.payments[i].state = source.payments[i].state;
			destination.payments[i].zip = source.payments[i].zip;
		}
	}
	
	private void connectCustomerToTextField(JTextField textfield) {
		textfield.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {updateCustomer();}
			@Override
			public void removeUpdate(DocumentEvent e) {updateCustomer();}
			@Override
			public void changedUpdate(DocumentEvent e) {updateCustomer();}
			public void updateCustomer() {
				
				if(textfield == userNameTF)
					editedCustomer.username = textfield.getText();
				else if(textfield == fullNameTF)
					editedCustomer.fullname = textfield.getText();
				else if(textfield == emailTF)
					editedCustomer.email = textfield.getText();
				else if(textfield == passwordTF)
					editedCustomer.password = textfield.getText();
				else if(textfield == phoneTF)
					editedCustomer.phone = textfield.getText();
			}
		});
	}
	
	private void connectCustomerToTextField(JTextField textfield, payment paymentComp, int comp) {
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
				if(comp == 1)
					paymentComp.accountNumber = textfield.getText();
				else if(comp == 2)
					paymentComp.name = textfield.getText();
				else if(comp == 3)
					paymentComp.expireDate = textfield.getText();
				else if(comp == 4)
					paymentComp.cvv = textfield.getText();
				else if(comp == 5)
					paymentComp.address1 = textfield.getText();
				else if(comp == 6)
					paymentComp.address2 = textfield.getText();
				else if(comp == 7)
					paymentComp.city = textfield.getText();
				else if(comp == 8)
					paymentComp.state = textfield.getText();
				else if(comp == 9)
					paymentComp.zip = textfield.getText();
			}
		});
	}
}

