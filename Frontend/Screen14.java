

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Yue Fang
 *
 */
@SuppressWarnings("serial")
public class Screen14 extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * init and set style
	 * @param total total price 
	 */
	public Screen14(double total) {
		getContentPane().setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 20, 93, 23);
		getContentPane().add(backButton);
		
		JLabel lblNewLabel = new JLabel("Price:$"+total);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(162, 24, 103, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("or");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(77, 103, 248, 15);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(134, 153, 141, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 173, 141, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(134, 193, 65, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(209, 193, 66, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setBounds(155, 224, 93, 23);
		getContentPane().add(confirmButton);
		
		JButton saveButton = new JButton("Use Save Payment Information");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		saveButton.setBounds(77, 70, 248, 23);
		getContentPane().add(saveButton);
		
		JButton payButton = new JButton("Alternative Payment Information");
		payButton.setBounds(77, 128, 248, 23);
		getContentPane().add(payButton);
	}
	
	public static void main(String[] args) {
		Screen14 window = new Screen14(17.97);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setSize(450,330);
		window.setVisible(true);
	}
}
