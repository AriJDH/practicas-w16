package com.bootcamp.showroom.repository;

import com.bootcamp.showroom.entity.Clothes;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface IClothesRepository extends ElasticsearchRepository<Clothes,String> {
    Optional<Clothes> findByCode(String code);
    List<Clothes> findAll();
    List<Clothes> findBySize(String size);
}
