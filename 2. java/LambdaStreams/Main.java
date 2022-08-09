package LambdaStreams;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        garaje.addVehicule("Fiesta", "Ford", 1000);
        garaje.addVehicule("Focus", "Ford", 1200);
        garaje.addVehicule("Explorer", "Ford", 2500);
        garaje.addVehicule("Uno", "Fiat", 500);
        garaje.addVehicule("Cronos", "Fiat", 1000);
        garaje.addVehicule("Torino","Fiat",  1250);
        garaje.addVehicule("Aveo", "Chevrolet", 1250);
        garaje.addVehicule("Spin", "Chevrolet", 2500);
        garaje.addVehicule("Corola", "Toyota", 1200);
        garaje.addVehicule("Fortuner", "Toyota", 3000);
        garaje.addVehicule("Logan", "Renault", 950);
        garaje.showOrderByBrandAndPrice();
    }
}
