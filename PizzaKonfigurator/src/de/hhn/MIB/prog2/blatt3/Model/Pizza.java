package de.hhn.MIB.prog2.blatt3.Model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Pizza {
    float price;
    PizzaSize size;
    List<PizzaTopping> pizzaToppings;
    List<Pizza>orders = new LinkedList<>();

    HashMap<PizzaSize, Integer> pizzaCost = new HashMap<PizzaSize, Integer>();



    public void setPizzaCost(){
        pizzaCost.put(PizzaSize.SMALL,500);
        pizzaCost.put(PizzaSize.MEDIUM,600);
        pizzaCost.put(PizzaSize.LARGE,800);
        pizzaCost.put(PizzaSize.EXTRA_LARGE,1100);
        this.pizzaCost=pizzaCost;
    }




    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public List<PizzaTopping> getPizzaToppings() {
        return pizzaToppings;
    }

    public void setPizzaToppings(List<PizzaTopping> pizzaToppings) {
        this.pizzaToppings = pizzaToppings;
    }

    public Pizza(float price, PizzaSize size) {
        this.price = price;
        this.size = size;
    }


    public Pizza(int price, PizzaSize size, List<PizzaTopping> pizzaToppings, HashMap<PizzaSize, Integer> pizzaCost) {
        this.price = price;
        this.size = size;
        this.pizzaToppings = pizzaToppings;
        this.pizzaCost = pizzaCost;
    }
}
