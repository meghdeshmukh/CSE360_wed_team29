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

    public Application(Owner owner) {
        this.owner = owner;
        users = new ArrayList<User>();
        orders = new ArrayList<Order>();
    }

    public Owner getOwner() {
        return this.owner;
    }

    public User[] getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addMenu(Menu menu) {
        if (this.menu == null) {
            this.menu = menu;
        } else {
            throw new Exception("Menu already set");
        }
    }

    public Menu getMenu() {
        return this.menu;
    }
}
