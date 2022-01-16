package de.hhn.MIB.prog2.blatt3.Controller;

import de.hhn.MIB.prog2.blatt3.Model.Pizza;
import de.hhn.MIB.prog2.blatt3.View.Pizzakonfigurator;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private Pizza model;
    private Pizzakonfigurator view;

    public  Controller(Pizza m, Pizzakonfigurator v){
        model = m;
        view = v;
    }
    private void initView(){
        //view.getSizePizza();
    }
    public void initController(){
       // view.getSizePizza().addActionListener(e -> savePizzasize);
    }
    public void savePizzasize(){

    }
}
