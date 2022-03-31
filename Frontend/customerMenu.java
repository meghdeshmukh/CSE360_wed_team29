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
	
	Font mainFont = new Font("Futura", Font.PLAIN, 25);
	Font mediumFont = new Font("Futura", Font.PLAIN ,18);
	Font smallFont = new Font("Futura", Font.ITALIC, 13);
	
	Dimension buttonDimension = new Dimension(120,50);
	
	public customerMenu(JFrame frame, customer customer, menu menu) {
		myFrame = frame;
		myCustomer = customer;
		myMenu = menu;
		
		profile = new JButton(myCustomer.username.substring(0, 1));
		profile.setFont(mainFont);
		//profile.setSh
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
		cart.setFont(mediumFont);
		cart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		cost = new JLabel("$" + String.format("%.2f", customer.cart.total));
		cost.setFont(mainFont);
		
		search.setFont(mediumFont);
		
		setLayout(new BorderLayout());
		
		JPanel topRow = new JPanel(new BorderLayout());
		JPanel left = new JPanel();
		left.add(profile);
		topRow.add(left, BorderLayout.WEST);
		JPanel right = new JPanel();
		right.add(cost);
		right.add(cart);
		topRow.add(right, BorderLayout.EAST);
		topRow.add(search, BorderLayout.SOUTH);
		JLabel welcome = new JLabel("Welcome to Restaurant!");
		//JLabel select = new JLabel("Select Items Below");
		welcome.setFont(mainFont);
		//select.setFont(mainFont);
		JPanel indent = new JPanel();
		indent.add(welcome);
		//indent.add(select);
		topRow.add(indent, BorderLayout.CENTER);
		JPanel searchRow = new JPanel();
		searchRow.add(search);
		topRow.add(searchRow, BorderLayout.SOUTH);
		add(topRow, BorderLayout.NORTH);
		
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
		int unmatched = 0;
		for(int i = 0; i < myMenu.numItems; i++) {
			if(myMenu.foodItems[i].name.contains(search.getText()))
			{
				food theFood = myMenu.foodItems[i];
				JPanel row = new JPanel(new BorderLayout());
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
				
				JPanel right = new JPanel(new GridLayout(1,0));
				right.add(price);
				right.add(details);
				right.add(add);
				row.add(right, BorderLayout.EAST);
				pane.add(row);
			}
			else
				unmatched++;
		}
		for(int i = 0; i < unmatched; i++) {
			JPanel row = new JPanel(new BorderLayout());
			row.setBorder(border);
			JButton nullButton = new JButton("NULL");			
			nullButton.setFont(mediumFont);
			nullButton.setVisible(false);
			JPanel right = new JPanel();
			right.add(nullButton);
			row.add(right, BorderLayout.EAST);
			pane.add(row);
		}
		myPanel.invalidate();
		myPanel.validate();
	}
}
