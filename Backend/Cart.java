import java.util.ArrayList;
public class Cart {
	
	private Float total;
	private ArrayList<String> items = new ArrayList<String>();
	
	public Cart() {
		this.total = 0.0f;
	}
	
	public void addToCart(String name, Float amount) {
		this.items.add(name);
		this.total += amount;
	}
	
	public void deleteFromCart(String name, Float amount) {
		if (this.items.remove(name)) {
			this.total -= amount;
			System.out.println("Successfully Removed " + name);
		}
		else {
			System.out.println(name + " does not exist in your cart!");
		}
	}
	
	public Float getTotal() {
		return this.total;
	}
	
	public ArrayList<String> getItems() {
		return this.items;
	}

}
