package Backend;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/*
Author: Megh Deshmukh in conjunction with CSE 360 Wednesday Team 29

Code is currently untested and unfinished due to non-integration
test
*/
public class Food implements Serializable{
    private String imgName;
    private String name;
    private String[] ingredients;
    private Double price;
    private int calories;
    private int timeCook;

    public Food(String name, String imgName, String[] ingredients, Double price, int calories, int timeCook) {
        this.imgName = imgName;
        this.name = name;
        this.ingredients =  ingredients;
        this.price = price;
        this.calories = calories;
        this.timeCook = timeCook;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

    public String[] getIngredients() {
        return this.ingredients;
    }
    
    public void replaceIng(ArrayList<String> newIngredients) {
    	ingredients = new String[newIngredients.size()];
    	for(int i = 0; i < newIngredients.size(); i++)
    		ingredients[i] = newIngredients.get(i);
    }

    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
    	this.price = price;
    }

    public int getCalories() {
        return this.calories;
    }
    
    public void setCalories(int calories) {
    	this.calories = calories;
    }

    
    public String getImageName() {
    	return this.imgName;
    }
    public BufferedImage getImg() {
        try {
			return ImageIO.read(Food.class.getResource("../images/" + this.imgName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    
    public void setImageName(String imgName) {
    	this.imgName = imgName;
    }

    public int getTime() {
    	return this.timeCook;
    }
    
    /*
     * testing to make sure the image finder functions works
     */
    public static void main(String[] args) {
    	
    	try {
			//File file = new File("C:\\Users\\gmota\\eclipse-workspace\\CSE360Project\\src\\images\\c.jpg");
			BufferedImage image = ImageIO.read(Food.class.getResource("../images/salmon.png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}