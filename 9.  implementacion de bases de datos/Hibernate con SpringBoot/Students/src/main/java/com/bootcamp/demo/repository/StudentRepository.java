package com.bootcamp.demo.repository;

import com.bootcamp.demo.clases.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {
    
}
