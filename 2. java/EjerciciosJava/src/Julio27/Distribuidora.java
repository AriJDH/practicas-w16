package Julio27;

public class Distribuidora {
    public static Producto[] productos = new Producto[10];
    public static void main(String[] args) {
        productos[0] = new Perecedero("Tomate",10,3);
        productos[1]  = new Perecedero("lechuga",30,1);
        productos[2] = new Perecedero("leche",18,2);
        productos[3]  = new Perecedero("fiambre",50,5);
        productos[4] = new Perecedero("queso",50,6);
        productos[5] = new NoPerecedero("arroz",15,"bolza");

        productos[6]  = new NoPerecedero("arbejas",20,"enlatado");
        productos[7]  = new NoPerecedero("lentejas",25,"bolza");
        productos[8]  = new NoPerecedero("choclo",20,"enlatado");
        productos[9]  = new NoPerecedero("fideos",19,"bolza");

        int precioTotal = 0 ;
        
    }
}
