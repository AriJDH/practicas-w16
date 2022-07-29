package EjercicioIntegradorEnVivo;

import EjercicioIntegradorEnVivo.models.Cliente;
import EjercicioIntegradorEnVivo.models.Localizadores;
import EjercicioIntegradorEnVivo.models.Producto;
import EjercicioIntegradorEnVivo.repository.ClienteRepository;
import EjercicioIntegradorEnVivo.repository.ProductoRepository;

import java.util.ArrayList;
import java.util.List;

public class AgenciaDeTurismo {

    public static void main (String[]args){



//        Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
//        Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.
//        Crear un localizador con una sola reserva para el mismo cliente.
//                Verificar que los descuentos fueron aplicados.


        Producto reservaDeHotel = new Producto(0L, "Reserva de hotel",20000);
        Producto comida = new Producto(1L, "Comida",1000);
        Producto boletosDeViaje = new Producto(2L, "Boletos de viaje",30000);
        Producto transporte = new Producto(3L, "Transporte",15654);

        ProductoRepository productoRepository = new ProductoRepository();

        productoRepository.crearProducto(reservaDeHotel);
        productoRepository.crearProducto(comida);
        productoRepository.crearProducto(boletosDeViaje);
        productoRepository.crearProducto(transporte);

        Cliente cliente = new Cliente("12345689-2", "Gilberto", "Perez", "+5697842436", new ArrayList<Localizadores>());

        ClienteRepository clienteRepository = new ClienteRepository();

        Cliente clienteCreadoPorRepository = clienteRepository.crearCliente(cliente);

        List<Producto> paqueteCompleto = new ArrayList<Producto>(4);

        paqueteCompleto.add(reservaDeHotel);
        paqueteCompleto.add(comida);
        paqueteCompleto.add(boletosDeViaje);
        paqueteCompleto.add(transporte);

        List<Producto> paqueteHotelYBoletos = new ArrayList<Producto>(4);

        paqueteHotelYBoletos.add(reservaDeHotel);
        paqueteHotelYBoletos.add(reservaDeHotel);
        paqueteHotelYBoletos.add(boletosDeViaje);
        paqueteHotelYBoletos.add(boletosDeViaje);

        List<Producto> paqueteProducto = new ArrayList<Producto>(1);


        paqueteProducto.add(transporte);

        Localizadores localizadorCompleto = new Localizadores(0L,clienteCreadoPorRepository,new ArrayList<>());
        localizadorCompleto.setProductos(paqueteCompleto);
        Localizadores localizadorHotelYBoletos = new Localizadores(2L,clienteCreadoPorRepository,new ArrayList<>());
        localizadorHotelYBoletos.setProductos(paqueteHotelYBoletos);

        Localizadores localizadorProducto = new Localizadores(3L,clienteCreadoPorRepository,new ArrayList<>());
        localizadorProducto.setProductos(paqueteProducto);


        List<Localizadores> localizadores = new ArrayList<Localizadores>();
        localizadores.add(localizadorCompleto);
        localizadores.add(localizadorProducto);


        Cliente clienteNuevo = new Cliente("12345689-2", "Alberto", "Perez", "+54842436", localizadores);

        clienteRepository.agregarLocalizador(localizadorHotelYBoletos,clienteNuevo);

    }
}
