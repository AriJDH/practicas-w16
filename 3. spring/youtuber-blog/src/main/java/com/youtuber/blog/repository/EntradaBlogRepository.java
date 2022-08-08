package com.youtuber.blog.repository;

import com.youtuber.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository {

        List<EntradaBlog> listaEntradas = new ArrayList<EntradaBlog>() {{
                add(new EntradaBlog(1L, "Objetos en Java", "ProgramacionYT", "20 de Julio de 2018"));
                add(new EntradaBlog(2L, "Clases en Java", "ProgramacionYT", "30 de Diciembre de 2021"));
        }};

        @Override
        public String nuevaEntrada(Long id, String nombre, String titulo, String fechaPublicacion) {
                List<EntradaBlog> idExiste = listaEntradas.stream().filter(e -> e.getId().equals(id)).collect(Collectors.toList());

                if (idExiste.isEmpty()) {
                        listaEntradas.add(new EntradaBlog(id, titulo, nombre, fechaPublicacion));
                        return "Entrada creada correctamente. ID: " + id;
                } else {
                        return null;
                }
        }

        @Override
        public EntradaBlog devolverEntrada(Long id) {
                for (EntradaBlog entrada : listaEntradas){
                        if(entrada.getId().equals(id)){
                                return entrada;
                        }
                }
                return null;
//                List<EntradaBlog> entradaFiltrada = listaEntradas.stream().filter(e -> e.getId().equals(id)).collect(Collectors.toList());
//                return entradaFiltrada.get(0);
        }

        @Override
        public List<EntradaBlog> allEntradas() {
                return listaEntradas;
        }
}
