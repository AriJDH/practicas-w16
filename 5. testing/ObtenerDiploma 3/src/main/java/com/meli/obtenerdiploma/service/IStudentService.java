package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;

import java.util.Set;

public interface IStudentService {
    boolean create(StudentDTO stu);
    StudentDTO read(Long id);
    void update(StudentDTO stu);
    void delete(Long id);
    Set<StudentDTO> getAll();
    Set<StudentDTO> getAllB();
}
