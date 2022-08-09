package integrador;

public class Main {
    public static void main(String[] args) {
        ScannerUtils keyboard = new ScannerUtils();
        Supermercado supermercado = new Supermercado();
        supermercado.agregarCliente(
                new Cliente(
                        keyboard.getStringFromScanner("Nombre del cliente"),
                        keyboard.getStringFromScanner("Apellido del cliente"),
                        keyboard.getIntFromScanner("Dni del cliente")
                )
        );
    }
}
