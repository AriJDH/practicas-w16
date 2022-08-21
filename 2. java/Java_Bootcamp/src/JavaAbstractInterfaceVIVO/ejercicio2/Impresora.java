package JavaAbstractInterfaceVIVO.ejercicio2;

public class Impresora implements Imprimible {

    @Override
    public String documento() {
        return null;
    }

    @Override
    public void imprimirDocumento(Imprimible imp) {
        Imprimible.super.imprimirDocumento(imp);
    }
}
