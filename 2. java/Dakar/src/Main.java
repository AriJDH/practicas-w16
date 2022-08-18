public class Main {
    public static void main(String[] args) {
        Race race = new Race(3);

        //Cargar vehiculos
        race.registerAuto(100.0, 120.0, 45.0, "1073525066");
        race.registerMotorcycle(130.0, 200.0, 80.0, "1073527896");
        race.registerAuto(90.0, 80.0, 10.0, "23944832");
        race.registerAuto(100.0, 120.0, 45.0, "80383605");

        //Eliminar vehiculo
        race.deleteVehicle(new Car(90.0, 80.0, 10.0, "23944832"));
        race.deleteVehiclePatent("1073527896");

        //Agregar uno más
        race.registerAuto(50.0, 220.0, 100.0, "80383605");
        race.registerMotorcycle(130.0, 200.0, 80.0, "1073527896");

        //Definir ganador
        race.defineWinner();

        //Socorrer
        race.helpCar("80383605");
        race.helpMotorcycle("1073527896");
    }
}
