import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;



public class OwnerView extends JPanel {
	private JTextField item, price, allergens;
	private JLabel MenuItem, Price, Allergens;
	private JButton add, delete;

	public OwnerView(){
		
		JTable view = new JTable();
		Object[] columns = {"Items", "Prices", "Allergies"};
		DefaultTableModel model = new DefaultTableModel();
		
		JFrame frame = new JFrame("OWNER VIEW");
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.getContentPane().setForeground(Color.white);
		frame.setBounds(100,100,518,369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		model.setColumnIdentifiers(columns);
		view.setModel(model);
		
		view.setBackground(Color.white);
		view.setForeground(new Color(136, 196, 235));
		view.setSelectionBackground(Color.white);
		view.setGridColor(Color.orange);
		view.setFont(new Font("Futura", Font.ITALIC, 25));
		view.setRowHeight(30);
		view.setAutoCreateRowSorter(true);
		
		JScrollPane pane = new JScrollPane(view);
		pane.setForeground(Color.orange);
		pane.setBackground(Color.white);
		pane.setBounds(10,10,495,186);
		frame.getContentPane().add(pane);
		
		item = new JTextField();
		item.setBounds(10, 235, 130, 26);
		frame.getContentPane().add(item);
		item.setColumns(10);
		
		price = new JTextField();
		price.setBounds(188, 235, 130, 26);
		frame.getContentPane().add(price);
		price.setColumns(10);
		
		allergens = new JTextField();
		allergens.setBounds(375, 235, 130, 26);
		frame.getContentPane().add(allergens);
		allergens.setColumns(10);
		
		MenuItem = new JLabel("Menu item");
		MenuItem.setForeground(Color.ORANGE);
		MenuItem.setBounds(33, 207, 95, 16);
		frame.getContentPane().add(MenuItem);
		
		Price = new JLabel("Price");
		Price.setForeground(Color.ORANGE);
		Price.setBounds(230, 208, 95, 16);
		frame.getContentPane().add(Price);
		
		Allergens = new JLabel("Allergens");
		Allergens.setForeground(Color.ORANGE);
		Allergens.setBounds(401, 208, 95, 16);
		frame.getContentPane().add(Allergens);
		
		Object[] rows = new Object[3];
		
		add = new JButton("ADD  item");
		add.setBackground(Color.ORANGE);
		add.setForeground(Color.ORANGE);
		add.setBounds(6, 260, 256, 75);
		frame.getContentPane().add(add);
		
		//functio for adding items to list
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rows[0] = item.getText();
				rows[1] = price.getText();
				rows[2] = allergens.getText();
				
			}
			
		});
		
		delete = new JButton("DELETE item");
		delete.setForeground(Color.ORANGE);
		delete.setBounds(263, 260, 249, 75);
		frame.getContentPane().add(delete);
		//function for deleting items out of list
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = view.getSelectedRow();
				if(i>=0) {
					model.removeRow(i);
				} else {
					JOptionPane.showMessageDialog(frame, "Nothing selected!");
				}
				
			}
			
		});
		
	}
}
