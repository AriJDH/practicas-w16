package poo.agenciaDeTurismo;

public class Main {

    public static void main(String[] args) {

        AgenciaDeTurismo agencia = new AgenciaDeTurismo("TuriSol");

        Cliente cliente1 = new Cliente("3333", "Carlos", "Roth");

        Localizador loc1 = agencia.crearNuevoLocalizador(cliente1);


        Hotel hotel = new Hotel("Hotel", 3, 2);
        Viaje viaje = new Viaje("Buenos Aires", "Cordoba", 2);
        Traslado traslado = new Traslado(2);
        Comida comida = new Comida(true, 2);

        agencia.agregarReserva(loc1, hotel);
        agencia.agregarReserva(loc1, viaje);
        agencia.agregarReserva(loc1, traslado);
        agencia.agregarReserva(loc1, comida);

        Localizador loc2hotel = agencia.crearNuevoLocalizador(cliente1);
        agencia.agregarReserva(loc2hotel, hotel);
        agencia.agregarReserva(loc2hotel, hotel);
        agencia.agregarReserva(loc2hotel, viaje);
        agencia.agregarReserva(loc2hotel, viaje);

        Localizador loc3 = agencia.crearNuevoLocalizador(cliente1);
        agencia.agregarReserva(loc3, hotel);

        Localizador loc2viajeMasDosLocalizadores = agencia.crearNuevoLocalizador(cliente1);
        agencia.agregarReserva(loc2viajeMasDosLocalizadores, viaje);
        agencia.agregarReserva(loc2viajeMasDosLocalizadores, viaje);
        agencia.agregarReserva(loc2viajeMasDosLocalizadores, comida);


        Localizador loc3TodosLosDescuentos = agencia.crearNuevoLocalizador(cliente1);
        agencia.agregarReserva(loc3TodosLosDescuentos, viaje);
        agencia.agregarReserva(loc3TodosLosDescuentos, viaje);
        agencia.agregarReserva(loc3TodosLosDescuentos, viaje);
        agencia.agregarReserva(loc3TodosLosDescuentos, hotel);
        agencia.agregarReserva(loc3TodosLosDescuentos, hotel);
        agencia.agregarReserva(loc3TodosLosDescuentos, hotel);
        agencia.agregarReserva(loc3TodosLosDescuentos, hotel);
        agencia.agregarReserva(loc3TodosLosDescuentos, traslado);
        agencia.agregarReserva(loc3TodosLosDescuentos, comida);
        agencia.agregarReserva(loc3TodosLosDescuentos, traslado);
        agencia.agregarReserva(loc3TodosLosDescuentos, comida);

        Cliente cliente2 = new Cliente("1234", "pepe", "Lopez");
        Localizador loc4SinDescuentos = agencia.crearNuevoLocalizador(cliente2);
        agencia.agregarReserva(loc4SinDescuentos, viaje);

        agencia.imprimirViajes();
    }
}

