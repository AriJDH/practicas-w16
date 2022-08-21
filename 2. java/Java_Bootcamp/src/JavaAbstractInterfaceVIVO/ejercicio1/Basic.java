package JavaAbstractInterfaceVIVO.ejercicio1;

public class Basic extends Cliente implements ITransaccionBasic, ITransaccion {


    @Override
    public void transaccionOK() {
        System.out.println("Transaccion Exitosa !!");
    }

    @Override
    public void transaccionNoOK() {
    }

    @Override
    public void retiroEfectivo() {
        System.out.println("Realizándose Retiro En Efectivo");
        transaccionOK();
    }

    @Override
    public void consultaSaldo() {
        System.out.println("Realizándose Consulta De Saldo");
        transaccionOK();
    }

    @Override
    public void pagosDeServicios() {
        System.out.println("Realizándose Pagos de Servicios");
        transaccionOK();
    }
}
