

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
/**
 * 
 * @author Yue Fang
 * list for repository
 *
 */
public class RepositoryListPanel extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private List<RepositoryItemPanel> items = new ArrayList<>();
	public RepositoryListPanel() {
		this.setLayout(new FlowLayout());
		init();
		
	}
	/**
	 * init ui
	 */
	private void init() {
		this.removeAll();
		this.updateUI();
		for (RepositoryItemPanel item : items) {
			item.setPreferredSize(new Dimension(510,80));
			this.add(item);
		}
		this.updateUI();
		this.validate();
	}
	/**
	 * update ui
	 */
	public void refresh() {
		init();
	}
	/**
	 * add a reponsitory item
	 * @param item RepositoryItemPanel
	 */
	public void addItem(RepositoryItemPanel item) {
		items.add(item);
	}
	

}
