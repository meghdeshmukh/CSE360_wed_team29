

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Yue Fang
 *
 */
@SuppressWarnings("serial")
public class Screen16 extends JFrame{
	
	private RepositoryListPanel listPanel;
	/**
	 * init and set style
	 */
	public Screen16() {
		getContentPane().setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 20, 93, 23);
		getContentPane().add(backButton);
		
		JLabel lblNewLabel = new JLabel("Customer Repository");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(162, 24, 141, 15);
		getContentPane().add(lblNewLabel);
		
		listPanel = new RepositoryListPanel();
		listPanel.setPreferredSize(new Dimension(530,400));
		listPanel.setBounds(10, 89, 518, 420);
		getContentPane().add(listPanel);
		addItem();
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	/**
	 * example to use
	 */
	public void addItem() {
		listPanel.addItem(new RepositoryItemPanel(Color.red,"C","Full Name 1","Phone Number 1",2));
		listPanel.addItem(new RepositoryItemPanel(Color.green,"D","Full Name 2","Phone Number 1",2));
		listPanel.addItem(new RepositoryItemPanel(Color.blue,"E","Full Name 3","Phone Number 1",2));
		listPanel.addItem(new RepositoryItemPanel(Color.pink,"P","Full Name 4","Phone Number 1",2));
		listPanel.refresh();
	}
	
	public static void main(String[] args) {
		Screen16 window = new Screen16();
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setSize(560,560);
		window.setVisible(true);
	}
}
