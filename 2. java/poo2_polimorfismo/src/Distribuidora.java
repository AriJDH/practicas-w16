import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        double valor_total=0;
      NoPerecedero producto1=new NoPerecedero("Atun",15000,"Lata");
      Perecederos producto2=new Perecederos("Leche",1000,3);
      Producto producto3=new Producto("Lapiz",60);
        ArrayList<Producto> lista=new ArrayList<>();
        lista.add(producto1);
        lista.add(producto2);
        lista.add(producto3);

        for(int i=0;i<lista.size();i++){
            valor_total=valor_total+lista.get(i).calcular(10);
        }

        System.out.println(valor_total);
    }
}
