package reservas;

import reservas.repository.ClienteRepository;
import reservas.repository.LocalizadorRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Crear localizador
        ClienteRepository clienteRepository = new ClienteRepository();
        LocalizadorRepository localizadorRepository = new LocalizadorRepository();
        //Cliente cliente = new Cliente("yenny","123");

        //paquete completo 10%
        TipoDeReservas reservaHotel=new TipoDeReservas("Reserva de Hotel");
        TipoDeReservas reservaComida=new TipoDeReservas("Reserva de Comida");
        TipoDeReservas reservaBoletos=new TipoDeReservas("Reserva de Boletos");
        TipoDeReservas reservaTransporte=new TipoDeReservas("Reserva de Transporte");
        List<TipoDeReservas> paqCompleto = new ArrayList<>();
        paqCompleto.add(reservaHotel);
        paqCompleto.add(reservaComida);
        paqCompleto.add(reservaBoletos);
        paqCompleto.add(reservaTransporte);

        List<TipoDeReservas> paqDosReservas = new ArrayList<>();
        paqDosReservas.add(reservaHotel);
        paqDosReservas.add(reservaHotel);

        localizadorRepository.creaLocalizador("Yenny","DNI1",paqCompleto,10000.00);

        //punto 2 2 reservas
        localizadorRepository.creaLocalizador("Carmen","DNI2",paqDosReservas,6000.00);

        System.out.println("Fin");
    }

}
