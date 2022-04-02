import java.util.*;
public class Cart {

	private Double total;
	private List<Food> items;

	public Cart() {
		this.total = 0.0;
		items = new ArrayList<Food>();
	}

	public void addToCart(Food food) {
		this.items.add(food);
		this.total += food.getPrice();
	}

	public void deleteFromCart(Food food) {
		if (this.items.remove(food)) {
			this.total -= food.getPrice();
			
		}
	}

	public Double getTotal() {
		return this.total;
	}

	public List<Food> getItems() {
		return this.items;
	}

}
