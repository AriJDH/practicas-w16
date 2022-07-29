package EjercicioIntegradorEnVivo.repository;

import EjercicioIntegradorEnVivo.models.Cliente;
import EjercicioIntegradorEnVivo.models.Localizadores;
import EjercicioIntegradorEnVivo.models.Producto;

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
        //historico
        if(cliente.getLocalizadoresList().size()>=2){
            localizadores.setTotal(localizadores.getTotal()*.95);
            cliente.addLocalizador(localizadores);

            System.out.println(cliente.toString());

            return cliente;
        }
//paquete completo
        boolean esCompleto = false;
        int contR=0,contC=0,contT=0,contB=0;
        for(Producto producto: localizadores.getProductos()){
            if(producto.getTipo().equals("Reserva de hotel")){
                contR+=1;
            }
            if(producto.getTipo().equals("Comida")){
                contC+=1;

            }
            if(producto.getTipo().equals("Boletos de viaje")){
                contT+=1;

            }
            if(producto.getTipo().equals("Transporte")){
                contB+=1;

            }
        }
        if(contR==1 && contC ==1 && contT==1 && contB==1){
            total = localizadores.getTotal()*.90;
        } else if(contR==2 && contB==2){
            total = localizadores.getTotal()*.95;
        }
        localizadores.setTotal(total);
        cliente.addLocalizador(localizadores);

        System.out.println("Cliente: ");

        System.out.println(cliente.toString());
        return cliente;
    }
}
