/*
Author: Megh Deshmukh in conjunction with CSE 360 Wednesday Team 29

Code is currently untested and unfinished due to non-integration
*/
public class Order {
    private Customer customer;
    private Payment payment;
    private Double totalPrice;

    public Order(Customer customer) {
        this.customer = customer;
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
}
