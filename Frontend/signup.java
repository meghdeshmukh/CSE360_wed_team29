import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class signup extends JPanel{
	//JFrame we are working in
	JFrame myframe;
	signup thisPanel;
	
	//Buttons
	public JButton submitButton;
	public JButton cancelButton;
	
	//labels
	private JLabel signupLabel;
	private JLabel usernameLabel;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JLabel confirmPasswordLabel;
	private JLabel phoneLabel;
	private JLabel error;
	
	//textfields
	private JTextField usernameTF;
	private JTextField emailTF;
	private JTextField passwordTF;
	private JTextField confirmPasswordTF;
	private JTextField phoneTF;
	
	//checkboxes
	 JCheckBox tos;
	 
	 //valid email domains
	 String[] emailDomains = {"@gmail.com", "@yahoo.com", "@outlook.com", "@asu.edu", "@email.com"};
	 
	 public signup(JFrame myFrame){
		Font mainFont = new Font("Futura", Font.ITALIC, 25);
		Font smallFont = new Font("Futura", Font.ITALIC, 13);
		myframe = myFrame;
		thisPanel = this;    		
		//setPreferredSize(new Dimension(770, 485)); 	
		setPreferredSize(new Dimension(myframe.getWidth(), myframe.getHeight()));
		
		//setup Button
		Dimension buttonDimension = new Dimension(90, 30);
		submitButton = new JButton("Submit");
		submitButton.setFont(smallFont);
		submitButton.addActionListener(new ButtonListener());
		submitButton.setPreferredSize(buttonDimension);
		submitButton.setBackground(new Color(235, 73, 52));
		cancelButton = new JButton("Cancel");
		cancelButton.setFont(smallFont);
		cancelButton.addActionListener(new ButtonListener());
		cancelButton.setPreferredSize(buttonDimension);
		
		//setup Label
		signupLabel = new JLabel("Signup");
		signupLabel.setFont(mainFont);
		usernameLabel = new JLabel("Username");
		usernameLabel.setFont(mainFont);
		emailLabel = new JLabel("Email");
		emailLabel.setFont(mainFont);
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(mainFont);
		confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setFont(mainFont);
		phoneLabel = new JLabel("Phone");
		phoneLabel.setFont(mainFont);
		
		//setup error Labels
		error = new JLabel("");
		error.setVisible(false);
		error.setFont(smallFont);
		error.setForeground(Color.RED);
		
		//setup textFields
		usernameTF = new JTextField( 25);
		emailTF = new JTextField(25);
		passwordTF = new JTextField(25);
		confirmPasswordTF = new JTextField(25);
		phoneTF = new JTextField(25);
		
		//setup checkBox
		tos = new JCheckBox("Click to agree to our Terms of Service");
		tos.setFont(smallFont);
		
		//setup layout
		//in order from topmost to bottom
		// Panel is 770 W and 485 H
		// TF are 279 W and 20 H
		// signup label is 79 W and 33 H
		// username label is 117 W and 33 H
		setLayout(new GridLayout(0,1));
		
		JPanel row = new JPanel();
		row.add(signupLabel);
		add(row);
		
		add(new JLabel());
		
		row = new JPanel();
		row.add(usernameLabel);
		row.add(usernameTF);
		add(row);
		
		row = new JPanel();
		row.add(emailLabel);
		row.add(emailTF);
		add(row);
		
		row = new JPanel();
		row.add(passwordLabel);
		row.add(passwordTF);
		add(row);
		
		row = new JPanel();
		row.add(confirmPasswordLabel);
		row.add(confirmPasswordTF);
		add(row);
		
		row = new JPanel();
		row.add(phoneLabel);
		row.add(phoneTF);
		add(row);
		
		row = new JPanel();
		row.add(tos);
		add(row);
		
		row = new JPanel();
		row.add(error);
		add(row);
		
		row = new JPanel();
		row.add(submitButton);
		row.add(new JLabel("           "));
		row.add(cancelButton);
		add(row);
	} //signup()
	
	/*
	 *BUTTONE LISTENER TO BE EXPANDED TO SWITCH BETWEEN SCREENS, REST OF CODE WORKS AS NORMAL 
	 */
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cancelButton) {
				///return to login screen, demo to new login frame atm
				//TBD
				 /*JFrame loginFrame = new JFrame("Login");
				 loginFrame.getContentPane().add(new signup(loginFrame));
				 loginFrame.pack();
				 loginFrame.setLocationRelativeTo(null);
				 loginFrame.setVisible(true);
				 myframe.setVisible(false);
				 myframe.dispose();*/
				signup newSignupPanel = new signup(myframe);
				myframe.remove(thisPanel);
				myframe.add(newSignupPanel);
				myframe.invalidate();
				myframe.validate();
			}
			
			else if(e.getSource() == submitButton) {
				error.setVisible(false);
				
				String usernameInput = usernameTF.getText();
				String emailInput = emailTF.getText();
				String passwordInput = passwordTF.getText();
				String confirmPasswordInput = confirmPasswordTF.getText();
				String phoneInput = phoneTF.getText();
				
				//check if email format is correct
				int emailSize = emailInput.length();
				boolean emailFormat = false;
				if(emailSize > 8) { //minimum length of a possible email would be a@asu.edu, or 9 characters
					for(int i = 0; i < emailDomains.length; i++) {
						if(emailSize > emailDomains[i].length())
							if(emailDomains[i].equals(emailInput.substring(emailSize - emailDomains[i].length()))) { //check to see if the final
								emailFormat = true;
								break;
							}
						emailFormat = false;
					}
				}
				else
					emailFormat = false;
				
				//check if phone format is correct
				int phoneSize = phoneInput.length();
				boolean phoneFormat = false;
				if(phoneSize == 10) { //only valid phone numbers are 10 numbers long with no additional characters
					try {
						Integer.parseInt(phoneInput.substring(0,5));
						Integer.parseInt(phoneInput.substring(5));
						phoneFormat = true;
					}catch (NumberFormatException f) {
						phoneFormat = false;
					}
				}
				else
					phoneFormat = false;
				
				if (!passwordInput.equals(confirmPasswordInput) || passwordInput.equals("")) {
					error.setVisible(true);
					error.setText("Passwords do not match");
				}
				else if(!emailFormat || !phoneFormat) {
					error.setVisible(true);
					error.setText("Formatting is incorrect");
				}
				else if(!tos.isSelected()) {
					error.setVisible(true);
					error.setText("Please agree to our Terms of Service");
				}
				else {
					//create a new customer and insert into database
					//TBD
					//go to menu
					menu testMenu = new menu();
					customer testCustomer = new customer();
					testCustomer.email = emailInput;
					testCustomer.username = usernameInput;
					testCustomer.password = passwordInput;
					testCustomer.phone = phoneInput;
					customerMenu testView = new customerMenu(myframe, testCustomer, testMenu);
					myframe.remove(thisPanel);
					myframe.add(testView);
					myframe.invalidate();
					myframe.validate();
				}
				
			}//submitButton
		}//actionPerformed
	}//Button listener
} //end of signup panel
