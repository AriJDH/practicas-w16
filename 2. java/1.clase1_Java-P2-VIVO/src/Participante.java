public class Participante {
    private int id;
    private int dni;
    private String name;
    private String lastName;
    private int age;
    private String cellphone;
    private String emergencyNumber;
    private String bloodType;

    public Participante (int id, String name, String lastName, int dni, int age, String cellphone, String emergencyNumber, String bloodType){
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.cellphone = cellphone;
        this.emergencyNumber = emergencyNumber;
        this.bloodType = bloodType;
    }

    public String showDataParticipante(){
        return  "Número de Registro: " + id + "\n" +
                "Nombre: " + name + " " + lastName + "\n" +
                "DNI: " + dni + "\n" +
                "Edad: " + age + "\n" +
                "Telefono: " + cellphone + "\n" +
                "Número de Emergencia: " + emergencyNumber + "\n" +
                "Tipo Sanguineo: " + bloodType + "." + "\n" ;
    }
}
