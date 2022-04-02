import java.util.ArrayList;

/*
 * Change Log
 * Float to Double
 */

public class Cart {

	private Double total;
	private ArrayList<Food> items = new ArrayList<Food>();

	public Cart() {
		this.total = 0d;
	}

	public void addToCart(Food food) {
		this.items.add(food);
		this.total += food.getPrice();
	}

	public void deleteFromCart(Food food) {
		if (this.items.remove(food)) {
			this.total -= food.getPrice();
			//System.out.println("Successfully Removed " + name);
		}
		else {
			//System.out.println(name + " does not exist in your cart!");
		}
	}

	public Double getTotal() {
		return this.total;
	}

	public ArrayList<Food> getItems() {
		return this.items;
	}

}