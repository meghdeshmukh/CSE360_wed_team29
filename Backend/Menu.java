/*
Author: Megh Deshmukh in conjunction with CSE 360 Wednesday Team 29

Code is currently untested and unfinished due to non-integration
*/
import java.util.*;

/*
 * Change Log
 * added test values
 */

public class Menu {
    private int numItems;
    private List<Food> foodItems;

    public Menu() {
       this.numItems = 0;
        this.foodItems = new ArrayList<Food>();
        
        for(int i = 0; i < 120; i++) {
        	String[] ingredients = new String[3];
        	Food food = new Food("Item #" + Integer.toString(i+1), "/path", ingredients, (double) i, i);
        	foodItems.add(food);
        	this.numItems++;
        }
    }

    public void add(Food item) {
        this.foodItems.add(item);
        this.numItems++;
    }
    
    /*
    public list retrive(String name) {
    	return list of Food that match string
    }
	*/
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