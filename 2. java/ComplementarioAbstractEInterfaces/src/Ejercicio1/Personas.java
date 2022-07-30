package Ejercicio1;

public abstract class Personas {
    private String nombre;
    private Integer id;

    // Constructor

    public Personas(String nombre, Integer id) {
        this.nombre = nombre;
        this.id = id;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
