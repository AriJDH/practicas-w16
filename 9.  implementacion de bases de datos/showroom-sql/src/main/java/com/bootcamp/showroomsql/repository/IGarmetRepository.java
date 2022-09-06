package com.bootcamp.showroomsql.repository;

import com.bootcamp.showroomsql.entity.Garmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGarmetRepository extends JpaRepository<Garmet, Integer> {
}
