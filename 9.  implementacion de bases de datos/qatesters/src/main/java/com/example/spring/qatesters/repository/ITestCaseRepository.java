package com.example.spring.qatesters.repository;

import com.example.spring.qatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findAllByLastUpdateBetween(
            LocalDate lastUpdate,
            LocalDate currentDate);
}