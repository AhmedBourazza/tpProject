package org.example.model;

import org.example.model.TypeAnimal;
import org.example.model.Zoo;

public class App {
    public static void main(String[] args) {
        Zoo zoo = new Zoo(15); // Maximum 15 visiteurs par secteur

        zoo.ajouterSecteur(TypeAnimal.CHIEN);
        zoo.ajouterSecteur(TypeAnimal.CHAT);

        try {
            zoo.nouvelAnimal(new Chien());
            zoo.nouvelAnimal(new Chat());
            zoo.nouveauVisiteur();
            zoo.nouveauVisiteur();

            System.out.println("Nombre total d'animaux dans le zoo : " + zoo.nombreAnimaux());
            System.out.println("Nombre total de visiteurs dans le zoo : " + zoo.getLimiteVisiteur());
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
