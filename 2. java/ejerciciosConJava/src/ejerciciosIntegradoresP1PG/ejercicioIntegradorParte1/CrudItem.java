package ejerciciosIntegradoresP1PG.ejercicioIntegradorParte1;

import java.util.List;

public class CrudItem implements Crud<Item>{

    public List<Item> items;

    public CrudItem(List<Item> items) {
        this.items = items;
    }

    @Override
    public List<Item> listar() {
        return items;
    }

    @Override
    public void crear(Item item) {
        items.add(item);
    }

    @Override
    public boolean encontrarPorDni(int dni) {
        String mensaje="No existe la factura";
        boolean facturaEncontrada=false;
        for(int i=0;i<items.size();i++){
            if(items.get(i).getCodigo()==dni){
                mensaje=items.get(i).toString();
                facturaEncontrada=true;
            }
        }
        System.out.println(mensaje);
        return facturaEncontrada;
    }

    @Override
    public void eliminarPorDni(int dni) {
        for(int i=0;i<items.size();i++){
            if(items.get(i).getCodigo()==dni){
                this.items.remove(i);
            }
        }
        System.out.println("Item eliminado");

    }

    public double totalPrecio(){
        double total=0;
        for(Item item:items){
            total += item.getCostoUnitario()*item.getCantidadComprada();
        }
        return total;
    }
}
