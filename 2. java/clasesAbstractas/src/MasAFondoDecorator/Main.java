package MasAFondoDecorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Con todos los accesorios");
        IVehiculo vehiculo1 = new ManillaCromada(
                new ChapaProtectora(
                        new RinDeLujo(
                                new VidrioReforzado(
                                        new Vehiculo(100.0, "Lanos", "Standard")
                                )
                        )
                )
        );
        System.out.println("Con dos accesorios");

        IVehiculo vehiculo2 = new ManillaCromada(
                new VidrioReforzado(
                        new Vehiculo(100.0, "Corsa", "Standard")
                )
        );
        System.out.println("Con 1 accesorio");

        IVehiculo vehiculo3 = new ChapaProtectora(
                new Vehiculo(100.0,"Cronos", "Standard")
        );

        System.out.println(
                "el vehiculo 1 precio " + vehiculo1.getPrecio() + " con accesorios: " + vehiculo1.getAccesorios()
        );


        System.out.println(
                "el vehiculo 2 precio " + vehiculo2.getPrecio() + " con accesorios: " + vehiculo2.getAccesorios()
        );


        System.out.println(
                "el vehiculo 3 precio " + vehiculo3.getPrecio() + " con accesorios: " + vehiculo3.getAccesorios()
        );
    }
}
