package com.bootcamp.estructuras;

import java.util.*;

public class EjercicioEstructurasDinamicasMejorado {
    //dni, nombre, edad, apellido, celular, nroEmergencia,grupoSanguineo;

    public static HashMap<Integer, String> circuitoChicoControl = new HashMap<>();
    public static HashMap<Integer, String> circuitoMedioControl = new HashMap<>();
    public static HashMap<Integer, String> circuitoGrandeControl = new HashMap<>();
    public static HashMap<Integer, List> circuitoChico = new HashMap();
    public static HashMap<Integer, List> circuitoMedio = new HashMap<>();
    public static HashMap<Integer, List> circuitoGrande = new HashMap<>();
    Integer contador = 0;
    Scanner entradaString = new Scanner(System.in);
    Scanner entradaInt = new Scanner(System.in);


    public static void main(String[] args) {
        EjercicioEstructurasDinamicasMejorado ejercicio = new EjercicioEstructurasDinamicasMejorado();
        ejercicio.menu();


    }

    public void cargarParticipante() {
        List<String> participante = new ArrayList();
        System.out.println("Favor ingrese DNI");
        participante.add(entradaString.nextLine());
        System.out.println("Favor ingrese Nombre");
        participante.add(entradaString.nextLine());
        System.out.println("Favor ingrese Apellido");
        participante.add(entradaString.nextLine());
        System.out.println("Favor ingrese Edad");
        participante.add(entradaString.nextLine());
        System.out.println("Favor ingrese Celular");
        participante.add(entradaString.nextLine());
        System.out.println("Favor ingrese Nro de emergencia");
        participante.add(entradaString.nextLine());
        System.out.println("Favor ingrese Grupo Sanguineo");
        participante.add(entradaString.nextLine());

        System.out.println("Categoria:\n1- Circuito chico\n2- Circuito mediano\n3- Circuito Grande");
        int ingresoUsuario = entradaInt.nextInt();
        if (controlParticipanteIngresado(participante.get(0))) {
            System.out.println("El usuario ya fue ingresado en la categoria solicitada");
        } else {
            switch (ingresoUsuario) {

                case 1:
                    circuitoChico.put(contador, participante);
                    circuitoChicoControl.put(contador, participante.get(0));
                    if (Integer.parseInt(participante.get(3)) >= 18) {
                        System.out.println("Participante correctamente registrado con el identificador " + contador);
                        System.out.println("Costo por inscripcion $1500");
                    } else {
                        System.out.println("Participante correctamente registrado con el identificador " + contador);
                        System.out.println("Costo por inscripcion $1300");
                    }
                    contador++;
                    break;
                case 2:
                    circuitoMedio.put(contador, participante);
                    circuitoMedioControl.put(contador, participante.get(0));
                    if (Integer.parseInt(participante.get(3)) >= 18) {
                        System.out.println("Participante correctamente registrado con el identificador " + contador);
                        System.out.println("Costo por inscripcion $2300");
                    } else {
                        System.out.println("Participante correctamente registrado con el identificador " + contador);
                        System.out.println("Costo por inscripcion $2000");
                    }
                    contador++;
                    break;
                case 3:
                    if (Integer.parseInt(participante.get(3)) >= 18) {
                        circuitoGrande.put(contador, participante);
                        circuitoGrandeControl.put(contador, participante.get(0));
                        System.out.println("Participante correctamente registrado con el identificador " + contador);
                        System.out.println("Costo por inscripcion $2800");
                        contador++;
                    } else {
                        System.out.println("Participante menor de edad, no puede registrarse en la categoria solicitada");
                    }
                    break;
            }

        }
    }

    public boolean controlParticipanteIngresado(String dni) {
        boolean resultado = false;
        if (circuitoChicoControl.containsValue(dni)) resultado = true;
        if (circuitoMedioControl.containsValue(dni)) resultado = true;
        if (circuitoGrandeControl.containsValue(dni)) resultado = true;

        return resultado;
    }

    public void menu() {
        System.out.println("Menu\n1- Ingresar participante\n2-Mostrar participantes por categoria\n3-Desinscribir participante\n4- Salir");


        switch (entradaInt.nextInt()) {
            case 1:
                cargarParticipante();
                menu();
                break;
            case 2:
                mostrarParticipantesXCategoria();
                menu();
                break;
            case 3:
                System.out.println("Ingrese el DNI del participante a eliminar");
                eliminarParticipante(entradaString.nextLine());
                menu();
                break;
            case 4:
                System.exit(1);
            default:
                System.out.println("Opcion no válida");
                break;

        }
    }

    public void eliminarParticipante(String dni) {
        if (circuitoGrandeControl.containsValue(dni)) {
            for (Map.Entry<Integer, String> mapa : circuitoGrandeControl.entrySet()) {
                if (mapa.getValue().equals(dni)) {
                    circuitoGrande.remove(mapa.getKey());
                    circuitoGrandeControl.remove(mapa.getKey());
                }
            }
        } else {
            if (circuitoMedioControl.containsValue(dni)) {
                for (Map.Entry<Integer, String> mapa : circuitoMedioControl.entrySet()) {
                    if (mapa.getValue().equals(dni)) {
                        circuitoMedio.remove(mapa.getKey());
                        circuitoMedioControl.remove(mapa.getKey());
                    }
                }
            } else {
                if (circuitoChicoControl.containsValue(dni)) {

                    for (Map.Entry<Integer, String> mapa : circuitoChicoControl.entrySet()) {
                        if (mapa.getValue().equals(dni)) {
                            circuitoChico.remove(mapa.getKey());
                            circuitoChicoControl.remove(mapa.getKey());
                        }
                    }
                } else {
                    System.out.println("No se encontró ningun participante con ese DNI");
                }
            }


        }

    }

    public void mostrarParticipantesXCategoria() {

        System.out.println("Categoria:\n1- Circuito chico\n2- Circuito mediano\n3- Circuito Grande");
        switch (entradaInt.nextInt()) {
            case 1:
                for (int i = 0; i < circuitoChico.size(); i++) {
                    if (i % 6 == 0) {
                        System.out.println(circuitoChico.get(i));
                    } else {
                        System.out.println(circuitoChico.get(i) + " ");
                    }
                }

                break;
            case 2:
                for (int i = 0; i < circuitoMedio.size(); i++) {
                    if (i % 6 == 0) {
                        System.out.println(circuitoMedio.get(i));

                    } else {
                        System.out.println(circuitoMedio.get(i) + " ");
                    }
                }
                break;
            case 3:
                for (int i = 0; i < circuitoGrande.size(); i++) {
                    if (i % 6 == 0) {
                        System.out.println(circuitoGrande.get(i));
                    } else {
                        System.out.println(circuitoGrande.get(i) + " ");
                    }
                }
                break;
            default:
                System.out.println("Opcion no válida");
                break;
        }
    }
}
