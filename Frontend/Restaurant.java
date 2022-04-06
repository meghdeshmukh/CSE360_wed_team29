package Frontend;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import Backend.*;

/*///////////////////////////////////////////////////////////////////////////////////////////
 * 
 * THIS IS WHERE WE WILL START THE APPLICATION. RUN FROM THIS SCREEN TO ENSURE FUNCTIONALITY
 * 
 * ////////////////////////////////////////////////////////////////////////////////////////*/


public class Restaurant {
	
	public static void main(String[] args) {
		JFrame restaurantApplication = new JFrame();
		restaurantApplication.setSize(new Dimension(1400, 800));
		restaurantApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		restaurantApplication.setLocationRelativeTo(null);
		
		Application restaurant = new Application();
		restaurant.restoreApplication();
		restaurantApplication.addWindowListener(new WindowListener() {
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowClosing(WindowEvent e) {restaurant.saveApplication();}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}
		});
		
		login startApp = new login(restaurantApplication, restaurant, null);
		restaurantApplication.add(startApp);
		
		restaurantApplication.setVisible(true);
	}
}
