package com.tomas.qatester.repository;

import com.tomas.qatester.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestRepository extends JpaRepository<TestCase, Long> {


}
