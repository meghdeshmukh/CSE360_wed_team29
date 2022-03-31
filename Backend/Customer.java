import java.util.*;

public class Customer extends User{

	private String username;
	private String phone;
	private String name;
	private Boolean isGuest;
	private Cart cart;
	private List<Coupon> coupons;
	private List<Payment> payments;

	public Customer (String email, String password, String username, String phone, String name) {
		super(email, password);
		this.username = username;
		this.phone = phone;
		this.name = name;
		this.isGuest = true;
		this.cart = new Cart();
	}

	public void register(String email, String password, String username, String phone, String name) {
		this.changeEmail(email);
		this.changePassword(password);
		this.changeUsername(username);
		this.changePhone(phone);
		this.changeName(name);
		this.isGuest = false;
	}

	public void changeUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void changePhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void changeName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public boolean getIsGuest() {
		return this.isGuest;
	}

	public void addCoupon(Coupon coupon) {
		this.coupons.add(coupon);
	}

	public List<Coupon> getCoupons() {
		return this.coupons;
	}

	public void addCart(Food food) {
		this.cart.addToCart(food);
	}

	public void deleteCart(Food food) {
		this.cart.deleteFromCart(food);;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void addPayment(Payment payment) {
		this.payments.add(payment);
	}

	public void removePayment(Payment payment) {
		this.payments.remove(payment);
	}

	public List<Payment> getPayments() {
		return this.payments;
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

	public Order customerCheckout(Payment payment) {
		Order order = new Order(this);
		order.setPayment(payment);
		order.setPrice(this.cart.getTotal());
		return order;
	}

	public Order guestCheckout(String cardName, String cardType, String accountNumber, String cardHolderName, String expireDate, String address1, String address2, String city, String state, int zip) {
		Order order = new Order(this);
		Payment payment = new Payment(cardName, cardType, accountNumber, cardHolderName, expireDate, address1, address2, city, state, zip);
		order.setPayment(payment);
		order.setPrice(this.cart.getTotal());
		return order;
	}

}
