import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JLabel;
/**
 * 
 * @author Yue Fang
 * create a circle JLabel
 *
 */
@SuppressWarnings("serial")
public class CircleLabel extends JLabel{
	private Color color;
	private int size;
	private String text;
	
	public CircleLabel(String text,Color color,int size) {
		this.text = text;
		this.color = color;
		this.size = size;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g.create();
		int strokeWidth = 2;
		g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.setColor(Color.black);
		Ellipse2D circle = new Ellipse2D.Double(0, 0, size, size);
		g2d.draw(circle);
		g2d.setColor(color);
		g2d.fill(circle);
		g2d.setColor(Color.black);
		g2d.drawString(text, size/2,size/2);
	}
}
