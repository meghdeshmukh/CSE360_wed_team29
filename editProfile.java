import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class editProfile extends JPanel{
	
	//JFrame we are working in
	JFrame myFrame;
	editProfile thisPanel = this;
	
	//Panels
	JScrollPane scrollPane;
	JPanel mainPane;
	
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
		fullNameTF = new JTextField(25);
		emailTF = new JTextField(25);
		passwordTF = new JTextField(25);
		phoneTF = new JTextField(25);
		
		//format
		Dimension textFieldDimension = userNameTF.getPreferredSize();
		
		Dimension profileDim = profileLabel.getPreferredSize();
		Dimension usernameDim = userNameLabel.getPreferredSize();
		Dimension fullDim = fullNameLabel.getPreferredSize();
		Dimension mailDim = emailLabel.getPreferredSize();
		Dimension passwordDim = passwordLabel.getPreferredSize();
		Dimension phoneDim = phoneLabel.getPreferredSize();
		Dimension paymentDim = paymentLabel.getPreferredSize();
		
		int verticalOffset = (myFrame.getHeight() - (profileDim.height + 6*(textFieldDimension.height + 10)))/2;
		int horizontalOffset = (myFrame.getWidth() - (textFieldDimension.width + paymentDim.width + 10))/2;
		int textFieldOffset = horizontalOffset + paymentDim.width + 10;
		
		profileLabel.setBounds((myFrame.getWidth() - profileDim.width) / 2, verticalOffset, profileDim.width + 10, profileDim.height);
		verticalOffset += profileDim.height + 10;
		userNameLabel.setBounds(horizontalOffset, verticalOffset + 1, usernameDim.width + 10, usernameDim.height);
		userNameTF.setBounds(textFieldOffset, verticalOffset, textFieldDimension.width, textFieldDimension.height);
		verticalOffset += usernameDim.height + 10;
		fullNameLabel.setBounds(horizontalOffset, verticalOffset + 1, fullDim.width + 10, fullDim.height);
		fullNameTF.setBounds(textFieldOffset, verticalOffset, textFieldDimension.width, textFieldDimension.height);
		verticalOffset += fullDim.height + 10;
		emailLabel.setBounds(horizontalOffset, verticalOffset + 1, mailDim.width + 10, mailDim.height);
		emailTF.setBounds(textFieldOffset, verticalOffset, textFieldDimension.width, textFieldDimension.height);
		verticalOffset += mailDim.height + 10;
		passwordLabel.setBounds(horizontalOffset, verticalOffset + 1, passwordDim.width + 10, passwordDim.height);
		passwordTF.setBounds(textFieldOffset, verticalOffset, textFieldDimension.width, textFieldDimension.height);
		verticalOffset += passwordDim.height + 10;
		phoneLabel.setBounds(horizontalOffset, verticalOffset + 1, phoneDim.width + 10, phoneDim.height);
		phoneTF.setBounds(textFieldOffset, verticalOffset + 200, textFieldDimension.width, textFieldDimension.height);
		verticalOffset += phoneDim.height + 10;
		paymentLabel.setBounds(horizontalOffset, verticalOffset + 200, paymentDim.width, paymentDim.height);
		
		phoneTF.setText(Integer.toString(paymentLabel.getPreferredSize().height) + " " + Integer.toString(textFieldDimension.height));
		
		setLayout(new BorderLayout());
		mainPane = new JPanel();
		mainPane.setLayout(null);
		mainPane.add(profileLabel);
		mainPane.add(userNameLabel);
		mainPane.add(userNameTF);
		mainPane.add(fullNameLabel);
		mainPane.add(fullNameTF);
		mainPane.add(emailLabel);
		mainPane.add(emailTF);
		mainPane.add(passwordLabel);
		mainPane.add(passwordTF);
		mainPane.add(phoneLabel);
		mainPane.add(phoneTF);
		mainPane.add(paymentLabel);
		mainPane.setPreferredSize(new Dimension(myFrame.getPreferredSize().width + 10, myFrame.getPreferredSize().height + 10));
		
		JScrollPane scroller = new JScrollPane();
		scroller.setPreferredSize(new Dimension(myFrame.getPreferredSize().width-10, myFrame.getPreferredSize().height-10));
		scroller.getViewport().add(mainPane);
		add(scroller, BorderLayout.CENTER);
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
	
	public static void main(String[] args) {
		JFrame testFrame = new JFrame("test frame profile");
		testFrame.setSize(new Dimension(770, 485));
		
		customer testCustomer = new customer();
		editProfile testSignup = new editProfile(testFrame, testCustomer);
		
		
		
		/*
		JScrollPane testScroll = new JScrollPane();
		JPanel testPanel = new JPanel();
		for(int i = 0; i < 100; i++) {
			JTextField newField = new JTextField(25);
			testPanel.add(newField);
		}
		testScroll.setViewportView(testPanel);
		//JScrollPane testScroll = new JScrollPane(testPanel, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JPanel containter = new JPanel();
		containter.setLayout(new BorderLayout());
		containter.add(testScroll, BorderLayout.CENTER);
		testFrame.add(containter);
		*/
		
		testFrame.add(testSignup);
		
		//testFrame.pack();
		testFrame.setLocationRelativeTo(null);
		testFrame.show();
	}

}

