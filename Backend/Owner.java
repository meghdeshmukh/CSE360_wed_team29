
public class Owner extends User {

	private Menu menu;

	public Owner(String email, String password)
	{
		super(email, password);
	}

	public Owner() {
		super("", "");
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
		}
	}

	public void addFood(Food food) {
		this.menu.add(food);
	}

	/*
	 * public void editFood(Food)
	 */

	public void deleteFood(Food food) {
		for(Food menuFood: menu.getItems())
			if(food.equals(menuFood))
				this.menu.remove(menuFood);
	}

	 public void giveCoupon(Customer customer, Double amount) {
		 Coupon newCoupon = new Coupon(customer, amount);
	 }

	/*
	 * public void exitCustomerView()
	 */

	/*
	 * public void viewFood(Food)
	 */
}
