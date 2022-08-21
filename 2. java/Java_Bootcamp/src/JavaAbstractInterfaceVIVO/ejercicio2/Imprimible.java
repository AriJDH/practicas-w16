package JavaAbstractInterfaceVIVO.ejercicio2;

public interface Imprimible {

    String documento();

    default void imprimirDocumento(Imprimible imp) {
        System.out.println(imp.documento());
    }
}
