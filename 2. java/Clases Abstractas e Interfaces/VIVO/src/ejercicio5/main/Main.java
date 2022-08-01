package ejercicio5.main;

import ejercicio5.clases.Coordenada;
import ejercicio5.clases.Flota;
import ejercicio5.clases.NaveSimple;
import ejercicio5.clases.Participante;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Ejercicio de raiz cuadrada - Asteroid
        List<Coordenada> listaCoordenadas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listaCoordenadas.add(generarCoordenadaRandom());
        }

        List<Participante> listaDeParticipantes = new ArrayList<>();
        listaDeParticipantes = Menu();

        HashMap<Coordenada, NaveSimple> coordenadaNaveSimpleHashMap = new HashMap<>();
        coordenadaNaveSimpleHashMap = realizarCalculos(listaDeParticipantes, listaCoordenadas);

        calcularGanador(listaDeParticipantes);
        coordenadaNaveSimpleHashMap.forEach((coordenada, naveSimple) -> {
            System.out.println("La nave más cerca de la coordenada X: " + coordenada.getX() + " Y: " + coordenada.getY() +
                    "fue: " + naveSimple.getNombre() + "\n");
        });

    }

    public static Coordenada generarCoordenadaRandom(){
        Coordenada coordenadaRandom = new Coordenada(Math.random(), Math.random());
        return coordenadaRandom;
    }

    public static List<Participante> Menu(){
        List<Participante> listaParticipantes = new ArrayList<>();
        int cantidadParticipantes = 0;
        int seleccionNave = 0;

        Scanner teclado = new Scanner(System.in);
        System.out.println("--- Registrar Participante ---");
        System.out.print("Cantidad de Participantes: ");
        try {
             cantidadParticipantes = teclado.nextInt();
        }catch (Exception ex){
            System.out.println("Debe ingresar un digito entero. [ERROR]: " + ex.getMessage());
        }

        for (int i = 0; i < cantidadParticipantes; i++) {
            System.out.print("\nNombre participante N° "+ (i+1) +": ");
            String nombre = teclado.next();

            boolean seguirIntentando = false;

            do {
                System.out.println("\nSeleccionar nave o flota (Coordenadas de posicion generadas automaticamente)");
                System.out.println("1) Nave Simple");
                System.out.println("2) Flotas de naves");
                try {
                    seleccionNave = teclado.nextInt();
                }catch (Exception ex){
                    System.out.println("Debe ingresar un digito entero. [ERROR]: " + ex.getMessage());
                }

                switch (seleccionNave){
                    case 1:
                        System.out.print("Ingresar nombre de la Nave: ");
                        String nombreNave = teclado.next();
                        NaveSimple naveSimple = new NaveSimple(nombreNave, generarCoordenadaRandom());
                        Participante nuevoParticipante = new Participante(nombre, naveSimple);
                        listaParticipantes.add(nuevoParticipante);
                        break;
                    case 2:
                        System.out.print("Ingresar cantidad de naves: ");
                        int cantidadFlota = 1;
                        try {
                            cantidadFlota = teclado.nextInt();
                        }catch (Exception ex){
                            System.out.println("Debe ingresar un digito entero. [ERROR]: " + ex.getMessage());
                        }
                        List<NaveSimple> listaFlota = new ArrayList<>();
                        for (int j = 0; j < cantidadFlota; j++) {
                            System.out.print("Ingresar nombre de la flota N° " + (j+1) + ": ");
                            String nombreNaveFlota = teclado.next();
                            NaveSimple nuevaNave = new NaveSimple(nombreNaveFlota, generarCoordenadaRandom());
                            listaFlota.add(nuevaNave);
                        }
                        Flota flota = new Flota(listaFlota);
                        Participante participante = new Participante(nombre, flota);
                        listaParticipantes.add(participante);
                        break;
                    default:
                        System.out.println("Debe seleccionar una opción valida.");
                        seguirIntentando = true;
                        break;
                }
            }while (seguirIntentando);

        }

        return listaParticipantes;
    }

    public static HashMap<Coordenada, NaveSimple> realizarCalculos(List<Participante> listaParticipantes, List<Coordenada> listaCoordenadas){
        HashMap<Coordenada, NaveSimple> coordenadaNaveSimpleHashMap = new HashMap<>();
        NaveSimple naveMasCerca = listaParticipantes.get(0).getNave();
        if (naveMasCerca == null){
            naveMasCerca = listaParticipantes.get(0).getFlota().getListaNaves().get(0);
        }

        for (Coordenada coordenada : listaCoordenadas){
            double distanciaCoordenada = coordenada.getX() + coordenada.getY();
            double diffActual = 0;
            double diffAnterior = 999;
            double distanciaNave = 0;
            for (Participante participante: listaParticipantes){
                if (participante.getFlota() != null){
                    for (NaveSimple nave : participante.getFlota().getListaNaves()){
                        distanciaNave = nave.getCoordenadas().getX() + nave.getCoordenadas().getY();
                        diffActual = Math.abs(distanciaCoordenada - distanciaNave);
                        if (diffActual < diffAnterior){
                            naveMasCerca = nave;
                            diffAnterior = diffActual;
                        }
                    }
                } else if (participante.getNave() != null) {
                    distanciaNave = participante.getNave().getCoordenadas().getX() + participante.getNave().getCoordenadas().getY();
                    diffActual = Math.abs(distanciaCoordenada - distanciaNave);
                    if (diffActual < diffAnterior){
                        naveMasCerca = participante.getNave();
                        diffAnterior = diffActual;
                    }
                }
            }
            naveMasCerca.setPuntuacion(naveMasCerca.getPuntuacion() + 1);
            coordenadaNaveSimpleHashMap.put(coordenada, naveMasCerca);
        }
        return  coordenadaNaveSimpleHashMap;
    }

    public static void calcularGanador(List<Participante> listaParticipantes){
        int puntosAnterior = 0;
        int puntosActuales = 0;
        Participante participanteMayorPuntaje = null;
        for (Participante participante: listaParticipantes){
            puntosActuales = 0;
            if (participante.getFlota() != null){
                for (NaveSimple nave : participante.getFlota().getListaNaves()){
                    puntosActuales += nave.getPuntuacion();
                }
            } else if (participante.getNave() != null) {
                puntosActuales +=  participante.getNave().getPuntuacion();
            }

            if (puntosActuales > puntosAnterior){
                participanteMayorPuntaje = participante;
                puntosAnterior = puntosActuales;
            }
        }

        System.out.println("\nEl participante con más puntos fue " + participanteMayorPuntaje.getNombre() + "!!\n");
    }
}
