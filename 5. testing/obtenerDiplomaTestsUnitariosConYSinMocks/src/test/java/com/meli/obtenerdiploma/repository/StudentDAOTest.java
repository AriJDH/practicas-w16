package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {

    @InjectMocks
    private StudentDAO studentDAOMock;

    @Test
    public void saveTestStudentNullThrowNullPointerException() {
        StudentDTO student = null;
        Assertions.assertThrows(NullPointerException.class, () -> studentDAOMock.save(student));
    }

    @Test
    public void saveStudentEmptyCreateStudentWithNewIdTest() {
        //definis variables
        StudentDTO student = new StudentDTO();
        //mock metodos
        //llamas al metodo q queres testear
        studentDAOMock.save(student);
        //asserts
        Assertions.assertTrue(student.getId() != null);
    }

    @Test
    public void saveStudentTest() {
        //definis variables
        String studentName = "Pepe";
        StudentDTO student = new StudentDTO();
        studentDAOMock.save(student);
        Long createdStudentId = student.getId();
        StudentDTO newStudent = new StudentDTO();
        newStudent.setStudentName(studentName);
        newStudent.setId(createdStudentId);

        studentDAOMock.save(newStudent);
        //asserts
        StudentDTO studentFromDB = studentDAOMock.findById(createdStudentId);
        Assertions.assertTrue(studentFromDB.getId().equals(createdStudentId));
        Assertions.assertTrue(studentFromDB.getStudentName().equals(studentName));
    }

    @Test
    public void findByIdStudentNotFoundTest() {
        Long id = -10L;
        studentDAOMock.delete(id);
        StudentDTO student = new StudentDTO();
        student.setId(id);
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAOMock.findById(student.getId()));
    }

    @Test
    public void findByIdStudentFoundTest() {
        String studentName = "Student";
        StudentDTO student = new StudentDTO();
        student.setStudentName(studentName);
        studentDAOMock.save(student);
        Long id = student.getId();
        StudentDTO studentFind = studentDAOMock.findById(id);
        Assertions.assertNotNull(studentFind);
        Assertions.assertEquals(studentFind.getId(), id);
        Assertions.assertEquals(studentFind.getStudentName(), studentName);
    }

    @Test
    public void findByIdNullTest() {
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAOMock.findById(null));
    }

    @Test
    public void deleteTest() {
        StudentDTO student = new StudentDTO();
        studentDAOMock.save(student);
        Long id = student.getId();
        Assertions.assertTrue(studentDAOMock.delete(id));
    }
    @Test
    public void deleteIdNullTest() {
        Assertions.assertFalse(studentDAOMock.delete(null));
    }

    @Test
    public void existsTest(){
        StudentDTO studentDTO = new StudentDTO();
        studentDAOMock.save(studentDTO);
        Assertions.assertTrue(studentDAOMock.exists(studentDTO));
    }

    @Test
    public void existsOfNullStudentTest(){
        Assertions.assertThrows(NullPointerException.class, () -> studentDAOMock.exists(null));
    }

    @Test
    public void noExistsTest(){
        StudentDTO studentDTO = new StudentDTO();
        Assertions.assertFalse(studentDAOMock.exists(studentDTO));
    }

}
