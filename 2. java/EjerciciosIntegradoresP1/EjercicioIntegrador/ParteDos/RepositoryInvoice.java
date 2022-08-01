package EjerciciosIntegradoresP1.EjercicioIntegrador.ParteDos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.controller.FilterType;
import EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.controller.Repository;
import EjerciciosIntegradoresP1.EjercicioIntegrador.ParteUno.model.Factura;

public class RepositoryInvoice implements Repository<Factura> {
         
        private Collection<Factura> facturas;
    
        public RepositoryInvoice() {
            this.facturas = new ArrayList<Factura>();
        }
    
        
        /** 
         * @param factura
         */
        @Override
        public void add(Factura factura) {
            this.facturas.add(factura);
        }
    
        
        /** 
         * @param factura
         */
        @Override
        public void remove(Factura factura) {
            this.facturas.remove(factura);
        }
    
        
        /** 
         * @param factura
         */
        @Override
        public void update(Factura factura) {
            
        }

        
        /** 
         * @param item
         * @return Factura
         */
        @Override
        public Factura get(Factura item) {
            return this.facturas.contains(item) ? item : null;
        }
    
        
        /** 
         * @param labels
         * @return Factura
         */
        @Override
        public Factura get(FilterType... labels) {
            Field[] fields = facturas.size() > 0 ? facturas.iterator().next().getClass().getDeclaredFields() : null;
            Factura response = null;
    
            for (Factura factura : this.facturas) {
                boolean match = false;
                for (FilterType filter : labels) {
                    for (Field field : fields) {
                        if (field.getName().equals(filter.getType())) {
                            if (factura.get(field.getName()).equals(filter.getValue())) {
                                match = true;
                            }
                        }
                    }
                }
                if (match) {
                    response = factura;
                    break;
                }
            }
    
            return response;
        }
    
        
        /** 
         * @param labels
         * @return boolean
         */
        @Override
        public boolean delete(FilterType... labels) {
            Field[] fields = facturas.size() > 0 ? facturas.iterator().next().getClass().getDeclaredFields() : null;
            boolean response = false;
    
            for (Factura factura : this.facturas) {
                boolean match = false;
                for (FilterType filter : labels) {
                    for (Field field : fields) {
                        if (field.getName().equals(filter.getType())) {
                            if (factura.get(field.getName()).equals(filter.getValue())) {
                                match = true;
                            }
                        }
                    }
                }
                if (match) {
                    response = true;
                    break;
                }
            }
    
            return response;
        }
    
        
        /** 
         * @return Collection<Factura>
         */
        @Override
        public Collection<Factura> getAll() {
            return this.facturas;
        }
}
