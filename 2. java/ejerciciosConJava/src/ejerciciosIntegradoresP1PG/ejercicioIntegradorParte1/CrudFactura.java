package ejerciciosIntegradoresP1PG.ejercicioIntegradorParte1;

import java.util.List;

public class CrudFactura implements Crud<Factura>{

    public List<Factura> facturas;

    public CrudFactura(List<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public List listar() {
        return facturas;
    }

    @Override
    public void crear(Factura factura){
      facturas.add(factura);
    }

    @Override
    public boolean encontrarPorDni(int dni) {
        String mensaje="No existe la factura";
        boolean facturaEncontrada=false;
        for(int i=0;i<facturas.size();i++){
            if(facturas.get(i).getId()==dni){
                mensaje=facturas.get(i).toString();
                facturaEncontrada=true;
            }
        }
        System.out.println(mensaje);
        return facturaEncontrada;
    }


    @Override
    public void eliminarPorDni(int dni) {
        for(int i=0;i<facturas.size();i++){
            if(facturas.get(i).getId()==dni){
                this.facturas.remove(i);
            }
        }
        System.out.println("Factura eliminada");
    }
}
