package integradores2;

public class SocorristaAuto extends Socorrista{

    public SocorristaAuto(){

    }

    @Override
    void socorrer(Vehiculo e) {

        if(e.getClass().getSimpleName().equals("Auto")){
            System.out.println("Socorriendo auto patente: " + e.getPatente());
        } else if (e.getClass().getSimpleName().equals("Moto")){
            System.out.println("Socorriendo moto  patente: " + e.getPatente());

        }
    }
}
