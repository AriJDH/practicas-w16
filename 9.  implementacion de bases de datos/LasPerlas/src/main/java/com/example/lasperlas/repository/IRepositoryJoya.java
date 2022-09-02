package com.example.lasperlas.repository;

import com.example.lasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryJoya extends JpaRepository<Joya,Long> {

}
