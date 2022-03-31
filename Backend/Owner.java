
public class Owner extends User {


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

	public void addFood(Food food, Menu menu) {
		menu.add(food);
	}

	/*
	 * public void editFood(Food)
	 */

	public void deleteFood(Food food, Menu menu) {
		for (int i = 0; i < menu.getItems().size(); i++) {
			if (food.getClass().equals(menu.getItems().get(i))) {
				menu.remove(food);
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
