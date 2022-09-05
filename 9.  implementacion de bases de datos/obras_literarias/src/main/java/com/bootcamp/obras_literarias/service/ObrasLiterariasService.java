package com.bootcamp.obras_literarias.service;

import com.bootcamp.obras_literarias.model.ObrasLiterarias;
import com.bootcamp.obras_literarias.repository.IObrasLiterariasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObrasLiterariasService implements IObrasLiterariasService {
    @Autowired
    private IObrasLiterariasRepository obrasLiterariasRepository;

    @Override
    public List<ObrasLiterarias> findByAutor(String autor) {
        return obrasLiterariasRepository.findByAutor(autor);
    }

    @Override
    public List<ObrasLiterarias> findByTitulo(String nombre) {
        return obrasLiterariasRepository.findByNombreContainsIgnoreCase(nombre);
    }

    @Override
    public List<ObrasLiterarias> findByCantidadPaginas(Integer paginas) {
        return obrasLiterariasRepository.findByPaginasGreaterThan(paginas);
    }

    @Override
    public List<ObrasLiterarias> findByAnioPublicacionGreaterThan(Integer anio) {
        return obrasLiterariasRepository.findByAnioPublicacionGreaterThan(anio);
    }

    @Override
    public List<ObrasLiterarias> findByAnioPublicacionLessThan(Integer anio) {
        return obrasLiterariasRepository.findByAnioPublicacionLessThan(anio);
    }

    @Override
    public List<ObrasLiterarias> findByEditorial(String editorial) {
        return obrasLiterariasRepository.findByEditorialIgnoreCase(editorial);
    }

    @Override
    public List<ObrasLiterarias> save(List<ObrasLiterarias> obras) {
        return castToList(obrasLiterariasRepository.saveAll(obras));
    }

    @Override
    public List<ObrasLiterarias> findAll() {
        return castToList(obrasLiterariasRepository.findAll());
    }

    private List<ObrasLiterarias> castToList(Iterable<ObrasLiterarias> obrasLiterarias){
        List<ObrasLiterarias> obrasLiterariasList = new ArrayList<>();
        obrasLiterarias.forEach(obrasLiterariasList::add);
        return obrasLiterariasList;
    }
}
