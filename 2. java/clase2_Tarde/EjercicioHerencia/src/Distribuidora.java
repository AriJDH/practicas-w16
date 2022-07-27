public class Distribuidora {
    static Producto[] distribuidora = new Producto[10];
    public static void main(String[] args) {
        Perecedero perecedero1 = new Perecedero("producto1",10,10);
        Perecedero perecedero2 = new Perecedero("producto2",23,10);
        Perecedero perecedero3 = new Perecedero("producto3",50,15);
        Perecedero perecedero4 = new Perecedero("producto4",10,4);
        Perecedero perecedero5 = new Perecedero("producto5",10,10);

        NoPerecedero noPerecedero1 = new NoPerecedero("productoNo1",15,"comida");
        NoPerecedero noPerecedero2 = new NoPerecedero("productoNo1",20,"comida");
        NoPerecedero noPerecedero3 = new NoPerecedero("productoNo1",10,"comida");
        NoPerecedero noPerecedero4 = new NoPerecedero("productoNo1",5,"comida");
        NoPerecedero noPerecedero5 = new NoPerecedero("productoNo1",60,"comida");

        distribuidora[0]= perecedero1;
        distribuidora[1]= perecedero2;
        distribuidora[2]= perecedero3;
        distribuidora[3]= perecedero4;
        distribuidora[4]= perecedero5;
        distribuidora[5]= noPerecedero1;
        distribuidora[6]= noPerecedero2;
        distribuidora[7]= noPerecedero3;
        distribuidora[8]= noPerecedero4;
        distribuidora[9]= noPerecedero5;
        double montoTotal = 0;

        for (int i= 0;i<distribuidora.length;i++){
            montoTotal=montoTotal + distribuidora[i].calcular(1);
        }
        System.out.println("Monto Total para pagar = "+ montoTotal);
    }
}
