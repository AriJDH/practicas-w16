package Distribuidora;

import java.util.ArrayList;


public class Distribuidora {
    ArrayList<Producto> listaProductos;
    ScannerUtils input;
    Distribuidora(ScannerUtils input ) {
        this.listaProductos = new ArrayList<Producto>();
        this.input = input;
    }
    public void agregarProducto() {
        int option = this.input.getIntFromScanner("1) No perecedero\n2)Distribuidora.Perecedero");
        if(option == 1) {
            this.agregarNoPerecedero();
        }
        else if(option == 2) {
            this.agregarPerecedero();
        }
        else {
            System.out.println("Ingrese una opcion valida");
            this.agregarProducto();
        }
    }
    private void agregarPerecedero() {
        String nombre = this.input.getStringFromScanner("Ingrese el nombre del producto");
        double precio = this.input.getDoubleFromScanner("Ingrese el precio del producto");
        int diasPorCaducar = this.input.getIntFromScanner("Ingrese la cantidad de dias hasta que caduque");
        this.listaProductos.add(new Perecedero(nombre, precio, diasPorCaducar));
    }
    private void agregarNoPerecedero() {
        String nombre = this.input.getStringFromScanner("Ingrese el nombre del producto");
        double precio = this.input.getDoubleFromScanner("Ingrese el precio del producto");
        String tipo = this.input.getStringFromScanner("Ingrese el tipo del producto");
        this.listaProductos.add(new NoPerecedero(nombre, precio, tipo));
    }

    @Override
    public String toString() {
        return "Distribuidora.Distribuidora{" +
                "listaProductos=" + listaProductos +
                '}';
    }
}
