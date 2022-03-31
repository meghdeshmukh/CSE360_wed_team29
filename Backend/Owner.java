
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

	/*
	 * public void addFood(Food)
	 */

	/*
	 * public void editFood(Food)
	 */

	/*
	 * public void deleteFood(Food)
	 */

	 public void giveCoupon(Customer customer, Float amount) {
		 Coupon newCoupon = new Coupon(customer, amount);
		 System.out.println("Coupon Given");
	 }

	/*
	 * public void exitCustomerView()
	 */

	/*
	 * public void viewFood(Food)
	 */
}
