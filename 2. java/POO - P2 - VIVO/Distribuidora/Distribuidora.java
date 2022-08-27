package PilaresPOO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Distribuidora {

    public static void main(String[]args){

        List<Producto> productos = new ArrayList<Producto>();
        List<Producto> productosVendidos = new ArrayList<Producto>();
        Scanner sc = new Scanner(System.in);

        Perecedero p1= new Perecedero("salmon",9900,1);
        Perecedero p2= new Perecedero("carne de res",10000,7);
        Perecedero p3= new Perecedero("platano",500,7);
        Perecedero p4= new Perecedero("manzana",200,3);
        Perecedero p5= new Perecedero("leche",300,2);

        NoPerecedero nP1= new NoPerecedero("tallarines",1000,"alacena");
        NoPerecedero nP2= new NoPerecedero("arroz",1000,"alacena");
        NoPerecedero nP3= new NoPerecedero("harina",200,"alacena");
        NoPerecedero nP4= new NoPerecedero("almendras",3300,"frutos secos");
        NoPerecedero nP5= new NoPerecedero("sal",5600,"alinios");

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(nP1);
        productos.add(nP2);
        productos.add(nP3);
        productos.add(nP4);
        productos.add(nP5);

        System.out.println("Bienvenido a Compu mundo hiper mega red");
        System.out.println("Ingrese el nombre del producto a comprar");
        int n =1;
        Producto encontrado = null;
        int cant =0, cantPe=0, cantNp=0;
        double valorTotal = 0;
        for(Producto producto: productos){
            System.out.println(n+".- "+producto.getNombre()+ " Valor: $"+producto.getPrecio());
            n +=1;
        }

        do{
            for(Producto producto: productos){
                System.out.println(n+".- "+producto.getNombre()+ " Valor: $"+producto.getPrecio());
                n +=1;
            }
            String prod = sc.next();

            encontrado = productos.stream()
                    .filter(p -> prod.equals(p.getNombre()))
                    .findAny()
                    .orElse(null);

            if(encontrado == null){
                System.out.println("Producto no encontrado ingrese nuevamente");
            }else{
                System.out.println("Ingrese la cantidad a comprar del producto: " +encontrado.getNombre()+ " Valor: $"+encontrado.getPrecio());
                cant = sc.nextInt();
                valorTotal += encontrado.calcular(cant);
                productosVendidos.add(encontrado);
            }


        } while(productosVendidos.size() < 5);

        System.out.println("Precio total a vender: $" +valorTotal);

    }

}
