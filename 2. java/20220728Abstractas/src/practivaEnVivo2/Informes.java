package practivaEnVivo2;

public class Informes implements Imprimir{

    public Informes(){

    }

    @Override
    public void imprimirDocumento() {
        System.out.println("Se imprimio el informe");
    }
}
