/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

/**
 *
 * @author andre
 */
public class Dish {
    private String dishName;
    private double bigSizePrice;          
    private boolean spicy;
    private char size;          // s m l
    private static final double MEDIAL_PRICE_RATIO = 0.6;
    private static final double SMALL_PRICE_RATIO = 0.4;

    public Dish(String dishName, double bigSizePrice, boolean spicy, char size) {
        this.dishName = dishName;
        this.bigSizePrice = bigSizePrice;
        this.spicy = spicy;
        this.size = Character.toUpperCase(size);
    }
    
    /**
     * To calculate the price for the dish, based on the size
     * @return the price for the dish
     */
    public double calcDishPrice() {
        if (size == 'S')
            return bigSizePrice * SMALL_PRICE_RATIO;
        if (size == 'M')
            return bigSizePrice * MEDIAL_PRICE_RATIO;

        return bigSizePrice;
    }
    
    public boolean equals(Dish dish) {
        return this.dishName.equals(dish.dishName) && 
                this.bigSizePrice == dish.bigSizePrice && 
                this.spicy == dish.spicy && 
                this.size == dish.size;
    }

    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-10s: %s", "Name", dishName);
        str += String.format("%-10s: %.2f", "Full Price", bigSizePrice);
        str += String.format("%-10s: %s", "Spicy", spicy ? "Spicy" : "Not spicy");
        str += String.format("%-10s: %c", "Size", size);
        
        return str;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getBigSizePrice() {
        return bigSizePrice;
    }

    public void setBigSizePrice(double bigSizePrice) {
        this.bigSizePrice = bigSizePrice;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = Character.toUpperCase(size);
    }
}
