package imprimir.modelos;

import imprimir.interfaces.Imprimible;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> habilidades = List.of("Proactiva", "Liderazgo", "Trabajo en equipo");
        Curriculum curriculum = new Curriculum("122344", "Gabriela", "Mejia", 22, "Ingeniera de sistemas", "mm@m.com", habilidades);
        Informes informe = new Informes("Informe sobre usurios de mercado pago", 20, "Gabriela Mejia", "Juan Perez");
        LibrosPdf libroPdf = new LibrosPdf(300, "Gabriel Garcia Marquez", "100 años de soledad", "Novela");

        Imprimible.imprimir(curriculum);
        System.out.println();
        Imprimible.imprimir(informe);
        System.out.println();
        Imprimible.imprimir(libroPdf);

    }

}
