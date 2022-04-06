package Frontend;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Backend.Application;
import Backend.Cart;
import Backend.Customer;
import Backend.Food;
import Backend.Owner;
import Backend.User;

import Backend.*;


@SuppressWarnings("serial")
public class login extends JPanel {

		JFrame myFrame;
		Application myApplication;
		Cart myCart;
		login myPanel = this;
	
		
		
		public JLabel email, password, create, resturantName, error, guest;
		private JTextField aemail, apassword;
		private JButton login, createAcc, continueGuest;
		
		public login(JFrame frame, Application application, Cart cart) {
			myFrame = frame;
			myApplication = application;
			myCart = cart;
			
			List<Food> list = myApplication.getMenu().getItems();//ArrayList<Food>
			for(Food foodItem : list) {
				foodItem.getName();
				foodItem.getCalories();
				foodItem.getPrice();
			}
			
			list.get(0).getName();
			
			Font mainFont = new Font("Futura", Font.ITALIC, 25);
			
			resturantName = new JLabel("Welcome to ---!");
			email = new JLabel("Email ");
			password = new JLabel("Password ");
			create = new JLabel("Don't have an account? click here to sign up!");
			error = new JLabel("Incorrent Login Information");
			guest = new JLabel("Or click here to continue as a guest!");
			
			resturantName.setFont(mainFont);
			email.setFont(mainFont);
			password.setFont(mainFont);
			create.setFont(mainFont);
			error.setFont(mainFont);
			guest.setFont(mainFont);
			
			error.setVisible(false);
			
			aemail = new JTextField(25);
			apassword = new JTextField(25);
			
			login = new JButton("Login");
			login.setPreferredSize(new Dimension(150,40));
			login.addActionListener(new ButtonListener());
			createAcc = new JButton("Create Account!");
			createAcc.setPreferredSize(new Dimension(170,40));
			createAcc.addActionListener(new ButtonListener());
			continueGuest = new JButton("Continue as Guest!");
			continueGuest.setPreferredSize(new Dimension(190, 40));
			continueGuest.addActionListener(new ButtonListener());
			
			
			setLayout(new BorderLayout());
			
			JPanel center = new JPanel(new GridLayout(0,1));
			JPanel row = new JPanel();
			
			center.add(new JLabel());
			
			row.add(resturantName);
			center.add(row);
			
			row = new JPanel();
			row.add(email);
			row.add(aemail);
			center.add(row);
			
			row = new JPanel();
			row.add(password);
			row.add(apassword);
			center.add(row);
			
			row = new JPanel();
			row.add(login);
			center.add(row);
			
			row = new JPanel();
			row.add(error);
			center.add(row);
			
			row = new JPanel();
			row.add(create);
			center.add(row);
			
			row = new JPanel();
			row.add(createAcc);
			center.add(row);
			
			row = new JPanel();
			row.add(guest);
			center.add(row);
			
			row = new JPanel();
			row.add(continueGuest);
			center.add(row);
			
			
			center.add(new JLabel());
			
			
			
			add(center, BorderLayout.CENTER);
		}
		
		private class ButtonListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == createAcc) {
					signup signupRequest = new signup(myFrame, myApplication, myCart);
					myFrame.remove(myPanel);
					myFrame.add(signupRequest);
					myFrame.invalidate();
					myFrame.validate();
				}
				else if(e.getSource() == login) {
					error.setVisible(false);
					User myUser = myApplication.searchUser(aemail.getText(), apassword.getText());
					if(myUser == null)
						error.setVisible(true);
					else if(myUser instanceof Customer) {
						Customer myCustomer = (Customer) myUser;
						if(myCart != null)
							for(Food food: myCart.getItems())
								myCustomer.addCart(food);
						customerMenu menuRequest = new customerMenu(myFrame, myApplication, myCustomer);
						myFrame.remove(myPanel);
						myFrame.add(menuRequest);
						myFrame.invalidate();
						myFrame.validate();
					}
					else if(myUser instanceof Owner) {
						Owner myOwner = (Owner) myUser;
						OwnerView ownerLoginRequest = new OwnerView(myFrame, myApplication, myOwner);
						myFrame.remove(myPanel);
						myFrame.add(ownerLoginRequest);
						myFrame.invalidate();
						myFrame.validate();
					}
				}
				else if(e.getSource() == continueGuest) {
					Customer guestCustomer = new Customer();
					if(myCart != null)
						for(Food food: myCart.getItems())
							guestCustomer.addCart(food);
					customerMenu guestMenuRequest = new customerMenu(myFrame, myApplication, guestCustomer);
					myFrame.remove(myPanel);
					myFrame.add(guestMenuRequest);
					myFrame.invalidate();
					myFrame.validate();
				}
			}
		}
		
		public static void main(String[] args) {
			JFrame testFrame = new JFrame("test frame");
			testFrame.setSize(new Dimension(1400, 800));

			Application testApp = new Application();

			testFrame.addWindowListener(new WindowListener() {
				@Override
				public void windowClosed(WindowEvent e) {}
				@Override
				public void windowOpened(WindowEvent e) {}
				@Override
				public void windowClosing(WindowEvent e) {testApp.saveApplication();}
				@Override
				public void windowIconified(WindowEvent e) {}
				@Override
				public void windowDeiconified(WindowEvent e) {}
				@Override
				public void windowActivated(WindowEvent e) {}
				@Override
				public void windowDeactivated(WindowEvent e) {}
			});
			
			
			testApp.restoreApplication();
			login test = new login(testFrame, testApp, null);
			
			testFrame.add(test);
			testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			testFrame.setLocationRelativeTo(null);
			testFrame.setVisible(true);
		}
}