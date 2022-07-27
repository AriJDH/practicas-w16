package Ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaP2Vivo {

    ArrayList<String> lstParticipanteDNI = new ArrayList<>();
    HashMap<String, String> lstParticipanteNombre = new HashMap<>();
    HashMap<String, String> lstParticipanteApellido = new HashMap<>();
    HashMap<String, Integer> lstParticipanteEdad = new HashMap<>();
    HashMap<String, String> lstParticipanteCelular = new HashMap<>();
    HashMap<String, String> lstParticipanteNumeroEmergencia = new HashMap<>();
    HashMap<String, String> lstParticipanteGrupoSangre = new HashMap<>();
    HashMap<Integer, String> lstCircuitoChico = new HashMap<>();
    HashMap<Integer, String> lstCircuitoMedio = new HashMap<>();
    HashMap<Integer, String> lstCircuitoAvanzado = new HashMap<>();
    int idCircuitoChico= 0;
    int idCircuitoMedio= 0;
    int idCircuitoAvanzado= 0;

    Scanner sc = new Scanner(System.in);

    public void menu()
    {
            System.out.println("Carrera de la Selva");
            System.out.println("===================");
            System.out.println("Opciones");
            System.out.println("1 \t Inscribir");
            System.out.println("2 \t Mostrar participante por categoría");
            System.out.println("3 \t Eliminar");
            System.out.println("4 \t Monto abono");
            System.out.println("0 \t Salir");
            System.out.println("Seleccione una opción");
    }

    public void functionSelector(int idSeleccion)
    {
        switch (idSeleccion)
        {
            case 1:
                functionAgregar();
                break;
            case 2:
                functionMostrar();
                break;
            case 3:
                fuctionDesinscribir();
                break;
            case 4:
                functionMostarAbono();
                break;
            default:
                break;
        }
    }
    private void functionAgregar()
    {
        System.out.println("Menu>1 \t Inscribir");
        System.out.println("Ingrese DNI");
        String dni = sc.next();
        if(!lstParticipanteDNI.contains(dni)) {
            System.out.println("Ingrese Nombre");
            String nombre = sc.next();
            System.out.println("Ingrese Apellido");
            String apellido = sc.next();
            System.out.println("Ingrese la edad");
            int edad = sc.nextInt();
            System.out.println("Ingrese celular");
            String celular = sc.next();
            System.out.println("Ingrese nro. emergencia");
            String emergencia = sc.next();
            System.out.println("Ingrese grupo sanguineo");
            String grupoSanguineo = sc.next();
            System.out.println("Inscribir en circuito opciones: ");
            System.out.println("1 - Chico");
            System.out.println("2 - Medio");

            if(edad>= 18)
                System.out.println("3 - Avanzado");
            int opcion =sc.nextInt();
            if(opcion == 3 && edad < 18)
                System.out.println("Esta categoría es solo para mayores a 18 años");
            else if(opcion >= 1 && opcion<= 3)
            {
                if (opcion == 1) {
                    idCircuitoChico++;
                    lstCircuitoChico.put(idCircuitoChico, dni);
                } else if (opcion == 2) {
                    idCircuitoMedio++;
                    lstCircuitoMedio.put(idCircuitoMedio, dni);
                } else if (opcion == 3) {
                    idCircuitoAvanzado++;
                    lstCircuitoAvanzado.put(idCircuitoAvanzado, dni);
                }

                lstParticipanteNombre.put(dni, nombre);
                lstParticipanteApellido.put(dni,apellido);
                lstParticipanteEdad.put(dni,edad);
                lstParticipanteCelular.put(dni, celular);
                lstParticipanteNumeroEmergencia.put(dni, emergencia);
                lstParticipanteGrupoSangre.put(dni,grupoSanguineo);

            }else
                System.out.println("La opción seleccionada " + opcion + " no se encuentra disponible");

        }else{
            System.out.println("DNI ya registrado!!");
        }

    }

    private void functionMostrar(){
        System.out.println("Menu>2 \t Mostrar participante por categoría");
        System.out.println("1 - Chico");
        System.out.println("2 - Medio");
        System.out.println("3 - Avanzado");
        int opcion = sc.nextInt();
        if(opcion == 1)
        {
            imprimir(lstCircuitoChico);
        }
        else if(opcion == 2)
        {
            imprimir(lstCircuitoMedio);
        }
        else if(opcion == 3)
        {
            imprimir(lstCircuitoAvanzado);
        }else
            System.out.println("La opción seleccionada " + opcion + " no se encuentra disponible");


    }


    private void imprimir(HashMap<Integer, String> lst){
        System.out.println("Id \t Nombre \t\t Apellido \t\t Edad \t\t Celular \t\t Emergencia \t\t Grupo Sanguíneo");
        for(Map.Entry pareja : lst.entrySet()) {
            System.out.print(pareja.getKey()+"\t\t");
            System.out.print(lstParticipanteNombre.get(pareja.getValue())+"\t\t");
            System.out.print(lstParticipanteApellido.get(pareja.getValue())+"\t\t");
            System.out.print(lstParticipanteEdad.get(pareja.getValue())+"\t\t");
            System.out.print(lstParticipanteCelular.get(pareja.getValue())+"\t\t");
            System.out.print(lstParticipanteNumeroEmergencia.get(pareja.getValue())+"\t\t");
            System.out.print(lstParticipanteGrupoSangre.get(pareja.getValue())+"\t\t");
        }
    }
    private void fuctionDesinscribir()
    {
        System.out.println("Menu>1 \t Inscribir");
        System.out.println("Ingrese DNI");
        String dni = sc.next();

        if(lstParticipanteDNI.contains(dni)) {
            lstParticipanteNombre.remove(dni);
            lstParticipanteApellido.remove(dni);
            lstParticipanteEdad.remove(dni);
            lstParticipanteCelular.remove(dni);
            lstParticipanteNumeroEmergencia.remove(dni);
            lstParticipanteGrupoSangre.remove(dni);
            lstParticipanteDNI.remove(dni);
        }else{
            System.out.println("DNI no se encuentra registrado!!");

        }
    }
    private void functionMostarAbono(){
        System.out.println("Menu>4 \t Monto Abono");
        System.out.println("Buscar participante por dni");
        String dni = sc.next();
        if(lstParticipanteDNI.contains(dni))
            if(lstCircuitoChico.containsKey(dni))
                functionCalcularCircuitoChico(dni);
            else if(lstCircuitoMedio.containsKey(dni))
                functionCalcularCircuitoMedio(dni);
            else
                functionCalcularCircuitoAvanzado(dni);
        else
            System.out.println("El dni ingresado no se encuentra registrado");
    }
    private void functionCalcularCircuitoChico(String dni){
        int edad = lstParticipanteEdad.get(dni);
        if(edad >= 18)
            System.out.println("Monto Abono: $1500");
        else
            System.out.println("Monto Abono: $1300");
    }
    private void functionCalcularCircuitoMedio(String dni){
        int edad = lstParticipanteEdad.get(dni);
        if(edad >= 18)
            System.out.println("Monto Abono: $2300");
        else
            System.out.println("Monto Abono: $2000");
    }
    private void functionCalcularCircuitoAvanzado(String dni){
        int edad = lstParticipanteEdad.get(dni);
        if(edad >= 18)
            System.out.println("Monto Abono: $2800");
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        JavaP2Vivo jpv = new JavaP2Vivo();
        int opcion = 0 ;
        boolean salir = false;

        do{
            jpv.menu();
            opcion = sc.nextInt();
            if(opcion == 0)
                salir = true;
            jpv.functionSelector(opcion);

        }while(!salir);
    }
}



