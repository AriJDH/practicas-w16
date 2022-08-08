package com.example.ejercicio2.service;

import com.example.ejercicio2.dto.EntradaBlogDTO;
import com.example.ejercicio2.exception.BlogExceptionCreateNotFound;
import com.example.ejercicio2.exception.BlogExceptionNotFound;
import com.example.ejercicio2.model.EntradaBlog;
import com.example.ejercicio2.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepository blogRepositor;
    @Override
    public Integer cargaData(EntradaBlog body){
        if(validaCarga(body)){
            throw new BlogExceptionNotFound(body.getId());
        }
        blogRepositor.cagarDatos(body);
        return body.getId();
    }
    public boolean validaCarga(EntradaBlog body){
        List<EntradaBlog> entrada=blogRepositor.muestraData().stream().filter(e-> e.getId()
                .equals(body.getId())).findFirst().stream().collect(Collectors.toList());
        if(entrada.size()==1){
            System.out.println("entro");
            return true;
        }
        return false;


    }

    public List<EntradaBlogDTO> transformaGet(List<EntradaBlog> data){
        List<EntradaBlogDTO> entrada= data.stream().map(e-> {
            EntradaBlogDTO entradaDto=new EntradaBlogDTO();
            entradaDto.setId(e.getId());
            entradaDto.setTitulo(e.getTitulo());
            entradaDto.setNombreDelAutor(e.getNombreDelAutor());
            entradaDto.setFecha(e.getFecha());
            return entradaDto;
        }).collect(Collectors.toList());
        return entrada;
    }




    @Override
    public List<EntradaBlogDTO> muestraData() {
        List<EntradaBlog> data=blogRepositor.muestraData();
        List<EntradaBlogDTO> entrada= transformaGet(data);
        return entrada;
    }

    @Override
    public EntradaBlogDTO getData(Integer id) {
        List<EntradaBlog> data=blogRepositor.muestraData().stream().filter(entradaBlog -> entradaBlog.getId().equals(id))
                .findFirst().stream().collect(Collectors.toList());

        List<EntradaBlogDTO> entrada= transformaGet(data);
        if(entrada.isEmpty()){
            throw new BlogExceptionNotFound(id);

        }
        EntradaBlogDTO finalDto=entrada.stream().findFirst().get();

        return finalDto;
    }


}
