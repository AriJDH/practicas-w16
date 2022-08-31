package com.example.qatestersexercice.repository;

import com.example.qatestersexercice.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {


    @Query(value= "SELECT t from TestCase t where t.last_update> :last_update")
    List<TestCase> findGraterThanDate(@Param("last_update") LocalDate last_update);
}
