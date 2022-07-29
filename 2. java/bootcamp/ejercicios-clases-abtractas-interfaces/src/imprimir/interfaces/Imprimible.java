package imprimir.interfaces;

public interface Imprimible {

     static void imprimir(Documento documento){
        System.out.println("Imprimiendo... " + "\n" +documento);
    }
}
