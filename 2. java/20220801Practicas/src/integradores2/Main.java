package integradores2;

public class Main {
    public static void main(String[] args) {
        Carrera c1 = new Carrera(205f,25000,"GrandPrix",3);
        c1.darDeAltaAuto(105f,125f,45,"ABC123");
        c1.darDeAltaAuto(85f,82f,60,"ABC124");
        c1.darDeAltaMoto(74f,130f,20,"ABC125");
        c1.darDeAltaMoto(125f,90f,10,"ABC126");
        System.out.println("Carrera inicial: \n" + c1.getLista());
        c1.ganador();
        c1.eliminarVehiculoConPatente("ABC125");
        System.out.println(c1.getLista());
        //Vehiculo eliminar = new Auto(105f,125f,45,"ABC123");
        c1.eliminarVehiculo(c1.getLista().get((0)));
        System.out.println(c1.getLista());
        c1.socorrerAuto("ABC124");
        c1.socorrerMoto("ABC126");

    }
}
