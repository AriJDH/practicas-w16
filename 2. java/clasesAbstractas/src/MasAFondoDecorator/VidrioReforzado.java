package MasAFondoDecorator;

public class VidrioReforzado implements IVehiculo{
    protected IVehiculo vehiculo;

    public VidrioReforzado(IVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public Double getPrecio() {
        return vehiculo.getPrecio() + 20.0;
    }

    @Override
    public String getAccesorios() {
        return vehiculo.getAccesorios() + " Vidrio Reforzado";
    }
}