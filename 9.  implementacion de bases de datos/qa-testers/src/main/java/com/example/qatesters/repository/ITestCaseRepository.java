package com.example.qatesters.repository;

import com.example.qatesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findBylastUpdateGreaterThan(LocalDate date);
}
