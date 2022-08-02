package Servicios;

public class ReservaDeHotel extends Reserva {
    private String nombreHotel;
    private String numeroHabitacion;
    private int diasReservados;

    public ReservaDeHotel(String numReserva, int costo, String nombreHotel, String numeroHabitacion, int diasReservados) {
        super(numReserva, costo);
        this.nombreHotel = nombreHotel;
        this.numeroHabitacion = numeroHabitacion;
        this.diasReservados = diasReservados;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public int getDiasReservados() {
        return diasReservados;
    }

    public void setDiasReservados(int diasReservados) {
        this.diasReservados = diasReservados;
    }

    @Override
    public String mostrarDatos() {
        return "***** Reserva de Hotel *****" + "\n"
        + super.mostrarDatos() + "\n"
                + "Hotel: " + this.getNombreHotel() + "\n"
                + "Habitación: " + this.getNumeroHabitacion() + "\n"
                + "Estadía: " + this.getDiasReservados() + " días" + "\n";
    }
}
