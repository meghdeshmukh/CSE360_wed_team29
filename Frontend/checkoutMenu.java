package Frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Backend.*;

public class checkoutMenu extends JPanel{
	
	Application myApplication;
	JFrame myFrame;
	Customer myCustomer;
	checkoutMenu myPanel = this;
	
	JButton backButton = new JButton("Back");
	
	JLabel foodName = new JLabel("Food Item");
	JLabel amountL = new JLabel("Amount");
	JLabel totalPriceL = new JLabel("Total Price");
	JLabel timeL = new JLabel("Estimated Cook Time");
	JLabel custAhead, waitTime;
	
	Font mainFont = new Font("Futura", Font.PLAIN, 25);
	Font mediumFont = new Font("Futura", Font.PLAIN ,18);
	Font smallFont = new Font("Futura", Font.ITALIC, 13);
	
	JPanel center;
	
	ArrayList<Food> processedItems = new ArrayList<Food>();
	ArrayList<Food> allItems = new ArrayList<Food>();
	
	ArrayList<JLabel> processedAmounts, processedPrices, processedCookTimes;
	
	Double overallPrice;
	
	ArrayList<Double> couponsToConsume = null;
	
	public checkoutMenu(JFrame frame, Application application, Customer customer) {
		myFrame = frame;
		myApplication = application;
		myCustomer = customer;
		
		
		setLayout(new BorderLayout());
		
		backButton.setFont(mainFont);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				customerMenu menuRequest = new customerMenu(myFrame, myApplication, myCustomer);
				myFrame.remove(myPanel);
				myFrame.add(menuRequest);
				myFrame.invalidate();
				myFrame.validate();
			}
		});
		JPanel row = new JPanel(new BorderLayout());
		row.add(backButton, BorderLayout.WEST);
		add(row, BorderLayout.NORTH);
		add(new JLabel("Fd"), BorderLayout.CENTER);
		
		center = new JPanel(new GridLayout(0,7));
		updateCenter();
		
		add(center, BorderLayout.CENTER);
		
		custAhead = new JLabel("Customers Ahead in Queue: " + Integer.toString(myApplication.getOrders().size()));
		custAhead.setFont(mainFont);
		waitTime = new JLabel("Estimated Wait Time Until Order Received: " + Integer.toString(myApplication.getTotalOrderTime()) + " min");
		waitTime.setFont(mainFont);
		row = new JPanel(new GridLayout(0,1));
		row.add(custAhead);
		row.add(waitTime);
		row.add(new JLabel());
		add(row, BorderLayout.SOUTH);
	}
	
	public void updateCenter() {
		center.removeAll();
		
		center.add(new JLabel());
		center.add(foodName);
		center.add(amountL);
		center.add(totalPriceL);
		center.add(timeL);
		center.add(new JLabel());
		center.add(new JLabel());
		
		overallPrice = myCustomer.getCart().getTotal();
		
		processedItems = new ArrayList<Food>();
		allItems = new ArrayList<Food>();
		processedAmounts = new ArrayList<JLabel>();
		processedPrices = new ArrayList<JLabel>();
		processedCookTimes = new ArrayList<JLabel>();
		//
		if(myCustomer.getCart().getItems().size() > 0) {
			for(Food item : myCustomer.getCart().getItems()) {
				if(processedItems.contains(item)) {
					int index = processedItems.indexOf(item);
					
					int amountOfOccurances = 1;
					for(Food processed : allItems)
						if(processed.equals(item))
							amountOfOccurances++;
					
					processedAmounts.get(index).setText("x" + Integer.toString(amountOfOccurances));
					processedPrices.get(index).setText("$" + String.format("%.2f", (Double)item.getPrice() * amountOfOccurances));
					processedCookTimes.get(index).setText(Integer.toString(amountOfOccurances * item.getTime()) + " min");
				}
				else {
					processedItems.add(item);
					JLabel name = new JLabel(item.getName());
					JLabel amount = new JLabel("x1");
					processedAmounts.add(amount);
					JLabel price = new JLabel("$" + String.format("%.2f", item.getPrice()));
					processedPrices.add(price);
					JLabel time = new JLabel(Integer.toString(item.getTime()) + " min");
					processedCookTimes.add(time);
					
					JButton add = new JButton("+");
					add.setBackground(Color.GREEN);
					JButton sub = new JButton("-");
					sub.setBackground(Color.RED);
					
					add.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							myCustomer.addCart(item);
							updateCenter();
						}
					});
					sub.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							myCustomer.deleteCart(item);
							for(Food item : myCustomer.getCart().getItems()){
								System.out.println(item.getName());
							}
							System.out.println("");
							updateCenter();
						}
					});
					
					JPanel buttonArea = new JPanel();
					buttonArea.add(add);
					buttonArea.add(sub);
					buttonArea.setAlignmentX(CENTER_ALIGNMENT);
					buttonArea.setAlignmentY(BOTTOM_ALIGNMENT);
					
					
					center.add(new JLabel());
					center.add(name);
					center.add(amount);
					center.add(price);
					center.add(time);
					center.add(buttonArea);
					center.add(new JLabel());
				}
				allItems.add(item);
			}
		}
		else {
			center.add(new JLabel());
			center.add(new JLabel());
			center.add(new JLabel());
			JLabel noItems = new JLabel("NO ITEMS");
			noItems.setFont(mainFont);
			center.add(noItems);
			center.add(new JLabel());
			center.add(new JLabel());
			center.add(new JLabel());
		}
		
		for(int i = 0; i < 7; i++)
			center.add(new JLabel());
		
		if(!myCustomer.getIsGuest()) {
			couponsToConsume = new ArrayList<Double>();
			for(Double coupon : myCustomer.getCoupons()) {
				if(overallPrice - coupon > 0) {
					couponsToConsume.add(coupon);
					overallPrice -= coupon;
					JLabel couponAmount = new JLabel("$" + String.format("%.2f", coupon) + " Coupon");
					couponAmount.setForeground(Color.RED);
					JLabel subtractCoupon = new JLabel("-$" + String.format("%.2f", coupon));
					subtractCoupon.setForeground(Color.RED);
					
					center.add(new JLabel());
					center.add(couponAmount);
					center.add(new JLabel());
					center.add(subtractCoupon);
					center.add(new JLabel());
					center.add(new JLabel());
					center.add(new JLabel());
					
				}
			}
		}
		
		JTextField total = new JTextField(15);
		total.setAlignmentX(LEFT_ALIGNMENT);
		total.setEditable(false);
		total.setFont(mediumFont);
		total.setText("$" + String.format("%.2f", overallPrice));
		JTextField totalCook = new JTextField(15);
		totalCook.setEditable(false);
		totalCook.setAlignmentX(LEFT_ALIGNMENT);
		totalCook.setFont(mediumFont);
		totalCook.setText(Integer.toString(myCustomer.getCart().getTime()) + " min");
		JButton checkout = new JButton("Checkout");
		checkout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paymentMenu checkoutRequest = new paymentMenu(myFrame, myApplication, myCustomer, couponsToConsume);
				myFrame.remove(myPanel);
				myFrame.add(checkoutRequest);
				myFrame.invalidate();
				myFrame.validate();
			}
		});
		
		JPanel indent = new JPanel(new BorderLayout());
		for(int i = 0; i < 3; i++)
			center.add(new JLabel());
		center.add(indent);
		indent.add(total, BorderLayout.WEST);
		indent = new JPanel(new BorderLayout());
		center.add(indent);
		indent.add(totalCook, BorderLayout.WEST);
		indent = new JPanel();
		center.add(indent);
		indent.add(checkout);
		center.add(new JLabel());
		
		
		myFrame.invalidate();
		myFrame.validate();
	}
	
	public static void main(String[] args) {
		JFrame testFrame = new JFrame("test frame");
		testFrame.setSize(new Dimension(1400, 800));
		Application testApp = new Application();
		
		Customer cust = new Customer();
		cust.register("", "", "", "", "");
		cust.addCoupon(23.0);
		cust.addCoupon(2.0);
		String[] ing = {};
		Food food = new Food("Burder", "fd", ing, 10.00, 5, 4);
		Food food2 = new Food("Pizza", "fd", ing, 12.00, 10, 6);
		cust.addCart(food);
		cust.addCart(food2);
		cust.addCart(food2);
		cust.addCart(food);
		cust.addCart(food2);
		
		
		checkoutMenu test = new checkoutMenu(testFrame, testApp, cust);
		testFrame.add(test);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setLocationRelativeTo(null);
		testFrame.setVisible(true);
	}
}
