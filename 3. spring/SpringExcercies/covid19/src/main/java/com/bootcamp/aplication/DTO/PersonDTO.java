package com.bootcamp.aplication.DTO;

public class PersonDTO {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;

    private SymptomDTO symptomDTO;

    public PersonDTO() {
    }

    public PersonDTO(SymptomDTO symptomDTO) {
        this.symptomDTO = symptomDTO;
    }

    public PersonDTO(int id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public PersonDTO(int id, String nombre, String apellido, int edad, SymptomDTO symptomDTO) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.symptomDTO = symptomDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public SymptomDTO getSintomas() {
        return symptomDTO;
    }

    public void setSintomas(SymptomDTO symptomDTO) {
        this.symptomDTO = symptomDTO;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", sintomas=" + symptomDTO +
                '}';
    }
}
