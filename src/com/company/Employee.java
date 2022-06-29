package com.company;

public abstract class Employee {

    String name;
    int nbrHeures ;
    String address;


    public Employee(String name, int nbrHeures, String address) {
        this.name = name;
        this.nbrHeures = nbrHeures;
        this.address = address;
    }

    public double calculeSalaire(){
        return 0;
    }

    public void afficherInfo(){
        System.out.println("nom:"+name);
        System.out.println("Addresse:"+address);
        System.out.println("nombre heures:"+nbrHeures);
    }
}
