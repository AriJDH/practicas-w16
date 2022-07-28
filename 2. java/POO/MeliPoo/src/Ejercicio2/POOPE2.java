package Ejercicio2;

public class POOPE2 {
    public static void main(String[] args) {



        Producto producto = new Producto(nombre, precio);

        double total =producto.calcular(20);
        System.out.println("Precio total es "+total);
    }

    static class Producto {
        private String nombre;
        private Double precio;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Double getprecio() {
            return precio;
        }

        public void setPrecio(Double precio) {
            this.precio = precio;
        }

        public Producto(String nombre, Double precio) {
            this.nombre = this.nombre;
            this.precio = this.precio;
        }
        @Override
        public String toString() {
            return "Nombre: " + this.nombre + " Precio: $" + this.precio;
        }

        public double calcular(int cantidadDeProductos) {
            double total = this.precio * cantidadDeProductos;
            return  total;
        }


    }
}
