package com.bootcamp.qatester.repository;

import com.bootcamp.qatester.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRepository extends JpaRepository<TestCase,Long> {

}
