package MasAFondoDecorator;

public class ManillaCromada implements IVehiculo{
    protected IVehiculo vehiculo;

    public ManillaCromada(IVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public Double getPrecio() {
        return vehiculo.getPrecio() + 12.5;
    }

    @Override
    public String getAccesorios() {
        return vehiculo.getAccesorios() + " Manilla Cromada";
    }
}
