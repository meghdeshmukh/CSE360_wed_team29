import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class customerMenu extends JPanel{
	JFrame myFrame;
	menu myMenu;
	customerMenu myPanel = this;
	customer myCustomer;
	
	JLabel cost;
	
	JButton profile;
	JButton cart;
	
	JTextField search = new JTextField(50);
	
	Font mainFont = new Font("Futura", Font.ITALIC, 25);
	Font mediumFont = new Font("Futura", Font.PLAIN ,18);
	Font smallFont = new Font("Futura", Font.ITALIC, 13);
	
	Dimension buttonDimension = new Dimension(90,30);
	
	public customerMenu(JFrame frame, customer customer, menu menu) {
		myFrame = frame;
		myCustomer = customer;
		myMenu = menu;
		
		profile = new JButton(myCustomer.username.substring(0, 1));
		profile.setFont(mainFont);
		profile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewProfile theProfile = new viewProfile(myFrame, myCustomer, myMenu);
				myFrame.remove(myPanel);
				myFrame.add(theProfile);
				myFrame.invalidate();
				myFrame.validate();
			}
		});
		
		cart = new JButton("Cart: " + Integer.toString(customer.cart.items.length));
		cart.setSize(buttonDimension);
		cart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		cost = new JLabel("$" + String.format("%.2f", customer.cart.total));
		cost.setFont(mediumFont);
		
		search.setFont(mediumFont);
		
		setLayout(new GridLayout(0,1));
		
		JPanel topRow = new JPanel(new BorderLayout());
		JPanel left = new JPanel();
		left.add(profile);
		topRow.add(left, BorderLayout.WEST);
		JPanel right = new JPanel();
		right.add(cost);
		right.add(cart);
		topRow.add(right, BorderLayout.EAST);
		topRow.add(search, BorderLayout.SOUTH);
		JPanel searchRow = new JPanel();
		searchRow.add(search);
		topRow.add(searchRow, BorderLayout.SOUTH);
		add(topRow);
		
		JScrollPane menuScroll = new JScrollPane();
		menuScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		menuScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JPanel menuItems = new JPanel();
		menuItems.setLayout(new BoxLayout(menuItems, BoxLayout.Y_AXIS));
		updateMenu(menuItems);
		menuScroll.getViewport().add(menuItems);
		add(menuScroll);
		
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
		for(int i = 0; i < myMenu.numItems; i++) {
			if(myMenu.foodItems[i].name.contains(search.getText()))
			{
				food theFood = myMenu.foodItems[i];
				JPanel row = new JPanel(new BorderLayout());
				row.setSize(pane.getWidth(), (int) buttonDimension.getHeight());
				row.setBackground(Color.cyan);
				row.setBorder(border);
				JLabel name = new JLabel(theFood.name);
				name.setFont(mediumFont);
				JLabel price = new JLabel(String.format("$%.2f",theFood.price));
				price.setFont(mediumFont);
				JButton details = new JButton("Details");
				details.setFont(mediumFont);
				details.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						customerFoodInfo info = new customerFoodInfo(myFrame, myCustomer, theFood, myMenu);
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
						// TODO Auto-generated method stub	
					}
				});
				
				row.add(name, BorderLayout.WEST);
				
				JPanel right = new JPanel();
				right.add(price);
				right.add(details);
				right.add(add);
				row.add(right, BorderLayout.EAST);
				pane.add(row);
			}
		}
		pane.invalidate();
		pane.validate();
	}
}
