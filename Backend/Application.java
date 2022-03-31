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

    public Application() {
        users = new ArrayList<User>();
        orders = new ArrayList<Order>();
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
}
