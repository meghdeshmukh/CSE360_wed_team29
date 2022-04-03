/*
Author: Megh Deshmukh in conjunction with CSE 360 Wednesday Team 29

Code is currently untested and unfinished due to non-integration
*/

import java.util.*;
public class Application {
    private List<User> users;
    private Menu menu;
    private Owner owner;
    private List<Order> orders;
    private int totalOrderTime;

    public Application() {
        users = new ArrayList<User>();
        orders = new ArrayList<Order>();
        totalOrderTime = 0;
    }

    public void setOwner(Owner owner) throws Exception {
        if (this.owner == null) {
            this.owner = owner;
        } else {
            throw new Exception("Owner already exists");
        }
    }

    public Owner getOwner() {
        return this.owner;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addMenu(Menu menu) throws Exception {
        if (this.menu == null) {
            this.menu = menu;
        } else {
            throw new Exception("Menu already set");
        }
    }

    public Menu getMenu() {
        return this.menu;
    }
    
    public User searchUser(String identifier, String password) {
    	for(User user: this.users) {
    		if(user.verifyLogin(identifier, password))
    			return user;
    	}
    	return null;
    }
    
    public void addOrder(Order order) {
    	this.orders.add(order);
    	totalOrderTime += order.getTime();
    }
    
    public int getTotalOrderTime() {
    	return totalOrderTime;
    }
}
