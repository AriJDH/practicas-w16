package poo.agenciaDeTurismo;

public class AgenciaDeTurismo {

    private Repositorio repositorio;
    private String nombre;

    public AgenciaDeTurismo(String nombre) {
        this.nombre = nombre;
        this.repositorio = new Repositorio();
    }

    public Localizador crearNuevoLocalizador(Cliente cte) {
        int cantidadDeLocalizador = repositorio.getCantidadLocalizadoresPorDni(cte.getDni());

        Localizador localizador = new Localizador(cte, cantidadDeLocalizador >= 2);

        repositorio.agregarLocalizador(localizador);

        return localizador;
    }

    public void agregarReserva(Localizador localizador, Reservable reserva) {
        localizador.agregarReserva(reserva);
    }

    public void imprimirViajes() {
        System.out.println(this.repositorio);
    }

}
