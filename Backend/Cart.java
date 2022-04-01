import java.util.*;
public class Cart {

	private Float total;
	private List<Food> items;

	public Cart() {
		this.total = 0.0f;
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

	public Float getTotal() {
		return this.total;
	}

	public List<Food> getItems() {
		return this.items;
	}

}
