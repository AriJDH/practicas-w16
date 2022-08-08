package clasesAbstractas_Interfaces.ejercicio_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan Pablo", "Torrres", "12345678", "UTN-Mendoza");
        LibroPDF libroPDF = new LibroPDF(150,"Juan Pablo", "Lalala", "Fantasia");
        Informe informe = new Informe(1550, 2, "Juan Pablo", "Diego");

        System.out.println(curriculum.imprimir());
        System.out.println(libroPDF.imprimir());
        System.out.println(informe.imprimir());


    }
}
