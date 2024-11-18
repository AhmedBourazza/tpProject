package org.example.model;

public class Animal {
    String nomAnimal;
    TypeAnimal typeAnimal;

    public String getNomAnimal() {
        return nomAnimal;
    }

    public TypeAnimal getTypeAnimal() {
        return typeAnimal;
    }
}
 enum TypeAnimal {
     CHIEN, CHAT,

}
