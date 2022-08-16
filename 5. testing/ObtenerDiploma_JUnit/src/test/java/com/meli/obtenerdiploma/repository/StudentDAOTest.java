package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    private StudentDAO tested = new StudentDAO();

    @Test
    public void givenStudentThenSaveStudentTest(){

        //Arrange
        StudentDTO student = new StudentDTO(null, "Jhon", "Message", 3.8,
                List.of(new SubjectDTO("Math", 4.0)));

        //Act
        tested.save(student);

        //Assert
       Assertions.assertTrue(tested.exists(student), "");


    }


    @Test
    public void deleteStudentThenStudentDoesntExistTest(){

        //Arrange
        StudentDTO student = new StudentDTO(null, "student1", "Message", 3.8,
                List.of(new SubjectDTO("Math", null)));

        //Act
        tested.save(student);

        tested.delete(2L);

        //Assert
        Assertions.assertFalse(tested.exists(student), "");

    }

    @Test
    public void findCreatedStudentThenStudentExistTest(){

        //Arrange
        StudentDTO expected = new StudentDTO(null, "student1", "Message", 3.8,
                List.of(new SubjectDTO("Math", null)));

        //Act
        tested.save(expected);

        StudentDTO actual = tested.findById(5L);

        //Assert
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void updateStudentThenStudentSavedTest(){

        //Arrange
        StudentDTO expected = new StudentDTO(2L, "student2", "Hello", 4.8,
                List.of(new SubjectDTO("Math", 5.0)));

        //Act
        tested.save(expected);

        StudentDTO actual = tested.findById(2L);

        //Assert
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void findNotCreatedStudentThenStudentNotFoundExceptionTest(){

        //Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> {
            tested.findById(20L);
        } );

    }

}