package Ejercicio2;

public class SocorristaAuto implements Socorrista<Auto>{

    @Override
    public void socorrer(Auto unAuto) {
        System.out.println("Socorriendo auto: "+ unAuto.getPatente());
    }
}
