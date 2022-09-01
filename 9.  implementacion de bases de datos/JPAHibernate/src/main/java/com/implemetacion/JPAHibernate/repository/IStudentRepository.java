package com.implemetacion.JPAHibernate.repository;

import com.implemetacion.JPAHibernate.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository <Student, Long> {
}
