package Frontend;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import Backend.*;


@SuppressWarnings("serial")
public class ownerEditItem extends JPanel{
	
	
	JFrame myFrame;
	Owner myOwner;
	Application myApplication;
	ownerEditItem myPanel = this;
	Food myFood;
	
	JButton back = new JButton("Back");
	JButton save = new JButton("Save Changes");
	
	JLabel ingredients = new JLabel("Ingredients");
	JLabel price = new JLabel("Price: $");
	JTextField priceTF = new JTextField(10);
	JLabel calories = new JLabel("Total Calories: ");
	JTextField calTF = new JTextField(10);
	JLabel name = new JLabel("Name: ");
	JTextField nameTF = new JTextField(20);
	JTextField imageName;
	
	BufferedImage foodPic;
	
	Font mainFont = new Font("Futura", Font.ITALIC, 25);
	Font mediumFont = new Font("Futura", Font.PLAIN ,18);
	Font smallFont = new Font("Futura", Font.ITALIC, 13);
	
	ArrayList<String> monitorIng = new ArrayList<String>();
	
	Dimension buttonDimension = new Dimension(90,30);
	
	public ownerEditItem(JFrame frame, Application application, Owner owner, Food food) {
		
		myFrame = frame;
		myOwner = owner;
		myApplication = application;
		myFood = food;
		
		for(String ing : myFood.getIngredients())
			monitorIng.add(ing);
		
		back.setSize(buttonDimension);
		back.setFont(mainFont);
		back.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				OwnerView theMenu = new OwnerView(myFrame, myApplication, myOwner);
				myFrame.remove(myPanel);
				myFrame.add(theMenu);
				myFrame.invalidate();
				myFrame.validate();
			}
		});
		
		save.setSize(buttonDimension);
		save.setFont(mainFont);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFood.setName(nameTF.getText());
				myFood.setImageName(imageName.getText());
				myFood.setPrice(Double.parseDouble(priceTF.getText()));
				myFood.setCalories(Integer.parseInt(calTF.getText()));
				myFood.replaceIng(monitorIng);
				OwnerView theMenu = new OwnerView(myFrame, myApplication, myOwner);
				myFrame.remove(myPanel);
				myFrame.add(theMenu);
				myFrame.invalidate();
				myFrame.validate();
			}
		});
		
		price.setFont(mediumFont);
		priceTF.setText(Double.toString(myFood.getPrice()));
		priceTF.setFont(mediumFont);
		calories.setFont(mediumFont);
		calTF.setText(Integer.toString(myFood.getCalories()));
		calTF.setFont(mediumFont);
		name.setFont(mainFont);
		nameTF.setText(myFood.getName());
		nameTF.setFont(mediumFont);
		
		setLayout(new BorderLayout());
		
		JPanel nameRow = new JPanel();
		nameRow.add(name);
		nameRow.add(nameTF);
		add(nameRow, BorderLayout.NORTH);
		
		JPanel informationRow = new JPanel(new GridLayout(0,5));
		informationRow.add(new JLabel());
		
		imageName = new JTextField(10);
		imageName.setFont(mediumFont);
		imageName.setText(myFood.getImageName());
		JLabel image = new JLabel("Food Image Name: ");
		image.setFont(mediumFont);
		JPanel resize = new JPanel();
		resize.add(image);
		resize.add(imageName);
		informationRow.add(resize);
		
		informationRow.add(new JLabel());
		JPanel ingredientsColumn = new JPanel(new GridLayout(0,1));
		updateIngredients(ingredientsColumn);
		
		informationRow.add(ingredientsColumn);
		informationRow.add(new JLabel());
		add(informationRow, BorderLayout.CENTER);
		
		JPanel bottom = new JPanel(new BorderLayout());
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel up = new JPanel();
		
		up.add(price);
		up.add(priceTF);
		up.add(calories);
		up.add(calTF);
		left.add(back);
		right.add(save);
		bottom.add(left, BorderLayout.WEST);
		bottom.add(right, BorderLayout.EAST);
		bottom.add(up, BorderLayout.NORTH);
		add(bottom, BorderLayout.SOUTH);
		
	}
	
	public void updateIngredients(JPanel ingredientsColumn) {
		ingredientsColumn.removeAll();
		ingredientsColumn.add(ingredients);
		ingredients.setFont(mainFont);
		for(String ingredient : monitorIng) {
			JTextField ingTF = new JTextField(10);
			ingTF.setFont(mediumFont);
			ingTF.setText(ingredient);
			ingTF.setEditable(false);
			JButton remove = new JButton("Remove");
			remove.setFont(mediumFont);
			remove.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {	
					monitorIng.remove(ingredient);
					updateIngredients(ingredientsColumn);
				}
			});
			JPanel ingRow = new JPanel();
			ingRow.add(ingTF);
			ingRow.add(remove);
			ingredientsColumn.add(ingRow);
		}
		JTextField newIng = new JTextField(10);
		newIng.setFont(mediumFont);
		JButton addIng = new JButton("Add");
		addIng.setFont(mediumFont);
		addIng.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				monitorIng.add(newIng.getText());
				updateIngredients(ingredientsColumn);
			}
		});
		JPanel ingRow = new JPanel();
		ingRow.add(newIng);
		ingRow.add(addIng);
		ingredientsColumn.add(ingRow);
		myFrame.invalidate();
		myFrame.validate();
	}
	
	public static void main(String[] args) {
		Application testApp = new Application();
		testApp.restoreApplication();
		Owner testOwner = testApp.getOwner();
		Food testFood = testApp.getMenu().getItems().get(0);
		
		JFrame testFrame = new JFrame();
		testFrame.setSize(new Dimension(1400, 800));
		ownerEditItem test = new ownerEditItem(testFrame, testApp, testOwner, testFood);
		testFrame.add(test);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setLocationRelativeTo(null);
		testFrame.setVisible(true);
	}
}