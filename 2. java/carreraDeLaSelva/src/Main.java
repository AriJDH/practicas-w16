import javax.swing.*;
import java.util.*;

public class Main {

    private static List<Map<String, String>> participantesCircuitoChico = new ArrayList<Map<String, String>>();

    private static List<Map<String, String>> participantesCircuitoMedio = new ArrayList<Map<String, String>>();

    private static List<Map<String, String>> participantesCircuitoAvanzado = new ArrayList<Map<String, String>>();

    private static int numero_participante;


    static final List<String> campos_persona = new ArrayList<String>(Arrays.asList(
            "DNI",
            "Nombre",
            "Apellido",
            "Celular",
            "Número de emergencia",
            "Grupo sanguíneo"
    ));

    public int ingresarEdad(){
        Scanner sc = new Scanner(System.in);
        int edad;
        do {
            System.out.print("Introduce la edad: ");
            while (!sc.hasNextInt()) {
                System.out.println("Edad no válida");
                sc.next();
                System.out.print("Introduce la edad: ");
            }
            edad = sc.nextInt();
            if(edad <= 0){
                System.out.println("Edad no válida");
            }
        } while (edad <= 0);
        return edad;
    }

    public boolean esMayordeEdad(int edad){
        return edad >= 18;
    }

    public float calcularMontoAbonar(int edad, int option){
        float monto_final=0;
        if (!esMayordeEdad(edad)){
            switch (option){
                case 1:
                    monto_final= 1300.0F;
                    break;
                case 2:
                    monto_final= 2000.0F;
                    break;
                case 3:
                    monto_final= 0.0F;
                break;
            }
        }else{
            switch (option){
                case 1:
                    monto_final= 1500.0F;
                break;
                case 2:
                    monto_final= 2300.0F;
                break;
                case 3:
                    monto_final= 2800.0F;
                break;
            }
        }
        return monto_final;
    }

    public void mensajeCircuitos(){
        System.out.println("Digite la opción correcta");
        System.out.println("1 - Circuito chico");
        System.out.println("2 - Circuito medio");
        System.out.println("3 - Circuito avanzado");
    }


    public Map<String,String> crearParticipante(int opcion){
        Map<String, String> persona = new HashMap<String, String>();
        Scanner teclado_persona = new Scanner(System.in);
        for (String campo_persona: campos_persona){
            System.out.println("Ingresar " + campo_persona + " :");
            persona.put(campo_persona, teclado_persona.nextLine());
        }
        numero_participante = numero_participante +1;
        persona.put("Número de participante", String.valueOf(numero_participante));
        int edad = 0;
        edad = ingresarEdad();
        persona.put("Edad", String.valueOf(edad));
        persona.put("Monto a abonar", String.valueOf(calcularMontoAbonar(edad, opcion)));

        return persona;
    }

    public void inscribir() {
        Scanner teclado_opcion = new Scanner(System.in);
        Map<String, String> inscripto = new HashMap<String, String>();
        int opcion = -1;
        while (opcion != 0) {
            mensajeCircuitos();
            opcion = teclado_opcion.nextInt();
            switch (opcion) {
                case 1:
                    inscripto = crearParticipante(opcion);
                    participantesCircuitoChico.add(inscripto);
                    opcion = 0;
                    break;
                case 2:
                    inscripto = crearParticipante(opcion);
                    participantesCircuitoMedio.add(inscripto);
                    opcion = 0;
                    break;
                case 3:
                    inscripto = crearParticipante(opcion);
                    participantesCircuitoAvanzado.add(inscripto);
                    opcion = 0;
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    continue;
            }
        }
        System.out.println(inscripto.get("Monto a abonar"));
    }
    public void imprimirParticipantes(Map<String, String> map){
        for (String key: map.keySet()){
            System.out.println(key+": " + map.get(key));
        }
    }
    public void desinscribir(String numero_participante) {
        Scanner teclado_opcion = new Scanner(System.in);

        int aux_indice = -1;

        int opcion = -1;
        while (opcion != 0) {
            mensajeCircuitos();
            opcion = teclado_opcion.nextInt();
            switch (opcion) {
                case 1:
                    for (int i = 0; i < participantesCircuitoChico.size(); i++) {
                        if (participantesCircuitoChico.get(i).get("Número de participante").equals(numero_participante)) {
                            aux_indice = i;
                        }
                    }
                    if (aux_indice != -1) {
                        participantesCircuitoChico.remove(aux_indice);
                        System.out.println("Participante Eliminado");
                    } else {
                        System.out.println("No se Encontro el Participante");
                    }
                    opcion = 0;
                    break;
                case 2:
                    for (int i = 0; i < participantesCircuitoMedio.size(); i++) {
                        if (participantesCircuitoMedio.get(i).get("Número de participante").equals(numero_participante)) {
                            aux_indice = i;
                        }
                    }
                    if (aux_indice != -1) {
                        participantesCircuitoMedio.remove(aux_indice);
                        System.out.println("Participante Eliminado");
                    } else {
                        System.out.println("No se Encontro el Participante");
                    }
                    opcion = 0;
                    break;
                case 3:
                    for (int i = 0; i < participantesCircuitoAvanzado.size(); i++) {
                        if (participantesCircuitoAvanzado.get(i).get("Número de participante").equals(numero_participante)) {
                            aux_indice = i;
                        }
                    }
                    if (aux_indice != -1) {
                        participantesCircuitoChico.remove(aux_indice);
                        System.out.println("Participante Eliminado");
                    } else {
                        System.out.println("No se Encontro el Participante");
                    }
                    opcion = 0;
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    continue;
            }
        }
    }
    public void mostrarInscriptosPorCategoria(){
        List<Map<String,String>> participo = participantesCircuitoChico;
        Scanner teclado_opcion = new Scanner(System.in);
        int opcion = -1;
        while (opcion == -1) {
            mensajeCircuitos();
            opcion = teclado_opcion.nextInt();

            switch (opcion) {
                case 1:
                    for (int i =0; i < participantesCircuitoChico.size();i++){
                        imprimirParticipantes(participantesCircuitoChico.get(i));
                    }
                    break;
                case 2:
                    for (int i =0; i < participantesCircuitoMedio.size();i++){
                        imprimirParticipantes(participantesCircuitoMedio.get(i));
                    }
                    break;
                case 3:
                    for (int i =0; i < participantesCircuitoAvanzado.size();i++){
                        imprimirParticipantes(participantesCircuitoAvanzado.get(i));
                    }
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    opcion = -1;
                    continue;
            }

        }


    }


    public static void main(String[] args) {

        Scanner teclado_opcion = new Scanner(System.in);
        Scanner teclado_participante = new Scanner(System.in);
        int opcion = -1;
        String participante_desinscribir ="";
        while (opcion != 0) {
            System.out.println("Digite la acción que desea realizar");
            System.out.println("1 - Inscribir nuevo participante");
            System.out.println("2 - Mostrar inscriptos por categoría");
            System.out.println("3 - Desinscribir participante");
            System.out.println("4 - Salir");
            opcion = teclado_opcion.nextInt();
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    new Main().inscribir();
                    break;
                case 2:
                    new Main().mostrarInscriptosPorCategoria();
                    break;
                case 3:
                    System.out.println("Ingrese número de participante");
                    participante_desinscribir = teclado_participante.nextLine();
                    new Main().desinscribir(participante_desinscribir);
                    break;
                case 4:
                    opcion = 0;
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    opcion = -1;
                    break;
            }
        }

    }
}
