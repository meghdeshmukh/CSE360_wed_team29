package Frontend;


import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Backend.Application;
import Backend.Customer;
import Backend.Order;
import Backend.Payment;
/**
 * 
 * @author Yue Fang
 *
 */
@SuppressWarnings("serial")
public class paymentMenu extends JPanel{
	JFrame myFrame;
	Application myApplication;
	Customer myCustomer;
	paymentMenu myPanel = this;
	
	private JLabel savedInfo = new JLabel("Use Saved Payment Information");
	private JLabel altInfo = new JLabel("Alternative Payment Information");
	private JLabel price;
	
	private JTextField ccNumber = new JTextField(20);
	private JTextField ccName = new JTextField(20);
	private JTextField ccExp = new JTextField(10);
	private JTextField ccCVV = new JTextField(10);
	
	private JButton confirm = new JButton("Confirm");
	private JButton back = new JButton("Back");
	
	Font mainFont = new Font("Futura", Font.PLAIN, 25);
	Font mediumFont = new Font("Futura", Font.PLAIN ,18);
	Font smallFont = new Font("Futura", Font.ITALIC, 13);
	/**
	 * init and set style
	 * @param total total price 
	 */
	public paymentMenu(JFrame frame, Application application, Customer customer, List<Double> coupons) {
		myFrame = frame;
		myApplication = application;
		myCustomer = customer;
		
		savedInfo.setFont(mainFont);
		altInfo.setFont(mainFont);
		
		Double overallPrice = customer.getCart().getTotal();
		if(coupons != null)
			for(Double coupon : coupons)
				overallPrice -= coupon;
		
		final Double finalPrice = overallPrice;
		
		price = new JLabel("Price: $" + String.format("%.2f",finalPrice));
		price.setFont(mainFont);
		
		ccNumber.setText("Credit Card Number");
		ccNumber.setFont(mediumFont);
		ccNumber.addFocusListener(new HintListener());
		
		ccName.setText("Cardholder Name");
		ccName.setFont(mediumFont);
		ccName.addFocusListener(new HintListener());
		
		ccExp.setText("Exp. Date");
		ccExp.setFont(mediumFont);
		ccExp.addFocusListener(new HintListener());
		
		ccCVV.setText("CVV");
		ccCVV.setFont(mediumFont);
		ccCVV.addFocusListener(new HintListener());
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkoutMenu returnRequest = new checkoutMenu(myFrame, myApplication, myCustomer);
				myFrame.remove(myPanel);
				myFrame.add(returnRequest);
				myFrame.invalidate();
				myFrame.validate();
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String num = ccNumber.getText();
				String name = ccName.getText();
				String exp = ccExp.getText();
				String cvvStr = ccCVV.getText();
				if(!num.equals("Credit Card Number") && !name.equals("Cardholder Name") && !exp.equals("Exp. Date") && !cvvStr.equals("CVV")) {
					Integer cvvInt = Integer.parseInt(ccCVV.getText());
					Order placeOrder = myCustomer.altCheckout(ccNumber.getText(), ccName.getText(), ccExp.getText(), cvvInt, coupons);
					placeOrder.setPrice(finalPrice);
					myApplication.addOrder(placeOrder);
					customerMenu menuRequest = new customerMenu(myFrame, myApplication, myCustomer);
					myFrame.remove(myPanel);
					myFrame.add(menuRequest);
					myFrame.invalidate();
					myFrame.validate();
				}
			}
		});
		
		setLayout(new GridLayout(0,1));
		
		addRow(null);
		
		JPanel topRow = new JPanel(new BorderLayout());
		topRow.add(back, BorderLayout.WEST);
		JPanel indent = new JPanel();
		indent.add(price);
		topRow.add(indent, BorderLayout.CENTER);
		add(topRow);
		
		if(!myCustomer.getIsGuest()) {
			addRow(savedInfo);
			for(Payment payInfo: myCustomer.getPayments()) {
				if(payInfo.isValid()) {
					JButton thisCard = new JButton();
					thisCard.setText(payInfo.getCardName());
					thisCard.setFont(mediumFont);
					thisCard.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub	
							Order placeOrder = myCustomer.customerCheckout(payInfo, coupons);
							placeOrder.setPrice(finalPrice);
							myApplication.addOrder(placeOrder);
							customerMenu menuRequest = new customerMenu(myFrame, myApplication, myCustomer);
							myFrame.remove(myPanel);
							myFrame.add(menuRequest);
							myFrame.invalidate();
							myFrame.validate();
						}
					});
					addRow(thisCard);
				}
			}
			addRow(new JLabel("or"));
		}
		addRow(altInfo);
		
		addRow(ccNumber);
		addRow(ccName);
		JPanel bottomRow = new JPanel();
		bottomRow.add(ccExp);
		bottomRow.add(ccCVV);
		addRow(bottomRow);
		addRow(confirm);
		
		addRow(null);
	}
	
	private void addRow(Component comp) {
		JPanel row = new JPanel();
		if(comp == null)
			row.add(new JLabel());
		else
			row.add(comp);
		myPanel.add(row);
	}
	
	private class HintListener implements FocusListener{
		@Override
		public void focusGained(FocusEvent e) {
			if(e.getSource() == ccNumber && ccNumber.getText().equals("Credit Card Number"))
				ccNumber.setText("");
			else if(e.getSource() == ccName && ccName.getText().equals("Cardholder Name"))
				ccName.setText("");
			else if(e.getSource() == ccExp && ccExp.getText().equals("Exp. Date"))
				ccExp.setText("");
			else if(e.getSource() == ccCVV && ccCVV.getText().equals("CVV"))
				ccCVV.setText("");
		}
		@Override
		public void focusLost(FocusEvent e) {
			if(e.getSource() == ccNumber && ccNumber.getText().equals(""))
				ccNumber.setText("Credit Card Number");
			else if(e.getSource() == ccName && ccName.getText().equals(""))
				ccName.setText("Cardholder Name");
			else if(e.getSource() == ccExp && ccExp.getText().equals(""))
				ccExp.setText("Exp. Date");
			else if(e.getSource() == ccCVV && ccCVV.getText().equals(""))
				ccCVV.setText("CVV");
		}
	}
}