package com.company;

import java.util.ArrayList;

public abstract class Produit {

    String name ;
    double price ;
    public Produit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void afficher() {
       System.out.println(name + " -------> "+price+" Dhs");
    }

    void ajouterAlimet(Category category){
        category.produits.add(this);
    }

}
