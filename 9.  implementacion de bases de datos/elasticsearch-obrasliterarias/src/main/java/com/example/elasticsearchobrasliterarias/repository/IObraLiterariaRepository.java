package com.example.elasticsearchobrasliterarias.repository;

import com.example.elasticsearchobrasliterarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    Iterable<ObraLiteraria> findObraLiterariaByAutorEqualsIgnoreCase(String autor);
    Iterable<ObraLiteraria> findObraLiterariaByObraContains(String word);
    Iterable<ObraLiteraria> findObraLiterariaByCantidadPaginasGreaterThan(Integer cantidad);

    Iterable<ObraLiteraria> findObraLiterariaByAnioPrimeraPublicacionBefore(Integer beforeYear);

    Iterable<ObraLiteraria> findObraLiterariaByAnioPrimeraPublicacionAfter(Integer afterYear);

    Iterable<ObraLiteraria> findObraLiterariaByEditorialEqualsIgnoreCase(String editorial);
}
