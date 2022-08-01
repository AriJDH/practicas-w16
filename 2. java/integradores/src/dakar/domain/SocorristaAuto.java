package dakar.domain;

import dakar.interfaces.Socorrista;

public class SocorristaAuto implements Socorrista<Auto>{
    @Override
    public void socorer(Auto auto) {
        System.out.println("Socorriendo un auto patente: " + auto.getPatente());
    }
}
