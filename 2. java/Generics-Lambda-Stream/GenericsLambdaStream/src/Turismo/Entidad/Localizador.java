package Turismo.Entidad;

import Turismo.Repositorio.ClienteRepositorio;

import java.util.List;
import java.util.Scanner;

public class Localizador {

    private int id;
    private Cliente cliente;
    private List<PaqueteTuristico> listaPaqueteTuristico;
    private double total;

    public Localizador(int id,int idCliente, List<Integer> listaIdsPaqueteTuristico) {
        this.id = id;
        this.cliente = BuscarCliente(idCliente);
        this.listaPaqueteTuristico = obtenerPaquetesTuristicos(listaIdsPaqueteTuristico);
        this.total = calcularCosto();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<PaqueteTuristico> getListaPaqueteTuristico() {
        return listaPaqueteTuristico;
    }

    public void setListaPaqueteTuristico(List<PaqueteTuristico> listaPaqueteTuristico) {
        this.listaPaqueteTuristico = listaPaqueteTuristico;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private double calcularCosto(){

        return listaPaqueteTuristico.stream()
                .mapToDouble(paqueteTuristico -> paqueteTuristico.getCosto()).sum();
    }

    private List<PaqueteTuristico> obtenerPaquetesTuristicos(List<Integer> listaIdPaquete){
        return null;
    }

    private Cliente BuscarCliente(int idCliente){

        if(ClienteRepositorio.validarExistencia(idCliente)){
            return ClienteRepositorio.getCliente(idCliente);
        }
        else{
            System.out.println("Cliente no existe, registralo");
            return ClienteRepositorio.registrarDato(new Scanner(System.in));
        }
    }
}
