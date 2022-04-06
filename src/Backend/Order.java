package Backend;
import java.io.Serializable;

/*
Author: Megh Deshmukh in conjunction with CSE 360 Wednesday Team 29

Code is currently untested and unfinished due to non-integration
*/
public class Order implements Serializable{
    private Customer customer;
    private Cart cart;
    private Payment payment;
    private Double totalPrice;
    private int totalTime;

    public Order(Customer customer) {
        this.customer = customer;
        this.cart = customer.getCart();
        this.totalTime = cart.getTime();
    }
    
    public Customer returnCustomer() {
    	return customer;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getPrice() {
        return this.totalPrice;
    }

    public void setPrice(Double newPrice) {
        this.totalPrice = newPrice;
    }

    public int getTime() {
    	return totalTime;
    }
}