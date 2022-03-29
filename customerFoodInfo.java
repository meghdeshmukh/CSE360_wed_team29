import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class customerFoodInfo extends JPanel{
	
	
	JFrame myFrame;
	customer myCustomer;
	menu myMenu;
	customerFoodInfo myPanel = this;
	
	JButton back = new JButton("Back");
	JButton add = new JButton("Add to Cart");
	
	JLabel ingredients = new JLabel("Ingredients");
	JLabel price = new JLabel("Price: $");
	JLabel calories = new JLabel("Total Calories: ");
	JLabel name;
	
	BufferedImage foodPic;
	
	Font mainFont = new Font("Futura", Font.ITALIC, 25);
	Font mediumFont = new Font("Futura", Font.PLAIN ,18);
	Font smallFont = new Font("Futura", Font.ITALIC, 13);
	
	Dimension buttonDimension = new Dimension(90,30);
	
	public customerFoodInfo(JFrame frame, customer customer, food food, menu menu) {
		
		myFrame = frame;
		myCustomer = customer;
		myMenu = menu;
		
		back.setSize(buttonDimension);
		back.setFont(smallFont);
		back.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				customerMenu theMenu = new customerMenu(myFrame, myCustomer, myMenu);
				myFrame.remove(myPanel);
				myFrame.add(theMenu);
				myFrame.invalidate();
				myFrame.validate();
			}
		});
		
		add.setSize(buttonDimension);
		add.setFont(smallFont);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO add to cart
			}
		});
		
		price.setText(price.getText() + String.format("%.2f", food.price));
		price.setFont(mediumFont);
		calories.setText(calories.getText() + Integer.toString(food.calories));
		calories.setFont(mediumFont);
		name = new JLabel(food.name);
		name.setFont(mainFont);
		
		setLayout(new GridLayout(0, 1));
		
		JPanel nameRow = new JPanel();
		nameRow.add(name);
		add(nameRow);
		
		JPanel informationRow = new JPanel(new GridLayout(0,5));
		informationRow.add(new JLabel());
		//TODO picture
		try {
			foodPic = ImageIO.read(new File("path to picture"));
			JLabel picLabel = new JLabel(new ImageIcon(foodPic));
			informationRow.add(picLabel);
		} catch (IOException e1) {
			informationRow.add(new JLabel("foo"));
		}
		informationRow.add(new JLabel());
		JPanel ingredientsColumn = new JPanel(new GridLayout(0,1));
		ingredientsColumn.add(ingredients);
		ingredients.setFont(mainFont);
		for(int i = 0; i < food.ingredients.length; i++) {
			JLabel ing = new JLabel("Ingredient " + Integer.toString(i+1) + ": " + food.ingredients[i]);
			ing.setFont(mediumFont);
			ingredientsColumn.add(ing);
		}
		informationRow.add(ingredientsColumn);
		informationRow.add(new JLabel());
		add(informationRow);
		
		JPanel overallInfoRow = new JPanel(new GridLayout(0,4));
		overallInfoRow.add(new JLabel());
		overallInfoRow.add(price);
		overallInfoRow.add(calories);
		overallInfoRow.add(new JLabel());
		add(overallInfoRow);
		
		JPanel buttonRow = new JPanel(new GridLayout(0,2));
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		left.add(back);
		right.add(add);
		buttonRow.add(left);
		buttonRow.add(right);
		add(buttonRow);	
	}
}
