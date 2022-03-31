

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
/**
 * 
 * @author Yue Fang
 *
 */
public class CalculatePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private FoodTablePane tablePanel;
	private JLabel couponsLabel;
	private JLabel subLabel;
	private Double subPrice;
	private JLabel totalPriceLabel;
	private JLabel totalTimeLabel;
	private JButton ckBtn;
	/**
	 * init and set style
	 * @param tablePanel table for Food order
	 */
	public CalculatePanel(FoodTablePane tablePanel) {
		this.tablePanel = tablePanel;
		setLayout(null);
		subPrice = 5.00;
		couponsLabel = new JLabel("$5 Coupons");
		couponsLabel.setForeground(Color.RED);
		couponsLabel.setBounds(24, 26, 96, 15);
		add(couponsLabel);
		
		subLabel = new JLabel("-$"+subPrice);
		subLabel.setForeground(Color.RED);
		subLabel.setBounds(204, 26, 54, 15);
		add(subLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 51, 403, 1);
		add(separator);
		
		totalPriceLabel = new JLabel("$17.79");
		totalPriceLabel.setBounds(204, 62, 54, 15);
		add(totalPriceLabel);
		
		totalTimeLabel = new JLabel("15 min");
		totalTimeLabel.setBounds(338, 62, 54, 15);
		add(totalTimeLabel);
		
		ckBtn = new JButton("Checkout");
		ckBtn.setBounds(402, 58, 93, 23);
		add(ckBtn);
	}
	/**
	 * update label text
	 */
	public void refreshData() {
		totalPriceLabel.setText("$" + (tablePanel.getTotalPrice()-subPrice));
		totalTimeLabel.setText(tablePanel.getTotalTime()+" min");
	}

}
