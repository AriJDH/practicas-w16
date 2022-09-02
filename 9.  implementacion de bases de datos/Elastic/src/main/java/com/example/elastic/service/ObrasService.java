package com.example.elastic.service;

import com.example.elastic.entity.ObrasLiterarias;
import com.example.elastic.repository.ObrasRepository;
import org.elasticsearch.common.util.iterable.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObrasService {
    @Autowired
    ObrasRepository obrasRepository;

    public ObrasLiterarias creaObras(ObrasLiterarias obras){
        return obrasRepository.save(obras);
    }
    public List<ObrasLiterarias> listarObras(){
        List<ObrasLiterarias> lista=obrasRepository.findAll();
        return lista;
    }

    public List<ObrasLiterarias> buscarPorAutor(String autor){
        return obrasRepository.findObrasLiterariasByAutor(autor);
    }

    public List<ObrasLiterarias> buscaPorTitle(String title){
        return obrasRepository.findByNombreObraLike(title);
    }

    public List<ObrasLiterarias> buscarMayoresPaginas(Integer paginas){
        return obrasRepository.findAllByCantidadDePaginasGreaterThan(paginas);
    }

    public List<ObrasLiterarias> buscarEntreFechas(Integer a, Integer b){
        return obrasRepository.findAllByAnioPublicacionBetween(a,b);
    }

    public List<ObrasLiterarias> buscarMenoresAFecha(Integer a){
        return obrasRepository.findAllByAnioPublicacionLessThan(a);
    }
    public List<ObrasLiterarias> buscarMayoresAFecha(Integer a){
        return obrasRepository.findAllByAnioPublicacionGreaterThan(a);
    }
}
