package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRepositoryTests {

    private StudentRepository studentRepository;

    @BeforeEach
    public void initStudentRepo(){
        studentRepository = new StudentRepository();
    }

    @Test
    public void findAllTest(){
        //Arrange
        //Act
        Set<StudentDTO> studentList = studentRepository.findAll();
        //Assert
        assertEquals(3,studentList.size());
    }

}
