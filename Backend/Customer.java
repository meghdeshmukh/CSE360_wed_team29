package Backend;
import java.util.*;

public class Customer extends User{

	private String username;
	private String phone;
	private String name;
	private Boolean isGuest;
	private Cart cart;
	public List<Double> coupons;
	private List<Payment> payments;
	private int totalVisits;

	public Customer (String email, String password, String username, String phone, String name) {
		super(email, password);
		this.username = username;
		this.phone = phone;
		this.name = name;
		this.isGuest = true;
		this.cart = new Cart();
		this.payments = new ArrayList<Payment>();
		totalVisits = 0;
	}

	public Customer() {
		super("", "");
		this.isGuest = true;
		this.cart = new Cart();
		totalVisits = 0;
	}

	public void register(String email, String password, String username, String phone, String name) {
		this.changeEmail(email);
		this.changePassword(password);
		this.changeUsername(username);
		this.changePhone(phone);
		this.changeName(name);
		this.isGuest = false;
		this.payments = new ArrayList<Payment>();
		totalVisits = 0;
		this.coupons = new ArrayList<Double>();
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

	public void addCoupon(Double coupon) {
		this.coupons.add(coupon);
	}

	public List<Double> getCoupons() {
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
	
	
	public int getVisits() {
		return totalVisits;
	}

	public Order customerCheckout(Payment payment, List<Double> couponsUsed) {
		Order order = new Order(this);
		order.setPayment(payment);
		order.setPrice(this.cart.getTotal());
		this.cart = new Cart();
		totalVisits++;
		for(Double coupon : couponsUsed) {
			if(this.coupons.contains(coupon))
				this.coupons.remove(coupon);
		}
		return order;
	}

	public Order altCheckout(String accountNumber, String cardHolderName, String expireDate, int cvv, List<Double> couponsUsed) {
		Order order = new Order(this);
		Payment payment = new Payment(accountNumber, cardHolderName, expireDate, cvv);
		order.setPayment(payment);
		order.setPrice(this.cart.getTotal());
		this.cart = new Cart();
		totalVisits++;
		if(!this.getIsGuest())
			for(Double coupon : couponsUsed) {
				if(this.coupons.contains(coupon))
					this.coupons.remove(coupon);
			}
		return order;
	}

}
