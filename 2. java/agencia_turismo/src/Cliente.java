public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private int celular;
    private String mail;
    private boolean descuentoFuturo;

    public Cliente(String dni, String nombre, String apellido, int celular, String mail){

        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.celular=celular;
        this.mail=mail;
        this.descuentoFuturo=false;

    }

    public String getApellido() {
        return apellido;
    }

    public int getCelular() {
        return celular;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        apellido = apellido;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean equals(Cliente obj) {
       return obj.getDni().equalsIgnoreCase(this.dni);
    }

    public void setDescuentoFuturo(boolean descuentoFuturo) {
        this.descuentoFuturo = descuentoFuturo;
    }

    public boolean isDescuentoFuturo() {
        return descuentoFuturo;
    }
}
