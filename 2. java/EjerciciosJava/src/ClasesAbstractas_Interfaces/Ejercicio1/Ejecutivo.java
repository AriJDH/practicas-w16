package ClasesAbstractas_Interfaces.Ejercicio1;

public class Ejecutivo implements Deposito, Transferencia{

    private int id;
    private static final String TIPO = "Ejecutivo: ";

    public Ejecutivo() {}

    public Ejecutivo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ejecutivo{" +
                "id=" + id +
                '}';
    }

    @Override
    public void realizarDeposito() {
        System.out.println(TIPO + "Deposito realizado con exito");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println(TIPO + "Transferencia realizada con exito");
    }
}
