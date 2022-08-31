package com.meli.implementacionjpa.repository;

import com.meli.implementacionjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository <Student, Long>  {
}
