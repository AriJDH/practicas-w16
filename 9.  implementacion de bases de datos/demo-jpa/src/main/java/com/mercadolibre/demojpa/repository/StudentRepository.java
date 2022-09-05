package com.mercadolibre.demojpa.repository;

import com.mercadolibre.demojpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
