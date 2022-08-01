package dakar.domain;

import dakar.interfaces.Socorrista;

public class SocorristaMoto implements Socorrista<Moto>{
    @Override
    public void socorer(Moto moto) {
        System.out.println("Socorriendo una moto patente: "+ moto.getPatente());
    }
}