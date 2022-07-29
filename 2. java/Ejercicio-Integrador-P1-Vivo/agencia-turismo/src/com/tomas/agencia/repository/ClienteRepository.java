package com.tomas.agencia.repository;

import com.tomas.agencia.models.Cliente;
import com.tomas.agencia.models.Localizadores;
import com.tomas.agencia.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements ICliente{

    @Override
    public Cliente crearCliente(Cliente cliente) {
        if(cliente !=null){
            System.out.println("Cliente creado");
            System.out.println(cliente.toString());
            return cliente;
        }

        System.out.println("Error en ingresar Cliente");
        return null;
    }

    @Override
    public Cliente agregarLocalizador(Localizadores localizadores, Cliente cliente) {

        Double total= Double.valueOf(0);

        //Si el cliente adquirió 2 localizadores, se le aplica el 5% de descuento en la próxima compra
        if(cliente.getLocalizadoresList().size() > 2){
            localizadores.setTotal(localizadores.getTotal()*.95);
            List<Localizadores> localizadores2 = new ArrayList<Localizadores>();
            localizadores2 = cliente.getLocalizadoresList();
            localizadores2.add(localizadores);
            cliente.setLocalizadoresList(localizadores2);

            System.out.println(cliente.toString());

            return cliente;
        }


        int contadorHotel = 0;
        int contadorComida = 0;
        int contadorTransporte = 0;
        int contadorBoletos = 0;


        for(Producto producto: localizadores.getProductos()){
            if(producto.getTipo().equals("Reserva de hotel")){
                contadorHotel += 1;
            }
            if(producto.getTipo().equals("Comida")){
                contadorComida += 1;

            }
            if(producto.getTipo().equals("Boletos de viaje")){
                contadorTransporte += 1;

            }
            if(producto.getTipo().equals("Transporte")){
                contadorBoletos += 1;

            }
        }

        //
        if(contadorHotel == 1 && contadorComida == 1 && contadorTransporte == 1 && contadorBoletos == 1){

            //Aplicando directamente el descuento del 10%
            total = localizadores.getTotal() * 0.90;


        } else if(contadorHotel==2 || contadorBoletos==2){

            //Aplicando directamente el descuento del 5%
            total = localizadores.getTotal() * 0.95;
        } else {
            total = localizadores.getTotal();
        }

        localizadores.setTotal(total);
        cliente.addLocalizador(localizadores);

        System.out.println("Cliente: ");
        System.out.println(cliente.toString());
        return cliente;
    }
}
