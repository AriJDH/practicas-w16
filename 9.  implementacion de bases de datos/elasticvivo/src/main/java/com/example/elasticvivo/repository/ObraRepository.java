package com.example.elasticvivo.repository;

import com.example.elasticvivo.model.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ObraRepository extends ElasticsearchRepository<Obra, String> {

    List<Obra> findAllByAutor(String autor);
    List<Obra> findAllByNombreObraContaining(String titulo);

    List<Obra> findAllByCantPaginasGreaterThan(Integer paginas);

    List<Obra> findAllByAnhoPublicacionGreaterThan(Integer anho);

    List<Obra> findAllByAnhoPublicacionLessThan(Integer anho);

    List<Obra> findAllByEditorial(String editorial);
}
