

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
public class ownerCreateItem extends JPanel{
	
	
	JFrame myFrame;
	Owner myOwner;
	Application myApplication;
	ownerCreateItem myPanel = this;
	
	JButton back = new JButton("Back");
	JButton save = new JButton("Save Item to Menu");
	
	JLabel ingredients = new JLabel("Ingredients");
	JLabel price = new JLabel("Price: $");
	JTextField priceTF = new JTextField(10);
	JLabel calories = new JLabel("Total Calories: ");
	JTextField calTF = new JTextField(10);
	JLabel name = new JLabel("Name: ");
	JTextField nameTF = new JTextField(20);
	JTextField imageName;
	JTextField cookTimeTF = new JTextField(10);
	
	Font mainFont = new Font("Futura", Font.ITALIC, 25);
	Font mediumFont = new Font("Futura", Font.PLAIN ,18);
	Font smallFont = new Font("Futura", Font.ITALIC, 13);
	
	ArrayList<String> monitorIng = new ArrayList<String>();
	
	Dimension buttonDimension = new Dimension(90,30);
	
	public ownerCreateItem(JFrame frame, Application application, Owner owner) {
		
		myFrame = frame;
		myOwner = owner;
		myApplication = application;
		
		
		back.setSize(buttonDimension);
		back.setFont(mainFont);
		back.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				OwnerView theMenu = new OwnerView(myFrame, myApplication, myOwner);// add my food
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
				String newName = nameTF.getText();
				String newImage = imageName.getText();
				String newPrice = priceTF.getText();
				String newCalories = calTF.getText();
				String newTime = cookTimeTF.getText();
				if(newName.length() > 0 && newImage.length() > 0 && newPrice.length() > 0 && newCalories.length() > 0 && newTime.length() > 0 && monitorIng.size() > 0) {
					String[] newIngredients = new String[monitorIng.size()];
					for(int i = 0; i < monitorIng.size(); i++)
						newIngredients[i] = monitorIng.get(i);
					
					Food newFood = new Food(newName, newImage, newIngredients, Double.parseDouble(newPrice), Integer.parseInt(newCalories), Integer.parseInt(newTime));
					myApplication.getMenu().add(newFood);
					OwnerView savedRequest = new OwnerView(myFrame, myApplication, myOwner);
					myFrame.remove(myPanel);
					myFrame.add(savedRequest);
					myFrame.invalidate();
					myFrame.validate();
				}
			}
		});
		
		price.setFont(mediumFont);
		priceTF.setFont(mediumFont);
		calories.setFont(mediumFont);
		calTF.setFont(mediumFont);
		name.setFont(mainFont);
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
		JLabel image = new JLabel("Food Image Name: ");
		image.setFont(mediumFont);
		cookTimeTF.setFont(mediumFont);
		JLabel cookTimeLabel = new JLabel("Cook Time: ");
		cookTimeLabel.setFont(mediumFont);
		
		JPanel column = new JPanel(new GridLayout(0,1));
		JPanel row = new JPanel();
		row.add(image);
		row.add(imageName);
		column.add(row);
		row = new JPanel();
		row.add(cookTimeLabel);
		row.add(cookTimeTF);
		column.add(row);
		informationRow.add(column);
		
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
		ownerCreateItem test = new ownerCreateItem(testFrame, testApp, testOwner);
		testFrame.add(test);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setLocationRelativeTo(null);
		testFrame.setVisible(true);
	}
}