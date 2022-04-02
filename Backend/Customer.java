import java.io.*;
import java.util.ArrayList;

/*
 * Change log
 * changed (string, string) parameters to (food) parameters
 * added the Payment class to customer, associated Accessor function
 */

public class Customer extends User{

	private String username;
	private String phone;
	private String name;
	private Boolean isGuest;
	private Cart cart;
	private ArrayList<Double> coupons = new ArrayList<Double>();
	//an array coupon of each coupon 
	private ArrayList<Payment> payments = new ArrayList<Payment>();

	public Customer (String email, String password, String username, String phone, String name) {
		super(email, password);
		this.username = username;
		this.phone = phone;
		this.name = name;
		this.isGuest = false;
		this.cart = new Cart();
	}

	
	public Customer() {
		super("", "");
		this.isGuest = true;
		this.cart = new Cart();
	}
	
	public boolean isGuest() {
		return isGuest;
	}
	
	/*
	public void register(String email, String password, String username, String phone, String name) {
		this.changeEmail(email);
		this.changeForcePassword(password);
		this.changeUsername(username);
		this.changePhone(phone);
		this.changeName(name);
		this.isGuest = false;
	}
	*/
	
	//GUI will create customer object
	//retrive the values from the inputs
	//set the values for the customer
	//

	public void changeUsername(String username) {
		this.username = username;
	}

	public void changePhone(String phone) {
		this.phone = phone;
	}

	public void changeName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getName() {
		return this.name;
	}

	public void addCoupon(Double coupon) {
		this.coupons.add(coupon);
	}
	
	public void useCoupon(int index) {
		this.coupons.remove(index);
	}

	/*
	public void viewCoupons() {
		for (int i = 0; i < this.coupons.size(); i++) {
			System.out.println(this.coupons.get(i).getAmount());
		}
	}
	*/

	public void addCart(Food food) {
		this.cart.addToCart(food);
	}

	public void deleteCart(Food food) {
		this.cart.deleteFromCart(food);;
	}

	/*
	public void viewCart() {
		System.out.println(this.cart.getItems());
		System.out.println(this.cart.getTotal());
	}
	*/
	
	public Cart getCart() {
		return cart;
	}
	
	public ArrayList<Payment> getPayments() {
		return payments;
	}

	
	public ArrayList<Double> getCoupons(){
		return coupons;
	}
	/*
	 * public void viewMenu() {
	 *  view menu GUI
	 *  }
	 */

	/* public void viewCart() {
	 *  view Cart GUI
	 *  }
	 */

	/*
	 *  public void viewItem(Food) {
	 *   view Food GUI
	 *   }
	 */

	/*
	 * public checkout() {
	 *  if isGuest
	 *   enter name and createPayment()
	 *  else
	 *   selectPayment()
	 *  }
	 */

	/*
	 * public Payment selectPayment() {
	 *  select payment and return
	 * }
	 */

	/* public void createPayment() {
	 * create a payment and return it
	 */
/*
	public static void main(String[] args) {
		Customer myCustomer = new Customer("Guest", "00000000", "Guest", "Guest", "Guest");
		Owner owner = new Owner("nlfuller@asu.edu", "Iamtheowner");
		myCustomer.register("nickfullerton2285@gmail.com", "Slimthug2285", "d1nick", "2815202266", "Nick Fullerton");
		System.out.println(myCustomer.getEmail());
		System.out.println(myCustomer.getPassword());
		System.out.println(myCustomer.getName());
		System.out.println(myCustomer.getUsername());
		System.out.println(myCustomer.getPhone());

		myCustomer.viewCoupons();
		owner.giveCoupon(myCustomer, 10.0f);
		myCustomer.viewCoupons();

		myCustomer.viewCart();
		myCustomer.addCart("chicken", 20.0f);
		myCustomer.addCart("yogurt", 5.0f);
		myCustomer.addCart("chicken", 20.0f);
		myCustomer.addCart("yogurt", 5.0f);
		myCustomer.addCart("yogurt", 5.0f);
		myCustomer.viewCart();

		myCustomer.deleteCart("yogurt", 5.0f);
		myCustomer.viewCart();
	}
	*/
}