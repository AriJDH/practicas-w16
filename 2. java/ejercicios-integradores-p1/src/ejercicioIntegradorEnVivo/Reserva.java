package ejercicioIntegradorEnVivo;

public enum Reserva {
    HOTEL, COMIDA, BOLETO_DE_VIAJES, TRANSPORTE;

    public Double getPrice() {
        switch(this) {
            case HOTEL:
                return 20d;

            case COMIDA:
                return 5d;

            case BOLETO_DE_VIAJES:
                return 15d;

            case TRANSPORTE:
                return 10d;

            default:
                return 0d;
        }
    }
}
