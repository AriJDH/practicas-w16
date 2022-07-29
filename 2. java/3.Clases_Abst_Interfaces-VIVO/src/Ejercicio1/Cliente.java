package Ejercicio1;

public abstract class Cliente {
    private String name;
    private String dni;
    private String clientType;

    public Cliente(String name, String dni, String clientType) {
        this.name = name;
        this.dni = dni;
        this.clientType = clientType;
    }

    @Override
    public String toString(){
        return  "*******DATOS DEL CLIENTE*******\n" +
                "-- Nombre: " + name + " \n" +
                "-- DNI: " + dni + " \n" +
                "-- Tipo de Cliente: " + clientType + " \n" +
                " \n" +
                "          MOVIMIENTOS: ";
    }
}
