package Frontend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Backend.Application;
import Backend.Customer;
import Backend.Food;
import Backend.Menu;


/*
 * somewhat finished implementation
 * Implement cart screen
 */

@SuppressWarnings("serial")
public class customerMenu extends JPanel{
	JFrame myFrame;
	Application myApplication;
	Menu myMenu;
	customerMenu myPanel = this;
	Customer myCustomer;
	
	JLabel cost;
	
	JButton profile;
	JButton signUp;
	JButton signIn;
	JButton cart;
	JButton logout;
	
	JTextField search = new JTextField(50);
	
	Font mainFont = new Font("Futura", Font.PLAIN, 25);
	Font mediumFont = new Font("Futura", Font.PLAIN ,18);
	Font smallFont = new Font("Futura", Font.ITALIC, 13);
	
	Dimension buttonDimension = new Dimension(120,50);
	
	public customerMenu(JFrame frame, Application application, Customer customer) {
		myFrame = frame;
		myCustomer = customer;
		myApplication = application;
		myMenu = myApplication.getMenu();
		
		try {
			profile = new JButton(myCustomer.getUsername().substring(0, 1));
		}
		catch(Exception e) {
			profile = new JButton("X");
		}
		profile.setFont(mainFont);
		//profile.setSh
		profile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewProfile theProfile = new viewProfile(myFrame, myApplication, myCustomer);
				myFrame.remove(myPanel);
				myFrame.add(theProfile);
				myFrame.invalidate();
				myFrame.validate();
			}
		});
		
		signIn = new JButton("Sign-In");
		signIn.setFont(smallFont);
		signIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login loginRequest = new login(myFrame, myApplication, myCustomer.getCart());
				myFrame.remove(myPanel);
				myFrame.add(loginRequest);
				myFrame.invalidate();
				myFrame.validate();
			}
		});
		
		signUp = new JButton("Sign-Up");
		signUp.setFont(smallFont);
		signUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signup requestSignup = new signup(myFrame, myApplication, myCustomer.getCart());
				myFrame.remove(myPanel); //JPanel or JScrollPane
				myFrame.add(requestSignup);
				myFrame.invalidate();
				myFrame.validate();
			}
		});
		
		logout = new JButton("Log out");
		logout.setFont(smallFont);
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login signoutRequest = new login(myFrame, myApplication, null);
				myFrame.remove(myPanel);
				myFrame.add(signoutRequest);
				myFrame.invalidate();
				myFrame.validate();
			}
		}
			);
		
		cart = new JButton();
		cart.setFont(mediumFont);
		cart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkoutMenu checkout = new checkoutMenu(myFrame, myApplication, myCustomer);
				myFrame.remove(myPanel);
				myFrame.add(checkout);
				myFrame.invalidate();
				myFrame.validate();
			}
		});
		cost = new JLabel();
		cost.setFont(mainFont);
		
		search.setFont(mediumFont);
		
		setLayout(new BorderLayout());
		
		JPanel topRow = new JPanel(new BorderLayout());
		JPanel left = new JPanel();
		if(myCustomer.getIsGuest()) {
			left.add(signIn);
			left.add(new JLabel(" or "));
			left.add(signUp);
		}
		else	{
			left.add(profile);
			left.add(logout);
		}
		topRow.add(left, BorderLayout.WEST);
		JPanel right = new JPanel();
		right.add(cost);
		right.add(cart);
		topRow.add(right, BorderLayout.EAST);
		topRow.add(search, BorderLayout.SOUTH);
		JLabel welcome = new JLabel("Welcome to Restaurant");
		welcome.setFont(mainFont);
		JPanel indent = new JPanel();
		indent.add(welcome);
		topRow.add(indent, BorderLayout.CENTER);
		JPanel searchRow = new JPanel();
		searchRow.add(search);
		topRow.add(searchRow, BorderLayout.SOUTH);
		myPanel.add(topRow, BorderLayout.NORTH);
		updateTop();
		
		JScrollPane menuScroll = new JScrollPane();
		menuScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		menuScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JPanel menuItems = new JPanel();
		menuItems.setLayout(new BoxLayout(menuItems, BoxLayout.Y_AXIS));
		updateMenu(menuItems);
		menuScroll.getViewport().add(menuItems);
		add(menuScroll, BorderLayout.CENTER);
			
		search.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateMenu(menuItems);
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateMenu(menuItems);
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				updateMenu(menuItems);
			}
		});
	}
	
	public void updateMenu(JPanel pane) {
		pane.removeAll();
		Border border = new LineBorder(Color.BLACK, 4, true);
		ArrayList<Food> foodItems = (ArrayList<Food>) myMenu.getItems();
		for(int i = 0; i < myMenu.getCount(); i++) {
			if(foodItems.get(i).getName().toLowerCase().contains(search.getText().toLowerCase()))
			{
				Food theFood = foodItems.get(i);
				JPanel row = new JPanel(new BorderLayout());
				row.setBorder(border);
				JLabel name = new JLabel(theFood.getName());
				name.setFont(mediumFont);
				JLabel price = new JLabel(String.format("$%.2f",theFood.getPrice()));
				price.setFont(mediumFont);
				JButton details = new JButton("Details");
				details.setFont(mediumFont);
				details.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						customerFoodInfo info = new customerFoodInfo(myFrame, myApplication, myCustomer, theFood);
						myFrame.remove(myPanel);
						myFrame.add(info);
						myFrame.invalidate();
						myFrame.validate();
					}
				});
				JButton add = new JButton("Add to Cart");
				add.setFont(mediumFont);
				add.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						myCustomer.addCart(theFood);
						updateTop();
					}
				});
				
				row.add(name, BorderLayout.WEST);
				
				JPanel right = new JPanel(new GridLayout(1,0));
				right.add(price);
				right.add(details);
				right.add(add);
				row.add(right, BorderLayout.EAST);
				pane.add(row);
			}
		}
		
		while(pane.getComponentCount() < 10) {
			JPanel row = new JPanel(new BorderLayout());
			row.setBorder(border);
			pane.add(row);
		}
		
		myPanel.invalidate();
		myPanel.validate();
	}
	
	public void updateTop() {
		cost.setText("$" + String.format("%.2f", myCustomer.getCart().getTotal()));
		cart.setText("Cart: " + Integer.toString(myCustomer.getCart().getItems().size()));
	}
}
