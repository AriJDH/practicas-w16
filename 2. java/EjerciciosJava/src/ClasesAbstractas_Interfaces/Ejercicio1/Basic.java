package ClasesAbstractas_Interfaces.Ejercicio1;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo{

    private int id;
    private static final String TIPO = "Basic: ";

    public Basic() {}

    public Basic(int id) {
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
        return "Basic{" +
                "id=" + id +
                '}';
    }

    @Override
    public void consultarSaldo() {
        System.out.println(TIPO + "Consulta de saldo realizada con exito");
    }

    @Override
    public void pagarServicio() {
        System.out.println(TIPO + "Pago de servicio realizado con exito");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println(TIPO + "Retiro de efectivo realizado con exito");
    }

}
