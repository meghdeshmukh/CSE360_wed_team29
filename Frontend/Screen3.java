

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 
 * @author Yue Fang
 *
 */
@SuppressWarnings("serial")
public class Screen3 extends JFrame {
	private JTextField textField;
	private JLabel headerLabel;
	private JLabel headerLabel2;
	private JLabel emailLabel;
	private JLabel messageLabel;
	private JButton sendButton;
	private JButton cancelButton;
	private int totalTime = 60;

	public Screen3() {
		init();
		setStyle();
		addEventHandler();
	}
	/**
	 * init
	 */
	private void init() {
		headerLabel = new JLabel("Please type your email address here,");
		headerLabel2 = new JLabel("so we can send you a link to reset password");
		emailLabel = new JLabel("Email address");
		textField = new JTextField();
		sendButton = new JButton("Submit");
		cancelButton = new JButton("Cancel");
		messageLabel = new JLabel("");
	}

	/**
	 * set style
	 */
	private void setStyle() {
		getContentPane().setLayout(null);

		headerLabel.setBounds(108, 23, 240, 15);
		getContentPane().add(headerLabel);

		headerLabel2.setBounds(94, 48, 284, 15);
		getContentPane().add(headerLabel2);

		emailLabel.setBounds(67, 88, 114, 15);
		getContentPane().add(emailLabel);

		textField.setBounds(240, 85, 163, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		sendButton.setBackground(Color.RED);
		sendButton.setBounds(63, 161, 130, 23);
		getContentPane().add(sendButton);

		cancelButton.setBounds(285, 161, 93, 23);
		getContentPane().add(cancelButton);

		messageLabel.setForeground(Color.RED);
		messageLabel.setBounds(130, 129, 198, 15);
		getContentPane().add(messageLabel);
	}
	/**
	 * add event handler to button
	 */
	private void addEventHandler() {
		sendButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				totalTime = 10;
				messageLabel.setText("Email has been sent");
				startSubmit();
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO:
			}
		});
	}
	/**
	 * Countdown counter
	 */
	private void startSubmit() {
		Timer timer=new Timer();

		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				sendButton.setText("Submit("+totalTime+")");
				if (totalTime == 0) {
					sendButton.setText("Submit");
					timer.cancel();
					return;
				}
				totalTime--;
			}
		}, 100,1000);
	}
	public static void main(String[] args) {
		Screen3 window = new Screen3();
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setSize(530, 300);
		window.setVisible(true);
	}
}
