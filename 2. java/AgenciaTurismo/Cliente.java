package AgenciaTurismo;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cliente implements ICliente {
    List<ILocalizador> localizadores;

    public List<ILocalizador> getLocalizadores() {
        return localizadores;
    }


    public Cliente() {
        this.localizadores = new ArrayList<>();
    }
    @Override
    public void agregarLocalizador(ILocalizador localizador) {
        this.localizadores.add(localizador);
    }
    @Override
    public ILocalizador getLocalizadorById(int id) {
        return this.localizadores.stream()
                .filter(localizador -> localizador.getId() == id)
                .findFirst().get();
    }
    public double getLocalizadorPrecioById(int id) {
        ILocalizador localizador = this.localizadores.stream()
                .filter(localizador1 -> localizador1.getId() == id)
                .findFirst().get();
        double acc = 0d;
        List<IReservaBoletosViaje> boletos = new ArrayList<>();
        List<IReservaHotel> hoteles = new ArrayList<>();
        List<IReservaRestaurant> restoranes = new ArrayList<>();
        List<IReservaTransporte> transportes = new ArrayList<>();
        List<IPaquete> paquetes = new ArrayList<>();
        localizador.getReservas().stream().forEach(reserva -> {
            if(reserva instanceof IReservaBoletosViaje) {
                boletos.add((IReservaBoletosViaje) reserva);
                return;
            }
            if(reserva instanceof IReservaHotel) {
                hoteles.add((IReservaHotel) reserva);
                return;
            }
            if(reserva instanceof IReservaRestaurant) {
                restoranes.add((IReservaRestaurant) reserva);
                return;
            }
            if(reserva instanceof IReservaTransporte) {
                transportes.add((IReservaTransporte) reserva);
                return;
            }
            if(reserva instanceof IPaquete) {
                paquetes.add((IPaquete) reserva);
                return;
            }
        });
        double precioBoletos = this.calcularPrecioReservas(boletos);
        if(boletos.size() >= 2) {
            precioBoletos = precioBoletos * 0.95;
        }

        acc=+ precioBoletos;

        double precioReservaHoteles = this.calcularPrecioReservas(hoteles);
        if(hoteles.size() >= 2) {
            precioReservaHoteles = precioReservaHoteles * 0.95;
        }
        acc=+ precioReservaHoteles;
        acc=+ this.calcularPrecioReservas(transportes);
        acc=+ this.calcularPrecioReservas(paquetes);
        double descuentos = 1;
        if(paquetes.size() >= 1) {
            descuentos =- 0.1;
        }
        if(this.getLocalizadores().size() >= 1) {
            descuentos =- 0.1;
        }
        return acc * descuentos;
    }
    private <T extends IReserva> double calcularPrecioReservas(List<T> reserva) {
        return reserva
                .stream()
                .mapToDouble(value -> value.getPrecio())
                .sum();
    }
}
