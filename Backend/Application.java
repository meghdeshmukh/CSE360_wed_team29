/*
Author: Megh Deshmukh in conjunction with CSE 360 Wednesday Team 29

Code is currently untested and unfinished due to non-integration
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
public class Application implements Serializable{
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
    
    private int getOrderCount() {
    	return orders.size();
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

    public int numberOfOrders() {
        return this.orders.size();
    }
    
    public List<Order> getOrders(){
    	return this.orders;
    }
    
    public void saveApplication() {
    	try {
			FileOutputStream f = new FileOutputStream(new File("database.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(this);
			
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void restoreApplication() {
		FileInputStream fi;
		try {
			fi = new FileInputStream(new File("database.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
		
			Application retrievedApp = (Application) oi.readObject();
			
			this.users = retrievedApp.getUsers();
			this.menu = retrievedApp.getMenu();
			this.owner = retrievedApp.getOwner();
			this.orders = retrievedApp.getOrders();
			this.totalOrderTime = retrievedApp.getTotalOrderTime();
            
            oi.close();
            fi.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) {
    }
}
