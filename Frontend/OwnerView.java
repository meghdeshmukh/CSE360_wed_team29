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
import Backend.Food;
import Backend.Menu;
import Backend.Owner;


/*
 * somewhat finished implementation
 * Implement cart screen
 */

@SuppressWarnings("serial")
public class OwnerView extends JPanel{
	JFrame myFrame;
	Application myApplication;
	Menu myMenu;
	OwnerView myPanel = this;
	Owner myOwner;
	
	JLabel cost;
	
	JButton profile;
	JButton createNew;
	JButton repository;
	JButton logout;
	
	JTextField search = new JTextField(50);
	
	Font mainFont = new Font("Futura", Font.PLAIN, 25);
	Font mediumFont = new Font("Futura", Font.PLAIN ,18);
	Font smallFont = new Font("Futura", Font.ITALIC, 13);
	
	Dimension buttonDimension = new Dimension(120,50);
	
	public OwnerView(JFrame frame, Application application, Owner owner) {
		myFrame = frame;
		myOwner = owner;
		myApplication = application;
		myMenu = myApplication.getMenu();
		
		profile = new JButton("Owner View");
		profile.setFont(mainFont);
		//profile.setSh
		profile.setEnabled(false);
		
		createNew = new JButton("Create New Menu Item");
		createNew.setFont(mainFont);
		createNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		repository = new JButton("Enter Customer Repository");
		repository.setFont(mainFont);
		repository.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerRepository repoRequest = new CustomerRepository(myFrame, myApplication);
				myFrame.remove(myPanel);
				myFrame.add(repoRequest);
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
		});
		
		search.setFont(mediumFont);
		
		setLayout(new BorderLayout());
		
		JPanel topRow = new JPanel(new BorderLayout());
		
		JPanel left = new JPanel();
		left.add(profile);
		left.add(logout);
		topRow.add(left, BorderLayout.WEST);
		
		JPanel right = new JPanel(new GridLayout(0,1));
		right.add(createNew);
		right.add(repository);
		topRow.add(right, BorderLayout.EAST);
		topRow.add(search, BorderLayout.SOUTH);
		//TODO return to "Welcome to Restaurant"
		JLabel welcome = new JLabel("Welcome back to Restaurant");
		welcome.setFont(mainFont);
		JPanel indent = new JPanel();
		indent.add(welcome);
		topRow.add(indent, BorderLayout.CENTER);
		JPanel searchRow = new JPanel();
		searchRow.add(search);
		topRow.add(searchRow, BorderLayout.SOUTH);
		myPanel.add(topRow, BorderLayout.NORTH);
		
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
				JButton edit = new JButton("Edit");
				edit.setFont(mediumFont);
				edit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ownerEditItem editRequest = new ownerEditItem(myFrame, myApplication, myOwner, theFood);
						myFrame.remove(myPanel);
						myFrame.add(editRequest);
						myFrame.invalidate();
						myFrame.validate();
					}
				});
				JButton remove = new JButton("Remove");
				remove.setFont(mediumFont);
				remove.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						myApplication.getMenu().remove(theFood);
						updateMenu(pane);
					}
				});
				
				row.add(name, BorderLayout.WEST);
				
				JPanel right = new JPanel(new GridLayout(1,0));
				right.add(price);
				right.add(edit);
				right.add(remove);
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
	
	public static void main(String[] args) {
		JFrame testFrame = new JFrame("test frame profile");
		testFrame.setSize(new Dimension(1400, 800));

		Application testApp = new Application();
		Menu testMenu = new Menu();
		for(int i = 0; i < 120; i++) {
			String[] ing = {"lettuce", "tomato", "souls"};
			Food newFood = new Food("Item #" + Integer.toString(i), "path", ing , (double) (i+1), i+i*10+i*100+i*1000, 5);
			testMenu.add(newFood);
		}
		try {
			testApp.addMenu(testMenu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
		Owner testOwner = new Owner("Owner", "1234");
		try {
			testApp.setOwner(testOwner);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OwnerView test = new OwnerView(testFrame, testApp, testOwner);
		
		testFrame.add(test);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setLocationRelativeTo(null);
		testFrame.setVisible(true);
	}
}
