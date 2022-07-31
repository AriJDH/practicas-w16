import modelo.Cliente;
import modelo.Localizador;
import modelo.RepositorioCliente;
import modelo.Reserva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repositorio {
    private List<Localizador> localizadores= new ArrayList<>();

    public void agregarLocalizadorCliente(Cliente cliente, List<Reserva> reservas, RepositorioCliente repositorioCliente){

        List<Localizador> historial = repositorioCliente.historial(cliente);

        double total=0;
        double descuentoTotal=0;
        int hotel=0;
        int transporte=0;
        int comida=0;
        int boleto=0;
        for (Reserva reserva :reservas) {
            total+=reserva.darPrecio();
            switch (reserva.tipo()){
                case "hotel":
                    hotel++;
                    break;
                case "transporte":
                    transporte++;
                    break;
                case "comida":
                    comida++;
                    break;
                case "boleto":
                    boleto++;
                    break;
            }
        }
        if(historial.size()>=2){
            descuentoTotal+=total*0.05;
        }

        if(hotel>0 && transporte>0 && comida>0 && boleto>0){
            descuentoTotal += total*0.1;
        }

        if(hotel>=2){
            for (Reserva res : reservas
                 ) {
                if(res.tipo().equals("hotel")){
                    descuentoTotal+=res.darPrecio()*0.05;
                }
            }

        }
        if(boleto>=2){
            for (Reserva res : reservas
            ) {
                if(res.tipo().equals("hotel")){
                    descuentoTotal+=res.darPrecio()*0.05;
                }
            }
        }
        Localizador localizador;

    }
    @Override
    public String toString() {
        return "Repositorio{" +
                "localizadores=" + localizadores +
                '}';
    }
}
