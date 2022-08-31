package com.example.demo.repository;

import com.example.demo.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryTestCase extends JpaRepository<TestCase, Long> {
}
