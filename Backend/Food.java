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
    private Float price;
    private int calories;

    public Food(String name, String imgPath, String[] ingredients, Float price, int calories) {
        this.imgPath = imgPath;
        this.name = name;
        this.ingredients =  ingredients;
        this.price = price;
        this.calories = calories;
    }

    public String getName() {
        return this.name;
    }

    public String[] getIngredients() {
        return this.ingredients;
    }

    public Float getPrice() {
        return this.price;
    }

    public int getCalories() {
        return this.calories;
    }

    public String getImg() {
        return this.imgPath;
    }
}