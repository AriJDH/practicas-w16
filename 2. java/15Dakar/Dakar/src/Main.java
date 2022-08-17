public class Main {
    public static void main(String[] args) {
        System.out.println("Inicio");
        System.out.println("Definir cupo para la carrera");

        Carrera carrera = new Carrera();
        carrera.setDistancia(10000.00);
        carrera.setPremioEnDolares(50000.00);
        carrera.setNombre("Rally Meli");
        carrera.setCantidadDeVehiculosPermitidos(4);

        //dar de alta

        carrera.darDeAltaAuto(100, 120,5,"AAA01");
        carrera.darDeAltaAuto(110, 130,6,"AAA02");
        SocorristaAuto socorristaAuto = new SocorristaAuto();

        carrera.socorrerAuto("AAA02");

        carrera.darDeAltaAuto(120, 140,7,"AAA03");
        carrera.darDeAltaMoto(126, 140,8,"AAA04");

        carrera.socorrerMoto("AAA04");

        carrera.darDeAltaMoto(127, 140,9,"AAA05");
        carrera.darDeAltaAuto(140, 140,2,"AAA06");//no inscribe
        carrera.darDeAltaMoto(160, 140,3,"AAA07");//no inscribe

        carrera.eliminarVehiculo("AAA01");
        carrera.eliminarVehiculo("AAA");

        carrera.vehiculoGanador();




    }
}
