

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
/**
 * 
 * @author Yue Fang
 * order item detail
 *
 */
public class FoodItemPanel extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer num;
	private Double price;
	private Integer time;
	private JLabel nameLabel;
	private JLabel amoutLabel;
	private JLabel priceLabel;
	private JLabel timeLabel;
	private JButton plusButton;
	private JButton subButton;
	private Screen13 parent;
	private CalculatePanel calcPane;
	
	public Integer getNum() {
		return num;
	}


	public void setNum(Integer num) {
		this.num = num;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getTime() {
		return time;
	}


	public void setTime(Integer time) {
		this.time = time;
	}


	public FoodItemPanel(String name, Integer num, Double price, Integer time,Screen13 parent,CalculatePanel calcPane) {
		super();
		this.name = name;
		this.num = num;
		this.price = price;
		this.time = time;
		this.parent = parent;
		this.calcPane = calcPane;
		init();
		addEventHandler();
		
	}

	/**
	 * Initialize component 
	 */
	public void init() {
		setLayout(null);
		
		nameLabel = new JLabel(name);
		nameLabel.setBounds(10, 10, 71, 15);
		add(nameLabel);
		
		amoutLabel = new JLabel("x"+num);
		amoutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		amoutLabel.setBounds(116, 10, 54, 15);
		add(amoutLabel);
		
		priceLabel = new JLabel("$"+(price*num));
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setBounds(218, 10, 54, 15);
		add(priceLabel);
		
		timeLabel = new JLabel((time*num)+" min");
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(325, 10, 54, 15);
		add(timeLabel);
		
		plusButton = new JButton("+");
		plusButton.setBounds(430, 6, 46, 23);
		add(plusButton);
		
		subButton = new JButton("-");
		subButton.setBounds(476, 6, 39, 23);
		add(subButton);
	}
	/**
	 * update label info
	 */
	private void refreshInfo() {
		amoutLabel.setText("x"+num);
		priceLabel.setText("$"+(price*num));
		timeLabel.setText((time*num)+" min");
	}
	/**
	 * add event handler
	 */
	private void addEventHandler() {
		plusButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				num = num + 1;
				refreshInfo();
				parent.refreshData();
				calcPane.refreshData();
			}
		});
		
		subButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (num > 0) {
					num = num - 1 ;
				}
				refreshInfo();
				parent.refreshData();
				calcPane.refreshData();
			}
		});
	}
	

	
	
}
