package com.tomas.agencia.models;

import java.util.List;

public class Localizadores {
    private Long id;
    private Cliente cliente;
    private List<Producto> productos;
    private Double total;

    public Localizadores(Long id, List<Producto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
    }

    public Localizadores() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        double valor =0;
        for(Producto producto:productos){
            valor += producto.getValor();
        }
        this.total = valor;
    }

    public Double getTotal(){
        return total;
    }

    public void setTotal(Double total){
        this.total = total;
    }


    @Override
    public String toString() {
        return "Localizadores{" +
                "id=" + id +
                ", productos=" + productos +
                ", total=" + total +
                '}';
    }
}