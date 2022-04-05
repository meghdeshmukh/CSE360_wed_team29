package Backend;
/*
Author: Megh Deshmukh in conjunction with CSE 360 Wednesday Team 29

Code is currently untested and unfinished due to non-integration
*/
import java.io.Serializable;
import java.util.*;
public class Menu implements Serializable{
    private int numItems;
    private List<Food> foodItems;

    public Menu() {
        this.numItems = 0;
        this.foodItems = new ArrayList<Food>();
    }

    public void add(Food item) {
        this.foodItems.add(item);
        this.numItems++;
    }

    public void remove(Food item) {
        this.foodItems.remove(item);
        this.numItems--;
    }

    public List<Food> getItems() {
        return this.foodItems;
    }

    public int getCount() {
        return this.numItems;
    }
}