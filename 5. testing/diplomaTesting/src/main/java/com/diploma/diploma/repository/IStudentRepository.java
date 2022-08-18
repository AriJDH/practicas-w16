package com.diploma.diploma.repository;

import com.diploma.diploma.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}
