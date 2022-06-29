package com.company;

public class CommandeItem {

    Produit produit;
    int quantity ;

    public CommandeItem(Produit produit) {
        this.produit = produit;
        this.quantity=0;
    }


    public double calculeItem(){
        double total = produit.price*quantity ;
        return total;
    }

    public void afficherItem(){
        System.out.println(produit.name);
        System.out.println("Quantity:"+quantity);
    }
}
