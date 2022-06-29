package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Produit> produits = new ArrayList<Produit>();
        ArrayList<Category> categories = new ArrayList<Category>();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Commande> commandes = new ArrayList<Commande>();

        while (1==1){
            window(categories,produits,employees,commandes);
            System.out.println(produits.size());
        }

    }

    public void rapport(ArrayList<Produit> produits,ArrayList<Category> categories,ArrayList<Employee> employees,ArrayList<Commande> commandes){
         int nbrGerant = 0;
        int nbrServ = 0 ;
        for(int i = 0;i<employees.size();i++){
            if(employees.get(i) instanceof Gerant){
                nbrGerant ++;
            }
            else if(employees.get(i) instanceof Serveur){
                nbrServ++;
            }
        }
        System.out.println(String.valueOf(produits.size())+" Produits");
        System.out.println(String.valueOf(categories.size())+" Category");
        System.out.println(String.valueOf(nbrGerant)+" Gerants");
        System.out.println(String.valueOf(nbrServ)+" Serveurs");
    }

    public static void lireAliment(ArrayList<Produit> produits,ArrayList<Category> categories){

        Scanner myObj = new Scanner(System.in);
        System.out.println("ajouter le nom de l'aliment:");
        String name = myObj.nextLine();

        System.out.println("ajouter le prix de l'aliment:");
        double price = Double.parseDouble(myObj.nextLine());

        Aliment aliment = new Aliment(name,price);

        System.out.println("Quelle category voulez-vous ajouter ce produit");
        String catName = myObj.nextLine();

        categories.forEach((category)->{
            if(category.name.toLowerCase().contains(catName.toLowerCase())){
                category.produits.add(aliment);
                System.out.println("Done");
            }
            else {
                System.out.println("le Category n'existe pas");
            }
        });
        produits.add(aliment);
    }

    public static CommandeItem lireItem(ArrayList<Produit> produits){

        CommandeItem commandeItem = null;
        Scanner myObj = new Scanner(System.in);
        System.out.println("le nom de produit:");
        String nom = myObj.nextLine();

        for (int i=0;i< produits.size();i++){
            if(produits.get(i).name.toLowerCase().contains(nom.toLowerCase())){
                commandeItem = new CommandeItem(produits.get(i));
                break;
            }
        }
        if(commandeItem==null){
            System.out.println("Produit n'existe pas");
        }else{
            System.out.println("quantite:");
            int q = myObj.nextInt();
            commandeItem.quantity=q;
        }

        return commandeItem;
    }

    public static void ajouterCommande( ArrayList<Commande> commandes,ArrayList<Produit> produits){

        ArrayList<CommandeItem> items = new ArrayList<CommandeItem>();

        Scanner myObj = new Scanner(System.in);
        System.out.println("le nombre de produits dans la commande:");
        int nbr = myObj.nextInt();

        for(int i=0;i<nbr;i++){
            items.add(lireItem(produits));
        }
        Commande commande = new Commande(items);
        commandes.add(commande);
    }

    public static void afficherCommandes(ArrayList<Commande> commandes){
        commandes.forEach((commande -> {
            commande.items.forEach((item)->{
                item.afficherItem();
                System.out.println("-------------------");
            });
            System.out.println("Total:"+commande.calculeTotal());
        }));
    }

    public static void lireBoisson(ArrayList<Produit> produits,ArrayList<Category> categories){

        Scanner myObj = new Scanner(System.in);
        System.out.println("ajouter le nom de boisson:");
        String name = myObj.nextLine();

        System.out.println("ajouter le prix de boisson:");
        double price = Double.parseDouble(myObj.nextLine());

        Boisson boisson = new Boisson(name,price);

        System.out.println("Quelle category voulez-vous ajouter ce produit");
        String catName = myObj.nextLine();

        categories.forEach((category)->{
            if(category.name.toLowerCase().contains(catName.toLowerCase())){
                category.produits.add(boisson);
                System.out.println("Done");
            }
            else {
                System.out.println("le Category n'existe pas");
            }
        });
        produits.add(boisson);

    }

    public static void lireCategory(ArrayList<Category> categories){

        Scanner myObj = new Scanner(System.in);
        System.out.println("ajouter le nom de category:");
        String name = myObj.nextLine();

        Category category = new Category(name);
        categories.add(category);

    }

    public static void afficherMenu(ArrayList<Category> categories){
        categories.forEach((category) -> {
            System.out.println(category.name);
            category.afficherProduits();
            System.out.println("----------------------------------");
        });
    }

    public static void ajouterGerant(ArrayList<Employee> employees){

        Scanner myObj = new Scanner(System.in);

        System.out.println("le nom:");
        String name = myObj.nextLine();

        System.out.println("Addresse:");
        String adr = myObj.nextLine();

        System.out.println("le nombre d'heurs:");
        int nbrH = myObj.nextInt();

        Gerant gerant = new Gerant(name,nbrH,adr);

        employees.add(gerant);

    }

    public static void ajouterServeur(ArrayList<Employee> employees){

        Scanner myObj = new Scanner(System.in);

        System.out.println("le nom:");
        String name = myObj.nextLine();

        System.out.println("Addresse:");
        String adr = myObj.nextLine();

        System.out.println("le nombre d'heurs:");
        int nbrH = myObj.nextInt();

        Serveur serveur = new Serveur(name,nbrH,adr);

        employees.add(serveur);

    }

    public static void afficherEmp(ArrayList<Employee> employees){
        employees.forEach((employee -> {
            employee.afficherInfo();
            System.out.println("-----------------------");
        }));
    }

    public static void window(ArrayList<Category> categories,ArrayList<Produit> produits,ArrayList<Employee> employees,ArrayList<Commande> commandes){

        Scanner myObj = new Scanner(System.in);

        System.out.println("Ecrire 1 pour ajouter un category ");
        System.out.println("Ecrire 2 pour ajouter un aliment ");
        System.out.println("Ecrire 3 pour ajouter un boisson ");
        System.out.println("Ecrire 4 pour voir le menu ");
        System.out.println("Ecrire 5 pour ajouter un gerant ");
        System.out.println("Ecrire 6 pour ajouter un serveur ");
        System.out.println("Ecrire 7 pour afficher les employees ");
        System.out.println("Ecrire 8 pour ajouter une commande ");
        System.out.println("Ecrire 9 pour afficher les commandes ");
        int choix = myObj.nextInt();

        switch (choix){
            case 1:
                lireCategory(categories);
                break;
            case 2:
                lireAliment(produits,categories);
                break;
            case 3:
                lireBoisson(produits,categories);
                break;
            case 4:
                afficherMenu(categories);
                break;
            case 5:
               ajouterGerant(employees);
                break;
            case 6:
                ajouterServeur(employees);
                break;
            case 7:
                afficherEmp(employees);
                break;
            case 8:
                ajouterCommande(commandes,produits);
                break;
            case 9:
                afficherCommandes(commandes);
                break;
            default:
                System.out.println("choix erroné");
        }
    }

}
