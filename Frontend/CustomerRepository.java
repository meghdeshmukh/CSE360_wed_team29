package Frontend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Backend.Application;
import Backend.Customer;
import Backend.User;


import java.util.List;


public class CustomerRepository extends JPanel{
    
    JFrame myFrame;
	Application myApplication;
	CustomerRepository myPanel = this;
	
	
	JButton back = new JButton("Back");
	JLabel title = new JLabel("Customer Repository");
	
	Dimension buttonDimension = new Dimension(90,30);
	
	Font mainFont = new Font("Futura", Font.PLAIN, 25);
	Font mediumFont = new Font("Futura", Font.PLAIN ,18);
	Font smallFont = new Font("Futura", Font.ITALIC, 13);
	

    public CustomerRepository(JFrame frame, Application application) {

        myApplication = application;
        myFrame = frame;

        back.setSize(buttonDimension);
		back.setFont(smallFont);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	OwnerView returnRequest = new OwnerView(myFrame, myApplication, myApplication.getOwner());
            	myFrame.remove(myPanel);
            	myFrame.add(returnRequest);
            	myFrame.invalidate();
            	myFrame.validate();
            }
        });

        title.setFont(mainFont);

        setLayout(new BorderLayout());
        JPanel topRow = new JPanel(new BorderLayout());
        JPanel left = new JPanel(new GridLayout(0,1));
        
        left.add(back);
        topRow.add(left, BorderLayout.WEST);
        JPanel indent = new JPanel();
		indent.add(title);
		topRow.add(indent, BorderLayout.CENTER);

        add(topRow, BorderLayout.NORTH);

        JScrollPane menuScroll = new JScrollPane();
		menuScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		menuScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JPanel customerRepo = new JPanel();
        customerRepo.setLayout(new BoxLayout(customerRepo, BoxLayout.Y_AXIS));
        updateRepo(customerRepo);
        menuScroll.getViewport().add(customerRepo);
		add(menuScroll, BorderLayout.CENTER);

    }

    public void updateRepo(JPanel pane) {
        pane.removeAll();
        Border border = new LineBorder(Color.BLACK, 4, true);
        List<User> customers = myApplication.getUsers();
        for (User user : customers) {
        	if(user instanceof Customer) {
	            Customer customer = (Customer) user;
	            JPanel row = new JPanel(new BorderLayout());
	            row.setBorder(border);
	
	            JPanel left = new JPanel(new GridLayout(0, 1));
	            JLabel name = new JLabel("Customer Name: " + customer.getName());
	            name.setFont(smallFont);
	            JLabel phone = new JLabel("Phone Number: " + customer.getPhone());
	            phone.setFont(smallFont);
	            JLabel visits = new JLabel("Orders Placed: " + Integer.toString(customer.getVisits()));
	
	            left.add(name);
	            left.add(phone);
	            left.add(visits);
	
	            JPanel right = new JPanel(new GridLayout(1,0));
	            JTextField amount = new JTextField(10);
	            amount.setFont(mediumFont);
	            JButton gift = new JButton("Gift Coupon");
	            gift.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    Double new_amount = Double.parseDouble(amount.getText());
	                    customer.addCoupon(new_amount);
	                    amount.setText("");
	                    System.out.println(customer.getCoupons());
	                }
	            });
	
	        
	
	            right.add(amount);
	            right.add(gift);
	            row.add(left, BorderLayout.WEST);
	            row.add(right, BorderLayout.EAST);
	            System.out.println(row.getSize());
	            row.setSize(50, 50);
	            pane.add(row, BorderLayout.CENTER);
	        }	
        }
        while(pane.getComponentCount() < 10) {
            JPanel row = new JPanel(new BorderLayout());
            row.setBorder(border);
            pane.add(row, BorderLayout.CENTER);
        }
    }
}
