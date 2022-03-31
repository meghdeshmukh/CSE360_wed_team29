

import javax.swing.JFrame;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
/**
 * 
 * @author Yue Fang
 *
 */
@SuppressWarnings("serial")
public class Screen13 extends JFrame {
	private JButton backButton;
	private FoodTablePane tablePane;
	private JPanel calcPanel;
	private JLabel label1;
	private JLabel label2;
	private CalculatePanel calcSubPanel;

	public Screen13() {
		init();
		setStyle();
		initTestData();
	}
	/**
	 * init
	 */
	private void init() {
		backButton = new JButton("Back");
		tablePane = new FoodTablePane();
		calcPanel = new JPanel();
		label1 = new JLabel("Customers Ahead in Queue: "+tablePane.getNum()+" Customers");
		label2 = new JLabel("Estimated Time Until Order Received: "+tablePane.getTotalTime()+" min");
	}
	/**
	 * set style
	 */
	private void setStyle() {
		getContentPane().setLayout(null);

		backButton.setBounds(25, 25, 93, 23);
		getContentPane().add(backButton);

		tablePane.setBounds(25, 89, 560, 328);
		getContentPane().add(tablePane);

		calcPanel.setBounds(25, 427, 560, 109);
		getContentPane().add(calcPanel);

		label1.setBounds(25, 613, 459, 15);
		getContentPane().add(label1);

		label2.setBounds(25, 638, 329, 15);
		getContentPane().add(label2);
		calcSubPanel = new CalculatePanel(tablePane);
		calcSubPanel.setPreferredSize(new Dimension(540, 107));
		calcPanel.add(calcSubPanel);
	}
	/**
	 * a example to use 
	 */
	private void initTestData() {
		tablePane.addItem(new FoodItemPanel("Menu Item 1",1,7.99,5,this,calcSubPanel));
		tablePane.addItem(new FoodItemPanel("Menu Item 2",1,6.99,5,this,calcSubPanel));
		tablePane.addItem(new FoodItemPanel("Menu Item 3",1,7.99,5,this,calcSubPanel));

		tablePane.refresh();
		refreshData();
	}
	/**
	 * update data
	 */
	public void refreshData() {
		label1.setText("Customers Ahead in Queue: "+tablePane.getNum()+" Customers");
		label2.setText("Estimated Time Until Order Received: "+tablePane.getTotalTime()+" min");
	}
	public static void main(String[] args) {
		Screen13 window = new Screen13();
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setSize(644, 740);
		window.setVisible(true);
	}
}
