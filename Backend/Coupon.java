import java.util.*;

public class Coupon {
	private Customer customer;
	private Double amount;

	public Coupon(Customer customer, Double amount) {
		this.customer = customer;
		this.amount = amount;
		this.customer.addCoupon(this);
	}

	public Double getAmount() {
		return this.amount;
	}

	public Customer getCustomer() {
		return this.customer;
	}

}
