package org.example.model;

import org.example.exception.AnimalDansMauvaisSecteurException;
import org.example.exception.LimiteVisiteurException;

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
    public void ajouterSecteur(TypeAnimal typeAnimal) {
        secteursAnimaux.add(new Secteur(typeAnimal));
    }
    public void nouveauVisiteur() throws LimiteVisiteurException {
        if (visiteurs >= getLimiteVisiteur()) {
            throw new LimiteVisiteurException("Nombre maximum de visiteurs atteint.");
        }
        visiteurs++;
    }
    public int getLimiteVisiteur() {
        return nbrVisiteursMaxParSecteur * secteursAnimaux.size();
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
