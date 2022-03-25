import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class editProfile extends JScrollPane{
	
	//JFrame we are working in
	JFrame myFrame;
	editProfile thisPanel = this;
	
	//Panels
	JPanel mainPane;
	JPanel paymentPanels[];
	//Customer accessing menu
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
	
	
	public editProfile(JFrame theFrame, customer theCustomer) {
		//create a new customer object with the same information as the the original customer
		//this customer object will be the object we change as we interact
		editedCustomer = new customer();
		editedCustomer.email = theCustomer.email;
		editedCustomer.fullname = theCustomer.fullname;
		editedCustomer.password = theCustomer.password;
		editedCustomer.phone = theCustomer.phone;
		editedCustomer.username = theCustomer.username;
		for(int i = 0; i < theCustomer.payments.length; i++) {
			editedCustomer.payments[i].accountNumber = theCustomer.payments[i].accountNumber;
			editedCustomer.payments[i].address1 = theCustomer.payments[i].address1;
			editedCustomer.payments[i].address2 = theCustomer.payments[i].address2;
			editedCustomer.payments[i].cardType = theCustomer.payments[i].cardType;
			editedCustomer.payments[i].city = theCustomer.payments[i].city;
			editedCustomer.payments[i].cvv = theCustomer.payments[i].cvv;
			editedCustomer.payments[i].expireDate = theCustomer.payments[i].expireDate;
			editedCustomer.payments[i].name = theCustomer.payments[i].name;
			editedCustomer.payments[i].state = theCustomer.payments[i].state;
			editedCustomer.payments[i].zip = theCustomer.payments[i].zip;
		}
		
		//the frame we interact with
		myFrame = theFrame;
		
		//Font Setup
		Font mainFont = new Font("Futura", Font.ITALIC, 25);
		Font smallFont = new Font("Futura", Font.ITALIC, 13);
		
		//Button setup
		Dimension buttonDimension = new Dimension(90,30);
		cancelButton = new JButton("Cancel");
		cancelButton.setFont(mainFont);
		cancelButton.addActionListener(new ButtonListener());
		cancelButton.setPreferredSize(buttonDimension);
		saveButton = new JButton("Submit");
		saveButton.setFont(smallFont);
		saveButton.addActionListener(new ButtonListener());
		saveButton.setPreferredSize(buttonDimension);
		saveButton.setBackground(new Color(235, 73, 52));
		
		//Label setup
		profileLabel = new JLabel("Edit Profile");
		profileLabel.setFont(mainFont);
		userNameLabel = new JLabel("Username");
		userNameLabel.setFont(smallFont);
		fullNameLabel = new JLabel("Full Name");
		fullNameLabel.setFont(smallFont);
		emailLabel = new JLabel("Email");
		emailLabel.setFont(smallFont);
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(smallFont);
		phoneLabel = new JLabel("Phone");
		phoneLabel.setFont(smallFont);
		paymentLabel = new JLabel("Payment Methods");
		paymentLabel.setFont(smallFont);
		
		//Textfield setup
		userNameTF = new JTextField(25);
		userNameTF.setText(editedCustomer.username);
		fullNameTF = new JTextField(25);
		fullNameTF.setText(editedCustomer.fullname);
		emailTF = new JTextField(25);
		emailTF.setText(editedCustomer.email);
		passwordTF = new JTextField(25);
		passwordTF.setText(editedCustomer.password);
		phoneTF = new JTextField(25);
		phoneTF.setText(editedCustomer.phone);
		
		//format
		Dimension textFieldDimension = userNameTF.getPreferredSize();
		
		Dimension profileDim = profileLabel.getPreferredSize();
		Dimension usernameDim = userNameLabel.getPreferredSize();
		Dimension fullDim = fullNameLabel.getPreferredSize();
		Dimension mailDim = emailLabel.getPreferredSize();
		Dimension passwordDim = passwordLabel.getPreferredSize();
		Dimension phoneDim = phoneLabel.getPreferredSize();
		Dimension paymentDim = paymentLabel.getPreferredSize();
		
		mainPane = new JPanel();
		mainPane.setLayout(new GridLayout(0,1));
		
		JPanel editProfileRow = new JPanel();
		JPanel usernameRow = new JPanel();
		JPanel fullnameRow = new JPanel();
		JPanel emailRow = new JPanel();
		JPanel passwordRow = new JPanel();
		JPanel phoneRow = new JPanel();
		JPanel paymentRow = new JPanel();
		
		
		editProfileRow.add(profileLabel);
		mainPane.add(editProfileRow);
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
					
					JLabel method = new JLabel("Method " + Integer.toString(i + 1));
					mainPane.add(method);
					
					JLabel accountLab = new JLabel("Account Number");
					JTextField accTF = new JTextField(25);
					accTF.setText(currentPayment.accountNumber);
					accTF.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currentPayment.accountNumber = accTF.getText();
						}
					});
					JPanel accountRow = new JPanel();
					accountRow.add(accountLab);
					accountRow.add(accTF);
					mainPane.add(accountRow);
					
					JLabel nameLab = new JLabel("Name");
					JTextField nameTF = new JTextField(25);
					nameTF.setText(currentPayment.name);
					nameTF.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currentPayment.name = nameTF.getText();
						}
					}
					);
					JPanel nameRow = new JPanel();
					nameRow.add(nameLab);
					nameRow.add(nameTF);
					mainPane.add(nameRow);
					
					JLabel expLab = new JLabel("Expiration Date");
					JTextField expTF = new JTextField(25);
					expTF.setText(currentPayment.expireDate);
					expTF.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currentPayment.expireDate = expTF.getText();
						}
					});
					JPanel expRow = new JPanel();
					expRow.add(expLab);
					expRow.add(expTF);
					mainPane.add(expRow);
					
					JLabel cvvLab = new JLabel("CVV");
					JTextField cvvTF = new JTextField(25);
					cvvTF.setText(currentPayment.cvv);
					cvvTF.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currentPayment.cvv = cvvTF.getText();
						}
					});
					JPanel cvvRow = new JPanel();
					cvvRow.add(cvvLab);
					cvvRow.add(cvvTF);
					mainPane.add(cvvRow);
					
					JLabel addressOneLab = new JLabel("Address 1");
					JTextField adrsOneTF = new JTextField(25);
					adrsOneTF.setText(currentPayment.address1);
					adrsOneTF.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currentPayment.address1 = adrsOneTF.getText();
						}
					});
					JPanel addressOneRow = new JPanel();
					addressOneRow.add(addressOneLab);
					addressOneRow.add(adrsOneTF);
					mainPane.add(addressOneRow);
					
					JLabel addressTwoLab = new JLabel("Address 2 (Optional)");
					JTextField adrsTwoTF = new JTextField(25);
					adrsTwoTF.setText(currentPayment.address2);
					adrsTwoTF.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currentPayment.address2 = adrsTwoTF.getText();
						}
					});
					JPanel addressTwoRow = new JPanel();
					addressTwoRow.add(addressTwoLab);
					addressTwoRow.add(adrsTwoTF);
					mainPane.add(addressTwoRow);
					
					JLabel cityLab = new JLabel("City");
					JTextField cityTF = new JTextField(25);
					cityTF.setText(currentPayment.city);
					cityTF.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currentPayment.city = cityTF.getText();
						}
					});
					JPanel cityRow = new JPanel();
					cityRow.add(cityLab);
					cityRow.add(cityTF);
					mainPane.add(cityRow);
					
					JLabel stateLab = new JLabel("State");
					JTextField stateTF = new JTextField(25);
					stateTF.setText(currentPayment.state);
					stateTF.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currentPayment.state = stateTF.getText();
						}
					});
					JPanel stateRow = new JPanel();
					stateRow.add(stateLab);
					stateRow.add(stateTF);
					mainPane.add(stateRow);
					
					JLabel zipLab = new JLabel("Zip Code");
					JTextField zipTF = new JTextField(25);
					zipTF.setText(currentPayment.zip);
					zipTF.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currentPayment.zip = zipTF.getText();
						}
					});
					JPanel zipRow = new JPanel();
					zipRow.add(zipLab);
					zipRow.add(zipTF);
					mainPane.add(zipRow);
				}
		}	
		
		setSize(new Dimension(myFrame.getWidth(), myFrame.getHeight()));
		this.getViewport().add(mainPane);
		this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//tbd
			if(e.getSource() == cancelButton)
				editedCustomer.phone = "foo";
			else if(e.getSource() == saveButton)
				editedCustomer.email = "foo";
		}
	}
}
