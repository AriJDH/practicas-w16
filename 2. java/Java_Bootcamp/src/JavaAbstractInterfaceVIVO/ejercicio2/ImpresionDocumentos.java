package JavaAbstractInterfaceVIVO.ejercicio2;

public class ImpresionDocumentos {

    public static void main(String[] args) {

        System.out.println("Usando Impresora");
        Impresora impresora = new Impresora();

        CurriculumPersona persona = new CurriculumPersona("Daniel", 123456789);
        impresora.imprimirDocumento(persona);

        System.out.println("---------------------------------");

        LibroPDF pdf = new LibroPDF(145, "Gabriel", "Un Libro", "Fantasia");
        impresora.imprimirDocumento(pdf);

        System.out.println("---------------------------------");

        Informe informe = new Informe("lorem Ipsum", 45, "Jorge", "Mariana");
        impresora.imprimirDocumento(informe);
    }
}
