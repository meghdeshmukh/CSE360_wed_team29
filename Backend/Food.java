/*
Author: Megh Deshmukh in conjunction with CSE 360 Wednesday Team 29

Code is currently untested and unfinished due to non-integration
test
*/
import java.util.*;
public class Food {
    private String imgPath;
    private String name;
    private String[] ingredients;
    private Double price;
    private int calories;
    private int timeCook;

    public Food(String name, String imgPath, String[] ingredients, Double price, int calories, int timeCook) {
        this.imgPath = imgPath;
        this.name = name;
        this.ingredients =  ingredients;
        this.price = price;
        this.calories = calories;
        this.timeCook = timeCook;
    }

    public String getName() {
        return this.name;
    }

    public String[] getIngredients() {
        return this.ingredients;
    }

    public Double getPrice() {
        return this.price;
    }

    public int getCalories() {
        return this.calories;
    }

    public String getImg() {
        return this.imgPath;
    }
    
    public int getTime() {
    	return this.timeCook;
    }
}
