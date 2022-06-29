package com.company;

import java.util.ArrayList;

public class Category {
    String name ;
    ArrayList<Produit> produits;

    public Category(String name) {
        this.name = name;
        this.produits = new ArrayList<Produit>();
    }

    public void addAliment(Produit produit){
        produits.add(produit);
    }

    void afficherProduits(){
        produits.forEach((produit)->{
            produit.afficher();
        });
    }
}
