
public class Owner extends User {

	private Menu menu;

	public Owner(String email, String password)
	{
		super(email, password);
	}
	/*
	 * public void viewCustomerView() {
	 * 	view customer view
	 * }
	 */

	/*
	 * public void viewRegistry()
	 */

	public void setMenu(Menu menu) throws Exception {
		if (this.menu == null) {
			this.menu = menu;
		} else {
			throw Exception("Menu already exists");
		}
	}

	public void addFood(Food food) {
		this.menu.add(food);
	}

	/*
	 * public void editFood(Food)
	 */

	public void deleteFood(Food food) {
		for (int i = 0; i < this.menu.getCount(); i++) {
			if (food.getClass().equals(this.menu.getItems().get(i))) {
				this.menu.remove(food);
			}
		}
	}

	 public void giveCoupon(Customer customer, Float amount) {
		 Coupon newCoupon = new Coupon(customer, amount);
	 }

	/*
	 * public void exitCustomerView()
	 */

	/*
	 * public void viewFood(Food)
	 */
}
