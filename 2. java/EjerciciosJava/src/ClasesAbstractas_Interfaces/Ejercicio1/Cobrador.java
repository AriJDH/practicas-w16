package ClasesAbstractas_Interfaces.Ejercicio1;

public class Cobrador implements RetiroDeEfectivo, ConsultaDeSaldo{

    private int id;
    private static final String TIPO = "Cobrador: ";

    public Cobrador() {}

    public Cobrador(int id) {
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
        return "Cobrador{" +
                "id=" + id +
                '}';
    }

    @Override
    public void consultarSaldo() {
        System.out.println(TIPO + "Consulta de saldo realizada con exito");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println(TIPO + "Retiro de efectivo realizado con exito");
    }

}
