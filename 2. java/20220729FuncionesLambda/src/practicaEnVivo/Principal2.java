package practicaEnVivo;

import java.util.*;

public class Principal2 {

    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Ford", "Fiesta",1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus",1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer",2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno",500);
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos",1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino",1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo",1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin",2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corola",1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuner",3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan",950);

        List<Vehiculo> lista = new ArrayList<>(Arrays.asList(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11));

        Garaje g = new Garaje(1, lista);

        //ejercicio3(g);

        //ejercicio4(g);
        ejercicio5(g);



    }

    public static void ejercicio3(Garaje e){

        e.getLista().sort(Comparator.comparing(Vehiculo::getCosto));
        e.getLista().forEach((e1)-> System.out.println(e1));
    }

    public static void ejercicio4(Garaje e){

        e.getLista().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        e.getLista().forEach((e1)-> System.out.println(e1));
    }

    public static void ejercicio5(Garaje e){

        List<Vehiculo> menores =  new ArrayList<>();
        List<Vehiculo> mayores = new ArrayList<>();

        e.getLista().forEach((e1) -> {
            if (e1.getCosto() < 1000){
                menores.add(e1);
            } else{
                mayores.add(e1);
            }
        });

        OptionalDouble promedio = e.getLista().stream().mapToInt(Vehiculo::getCosto).average();

        System.out.println("Lista de menores: \n" + menores);
        System.out.println("Lista de mayores: \n" + mayores);
        System.out.println("Promedio de autos: " + promedio.getAsDouble());


    }

}
