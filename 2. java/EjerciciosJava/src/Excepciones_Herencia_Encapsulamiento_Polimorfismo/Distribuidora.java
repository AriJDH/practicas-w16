package Excepciones_Herencia_Encapsulamiento_Polimorfismo;

public class Distribuidora {

    public static void main(String[] args) {

        Producto arrProductosPer[] = new Perecedero[5];

        arrProductosPer[0] = new Perecedero("Leche", 100, 1);
        arrProductosPer[1] = new Perecedero("Crema", 200, 1);
        arrProductosPer[2] = new Perecedero("Jugo", 100, 2);
        arrProductosPer[3] = new Perecedero("Carne", 100, 3);
        arrProductosPer[4] = new Perecedero("Queso", 100, 7);

        Producto arrProductosNoPer[] = new NoPerecedero[5];

        arrProductosNoPer[0] = new NoPerecedero("Arroz", 100, "Cereal");
        arrProductosNoPer[1] = new NoPerecedero("Garbanzos", 100, "Legumbres");
        arrProductosNoPer[2] = new NoPerecedero("Lentejas", 100, "Legumbres");
        arrProductosNoPer[3] = new NoPerecedero("Fideos", 100, "Pasta");
        arrProductosNoPer[4] = new NoPerecedero("Almendras", 100, "Frutos Secos");

        double valorTotalPer = 0;
        double valorTotalNoPer = 0;

        for(Producto producto : arrProductosPer){
            double valor = producto.calcular(1);
            System.out.println(producto.toString() + " Valor: " + valor);
            valorTotalPer += valor;
        }

        for(Producto producto : arrProductosNoPer){
            double valor = producto.calcular(2);
            System.out.println(producto.toString() + " Valor: " + valor);
            valorTotalNoPer += valor;
        }

        System.out.println("----------------");
        System.out.println("Valor total perecederos: " + valorTotalPer);
        System.out.println("Valor total no perecederos: " + valorTotalNoPer);
        System.out.println("Valor total: " + (valorTotalPer + valorTotalNoPer));

    }

}
