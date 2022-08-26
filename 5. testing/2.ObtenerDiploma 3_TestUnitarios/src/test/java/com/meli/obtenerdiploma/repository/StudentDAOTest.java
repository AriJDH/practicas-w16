package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    StudentDAO studentDAO = new StudentDAO();

    @DisplayName("Verificar que se este guardando el estudiante")//Casos nulos, vacíos, inválidos
    @Test
    public void testSaveStudentDTO(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Alfonso Prado", "Estudiante destacado", 8.5, new ArrayList<>());

        //Act
        studentDAO.save(student);

        //Assert
        assertTrue(studentDAO.exists(student));
    }

    @DisplayName("Verificar que se este removiendo el estudiante")
    @Test
    public void testDeleteStudentDTOById(){
        //Arrange
        StudentDTO student = new StudentDTO(1L, "Alfonso Prado", "Estudiante destacado", 8.5, new ArrayList<>());

        //Act
        studentDAO.delete(student.getId());

        //Assert
        assertFalse(studentDAO.exists(student));
    }

    @DisplayName("Verificar la excepcion cuando el alumno no exista")
    @Test
    public void testDeleteStudentDTOByIdNotFound(){
        //Arrange
        Long id = 4L;

        //Act
        studentDAO.delete(id);

        //Assert
        assertThrows(StudentNotFoundException.class, () -> { studentDAO.findById(id);} );
    }

    @DisplayName("Verificar que un alumno existe")
    @Test
    public void testStudentDTOExists(){
        //Arrange
        StudentDTO student = new StudentDTO(2L, "Alfonso Prado", "Estudiante destacado", 8.5, new ArrayList<>());
        //studentDAO.save(student);

        //Act
        boolean studentExists = studentDAO.exists(student);


        //Assert
        assertTrue(studentExists);
    }

    @DisplayName("Verificar la excepcion cuando un alumno no existe")
    @Test
    public void testStudentDTONoExists(){
        //Arrange
        StudentDTO student = new StudentDTO(24L, "Alfonso Prado", "Estudiante destacado", 8.5, new ArrayList<>());

        //Act
        studentDAO.exists(student);


        //Assert
        assertThrows(StudentNotFoundException.class, () -> { studentDAO.findById(student.getId());} );
    }

    @DisplayName("Traer un estudiante por Id")
    @Test
    public void testStudentDTOById(){
        //Arrange
        StudentDTO student3 = new StudentDTO(7L, "Alfonso Prado", "Estudiante destacado", 8.5, new ArrayList<>());

        //Act
        studentDAO.save(student3);
        StudentDTO studentById = studentDAO.findById(7L);


        //Assert
        Assertions.assertEquals(student3, studentById);
    }

    @DisplayName("Verificar la excepcion cuando el Id no exista")
    @Test
    public void testStudentDTOByIdNotFound(){

        Assertions.assertThrows(StudentNotFoundException.class, () -> { studentDAO.findById(25L);} );
    }

}