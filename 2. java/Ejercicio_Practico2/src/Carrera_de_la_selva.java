import java.awt.image.ImageProducer;
import java.sql.SQLOutput;
import java.util.HashMap;
import  java.util.Map;
import java.util.Scanner;

public class Carrera_de_la_selva {

    public static void main(String[] args) {

        Map<Integer,Map> circuito =new HashMap<>();
        Map<String,String[]> participante = new HashMap<>();

        Scanner teclado = new Scanner(System.in);
        int opcion;
        int numeroParticipante=0;
        int carrera=0;


        do {
            System.out.println("Menu");
            System.out.println("-------------------------");
            System.out.println("Agregar Participante: 1");
            System.out.println("Ver participantes por categoria: 2 ");
            System.out.println("Desincribir Participantes: 3");
            System.out.println("Monto a pagar: 4");
            System.out.println("Salir: 0");
            System.out.println("-------------------------");
            System.out.print("Ingrese una opcion:");
            opcion=teclado.nextInt();

            switch (opcion)
            {
                case 1:{

                    String[] datos= new String[7];
                    String key;
                    System.out.println("Ingrese datos del participante");
                    System.out.print("DNI:");
                    key=teclado.next();
                    System.out.print("Nombre:");
                    datos[0]=teclado.next();
                    System.out.print("Apellido:");
                    datos[1]=teclado.next();
                    System.out.print("Edad:");
                    datos[2]=teclado.next();
                    System.out.print("Celular:");
                    datos[3]=teclado.next();
                    System.out.print("Celular de emergencia:");
                    datos[4]=teclado.next();
                    System.out.print("Grupo Sanguineo:");
                    datos[5]=teclado.next();
                    datos[6]=String.valueOf(numeroParticipante);
                    numeroParticipante++;
                    participante.put(key,datos);
                    System.out.println("Ingrese circuito a inscribirse ");
                    System.out.println("Circuito chico: 1");
                    System.out.println("Circuito medio: 2");
                    System.out.println("Circuito avanzado: 3");
                    System.out.print(":");
                    carrera= teclado.nextInt();
                    circuito.put(carrera,participante);
                    carrera=0;


                    break;
                }

                case 2:{
                    System.out.println("Ingrese circuito a revisar ");
                    System.out.println("Circuito chico: 1");
                    System.out.println("Circuito medio: 2");
                    System.out.println("Circuito avanzado: 3");
                    System.out.print(":");
                    carrera= teclado.nextInt();
                    System.out.println();

                    if(!circuito.isEmpty())
                    {


                        try {
                            if(circuito.get(carrera)==null){
                                System.out.println("No hay participantes registrados en este circuito");
                            }else
                            {

                                Map<String,String[]> participantesmap=circuito.get(carrera);

                                for(Map.Entry<String ,String[]> recorrer : participantesmap.entrySet()){
                                    System.out.println("Dni: "+recorrer.getKey()+"\nNobre: "+recorrer.getValue()[0]+"\nApellido: "+recorrer.getValue()[1]+"\nEdad: "+recorrer.getValue()[2]+"\nCelular: "+recorrer.getValue()[3]+"\nCelular de emergencia: "+recorrer.getValue()[4]+"\nGrupo sanguineo: "+recorrer.getValue()[5]+"\nNúmero participante: "+recorrer.getValue()[6]+"\n---------------");
                                }

                            }


                        }catch (Exception e){
                        }


                    }
                    else{
                        System.out.println("No hay ningun participante registrado");
                    }
                    break;
                }

                case 3:{
                    System.out.println("Ingrese circuito a revisar ");
                    System.out.println("Circuito chico: 1");
                    System.out.println("Circuito medio: 2");
                    System.out.println("Circuito avanzado: 3");
                    System.out.print(":");
                    carrera= teclado.nextInt();
                    System.out.println();
                    System.out.println("Ingrese datos del participante");
                    System.out.print("DNI:");
                    String clave=teclado.next();
                    circuito.get(carrera).remove(clave);



                    break;
                }

                case 4:{


                    System.out.println("Ingrese circuito a revisar ");
                    System.out.println("Circuito chico: 1");
                    System.out.println("Circuito medio: 2");
                    System.out.println("Circuito avanzado: 3");
                    System.out.print(":");
                    carrera= teclado.nextInt();
                    System.out.println();
                    System.out.println("Ingrese datos del participante");
                    System.out.print("DNI:");
                    String clave=teclado.next();
                    Map<String,String[]> corredor =circuito.get(carrera);
                    int edad =Integer.parseInt(corredor.get(clave)[2]);
                    System.out.println(edad);



                    switch (carrera){

                        case 1:{

                            if(edad<18)
                            {
                                System.out.println("El monto a cancelar es: $1300");
                            }
                            else
                            {
                                System.out.println("El monto a cancelar es: $1500");
                            }

                            break;
                        }

                        case 2:{

                            if(edad<18)
                            {
                                System.out.println("El monto a cancelar es: $2000");
                            }
                            else
                            {
                                System.out.println("El monto a cancelar es: $2300");
                            }
                            break;
                        }

                        case 3:{
                            if(edad<18)
                            {
                                System.out.println("No se puede inscribir");
                            }
                            else
                            {
                                System.out.println("El monto a cancelar es: $2800");
                            }
                        }
                    }



                    break;
                }

            }

        }while(opcion!=0);





    }
}
