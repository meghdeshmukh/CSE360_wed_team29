import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



public class signup extends JPanel{
	//JFrame we are working in
	 JFrame myframe;
	
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
	private JLabel formatError;
	private JLabel passwordError;
	
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
		formatError = new JLabel("Ensure phone and email are in correct format");
		formatError.setVisible(false);
		formatError.setFont(smallFont);
		formatError.setForeground(Color.RED);
		passwordError = new JLabel("Passwords do not match");
		passwordError.setVisible(false);
		passwordError.setFont(smallFont);
		passwordError.setForeground(Color.RED);
		
		//setup textFields
		usernameTF = new JTextField( 25);
		emailTF = new JTextField(25);
		passwordTF = new JTextField(25);
		confirmPasswordTF = new JTextField(25);
		phoneTF = new JTextField(25);
		
		//setup checkBox
		tos = new JCheckBox("Click to agree to our Terms of Service");
		tos.setFont(smallFont);
		
		//setup panel
		setBackground(new Color(139,196,235));     		
		setPreferredSize(new Dimension(770, 485)); 		
		
		//setup layout
		//in order from topmost to bottom
		// Panel is 770 W and 485 H
		// TF are 279 W and 20 H
		// signup label is 79 W and 33 H
		// username label is 117 W and 33 H
		setLayout(null);
		Dimension sizeSignLabel = signupLabel.getPreferredSize();
		signupLabel.setBounds(345,60, sizeSignLabel.width, sizeSignLabel.height);
		
		Dimension sizeUserLabel = usernameLabel.getPreferredSize();
		usernameLabel.setBounds(140, 105, sizeUserLabel.width, sizeUserLabel.height);
		Dimension sizeUserTF = usernameTF.getPreferredSize();
		usernameTF.setBounds(360, 105 + 10, sizeUserTF.width, sizeUserTF.height);
		
		Dimension sizeMailLabel = emailLabel.getPreferredSize();
		emailLabel.setBounds(140, 140, sizeMailLabel.width, sizeMailLabel.height);
		Dimension sizeMailTF = emailTF.getPreferredSize();
		emailTF.setBounds(360, 140 + 10, sizeMailTF.width, sizeMailTF.height);
		
		Dimension sizePWLabel = passwordLabel.getPreferredSize();
		passwordLabel.setBounds(140, 175, sizePWLabel.width, sizePWLabel.height);
		Dimension sizePWTF = passwordTF.getPreferredSize();
		passwordTF.setBounds(360, 175 + 10, sizePWTF.width, sizePWTF.height);
		
		Dimension sizeConfirmPWLabel = confirmPasswordLabel.getPreferredSize();
		confirmPasswordLabel.setBounds(140, 210, sizeConfirmPWLabel.width, sizeConfirmPWLabel.height);
		Dimension sizeConfirmPWTF = confirmPasswordTF.getPreferredSize();
		confirmPasswordTF.setBounds(360, 210 + 10, sizeConfirmPWTF.width, sizeConfirmPWTF.height);

		Dimension sizePhoneLabel = phoneLabel.getPreferredSize();
		phoneLabel.setBounds(140, 245, sizePhoneLabel.width, sizePhoneLabel.height);
		Dimension sizePhoneTF = phoneTF.getPreferredSize();
		phoneTF.setBounds(360, 245 + 10, sizePhoneTF.width, sizePhoneTF.height);
		
		Dimension sizeTOS = tos.getPreferredSize();
		tos.setBounds(262, 285, sizeTOS.width, sizeTOS.height);
		
		Dimension sizeFormatError = formatError.getPreferredSize();
		formatError.setBounds(254, 320, sizeFormatError.width, sizeFormatError.height);
		Dimension sizePasswordError = passwordError.getPreferredSize();
		passwordError.setBounds(313,320, sizePasswordError.width, sizePasswordError.height);
		
		submitButton.setBounds(197, 350, buttonDimension.width, buttonDimension.height);
		cancelButton.setBounds(484, 350, buttonDimension.width, buttonDimension.height);
		
		//add elements
		add(signupLabel);
		add(usernameLabel);
		add(usernameTF);
		add(emailLabel);
		add(emailTF);
		add(passwordLabel);
		add(passwordTF);
		add(confirmPasswordLabel);
		add(confirmPasswordTF);
		add(phoneLabel);
		add(phoneTF);
		add(tos);
		add(formatError);
		add(passwordError);
		add(submitButton);
		add(cancelButton);
	} //signup()
	
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cancelButton) {
				///eturn to login screen, demo to new login frame atm
				 JFrame loginFrame = new JFrame("Login");
				 loginFrame.getContentPane().add(new signup(loginFrame));
				 loginFrame.pack();
				 loginFrame.setLocationRelativeTo(null);
				 loginFrame.setVisible(true);
				 myframe.setVisible(false);
				 myframe.dispose();
			}
			
			else if(e.getSource() == submitButton) {
				formatError.setVisible(false);
				passwordError.setVisible(false);
				
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
				
				if (!passwordInput.equals(confirmPasswordInput) || passwordInput.equals(""))
					passwordError.setVisible(true);
				else if(!emailFormat || !phoneFormat)
					formatError.setVisible(true);
				else {
					//create a new customer and insert into database
					
					//go to menu
				}
				
			}//submitButton
		}//actionPerformed
	}//Button listener
	
	//test main, remove as needed
	public static void main(String[] args) {
		JFrame testFrame = new JFrame("test frame");
		signup testSignup = new signup(testFrame);
		
		
		testFrame.add(testSignup);
		testFrame.setSize(900,900);
		testFrame.pack();
		testFrame.setLocationRelativeTo(null);
		testFrame.show();	

	}
} //end of signup panel