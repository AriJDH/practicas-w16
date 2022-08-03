package com.tomas.supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImplementacion implements ICrud<Factura> {

    private List <Factura> facturas = new ArrayList<Factura>();

    @Override
    public void guardar(Factura objeto) {

        facturas.add(objeto);

    }

    @Override
    public void mostrarDatos() {

        for(Factura datoFactura: facturas) {
            System.out.println(datoFactura.toString());
        }

    }

    @Override
    public Optional<Factura> buscar(int id) {

        boolean facturaExiste = false;
        for(Factura datoFactura: facturas) {

            if(datoFactura.getCodigo() == id) {
                System.out.println(datoFactura.toString());
                facturaExiste = true;

                return Optional.of(datoFactura);
            }

        }

        if(!facturaExiste) {
            System.out.println("El cliente no existe");
        }

        return Optional.empty();
    }

    @Override
    public List<Factura> listarDatoCompleto() {
        return facturas;
    }

    @Override
    public void eliminar(int id) {

        boolean facturaExiste = false;
        for(Factura datoFactura: facturas) {

            if(datoFactura.getCodigo() == id) {
                facturaExiste = true;
                facturas.remove(datoFactura);
            }

        }

        if(facturaExiste) {
            System.out.println("La factura fue elimindado");
        } else {
            System.out.println("La factura no existe y por lo tanto no se ha podido eliminar ningún registro");
        }

    }

}
