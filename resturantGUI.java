import javax.swing.JFrame;

public class resturantGUI {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Restaurant");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		login panel = new login();
		frame.getContentPane().add(new login());

		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
