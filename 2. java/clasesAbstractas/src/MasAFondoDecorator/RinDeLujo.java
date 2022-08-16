package MasAFondoDecorator;

public class RinDeLujo implements IVehiculo{
    protected IVehiculo vehiculo;

    public RinDeLujo(IVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public Double getPrecio() {
        return vehiculo.getPrecio() + 10.0;
    }

    @Override
    public String getAccesorios() {
        return vehiculo.getAccesorios() + " Rines De Lujo";
    }
}