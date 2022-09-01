package com.tester.app.repository;

import com.tester.app.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRespository extends JpaRepository<TestCase,Long> {
    List<TestCase> findByLastUpdateAfter(LocalDate date);
}
