package MasAFondoDecorator;

public class ChapaProtectora implements IVehiculo{
    protected IVehiculo vehiculo;

    public ChapaProtectora(IVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public Double getPrecio() {
        return vehiculo.getPrecio() + 15.0;
    }

    @Override
    public String getAccesorios() {
        return vehiculo.getAccesorios() + " Chapa Protectora";
    }
}