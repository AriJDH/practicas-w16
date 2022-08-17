package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentDaoTestWoMocks {

    StudentDAO studentDAO ;


    @BeforeEach
    public void clearRepository(){
        studentDAO = new StudentDAO();
    }

    @Test
    public void  testSaveAndFindById(){
        //Arrange
        StudentDTO testStudent = new StudentDTO(1L,"","",2D,new ArrayList<>());

        //Act
        studentDAO.save(testStudent);

        StudentDTO resultStudent = studentDAO.findById(1L);

        //Assert
        assertEquals(testStudent,resultStudent);
    }

    @Test
    public void testDelete(){
        //Arrange
        StudentDTO testStudent = new StudentDTO(1L,"","",2D,new ArrayList<>());

        //Act
        studentDAO.save(testStudent);
        studentDAO.delete(1L);

        //Assert
        assertThrows(StudentNotFoundException.class,()->studentDAO.findById(1L));
    }
}
