package com.bootcamp;

import java.util.*;


public class PracticaMap {
    static List<Map> chico = new ArrayList<>();
    static List<Map> medio = new ArrayList<>();
    static List<Map> avanzado = new ArrayList<>();


    public void msg(){
        System.out.println("Con 0 termina la ejecucion");
        System.out.println("Con 1 Inscribe a un participante");
        System.out.println("Con 2 muestra los participantes");
        System.out.println("Con 3 desensicribe un participante ");
    }
    // chico, medio y avanzado
    //numero de participante, dni,nombre,apellido,edad,celular,numero y grupo sanguineo
    // chico >18 $1300  18<  $1500
    // medio >18 $2000  18<  $2300
    // avanzado >18 no permitido  18<  $2800

    //aplicacion que sea capas de
    public static void inscriptionUser(String nombre, String dni, String edad,String celular,String numero,
                                       String sangre,String nIns,String monto, List<Map> lista){
        Map<String, String> map = new HashMap<String, String>();
        map.put("Nombre", nombre);
        map.put("Dni", dni);
        map.put("Celular", celular);
        map.put("Numero ", numero);
        map.put("Tipo_Sangineo", sangre);
        map.put("Numero_de_inscripto",nIns);
        map.put("Monto",monto);
        lista.add(map);
        System.out.println(lista);
    }
    public static String calculateMonto(String edad,String circuito){

        int edadI=Integer.parseInt(edad);
        if(circuito.equals("chico")){
            if (edadI>18){
                return "1500";
            }else{
                return "1300";
            }
        }
        if(circuito.equals("medio")){
            if (edadI>18){
                return "2300";
            }else{
                return "2000";
            }
        }
        if(circuito.equals("avanzado")){
            return "2800";
        }

        return "";
    }
    public static void removeUser(List<Map> lista, String nIns){
        int cnt=0;
        int i=-1;
        for (Map<String,String> map: lista){
            if(map.get("Numero_de_inscripto").equals(nIns)){
                i=cnt;
                break;
            }
            cnt++;
        }
        if (i!=-1) {
            lista.remove(i);
            System.out.println("participante eliminado");
        }else{
            System.out.println("participante no encontrado");
        }
    }
    public static void main(String[] args) {
        PracticaMap practicaMap=new PracticaMap();
        Scanner teclado=new Scanner(System.in);
        practicaMap.msg();
        int ref=teclado.nextInt();
        int nIns=1;
        while (ref!=0){

            if(ref ==1){
                String dni1=teclado.nextLine();
                System.out.println("Ingrese su dni");
                String dni=teclado.nextLine();
                System.out.println("Ingrese su nombre");
                String nombre=teclado.nextLine();
                System.out.println("Ingrese su edad");
                String edad=teclado.nextLine();
                System.out.println("Ingrese su celular");
                String celular=teclado.nextLine();
                System.out.println("Ingrese su numero de respaldo");
                String numero=teclado.nextLine();
                System.out.println("Ingrese su sangre");
                String sangre=teclado.nextLine();
                System.out.println("Ingrese el tipo de Carrera |CHICO|MEDIO|AVANZADO|");
                String circuito=teclado.nextLine().toLowerCase(Locale.ROOT);
                String num=nIns+"";
                String monto=calculateMonto(edad,circuito);
                if (Integer.parseInt(edad)<18 & circuito.equals("avanzado")){
                    System.out.println("Error Edad no permitida para el circuito avanzado");
                    System.out.println("------------------------Programa Nuevamente------------------------");
                    practicaMap.msg();

                    continue;
                }
                if (circuito.equals("chico")){
                    inscriptionUser(nombre,dni,edad,celular,numero,sangre,num,monto,chico);
                    nIns ++;
                } else if (circuito.equals("medio")) {

                    inscriptionUser(nombre,dni,edad,celular,numero,sangre,num,monto,medio);
                    nIns ++;
                } else if (circuito.equals("avanzado")) {
                    inscriptionUser(nombre,dni,edad,celular,numero,sangre,num,monto,avanzado);
                    nIns ++;
                }else {
                    System.out.println("El circuito no existe, vuelva  a ingresar todos los datos.");
                }


            } else if (ref ==2) {
                //muestra participantes
                System.out.println("Ingese el tipo circuito que quiere ver");
                System.out.println("|CHICO|MEDIO|AVANZADO|TODOS|");
                String abreBuffer= teclado.nextLine();
                String circuito= teclado.nextLine().toLowerCase(Locale.ROOT);

                if (circuito.equals("chico") ){
                    System.out.println(chico);
                } else if (circuito.equals("medio")) {
                    System.out.println(medio);
                } else if (circuito.equals("avanzado")) {
                    System.out.println(avanzado);

                }else {
                    System.out.println("El circuito no existe, vuelva  a ingresar.");
                }

            }else if (ref ==3) {
                //borra inscripcion
                String abreBuffer= teclado.nextLine();
                System.out.println("Ingese el circuito del inscripto");
                System.out.println("|CHICO|MEDIO|AVANZADO|TODOS|");
                String tipoCircuito=teclado.nextLine().toLowerCase();

                System.out.println("Ingrese el numero de inscripto");
                String nInsc=teclado.next();

                if (tipoCircuito.equals("chico")){
                    removeUser(chico,nInsc);
                } else if (tipoCircuito.equals("medio")) {
                    removeUser(medio,nInsc);

                } else if (tipoCircuito.equals("avanzado")) {
                    removeUser(avanzado,nInsc);

                } else {
                    System.out.println("El circuito no existe");
                }


            }else {
                System.out.println("el valor ingresado por teclado: "+ ref +" no es valido");
                System.out.println("------------------------Programa Nuevamente------------------------");
            }
            practicaMap.msg();
            ref= teclado.nextInt();

        }
    }
}
