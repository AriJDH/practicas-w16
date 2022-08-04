package abstractasInterfases.interfaces2;

public interface Imprimible{

    static void imprimirArchivo(Imprimible archivo) {
        System.out.println("Imprimiendo "+ archivo);
        archivo.imprimir();
    }

    public void imprimir();

}
