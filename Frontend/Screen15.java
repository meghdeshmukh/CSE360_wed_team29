

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
/**
 * 
 * @author Yue Fang
 *
 */
@SuppressWarnings("serial")
public class Screen15 extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * init and set style
	 * @param total total price 
	 */
	public Screen15(Double total) {
		getContentPane().setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 20, 93, 23);
		getContentPane().add(backButton);
		
		JLabel lblNewLabel = new JLabel("Price:$"+total);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(162, 24, 103, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(134, 97, 141, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 118, 141, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(134, 138, 65, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(209, 138, 66, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setBounds(159, 169, 93, 23);
		getContentPane().add(confirmButton);
		
		JButton payButton = new JButton("Alternative Payment Information");
		payButton.setBounds(79, 64, 248, 23);
		getContentPane().add(payButton);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		payButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static void main(String[] args) {
		Screen15 window = new Screen15(19.97);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setSize(450,258);
		window.setVisible(true);
	}
}
