package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStudentRepositoryWoMocks {
    StudentRepository studentRepository ;


    @BeforeEach
    public void clearRepository(){
        studentRepository = new StudentRepository();
    }
    @Test
    public void checkFindALLSize(){
        //Arrange
        //Act
        Set<StudentDTO> studentList = studentRepository.findAll();
        //Assert
        assertEquals(studentList.size(),2);
    }
}
