package ejerciciosIntegradoresP1PG.ejercicioIntegradorParte1;

import java.util.ArrayList;
import java.util.List;

public class CrudCliente implements Crud<Cliente>{
    public List<Cliente> clientes;

    public CrudCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public List<Cliente> listar() {
        return this.clientes;
    }

    @Override
    public void crear(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public boolean encontrarPorDni(int dni) {

        String mensaje="No existe el cliente";
        boolean clienteEncontrado=false;
        for(int i=0;i<clientes.size();i++){
            if(clientes.get(i).getDni()==dni){
                mensaje=clientes.get(i).toString();
                clienteEncontrado=true;
            }
        }
        System.out.println(mensaje);
        return clienteEncontrado;
    }
    @Override
    public void eliminarPorDni(int dni) {
        for(int i=0;i<clientes.size();i++){
            if(clientes.get(i).getDni()==dni){
                this.clientes.remove(i);
            }
        }
        System.out.println("Cliente eliminado");
    }
}
