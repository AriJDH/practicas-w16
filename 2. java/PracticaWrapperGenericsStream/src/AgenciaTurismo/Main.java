package AgenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LocalizadorRepository localizadorRepository = new LocalizadorRepository();
        ClienteRepository clienteRepository = new ClienteRepository();

        System.out.println("----------------Deberia aplicar 10-------------------");

        Cliente cliente = new Cliente("German");
        clienteRepository.addCliente(cliente);

        List<Paquete> paquetesCliente1 = new ArrayList<>();
        paquetesCliente1.add(new Paquete(true,true,true,true));

        Localizador loc1 = new Localizador(cliente, paquetesCliente1, 2000);

        verificarDescuentos(loc1, cliente, localizadorRepository);
        localizadorRepository.addLocalizador(loc1);

        System.out.println(loc1);

        System.out.println("---------------Deberia aplicar 5--------------------");

        Cliente cliente2 = new Cliente("Romina");
        clienteRepository.addCliente(cliente2);

        List<Paquete> paquetesCliente2 = new ArrayList<>();
        paquetesCliente2.add(new Paquete(true,false,true,false));
        paquetesCliente2.add(new Paquete(true,false,true,false));

        Localizador loc2 = new Localizador(cliente2, paquetesCliente2, 2000);

        verificarDescuentos(loc2, cliente2, localizadorRepository);
        localizadorRepository.addLocalizador(loc2);

        System.out.println(loc2);

        System.out.println("---------------No deberia aplicar (aun no tiene 2 localizadores guardados)--------------------");

        Cliente cliente3 = new Cliente("Romina");
        clienteRepository.addCliente(cliente3);

        List<Paquete> paquetesCliente3 = new ArrayList<>();
        paquetesCliente3.add(new Paquete(true,false,true,false));

        Localizador loc3 = new Localizador(cliente3, paquetesCliente3, 2000);

        verificarDescuentos(loc3, cliente3, localizadorRepository);
        localizadorRepository.addLocalizador(loc3);

        System.out.println(loc3);

        System.out.println("---------------Deberia aplicar 5 (ya tiene 2 localizadores gurdados)--------------------");

        Cliente cliente4 = new Cliente("Romina");
        clienteRepository.addCliente(cliente4);

        List<Paquete> paquetesCliente4 = new ArrayList<>();
        paquetesCliente4.add(new Paquete(true,false,true,false));

        Localizador loc4 = new Localizador(cliente4, paquetesCliente4, 2000);

        verificarDescuentos(loc4, cliente4, localizadorRepository);
        localizadorRepository.addLocalizador(loc4);

        System.out.println(loc4);

        System.out.println("-----------------------------------");
    }

    public static void verificarDescuentos(Localizador loc, Cliente cliente, LocalizadorRepository repository){
        if(repository.verificacionDescuento(cliente))
            loc.aplicarDescuento(5);
        if(loc.verificarDescuentoPqueteCompleto())
            loc.aplicarDescuento(10);
        if(loc.verificarDescuentoResrvasOBoletos())
            loc.aplicarDescuento(5);
    }
}
