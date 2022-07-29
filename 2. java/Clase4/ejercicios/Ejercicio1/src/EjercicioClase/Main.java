package EjercicioClase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List <Vehiculo> lista=new ArrayList<>();

        lista.add(new Vehiculo("Ford","Fista",1000));
        lista.add(new Vehiculo("Ford","Focus",1200));
        lista.add(new Vehiculo("Ford","Explorer",2500));
        lista.add(new Vehiculo("Fiat","Uno",500));
        lista.add(new Vehiculo("Fiat","Cronos",1000));
        lista.add(new Vehiculo("Fiat","Torino",1250));
        lista.add(new Vehiculo("Chevrolet","Aveo",1250));
        lista.add(new Vehiculo("Chevrolet","Spin",2500));
        lista.add(new Vehiculo("Toyota","Corola",1200));
        lista.add(new Vehiculo("Toyota","Fortuner",3000));
        lista.add(new Vehiculo("Renault","Logan",950));


        List<Vehiculo> sortedList = lista.stream()
                .sorted(Comparator.comparingInt(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println("por precio : " +sortedList);

        List<Vehiculo> sortedAndMandP= lista.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
            System.out.println("costo y marca : "+sortedAndMandP);

        List<Vehiculo> menores=lista.stream()
                .filter(vehiculo -> vehiculo.getCosto()<1000)
                .collect(Collectors.toList());
        System.out.println("menores que 1000: " +menores);

        List<Vehiculo> mayores=lista.stream()
                .filter(vehiculo -> vehiculo.getCosto()>=1000)
                .collect(Collectors.toList());;
        System.out.println("mayores que 1000" + mayores);


        double cont=0;
        for (Vehiculo p:lista){
            cont+=p.getCosto();
        }
        double result= cont/lista.size();
        System.out.println("promedio de precios : " +result);

            //getCosto /lista.lenght

    }

}
