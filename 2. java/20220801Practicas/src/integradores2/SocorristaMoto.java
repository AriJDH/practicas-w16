package integradores2;

public class SocorristaMoto extends Socorrista{

    public SocorristaMoto(){

    }

    @Override
    void socorrer(Vehiculo e) {
        if(e.getClass().getSimpleName().equals("Auto")){
            System.out.println("Socorriendo auto patente: " + e.getPatente());
        } else if (e.getClass().equals("Moto")){
            System.out.println("Socorriendo moto patente: "+ e.getPatente());

        }
    }
}
