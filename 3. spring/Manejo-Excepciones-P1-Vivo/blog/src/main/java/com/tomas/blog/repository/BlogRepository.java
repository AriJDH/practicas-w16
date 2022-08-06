package com.tomas.blog.repository;

import com.tomas.blog.entity.EntradaBlog;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@Repository
public class BlogRepository implements IBlogRepository{

    private HashMap<Integer, EntradaBlog> diccionarioBlog = new HashMap<>();

    public BlogRepository( ) {

    }

    @Override
    public Integer guardarEntradaBlog(Integer id, String titulo, String nombreAutor, String fechaPublicacion) {

        EntradaBlog datoBlog = new EntradaBlog();

        datoBlog.setId(id);
        datoBlog.setTitulo(titulo);
        datoBlog.setAutor(nombreAutor);
        datoBlog.setFecha(fechaPublicacion);

        diccionarioBlog.put(id, datoBlog);

        return datoBlog.getId();
    }


    @Override
    public Boolean consultarExistenciaBlog(Integer id) {

        if(diccionarioBlog.containsKey(id)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<String> traerInformacion(int id) {

        List<String> datoBlog = new ArrayList<>();
        EntradaBlog entradaBlog = diccionarioBlog.get(id);
        datoBlog.add(String.valueOf(entradaBlog.getId()));
        datoBlog.add(entradaBlog.getTitulo());
        datoBlog.add(entradaBlog.getAutor());
        datoBlog.add(entradaBlog.getFecha());

        return datoBlog;

    }

    @Override
    public HashMap<Integer, EntradaBlog> obtenerTodosBlogs() {
        return diccionarioBlog;
    }

}
