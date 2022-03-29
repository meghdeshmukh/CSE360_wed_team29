

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
/**
 * 
 * @author Yue Fang
 * Order Table header
 *
 */
public class FoodHeaderPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	/**
	 * init and set style
	 */
	public FoodHeaderPanel() {
		setLayout(null);
		
		JLabel nameLabel = new JLabel("FoodItem");
		nameLabel.setBounds(10, 10, 71, 15);
		add(nameLabel);
		
		JLabel amoutLabel = new JLabel("Amount");
		amoutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		amoutLabel.setBounds(116, 10, 54, 15);
		add(amoutLabel);
		
		JLabel priceLabel = new JLabel("Total Price");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setBounds(214, 10, 71, 15);
		add(priceLabel);
		
		JLabel timeLabel = new JLabel("Estimated Cook Time");
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setBounds(325, 10, 134, 15);
		add(timeLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 35, 455, 1);
		add(separator);
	}
}
