package EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.controller;

public class FilterType {
    private String type;
    private String value;

    public FilterType(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
