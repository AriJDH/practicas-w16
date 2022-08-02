package poo.ejercicioVehiculo;

public class Main {

    public static void main(String[] args) {

        Garaje garaje = new Garaje(1);
        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);


        garaje.guardarVehiculo(v1);
        garaje.guardarVehiculo(v2);
        garaje.guardarVehiculo(v3);
        garaje.guardarVehiculo(v4);
        garaje.guardarVehiculo(v5);
        garaje.guardarVehiculo(v6);
        garaje.guardarVehiculo(v7);
        garaje.guardarVehiculo(v8);
        garaje.guardarVehiculo(v9);
        garaje.guardarVehiculo(v10);
        garaje.guardarVehiculo(v11);

        //System.out.println(garaje);

        System.out.println("Vehiculos ordenados por precio: ");
        garaje.mostrarVehiculosOrdenadosPorPrecio();

        System.out.println("Vehiculos ordenados marca y precio: ");
        garaje.mostrarVehiculosOrdenadosPorMarcaYPrecio();

        System.out.println("Vechiculos con precio menor a $1000: ");
        garaje.mostrarVehiculosConPrecioMenorAMil();

        System.out.println("Vechiculos con precio mayor e igual a $1000: ");
        garaje.mostrarVehiculosConPrecioMayorAMil();

        System.out.println("Promedio total de precios: ");
        garaje.mostrarPromedio();


    }
}
