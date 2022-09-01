package com.movies.api.repository;

import com.movies.api.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie,Long> {

    @Query("select serie from Season s join s.serie serie group by serie having count(s) > :seasons")
    List<Serie> findAllByAmountSeasonsOver(Long seasons);
}
