

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * 
 * @author Yue Fang
 * repository item
 *
 */
public class RepositoryItemPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private CircleLabel circleLabel;
	private JButton gouponButton;
	
	/**
	 * cretate repository item
	 * @param color circle label color
	 * @param charactor label text
	 * @param fullName full name
	 * @param phone phone number
	 * @param visits visit number
	 */
	public RepositoryItemPanel(Color color,String charactor,String fullName,String phone,int visits) {
		Border createLineBorder = BorderFactory.createLineBorder(Color.black);
		this.setBorder(createLineBorder);
		setLayout(null);
		
		circleLabel = new CircleLabel(charactor,color,40);
		circleLabel.setBounds(10, 31, 54, 54);
		add(circleLabel);
		
		JLabel lblNewLabel_1 = new JLabel(fullName);
		lblNewLabel_1.setBounds(67, 16, 107, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(phone);
		lblNewLabel_2.setBounds(67, 41, 107, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("visits: "+visits);
		lblNewLabel_3.setBounds(222, 31, 72, 15);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(315, 28, 66, 21);
		add(textField);
		textField.setColumns(10);
		
		gouponButton = new JButton("Gift Coupon");
		gouponButton.setBounds(380, 27, 107, 23);
		add(gouponButton);
	}

}
