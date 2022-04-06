package Frontend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Backend.Application;
import Backend.Customer;
import Backend.Food;


@SuppressWarnings("serial")
public class customerFoodInfo extends JPanel{
	
	
	JFrame myFrame;
	Customer myCustomer;
	Application myApplication;
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
	
	public customerFoodInfo(JFrame frame, Application application, Customer customer, Food food) {
		
		myFrame = frame;
		myCustomer = customer;
		myApplication = application;
		
		back.setSize(buttonDimension);
		back.setFont(smallFont);
		back.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				customerMenu theMenu = new customerMenu(myFrame, myApplication, myCustomer);
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
				myCustomer.addCart(food);
				customerMenu theMenu = new customerMenu(myFrame, myApplication, myCustomer);
				myFrame.remove(myPanel);
				myFrame.add(theMenu);
				myFrame.invalidate();
				myFrame.validate();
				
			}
		});
		
		price.setText(price.getText() + String.format("%.2f", food.getPrice()));
		price.setFont(mediumFont);
		calories.setText(calories.getText() + Integer.toString(food.getCalories()));
		calories.setFont(mediumFont);
		name = new JLabel(food.getName());
		name.setFont(mainFont);
		
		setLayout(new GridLayout(0, 1));
		
		JPanel nameRow = new JPanel();
		nameRow.add(name);
		add(nameRow);
		
		JPanel informationRow = new JPanel(new GridLayout(0,5));
		informationRow.add(new JLabel());
		
		//JLabel picLabel = new JLabel(new ImageIcon(food.getImg()));
		JLabel picLabel = new JLabel();
		informationRow.add(picLabel);
		Image dimg = food.getImg().getScaledInstance(myFrame.getWidth()/5, myFrame.getHeight()/4, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		picLabel.setIcon(imageIcon);
		
		informationRow.add(new JLabel());
		JPanel ingredientsColumn = new JPanel(new GridLayout(0,1));
		ingredientsColumn.add(ingredients);
		ingredients.setFont(mainFont);
		for(int i = 0; i < food.getIngredients().length; i++) {
			JLabel ing = new JLabel("Ingredient " + Integer.toString(i+1) + ": " + food.getIngredients()[i]);
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