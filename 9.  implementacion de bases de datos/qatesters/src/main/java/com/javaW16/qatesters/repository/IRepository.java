package com.javaW16.qatesters.repository;

import com.javaW16.qatesters.model.TestCase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IRepository extends JpaRepository < TestCase, Long> {

}
