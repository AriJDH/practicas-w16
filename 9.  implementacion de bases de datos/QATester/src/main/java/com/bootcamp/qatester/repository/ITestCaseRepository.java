package com.bootcamp.qatester.repository;

import com.bootcamp.qatester.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase,Long> {

}
