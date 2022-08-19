package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class StudentsDAOTest {
    StudentDAO studentDAO;

    @BeforeEach
    public void createDAO(){
        studentDAO = new StudentDAO();
    }

    @Test
    public void testSave(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(11L, "", "", 20.0, new ArrayList<>());

        //Act
        studentDAO.save(studentDTO);

        StudentDTO expected = studentDAO.findById(studentDTO.getId());

        assertEquals(studentDTO, expected);
    }

    @Test
    public void testDelete(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(12L, "", "", 20.0, new ArrayList<>());

        //Act
        studentDAO.save(studentDTO);
        studentDAO.delete(studentDTO.getId());

        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(studentDTO.getId()));
    }

    @Test
    public void testExists(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(200L, "Prueba", "Nada", 20.0, new ArrayList<>());

        //Act
        studentDAO.save(studentDTO);

        //Assert
        assertEquals(true, studentDAO.exists(studentDTO));
    }

    @Test
    public void testNotExists(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(200L, "Prueba", "Nada", 20.0, new ArrayList<>());

        //Act
        boolean exists = studentDAO.exists(studentDTO);

        //Assert
        assertEquals(false, exists);
    }

    @Test
    public void testFindById(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(200L, "Prueba", "Nada", 20.0, new ArrayList<>());

        //Act
        studentDAO.save(studentDTO);
        StudentDTO studentDTO_2 = studentDAO.findById(studentDTO.getId());

        //Assert
        assertEquals(studentDTO, studentDTO_2);
    }

    @Test
    public void testNotFindById(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO(200L, "Prueba", "Nada", 20.0, new ArrayList<>());

        //Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(studentDTO.getId()));
    }
}
