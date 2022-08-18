package com.meli.obtenerdiploma.RepositoryTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StudentDAOTest {
    private StudentDAO studentDAO;
    private StudentDTO fakeStudent;
    private List<SubjectDTO> fakeSubjects;
    private SubjectDTO fakeSubject;
    @BeforeEach
    private void init() {
        this.studentDAO = new StudentDAO();
        this.fakeStudent = new StudentDTO();
        this.fakeStudent.setStudentName("Matias");
        this.fakeStudent.setMessage("Hola");
        this.fakeStudent.setAverageScore(10D);
        this.fakeSubjects = new ArrayList<>();
        this.fakeSubject = new SubjectDTO("Programacion", 10d);
        this.fakeSubjects.add(fakeSubject);
        this.studentDAO.save(this.fakeStudent);
    }
    @AfterEach
    private void clean() {
        this.studentDAO.delete(3L);
    }
    @Test
    void GivenAnIdFindByIdReturnsNotNull() {
        assertNotNull(this.studentDAO.findById(1L));
    };
    @Test
    void GivenAnIdFindByIdReturnsStudentDTO() {
        assertTrue(this.studentDAO.findById(1L) instanceof StudentDTO);
    }
    @Test
    void GivenANewStudentShouldBeCreated() {
        this.studentDAO.save(this.fakeStudent);
        assertNotNull(this.studentDAO.findById(3L));
    }
    @Test
    void GivenAChangeOfNameTheStudentShouldBeUpdated() {
        StudentDTO student = this.studentDAO.findById(3L);
        student.setStudentName("Mati");
        assertEquals(studentDAO.findById(3L).getStudentName(), "Mati");
    }
    @Test
    void GivenAnIdShouldDeleteStudent() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("eze");
        student.setMessage("chau");
        student.setAverageScore(12D);
        this.studentDAO.save(student);
        Long id = student.getId();
        this.studentDAO.delete(student.getId());

        StudentNotFoundException thrown = assertThrows(
                StudentNotFoundException.class,
                () -> this.studentDAO.findById(id),
                "Expected to throw an error if the student does not exists"
        );
    }

}
