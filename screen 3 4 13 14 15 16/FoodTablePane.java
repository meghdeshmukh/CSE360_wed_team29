

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
/**
 * 
 * @author Yue Fang
 * Order table 
 *
 */
public class FoodTablePane extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private static FoodHeaderPanel header = new FoodHeaderPanel();
	private static List<FoodItemPanel> items = new ArrayList<>();
	
	public FoodTablePane() {
		this.setLayout(new FlowLayout());
		this.setMinimumSize(new Dimension(600,700));
		init();
		
	}
	/**
	 * get total number
	 * @return int num
	 */
	public Integer getNum() {
		int num = 0;
		for (FoodItemPanel item : items) {
			num += item.getNum();
		}
		return num;
	}
	/**
	 * get total time
	 * @return int time
	 */
	public Integer getTotalTime() {
		int time = 0;
		for (FoodItemPanel item : items) {
			time += item.getTime()*item.getNum();
		}
		return time;
	}
	/**
	 * get total price
	 * @return double price
	 */
	public Double getTotalPrice() {
		double total = 0;
		for (FoodItemPanel item : items) {
			total += item.getNum()*item.getPrice();
		}
		return total;
	}
	
	/**
	 * init table 
	 */
	private void init() {
		this.removeAll();
		this.updateUI();
		header.setPreferredSize(new Dimension(540,56));
		this.add(header);
		for (FoodItemPanel foodItemPanel : items) {
			foodItemPanel.setPreferredSize(new Dimension(540,56));
			this.add(foodItemPanel);
		}
		this.updateUI();
		this.validate();
	}
	/**
	 * update table
	 */
	public void refresh() {
		init();
	}
	/**
	 * add a order item
	 * @param item order detail
	 */
	public void addItem(FoodItemPanel item) {
		items.add(item);
	}
	


}
