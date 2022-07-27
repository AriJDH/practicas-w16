package practicaPoo2Vivo.ejercicio2;

class Caducidad {

    private Integer diasPorCaducar;

    public Caducidad(Integer diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Integer getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public Double afectarPrecioSegunCantidadDiasRestantesDado(Double unPrecioFinal) {
        if (diasPorCaducar == 1) return unPrecioFinal / 4;
        if (diasPorCaducar == 2) return unPrecioFinal / 3;
        if (diasPorCaducar == 3) return unPrecioFinal / 2;
        return unPrecioFinal;
    }
}

public class Perecedero extends Producto {

    private Caducidad caducidad;

    public Perecedero(String nombre, Double precio, Integer diasPorCaducar) {
        super(nombre, precio);
        this.caducidad = new Caducidad(diasPorCaducar);
    }

    public Integer getDiasPorCaducar() {
        return caducidad.getDiasPorCaducar();
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + caducidad.getDiasPorCaducar() + '\'' +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public Double calcular(int unaCantidadDeProductos){
        return caducidad.afectarPrecioSegunCantidadDiasRestantesDado(super.calcular(unaCantidadDeProductos));
    }

}
