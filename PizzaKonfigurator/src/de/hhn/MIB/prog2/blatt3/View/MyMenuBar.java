package de.hhn.MIB.prog2.blatt3.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar(){

        JMenu datei = new JMenu("Datei");
        JMenuItem abo = new JMenuItem("Beenden!");
        abo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(abo,"Exit?","Wxit title",JOptionPane.YES_NO_OPTION);
                if(n==0)
                    System.exit(0);
            }
        });
        datei.add(abo);
        add(datei);

        JMenu bestellung = new JMenu("Bestellung");
        JMenuItem abo2 = new JMenuItem("ups!");
        bestellung.add(abo2);
        add(bestellung);

        JMenu hilfe = new JMenu("Hilfe");
        JMenuItem abo3 = new JMenuItem("ups!");
        hilfe.add(abo3);
        add(hilfe);
    }
}
