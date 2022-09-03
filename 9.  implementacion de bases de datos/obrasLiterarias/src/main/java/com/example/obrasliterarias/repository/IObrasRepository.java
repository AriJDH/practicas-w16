package com.example.obrasliterarias.repository;

import com.example.obrasliterarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IObrasRepository extends ElasticsearchRepository<ObraLiteraria,String> {
    List<ObraLiteraria> findByAutor(String autor);

    List<ObraLiteraria> findByNombreContaining(String nombre);

    List<ObraLiteraria> findByCantPaginasGreaterThan(Integer cant);

    List<ObraLiteraria> findByFechaPublicacionBefore(Date fecha);

    List<ObraLiteraria> findByFechaPublicacionAfter(Date fecha);

    List<ObraLiteraria> findByEditorial(String editorial);
}
