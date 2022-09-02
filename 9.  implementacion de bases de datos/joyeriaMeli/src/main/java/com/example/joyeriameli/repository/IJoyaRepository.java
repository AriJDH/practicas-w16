package com.example.joyeriameli.repository;

import com.example.joyeriameli.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya,Long> {

}
