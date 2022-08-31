package com.example.ejerciciodosvivo.repository;

import com.example.ejerciciodosvivo.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseRepository extends JpaRepository<TestCase,Long> {
    List<TestCase> findAllByLastUpdateAfter(LocalDate date);
}
