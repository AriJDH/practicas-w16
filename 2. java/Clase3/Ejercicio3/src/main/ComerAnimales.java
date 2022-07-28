package main;

import interfaces.ComerCarne;
import interfaces.ComerHierba;

public class ComerAnimales implements ComerHierba, ComerCarne {
    @Override
    public void comerCarne() {
        System.out.println("Comiendo Carne");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo Carne");

    }
    public void animalComiendo(String animal){
        if(animal.equals("perro") | animal.equals("gato")){
            comerCarne();
        }else if(animal.equals("vaca")){
            comerHierba();
        }
    }

}
