package com.example.testers.dao;

import com.example.testers.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITesterDAO extends JpaRepository<TestCase, Long> {
}
