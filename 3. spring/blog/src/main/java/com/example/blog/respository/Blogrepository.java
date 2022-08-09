package com.example.blog.respository;

import com.example.blog.dtos.request.NuevaEntradaDTO;
import com.example.blog.dtos.response.EntradaDTO;
import com.example.blog.entities.EntradaBlog;
import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@Repository

public class Blogrepository {

    public Integer contador;
    public List<EntradaBlog> repositorioEntradas;

    public Blogrepository() {
        this.contador = 0;
    }
}
