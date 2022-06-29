package com.company;

public class Serveur extends Employee{

    public Serveur(String name, int nbrHeures, String address) {
        super(name, nbrHeures, address);
    }

    @Override
    public double calculeSalaire() {
        double sal = nbrHeures*25;
        return sal;
    }

    @Override
    public void afficherInfo() {
        super.afficherInfo();
        System.out.println("type:"+ "Serveur");
        System.out.println("Salaire:"+ calculeSalaire());
    }
}
