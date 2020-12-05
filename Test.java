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
public class Test {
    public static void main(String[] args) {
        Dish d1 = new Dish("Fries", 1.99, false, 'm');
        Dish d2 = new Dish("Cheese burger", 4.99, false, 'l');
        Dish d3 = new Dish("Milk shake", 4.99, false, 'l');

        ArrayList<Dish> dishes = new ArrayList<>();
        dishes.add(d1);
        dishes.add(d2);
        dishes.add(d3);

        Bill b1 = new Bill(dishes, 0.15);
        System.out.println(b1);
    }
    
}
