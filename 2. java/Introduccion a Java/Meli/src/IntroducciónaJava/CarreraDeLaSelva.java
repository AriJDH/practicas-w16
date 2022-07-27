package IntroducciónaJava;

import java.util.ArrayList;
import java.util.Scanner;

public class CarreraDeLaSelva {

    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int numEmergencia;
    private String grupoSanguineo;
    private int circuito;
    private int idParticipante;

    private static ArrayList<PersonaParticipante> listParticipanteCategoria1 = new ArrayList<>();
    private static ArrayList<PersonaParticipante> listParticipanteCategoria2 = new ArrayList<>();
    private static ArrayList<PersonaParticipante> listParticipanteCategoria3 = new ArrayList<>();

    public static void main(String[] args) {

        int opcion;
        int opcionCircuito;
        int opcionCircuitoDelete;
        int salir =0;
        CarreraDeLaSelva carreraDeLaSelva = new CarreraDeLaSelva();
        Scanner entrada = new Scanner(System.in);
        int id=1;
        while(salir==0) {
            System.out.println("Ingrese su opcion");
            System.out.println("--1-- Ingresar Participante");
            System.out.println("--2-- Consultar Participante");
            System.out.println("--3-- Borrar Participante");
            System.out.println("--4-- Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    carreraDeLaSelva.participante(id);
                    id++;
                    break;
                case 2:
                    System.out.println("--------------------------------");
                    System.out.println("¿Que categoria quiere consultar?");
                    System.out.println("Ingrese 1 si es circuito chico");
                    System.out.println("Ingrese 2 si es circuito medio");
                    System.out.println("Ingrese 3 si es circuito grande");
                    System.out.println("--------------------------------");
                    opcionCircuito = entrada.nextInt();
                    switch (opcionCircuito){
                        case 1:
                            for (PersonaParticipante p:listParticipanteCategoria1){
                                System.out.println("DNI: "+p.getDni()+"\n"+"Id Participante: "+p.idParticipante+"\n"+"Nombre: "+ p.getNombre()+"\n"+"Apellido: "+p.getApellido()+" "+"\n"+"Edad: "+p.getEdad()+"\n"+"Celular: "+p.getCelular()+"\n"+"Numero de emergencia:  "+p.getNumEmergencia()+"\n"+"Numero de circuito: "+p.getCircuito()+"\n"+"Valor circuito: "+p.getValorCircuito()+"\n");

                            }
                            break;
                        case 2:
                            for (PersonaParticipante p:listParticipanteCategoria2){
                                System.out.println("DNI: "+p.getDni()+"\n"+"Id Participante: "+p.idParticipante+"\n"+"Nombre: "+ p.getNombre()+"\n"+"Apellido: "+p.getApellido()+" "+"\n"+"Edad: "+p.getEdad()+"\n"+"Celular: "+p.getCelular()+"\n"+"Numero de emergencia:  "+p.getNumEmergencia()+"\n"+"Numero de circuito: "+p.getCircuito()+"\n"+"Valor circuito: "+p.getValorCircuito()+"\n");
                            }
                            break;
                        case 3:
                            for (PersonaParticipante p:listParticipanteCategoria3){
                                System.out.println("DNI: "+p.getDni()+"\n"+"Id Participante: "+p.idParticipante+"\n"+"Nombre: "+ p.getNombre()+"\n"+"Apellido: "+p.getApellido()+" "+"\n"+"Edad: "+p.getEdad()+"\n"+"Celular: "+p.getCelular()+"\n"+"Numero de emergencia:  "+p.getNumEmergencia()+"\n"+"Numero de circuito: "+p.getCircuito()+"\n"+"Valor circuito: "+p.getValorCircuito()+"\n");
                            }
                            break;
                    }

                    break;
                case 3:
                    System.out.println("--------------------------------...............................");
                    System.out.println("¿A que categoria pertenece el participante que quiere eliminar?");
                    System.out.println("Ingrese 1 si es circuito chico");
                    System.out.println("Ingrese 2 si es circuito medio");
                    System.out.println("Ingrese 3 si es circuito grande");
                    System.out.println("---------------------------------------------------------------");
                    opcionCircuitoDelete = entrada.nextInt();

                    System.out.println("Ingrese el id del participante que quiere eliminar");
                    int idPartcipanteDelete = entrada.nextInt();

                    switch (opcionCircuitoDelete){
                        case 1:

                            for (int i = 0; i < listParticipanteCategoria1.size(); i++) {
                                if (listParticipanteCategoria1.get(i).idParticipante == idPartcipanteDelete) {
                                    listParticipanteCategoria1.remove(i);
                                    break;
                                }
                            }
                            break;
                        case 2:
                            for (int i = 0; i < listParticipanteCategoria2.size(); i++) {
                                if (listParticipanteCategoria2.get(i).idParticipante == idPartcipanteDelete) {
                                    listParticipanteCategoria2.remove(i);
                                    break;
                                }
                            }
                            break;
                        case 3:
                            for (int i = 0; i < listParticipanteCategoria3.size(); i++) {
                                if (listParticipanteCategoria3.get(i).idParticipante == idPartcipanteDelete) {
                                    listParticipanteCategoria3.remove(i);
                                    break;
                                }
                            }
                            break;
                    }


                    System.out.println("--3--");
                    break;
                case 4:
                    System.out.println("Hasta Luego!!");
                    salir=1;
                    break;
            }

        }


    }
    private void participante(int id) {
        Scanner entrada = new Scanner (System.in);
        idParticipante=id;
        System.out.println("Ingrese su dni");
        dni = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Ingrese su nombre");
        nombre = entrada.nextLine();

        System.out.println("Ingrese su apellido");
        apellido = entrada.nextLine();

        System.out.println("Ingrese su edad");
        edad = entrada.nextInt();

        System.out.println("Ingrese su celular");
        celular = entrada.nextInt();

        System.out.println("Ingrese su numero de emergencia");
        numEmergencia = entrada.nextInt();

        System.out.println("Ingrese su grupo sanguineo");
        grupoSanguineo = entrada.nextLine();

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Ingrese el circuito que quiere completar");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("--1-- Circuito chico: 2 km por selva y arroyos.");
        System.out.println("--2-- Circuito medio: 5 km por selva, arroyos y barro.");
        System.out.println("--3-- Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra..");
        circuito = entrada.nextInt();
        int valorCircuito=0;
        switch (circuito){
            case 1:
                if(edad<18){
                    valorCircuito=1300;
                }
                else{
                    valorCircuito=1500;
                }
                break;
            case 2:
                if(edad<18){
                    valorCircuito=2000;
                }
                else{
                    valorCircuito=2300;
                }
                break;
            case 3:
                if(edad<18){
                    System.out.println("No se pueden inscribir personas menores de 18 años en circuito 3");
                }
                else{
                    valorCircuito=2800;
                }
                break;

        }
        System.out.println("-----------------------------------------------------");
        System.out.println("El valor del circuito "+circuito+ " es "+valorCircuito);
        System.out.println("-----------------------------------------------------");

        PersonaParticipante participante= new PersonaParticipante();
        participante.setDni(dni);
        participante.setIdParticipante(id);
        participante.setNombre(nombre);
        participante.setApellido(apellido);
        participante.setEdad(edad);
        participante.setCelular(celular);
        participante.setNumEmergencia(numEmergencia);
        participante.setGrupoSanguineo(grupoSanguineo);
        participante.setCircuito(circuito);
        participante.setValorCircuito(valorCircuito);

        switch (circuito){
            case 1:
                listParticipanteCategoria1.add(participante);
                break;
            case 2:
                listParticipanteCategoria2.add(participante);
                break;
            case 3:
                if(valorCircuito>0) {
                    listParticipanteCategoria3.add(participante);
                }
                break;
        }


        //System.out.println(dni + "\n" + nombre + "\n" + apellido + "\n" + edad + "\n" + celular + "\n" + numEmergencia + "\n" + grupoSanguineo+"\n"+circuito);

    }
    class PersonaParticipante{

        private int dni;
        private int idParticipante;
        private String nombre;
        private String apellido;
        private int edad;
        private int celular;
        private int numEmergencia;
        private String grupoSanguineo;
        private int circuito;
        private int valorCircuito;


        public int getDni() {
            return dni;
        }

        public void setDni(int dni) {
            this.dni = dni;
        }

        public int getIdParticipante() {
            return idParticipante;
        }

        public void setIdParticipante(int idParticipante) {
            this.idParticipante = idParticipante;
        }


        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public int getCelular() {
            return celular;
        }

        public void setCelular(int celular) {
            this.celular = celular;
        }

        public int getNumEmergencia() {
            return numEmergencia;
        }

        public void setNumEmergencia(int numEmergencia) {
            this.numEmergencia = numEmergencia;
        }

        public String getGrupoSanguineo() {
            return grupoSanguineo;
        }

        public void setGrupoSanguineo(String grupoSanguineo) {
            this.grupoSanguineo = grupoSanguineo;
        }

        public int getCircuito() {
            return circuito;
        }

        public void setCircuito(int circuito) {
            this.circuito = circuito;
        }
        public int getValorCircuito() {
            return valorCircuito;
        }

        public void setValorCircuito(int valorCircuito) {
            this.valorCircuito = valorCircuito;
        }



    }


    }


