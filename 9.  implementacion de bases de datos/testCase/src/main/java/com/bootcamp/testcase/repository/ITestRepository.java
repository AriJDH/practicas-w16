package com.bootcamp.testcase.repository;

import com.bootcamp.testcase.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface ITestRepository extends JpaRepository<TestCase, Long> {
}
