package com.myapp.testcase.repository;

import com.myapp.testcase.dto.TestCaseDTO;
import com.myapp.testcase.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
