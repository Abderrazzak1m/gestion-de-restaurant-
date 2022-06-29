package com.company;

import java.util.ArrayList;
import java.util.List;

public class Commande {

    ArrayList<CommandeItem> items ;

    public Commande(ArrayList<CommandeItem> items) {
        this.items = items;
    }


    public double calculeTotal(){
        double total = 0 ;
        for (int i = 0;i<items.size();i++){
            total = total + items.get(i).calculeItem();
        }
        return total;
    }
}
