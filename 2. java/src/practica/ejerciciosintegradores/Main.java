package practica.ejerciciosintegradores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Repositorio repositorio = Repositorio.getInstance();

        // a
        Cliente clienteUno = new Cliente("Hernan", "Gonzalez", 12345);

        PaqueteTuristico paqueteTuristicoUno = new PaqueteTuristico(true, true, true, true);
        ArrayList<PaqueteTuristico> paquetesTursiticosUno = new ArrayList<PaqueteTuristico>(Arrays.asList(paqueteTuristicoUno));

        Localizador localizadorUno = new Localizador(paquetesTursiticosUno, clienteUno, 1000);

        repositorio.addLocalizador(localizadorUno.getCliente().getDni(), localizadorUno);

        // b
        PaqueteTuristico paqueteTuristicoDos = new PaqueteTuristico(true, false, true, false);
        PaqueteTuristico paqueteTuristicoTres = new PaqueteTuristico(true, false, true, false);
        ArrayList<PaqueteTuristico> paqueteTuristicosDos = new ArrayList<>(Arrays.asList(paqueteTuristicoDos, paqueteTuristicoTres));

        Localizador localizadorDos = new Localizador(paqueteTuristicosDos, clienteUno, 2000);

        repositorio.addLocalizador(localizadorDos.getCliente().getDni(), localizadorDos);

        // c
        PaqueteTuristico paqueteTuristicoCuatro = new PaqueteTuristico(true, false, false, false);
        ArrayList<PaqueteTuristico> paqueteTuristicosTres = new ArrayList<PaqueteTuristico>(Arrays.asList(paqueteTuristicoCuatro));

        Localizador localizadorTres = new Localizador(paqueteTuristicosTres, clienteUno, 100);

        repositorio.addLocalizador(localizadorTres.getCliente().getDni(), localizadorTres);

        // resto

        for (Map.Entry<Integer, ArrayList<Localizador>> localizador : repositorio.getLocalizadores().entrySet()) {
            Integer key = localizador.getKey();
            ArrayList<Localizador> localizadores = localizador.getValue();
            System.out.println(key);
            for (Localizador localizadorCliente : localizadores) {
                System.out.println(localizadorCliente);
            }
            System.out.println(localizadores);
        }
    }
}
