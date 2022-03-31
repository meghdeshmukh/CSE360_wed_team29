import java.util.*;

public class Coupon {
	private Customer customer;
	private Float amount;

	public Coupon(Customer customer, Float amount) {
		this.customer = customer;
		this.amount = amount;
		this.customer.addCoupon(this);
	}

	public Float getAmount() {
		return this.amount;
	}

	public Customer getCustomer() {
		return this.customer;
	}

}
