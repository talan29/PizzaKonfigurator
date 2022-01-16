package de.hhn.MIB.prog2.blatt3.View;

import de.hhn.MIB.prog2.blatt3.Model.Order;
import de.hhn.MIB.prog2.blatt3.Model.Pizza;
import de.hhn.MIB.prog2.blatt3.Model.PizzaSize;
import de.hhn.MIB.prog2.blatt3.Model.PizzaTopping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Pizzakonfigurator extends JFrame {

    float amount=0;

    JButton beenden;
    JButton fertig;

    JCheckBox tomato;
    JCheckBox cheese;
    JCheckBox salami;
    JCheckBox ham;
    JCheckBox ananas;
    JCheckBox vegetables;
    JCheckBox seafood;
    JCheckBox nutella;
    JCheckBox sourCream;

    JComboBox sizePizza;

    String res="";

    public JButton getFertig() {
        return fertig;
    }

    public void setFertig(JButton fertig) {
        this.fertig = fertig;
    }

    public Pizzakonfigurator(){

        //Panel
        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0,200,200);
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setLayout(new BorderLayout());

        JPanel panel2 = new JPanel();
        panel2.setBounds(200,0,200,200);
        panel2.setBackground(Color.WHITE);
        panel2.setLayout(new GridLayout(10,1));

        JPanel panel3 = new JPanel();
        panel3.setBounds(400,0,200,200);
        panel3.setBackground(Color.GREEN);
        panel3.setLayout(new GridLayout(2,1));

        JPanel panel4 = new JPanel();
        panel4.setBounds(400,200,200,200);
        panel4.setBackground(Color.WHITE);
        JLabel imageLabel = new JLabel();
        ImageIcon pizzaImg = new ImageIcon("src/pizzaPic.jpg");
        imageLabel.setIcon(pizzaImg);
        panel4.add(imageLabel);
        panel4.setLayout(new FlowLayout());

        JPanel panel5 = new JPanel();
        panel5.setBounds(400,0,200,200);
        panel5.setBackground(Color.GRAY);
        panel5.setLayout(new FlowLayout());

        //Buttons
        beenden = new JButton("Beenden");
        beenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(beenden,"Exit?","Exit title",JOptionPane.YES_NO_OPTION);
                if(n==0)
                    System.exit(0);
            }
        });

        fertig = new JButton("Fertig");

        //Label
        JLabel label1= new JLabel("Größe: ");
        JLabel label2 = new JLabel("Belog: ");

        //CheckBox

        tomato = new JCheckBox("Tomato");
        cheese = new JCheckBox("Cheese");
        salami = new JCheckBox("Salami");
        ham = new JCheckBox("Ham");
        ananas = new JCheckBox("Ananas");
        vegetables = new JCheckBox("Vegetables");
        seafood = new JCheckBox("Seafood");
        nutella = new JCheckBox("Nutella");
        sourCream = new JCheckBox("Sour cream");

        //ComboBox

        sizePizza = new JComboBox(PizzaSize.values());

        //MenuBar
        JMenuBar menu = new MyMenuBar();

        //ButtonAction

        fertig.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PizzaSize selectedSize = null;
                System.out.print("You have chosen: "+sizePizza.getSelectedItem().toString()+" size pizza with: ");
                String str1 = "You have chosen: "+sizePizza.getSelectedItem().toString()+" size pizza with: \n";
                res +=str1;
                if(sizePizza.getSelectedItem()==PizzaSize.SMALL) {
                    amount += 5;
                    selectedSize=PizzaSize.SMALL;
                }
                if(sizePizza.getSelectedItem()==PizzaSize.MEDIUM){
                    amount+=6;
                    selectedSize=PizzaSize.MEDIUM;
                }
                if(sizePizza.getSelectedItem()==PizzaSize.LARGE){
                    amount+=8;
                    selectedSize=PizzaSize.LARGE;
                }
                if(sizePizza.getSelectedItem()==PizzaSize.EXTRA_LARGE){
                    amount+=11;
                    selectedSize=PizzaSize.EXTRA_LARGE;
                }
                if(tomato.isSelected()){
                    System.out.print("tomato ");
                    String str2 = "tomato ";
                    res += str2;
                    amount+=0.5;
                }
                if (cheese.isSelected()){
                    System.out.print("cheese ");
                    String str3 = "cheese ";
                    res += str3;
                    amount+=0.5;
                }
                if (salami.isSelected()) {
                    System.out.print("salami ");
                    String str4 = "salami ";
                    res +=str4;
                    amount+=0.5;
                }
                if (ham.isSelected()) {
                    System.out.print("ham ");
                    String str5 = "ham ";
                    res += str5;
                    amount+=0.5;
                }
                if (ananas.isSelected()) {
                    System.out.print("ananas ");
                    String str6 = "ananas ";
                    res += str6;
                    amount+=0.5;
                }
                if (vegetables.isSelected()) {
                    System.out.print("vegetables ");
                    String str7 = "vegetables ";
                    res += str7;
                    amount+=0.5;
                }
                if (seafood.isSelected()) {
                    System.out.print("seafood ");
                    String str8 = "seafood ";
                    res += str8;
                    amount+=0.5;
                }
                if (nutella.isSelected()) {
                    System.out.print("nutella ");
                    String str9 = "nutella ";
                    res += str9;
                    amount+=0.5;
                }
                if (sourCream.isSelected()) {
                    System.out.print("sour cream ");
                    String str10 = "sour cream ";
                    res += str10;
                    amount+=0.5;
                }
                res += "\n Total amount: "+amount +"Euro";
                int result = JOptionPane.showConfirmDialog(beenden,res,"Order confirm title",JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    Pizza myPizza = new Pizza(amount,selectedSize );
                    //System.exit(0);
                }
            }
        });


        //JOptionPane
        //int n = JOptionPane.showConfirmDialog(beenden,"Exit?","Wxit title",JOptionPane.YES_NO_OPTION);

        //Layout
        JFrame frame = new JFrame();
        frame.setTitle("Pizzakonfigurator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        frame.setSize(900,600);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        panel3.add(panel4);
        panel3.add(panel5);
        panel5.add(fertig);
        panel5.add(beenden);
        panel1.add(label1, BorderLayout.NORTH);
        panel1.add(label2, BorderLayout.CENTER);
        panel2.add(sizePizza);
        panel2.add(tomato);
        panel2.add(cheese);
        panel2.add(salami);
        panel2.add(ham);
        panel2.add(ananas);
        panel2.add(vegetables);
        panel2.add(seafood);
        panel2.add(nutella);
        panel2.add(sourCream);

        frame.setJMenuBar(menu);
        frame.setVisible(true);
    }

    //Getters & Setters


    public JButton getBeenden() {
        return beenden;
    }

    public JComboBox getSizePizza() {
        return sizePizza;
    }

    public void setSize(JComboBox size) {
        this.sizePizza = size;
    }

    public void setBeenden(JButton beenden) {
        this.beenden = beenden;
    }

    public JCheckBox getTomato() {
        return tomato;
    }

    public void setTomato(JCheckBox tomato) {
        this.tomato = tomato;
    }

    public JCheckBox getCheese() {
        return cheese;
    }

    public void setCheese(JCheckBox cheese) {
        this.cheese = cheese;
    }

    public JCheckBox getSalami() {
        return salami;
    }

    public void setSalami(JCheckBox salami) {
        this.salami = salami;
    }

    public JCheckBox getHam() {
        return ham;
    }

    public void setHam(JCheckBox ham) {
        this.ham = ham;
    }

    public JCheckBox getAnanas() {
        return ananas;
    }

    public void setAnanas(JCheckBox ananas) {
        this.ananas = ananas;
    }

    public JCheckBox getVegetables() {
        return vegetables;
    }

    public void setVegetables(JCheckBox vegetables) {
        this.vegetables = vegetables;
    }

    public JCheckBox getSeafood() {
        return seafood;
    }

    public void setSeafood(JCheckBox seafood) {
        this.seafood = seafood;
    }

    public JCheckBox getNutella() {
        return nutella;
    }

    public void setNutella(JCheckBox nutella) {
        this.nutella = nutella;
    }

    public JCheckBox getSourCream() {
        return sourCream;
    }

    public void setSourCream(JCheckBox sourCream) {
        this.sourCream = sourCream;
    }


    public static void main(String[] args){
        new Pizzakonfigurator();
    }

}
