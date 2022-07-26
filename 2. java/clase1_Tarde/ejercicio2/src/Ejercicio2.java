import java.util.*;

public class Ejercicio2 {
    static Map<Integer, List<Participante>> competencia = new HashMap<>();
    static int inscriptos = 0;


    public static void Carrera(){
        System.out.println("**********************************");
        System.out.println("*        Carrera de la selva     *");
        System.out.println("*         1-Circuito chico       *");
        System.out.println("*         2-Circuito Medio       *");
        System.out.println("*         3-Circuito Avanzado    *");
        System.out.println("**********************************");
    }
    public static void Menu(){
        System.out.println("************************************");
        System.out.println("*      Carrera de la selva         *");
        System.out.println("*        1-Inscribir Participante  *");
        System.out.println("*        2-Listar Participantes    *");
        System.out.println("*        3-Eliminar Participantes  *");
        System.out.println("*        4-Consultar monto         *");
        System.out.println("*        0-Salir                   *");
        System.out.println("************************************");
    }
    public static Participante Datos(){
        System.out.println("Ingrese DNI");
        Scanner opcion = new Scanner(System.in);
        int dni = opcion.nextInt();
        System.out.println("Ingrese Nombre");
        Scanner opcion1 = new Scanner(System.in);
        String nombre = opcion1.nextLine();
        System.out.println("Ingrese Apellido");
        Scanner opcion2 = new Scanner(System.in);
        String apellido = opcion2.nextLine();
        System.out.println("Ingrese Edad");
        Scanner opcion3 = new Scanner(System.in);
        int edad = opcion3.nextInt();
        System.out.println("Ingrese Celular");
        Scanner opcion4 = new Scanner(System.in);
        int celular = opcion4.nextInt();
        System.out.println("Ingrese Numero de Emergencia");
        Scanner opcion5 = new Scanner(System.in);
        int numero_emergencia = opcion5.nextInt();
        System.out.println("Ingrese Grupo Sanguineo");
        Scanner opcion6 = new Scanner(System.in);
        String sanguineo = opcion6.nextLine();
        Participante res = new Participante(dni,nombre,apellido,edad,celular,numero_emergencia,sanguineo);
        return res;
    }

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir){
            Menu();
            Scanner opcion = new Scanner(System.in);
            int opt = opcion.nextInt();
            switch (opt){
                case 1:
                    Participante p = Datos();
                    boolean edadValida= false;
                    int carrera = 0;
                    while (!edadValida){
                        Carrera();
                        Scanner res = new Scanner(System.in);
                        carrera = res.nextInt();
                        if(p.getEdad()>18 && carrera ==3)
                            edadValida=true;
                        if (carrera== 1 || carrera ==2)
                            edadValida=true;
                    }
                    if(competencia.get(carrera)== null) {
                        List<Participante> list = new ArrayList<Participante>();
                        list.add(p);
                        competencia.put(carrera,list);
                    }
                    else{
                        competencia.get(carrera).add(p);
                    }
                    inscriptos++;
                    int monto = 0;
                    if (carrera ==1){
                        if (p.getEdad() < 18)
                            monto= 1300;
                        else
                            monto= 1500;
                    }
                    if (carrera ==2){
                        if (p.getEdad() < 18)
                            monto = 2000;
                        else
                            monto = 2300;
                    }
                    if (carrera ==3)
                        monto = 2800;
                    System.out.println("Su numero de inscripcion es: " + inscriptos);
                    System.out.println("Costo de la Inscripcion:" + monto );
                break;
                case 2:
                   do {
                        Carrera();
                       Scanner res = new Scanner(System.in);
                       carrera = res.nextInt();
                   }while(carrera > 3 || carrera < 1 );
                        List<Participante> aux = competencia.get(carrera);
                        if (aux == null)
                            System.out.println("No hay inscriptos hasta el momento");
                        else {
                            for (Participante e : aux) {
                                System.out.println(e.toString());
                            }
                        }
                break;
                case 3:
                    System.out.println("Elegir Carrera que estaba inscripto");
                    do {
                        Carrera();
                        Scanner res = new Scanner(System.in);
                        carrera = res.nextInt();
                    }while(carrera > 3 || carrera < 1 );
                    System.out.println("Ingrese el DNI");
                    Scanner opcionDni = new Scanner(System.in);
                    int dni = opcionDni.nextInt();
                    List<Participante> listaCorredores =  competencia.get(carrera);
                    int contador = 0;
                    int marcador = 0;
                    for(Participante par : listaCorredores){
                        if (par.getDni()==dni)
                            marcador = contador;
                        contador++;
                    }
                    if (marcador == 0){
                        System.out.println("Ese competidor no esta inscripto");
                    }
                    else{
                        competencia.get(carrera).remove(marcador);
                    }
                break;
                case 4:
                    do {
                        Carrera();
                        Scanner res = new Scanner(System.in);
                        carrera = res.nextInt();
                    }while(carrera > 3 || carrera < 1 );
                    System.out.println("Ingrese edad");
                    Scanner opcion_edad = new Scanner(System.in);
                    int edad = opcion_edad.nextInt();
                    if (carrera ==1){
                        if (edad < 18)
                            System.out.println("El monto a pagar es:"+ 1300);
                        else
                            System.out.println("El monto a pagar es:"+ 1500);
                    }
                    if (carrera ==2){
                        if (edad < 18)
                            System.out.println("El monto a pagar es:"+ 2000);
                        else
                            System.out.println("El monto a pagar es:"+ 2300);
                    }
                    if (carrera ==3){
                        if (edad < 18)
                            System.out.println("No se puede inscribir");
                        else
                            System.out.println("El monto a pagar es:"+ 2800);
                    }
                break;
                case 0:
                    salir = true;
                break;
            }
        }
    }
}
