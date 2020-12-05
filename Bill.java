/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Bill {
    private ArrayList<Dish> orderedDishes;
    private double tipRatio;
    private final static double FED_TEX_RATIO = 0.05;
    private final static double PRO_TEX_RATIO = 0.1;

    public Bill(ArrayList<Dish> orderedDishes, double tipRatio) {
        this.orderedDishes = orderedDishes;
        this.tipRatio = tipRatio;
    }
    
    public Bill(Bill bill) {
        this.orderedDishes = bill.orderedDishes;
        this.tipRatio = bill.tipRatio;
    }
    
    /**
     * To calculate the total price of the dishes without tax and tips
     * @return the total price of the dishes without tax and tips
     */
    public double calcTotalDishPrice() {
        double sum = 0;
        for (int i = 0; i < orderedDishes.size(); i++) 
            sum += orderedDishes.get(i).calcDishPrice();
        
        return sum;
    }
    
    public boolean equals(Bill bill) {
        return this.orderedDishes.equals(bill.orderedDishes) &&
                this.tipRatio == bill.tipRatio;
    }

    @Override
    public String toString() {
        String str = "";
        
        for (int i = 0; i < orderedDishes.size(); i++) {
            Dish dish = orderedDishes.get(i);
            str += String.format("%-18s: %-15s %-5c $%.2f\n", 
                    "Dish", dish.getDishName(), dish.getSize(), dish.calcDishPrice());
        }
        
        double totalDishPrice = calcTotalDishPrice();
        str += String.format("%-18s: $%.2f\n\n", "Total Dish Price", totalDishPrice);
        
        double fedTax = totalDishPrice * FED_TEX_RATIO;
        double qcTax = totalDishPrice * PRO_TEX_RATIO;
        double totalTax = fedTax + qcTax;
        
        str += String.format("%-18s: $%.2f\n", "Fed Tax", fedTax);
        str += String.format("%-18s: $%.2f\n", "QC Tax", qcTax);
        str += String.format("%-18s: $%.2f\n\n", "Total Tax", totalTax);
        
        double tips = (totalDishPrice + totalTax) * tipRatio;
        str += String.format("%-18s: $%.2f\n", "Tips", tips);
        
        str += "------------------------------\n";
        double finalPrice = totalDishPrice + totalTax + tips;
        str += String.format("%-18s: $%.2f\n", "Total", finalPrice);

        return str;
    }

    public ArrayList<Dish> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(ArrayList<Dish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public double getTipRatio() {
        return tipRatio;
    }

    public void setTipRatio(double tipRatio) {
        this.tipRatio = tipRatio;
    }
}
