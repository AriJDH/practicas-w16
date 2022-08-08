package com.example.ejercicio2.repository;

import com.example.ejercicio2.dto.EntradaBlogDTO;
import com.example.ejercicio2.model.EntradaBlog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class BlogRepository implements IBlogRepository{

    List<EntradaBlog> entradaBlog=new ArrayList<>();
    @Override
    public Integer cagarDatos(EntradaBlog body){
        entradaBlog.add(body);
        return body.getId();
    }

    @Override
    public List<EntradaBlog> muestraData() {
        return entradaBlog;
    }
}
