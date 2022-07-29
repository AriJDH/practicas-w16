package ejercicioIntegradorEnVivo.cliente;

public class Cliente {

    private final Integer dni;
    private final String nombreCompleto;

    public Cliente(Integer dni, String nombreCompleto) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                '}';
    }
}
