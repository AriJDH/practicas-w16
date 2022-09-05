package com.example.elastic.service;

import com.example.elastic.model.ObrasLiterarias;
import com.example.elastic.repository.IObrasLIterarias;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ObrasLiterariasService  implements IObrasLiterariasService{

    @Autowired
    IObrasLIterarias repo;

    @Override
    public List<ObrasLiterarias> findByAutor(String autor) {
        return repo.findByAutor(autor);
    }

    @Override
    public List<ObrasLiterarias> findByNombreContainsIgnoreCase(String nombre) {
        return repo.findByNombreContainsIgnoreCase(nombre);
    }

    @Override
    public List<ObrasLiterarias> findByPaginasGreaterThan(Integer paginas) {
        return repo.findByPaginasGreaterThan(paginas);
    }

    @Override
    public List<ObrasLiterarias> findByAnoPublicacionAfter(Integer anio) {
        return repo.findByAnoPublicacionAfter(anio);
    }

    @Override
    public List<ObrasLiterarias> findByAnoPublicacionBefore(Integer anio) {
        return repo.findByAnoPublicacionBefore(anio);
    }

    @Override
    public List<ObrasLiterarias> findByEditorial(String editorial) {
        return repo.findByEditorial(editorial);

    }

    @Override
    public List<ObrasLiterarias> save(List<ObrasLiterarias> obras) {
        List<ObrasLiterarias> lista= new ArrayList<>();
        repo.saveAll(obras).forEach(lista::add);
        return lista;

    }


}
