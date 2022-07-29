package practica_2.Selva;

public class Participante {
    static private int idParticipante = 0;
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;

    public TiposCircuitos tiposCircuitos;
    public double dineroAbono;

    public Participante(String dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.id = ++idParticipante;
    }


    public int getEdad() {
        return edad;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {

        return  "Id : " + id + "\n" +
                "nombre : " + nombre + " " + apellido + "\n" +
                "edad : " + edad + "\n" +
                "dni : " + dni + "\n" +
                "celular : " + celular + "\n" +
                "numeroEmergencia : " + numeroEmergencia + "\n" +
                "grupoSanguineo : " + grupoSanguineo + "\n" +
                "numeroEmergencia : " + numeroEmergencia + "\n" +
                "tipo de circuitos : " + tiposCircuitos.name() + "\n" +
                "pago : " + dineroAbono + "\n\n";
    }
}
