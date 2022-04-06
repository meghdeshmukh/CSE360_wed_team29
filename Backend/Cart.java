package Backend;
import java.io.Serializable;
import java.util.*;
public class Cart implements Serializable{

	private Double total;
	private List<Food> items;
	private int totalTime;

	public Cart() {
		this.total = 0.0;
		items = new ArrayList<Food>();
		this.totalTime = 0;
	}

	public void addToCart(Food food) {
		this.items.add(food);
		this.total += food.getPrice();
		this.totalTime += food.getTime();
	}

	public void deleteFromCart(Food food) {
		if (this.items.remove(food)) {
			this.total -= food.getPrice();
			this.totalTime -= food.getTime();
		}
	}

	public Double getTotal() {
		return this.total;
	}

	public List<Food> getItems() {
		return this.items;
	}

	public int getTime() {
		return this.totalTime;
	}
	
	public void update() {
		total = 0.0;
		totalTime = 0;
		for(Food food : items) {
			total += food.getPrice();
			totalTime += food.getTime();
		}
	}
}