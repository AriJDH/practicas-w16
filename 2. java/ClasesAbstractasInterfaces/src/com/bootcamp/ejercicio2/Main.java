package com.bootcamp.ejercicio2;

import com.bootcamp.ejercicio2.modelos.Curriculum;
import com.bootcamp.ejercicio2.modelos.Informe;
import com.bootcamp.ejercicio2.modelos.Pdf;
import com.bootcamp.ejercicio2.interfaces.Imprimible;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<String> habiliadesKevin = new ArrayList<String>();
    habiliadesKevin.add("Creatividad");
    habiliadesKevin.add("Flexibilidad");
    habiliadesKevin.add("Empatia");
    habiliadesKevin.add("Comunicacion");

    //Curriculum
    Curriculum curriculumKevin = new Curriculum("Kevin", habiliadesKevin);
    curriculumKevin.imprimir();

    //PDF
    Pdf pdfMarwan = new Pdf(320, "Marwan", "Poesia", "Los amores imparables");
    pdfMarwan.imprimir();

    //Informe
    Informe informeCuenta = new Informe("Texto del informe", 180, "Luis Miguel", "Margarita");
    informeCuenta.imprimir();


  }
}
