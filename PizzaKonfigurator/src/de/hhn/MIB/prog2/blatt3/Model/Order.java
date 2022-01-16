package de.hhn.MIB.prog2.blatt3.Model;

import java.util.LinkedList;
import java.util.List;

public class Order extends Pizza{
    public long orderld;
    List<Pizza> pizzas = new LinkedList<>();

    public Order(int price, PizzaSize size) {
        super(price, size);
    }

    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }
    public void removePizza(Pizza pizza){

        if(pizzas.size()==0|| !pizzas.contains(pizza))
            throw new IllegalArgumentException();
        pizzas.remove(pizza);
    }


    public void calculateTotalOrderCost(){
        for (Pizza pizza : pizzas){
            switch (pizza.getSize()){
                case SMALL:
                    orderld+=pizzaCost.get(PizzaSize.SMALL);
                    break;
                case MEDIUM:
                    orderld+=pizzaCost.get(PizzaSize.MEDIUM);
                    break;
                case LARGE:
                    orderld+=pizzaCost.get(PizzaSize.LARGE);
                    break;
                case EXTRA_LARGE:
                    orderld+=pizzaCost.get(PizzaSize.EXTRA_LARGE);
                    break;
                default:
                    orderld+=0;
                    break;

            }
            int totalToppings = pizza.getPizzaToppings().size();
            orderld+=totalToppings * 50;
        }
    }

    public long getOrderld() {
        return orderld;
    }

    public void setOrderld(long orderld) {
        this.orderld = orderld;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
