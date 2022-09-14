package ejercicio3.ClaseAbstracta;

public abstract class Animal {

    private String nombre;
    private String tipoAlimentacion;

    public Animal(String nombre, String tipoAlimentacion) {
        this.nombre = nombre;
        this.tipoAlimentacion = tipoAlimentacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    public void setTipoAlimentacion(String tipoAlimentacion) {
        this.tipoAlimentacion = tipoAlimentacion;
    }

    public String comerCarne(){
        return "El " + getNombre() + " come carne";
    }

    public String comerHierva(){
        return "La " + getNombre() + " come hierva";
    }

    public String comerAnimal(){
        return (getTipoAlimentacion().equals("carnivoro")) ? comerCarne() : comerHierva();
    }
}
