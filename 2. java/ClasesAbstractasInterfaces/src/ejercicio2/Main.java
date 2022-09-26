package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<String> habiliadesJavier = new ArrayList<String>();
    habiliadesJavier.add("Autodidacta");
    habiliadesJavier.add("Paciente");
    habiliadesJavier.add("Comunicativo");
    habiliadesJavier.add("Resolutivo");

    //Informe
    Informe informeCuenta = new Informe("Informe científico", 230, "Juan Perez", "Pedro Guerra");
    informeCuenta.imprimir();

    //Curriculum
    Curriculum cvJavier = new Curriculum("Javier", habiliadesJavier);
    cvJavier.imprimir();

    //PDF
    Pdf pdfMarwan = new Pdf(210, "Carl Sagan", "Astronomia", "Cosmos: un viaje personal");
    pdfMarwan.imprimir();
  }
}


