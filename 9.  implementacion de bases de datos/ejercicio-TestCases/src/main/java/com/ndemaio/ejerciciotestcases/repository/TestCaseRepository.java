package com.ndemaio.ejerciciotestcases.repository;

import com.ndemaio.ejerciciotestcases.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
