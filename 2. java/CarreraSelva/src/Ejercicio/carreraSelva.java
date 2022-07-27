/*
    Author: Tannia Lucía Hernández Rojas
    Descripción: Inscripción de participantes a la carrera de la selva
    Fecha: 27 de Julio de 2022
* */

package Ejercicio;

import java.util.*;

public class carreraSelva {

    public static int montoAbonar(int edad, int circuito){
        //Función para el cálculo del monto a abonar

        int monto_abonar = 2800;
        if(circuito==1){
            monto_abonar = 1300;
            if(edad>=18){
                monto_abonar = 1500;
            }
        }
        else if(circuito==2){
            monto_abonar = 2000;
            if(edad>=18){
                monto_abonar = 2300;
            }
        }
        return monto_abonar;
    }
    public static Map inscribirParticipante(int circuito, int num){

        //Función que almacena la información del participante en un diccionario

        Scanner input = new Scanner(System.in);
        Map<String, String> informacion = new HashMap<>();
        System.out.println("Ingrese el dni del participante "+ num);
        String dni = input.nextLine();
        informacion.put("dni", dni);
        System.out.println("Ingrese el nombre del participante "+ num);
        String nombre = input.nextLine();
        informacion.put("nombre", nombre);
        System.out.println("Ingrese el apellido del participante "+ num);
        String apellido = input.nextLine();
        informacion.put("apellido", apellido);
        System.out.println("Ingrese el edad del participante "+ num);
        int edad = input.nextInt();
        informacion.put("edad", String.valueOf(edad));
        System.out.println("Ingrese el celular del participante "+ num);
        String celular = input.next();
        informacion.put("celular", celular);
        System.out.println("Ingrese el número de emergencia del participante "+ num);
        String emergencia = input.next();
        informacion.put("emergencia", emergencia);
        System.out.println("Ingrese el grupo sanguíneo del participante "+ num);
        String sanguineo = input.next();
        informacion.put("sanguineo", sanguineo);
        informacion.put("inscripcion",String.valueOf(num));
        informacion.put("abonar",String.valueOf(montoAbonar(edad,circuito)));

        return informacion;
    }

    public static void main(String[] args){

        //Inicialización de las listas
        List<Map> circuitoChico = new ArrayList<Map>();
        List<Map> circuitoMedio = new ArrayList<Map>();
        List<Map> circuitoAvanzado = new ArrayList<Map>();

        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("Bienvenido a la carrera de la selva");
        System.out.println("Ingrese la cantidad de participantes ");
        int participantes = input.nextInt();

        for(int i=0; i<participantes; i++){

            //Inscripción de todos los participantes
            int num = i+1;
            System.out.println("Ingrese la categoría  a la que se desea inscrbir el participante "+num);
            System.out.println("Ingrese 1 si es a Circuito chico, 2 si es a Circuito medio o 3 si es a Circuito avanzado");
            int circuito = input.nextInt();
            Map informacion = inscribirParticipante(circuito, num);

            if (Integer.parseInt(informacion.get("edad").toString())<18 && circuito==3){
                System.out.println("No se permite inscripciones a menores de 18 años en Circuito Avanzado");
                continue;
            }
            //Almacenar la información en el respectivo circuito
            if (circuito==1) {
                circuitoChico.add(informacion);
            }
            else if(circuito==2){
                    circuitoMedio.add(informacion);
            }
            else{
                circuitoAvanzado.add(informacion);
            }
        }

        //Inscripción de un participante adicional

        System.out.println("Si requiere inscribir un participante adicional ingrese 1, sino ingrese 0");

        int opcion = input.nextInt();

        if (opcion==1){
            System.out.println("Ingrese la categoría  a la que se desea inscrbir el participante");
            System.out.println("Ingrese 1 si es a Circuito chico, 2 si es a Circuito medio o 3 si es a Circuito avanzado");
            int circuito = input.nextInt();
            int num = circuitoChico.size() + circuitoMedio.size() + circuitoAvanzado.size() +1;

            Map informacion = inscribirParticipante(circuito, num);

            if (Integer.parseInt(informacion.get("edad").toString())<18 && circuito==3){
                System.out.println("No se permite inscripciones a menores de 18 años en Circuito Avanzado");
            }
            else {
                if (circuito == 1) {
                    circuitoChico.add(informacion);
                } else if (circuito == 2) {
                    circuitoMedio.add(informacion);
                } else {
                    circuitoAvanzado.add(informacion);
                }
            }
        }

        //Eliminar algún participante

        System.out.println("Si requiere eliminar un participante inscrito ingrese 1, sino ingrese 0");
        int opci = input.nextInt();

        if(opci==1){
            System.out.println("Seleccione el circuito en el que se encuentra el participante 1: Circuito Chico, 2:Circuito Medio, 3: Circuito Avanzado");
            int opc = input.nextInt();
            if(opc==1){
                for(int i=0; i<circuitoChico.size(); i++){
                    System.out.println("Posición:"+i+" "+circuitoChico.get(i));
                }
                System.out.println("Ingrese la posición correspondiente al participante que desea eliminar");
                int pos = input.nextInt();
                circuitoChico.remove(pos);
            }
            else if(opc==2){
                for(int i=0; i<circuitoMedio.size(); i++){
                    System.out.println("Posición:"+i+" "+circuitoMedio.get(i));
                }
                System.out.println("Ingrese la posición correspondiente al participante que desea eliminar");
                int pos = input.nextInt();
                circuitoMedio.remove(pos);
            }
            else if(opc==3){
                for(int i=0; i<circuitoAvanzado.size(); i++){
                    System.out.println("Posición:"+i+" "+circuitoAvanzado.get(i));
                }
                System.out.println("Ingrese la posición correspondiente al participante que desea eliminar");
                int pos = input.nextInt();
                circuitoAvanzado.remove(pos);
            }

        }

        //Mostrar en pantalla los participantes

        System.out.println("Si requiere mostrar los participantes inscritos a las diferentes categorias ingrese 1, sino ingrese 0");
        int opcio = input.nextInt();
        if(opcio==1){
            System.out.println("Seleccione el circuito del que desea conocer los participantes 1: Circuito Chico, 2:Circuito Medio, 3: Circuito Avanzado, 4: Todos");
            int opc = input.nextInt();
            if(opc==1 || opc==4){
                System.out.println("------------------------");
                System.out.println("CIRCUITO CHICO");
                for(Map chico: circuitoChico){
                    System.out.println("Número inscripcion: "+chico.get("inscripcion")+" DNI: "+chico.get("dni")+" Nombre: "+chico.get("nombre")+ " Apellido: "+chico.get("apellido")+" Edad: "+chico.get("edad")+ " Celular: "+chico.get("celular")+ " Número emergencia: "+chico.get("emergencia")+ " Grupo sanguíneo: "+chico.get("sanguineo"));
                    System.out.println("Monto a abonar: "+chico.get("abonar"));
                }
            }
            if(opc==2 || opc==4){
                System.out.println("------------------------");
                System.out.println("CIRCUITO MEDIO");
                for(Map medio: circuitoMedio){
                    System.out.println("Número inscripcion: "+medio.get("inscripcion")+" DNI: "+medio.get("dni")+" Nombre: "+medio.get("nombre")+ " Apellido: "+medio.get("apellido")+" Edad: "+medio.get("edad")+ " Celular: "+medio.get("celular")+ " Número emergencia: "+medio.get("emergencia")+ " Grupo sanguíneo: "+medio.get("sanguineo"));
                    System.out.println("Monto a abonar: "+medio.get("abonar"));
                }
            }
            if(opc==3 || opc==4){
                System.out.println("------------------------");
                System.out.println("CIRCUITO AVANZADO");
                for(Map avanzado: circuitoAvanzado){
                    System.out.println("Número inscripcion: "+avanzado.get("inscripcion")+" DNI: "+avanzado.get("dni")+" Nombre: "+avanzado.get("nombre")+ " Apellido: "+avanzado.get("apellido")+" Edad: "+avanzado.get("edad")+ " Celular: "+avanzado.get("celular")+ " Número emergencia: "+avanzado.get("emergencia")+ " Grupo sanguíneo: "+avanzado.get("sanguineo"));
                    System.out.println("Monto a abonar: "+avanzado.get("abonar"));
                }
            }
        }
    }
}
