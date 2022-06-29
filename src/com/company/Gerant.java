package com.company;

import static com.company.Grade.A;
import static com.company.Grade.B;
import static com.company.Grade.C;

public class Gerant extends Employee{

    Grade grade;

    public Gerant(String name, int nbrHeures, String address) {
        super(name, nbrHeures, address);
        this.grade = A;
    }

    @Override
    public void afficherInfo() {
        super.afficherInfo();
        System.out.println("type:"+ "Gerant");
        System.out.println("grade:"+ grade);
        System.out.println("Salaire:"+ calculeSalaire());
    }

    @Override
    public double calculeSalaire() {
        double sal = 0;
        switch (grade){
            case A:
                sal = nbrHeures*50 + 1000;
                break;
            case B:
                sal = nbrHeures*50 + 500;
                break;
            case C:
                sal = nbrHeures*50 + 250;
                break;
        }
        return sal;
    }
}
