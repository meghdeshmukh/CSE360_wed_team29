import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javafx.scene.control.TextField;

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

        back.setSize(buttonDimension);
		back.setFont(smallFont);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // go to owner view
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
            Customer customer = (Customer) user;
            JPanel row = new JPanel(new BorderLayout());
            row.setBorder(border);

            JPanel left = new JPanel(new GridLayout(0, 1));
            JLabel name = new JLabel(customer.getName());
            name.setFont(smallFont);
            JLabel phone = new JLabel(customer.getPhone());
            phone.setFont(smallFont);

            left.add(name);
            left.add(phone);

            JPanel right = new JPanel(new GridLayout(1,0));
            JTextField amount = new JTextField(10);
            amount.setFont(mediumFont);
            JButton gift = new JButton("Gift Coupon");
            gift.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Double new_amount = Double.parseDouble(amount.getText());
                    customer.addCoupon(new_amount);
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


    public static void main(String[] args) {

        Customer customer1 = new Customer ("nfl@gmail.com", "1234", "d1", "1234567890", "Bobby Bobby");
        Customer customer2 = new Customer ("nba@gmail.com", "1234", "d1", "1234567890", "Bobby Bobby");
        Customer customer3 = new Customer ("mlb@gmail.com", "1234", "d1", "1234567890", "Bobby Bobby");
        Customer customer4 = new Customer ("nhl@gmail.com", "1234", "d1", "1234567890", "Bobby Bobby");
        Customer customer5 = new Customer ("wnba@gmail.com", "1234", "d1", "1234567890", "Bobby Bobby");
        Customer customer6 = new Customer ("pl@gmail.com", "1234", "d1", "1234567890", "Bobby Bobby");
        Customer customer7 = new Customer ("mls@gmail.com", "1234", "d1", "1234567890", "Bobby Bobby");


		JFrame testFrame = new JFrame("test frame profile");
		testFrame.setSize(new Dimension(1400, 800));

		Application testApp = new Application();
        testApp.addUser(customer1);
        testApp.addUser(customer2);
        testApp.addUser(customer3);
        testApp.addUser(customer4);
        testApp.addUser(customer5);
        testApp.addUser(customer6);
        testApp.addUser(customer7);
		
		CustomerRepository test = new CustomerRepository(testFrame, testApp);
		
		testFrame.add(test);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setLocationRelativeTo(null);
		testFrame.setVisible(true);
	}

}
