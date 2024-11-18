package org.example.model;

import org.example.exception.AnimalDansMauvaisSecteurException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    int visiteurs;
    List<Secteur> secteursAnimaux;
    int nbrVisiteursMaxParSecteur;
    public Zoo(int nbVisiteurMaxParSecteur) {
        this.nbrVisiteursMaxParSecteur = nbVisiteurMaxParSecteur;
        this.secteursAnimaux = new ArrayList<>();
    }
    public void ajouterSecteur(TypeAnimal typeAnimal){

    }
    public void nouveauVisiteur(){

    }
    public int getLimiteVisiteur(){
        return nbrVisiteursMaxParSecteur;
    }

    public void nouvelAnimal(Animal animal) throws AnimalDansMauvaisSecteurException {
        for (Secteur secteur : secteursAnimaux) {
            if (secteur.obtenirType() == animal.getTypeAnimal()) {
                secteur.ajouterAnimal(animal);
                return;
            }
        }
        throw new AnimalDansMauvaisSecteurException("Aucun secteur approprié pour cet animal.");
    }
    public int nombreAnimaux() {
        int total = 0;
        for (Secteur secteur : secteursAnimaux) {
            total += secteur.getNombreAnimaux();
        }
        return total;
    }
}
