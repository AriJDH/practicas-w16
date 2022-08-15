package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentsRepositoryDAOTest {

    @Autowired
    private IStudentDAO iStudentDAO;
    @Autowired
    private IStudentRepository iStudentRepository;

    @Test
    public void createStudent() {
        SubjectDTO subject1 = new SubjectDTO("Matematicas", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Quimica", 10.0);

        StudentDTO studentCreate = new StudentDTO(
                23L, "Mariana", "Nota", 5.0, new ArrayList<>(Arrays.asList(subject1, subject2)));
        iStudentDAO.save(studentCreate);

        findStudentById();
    }


    @Test
    public void findStudentById() {
        long id = 1;
        StudentDTO student = iStudentRepository.findAll().stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);

        assertNotNull(student);
    }

    @Test
    public void updateStudent() {

        createStudent();

        SubjectDTO subject1 = new SubjectDTO("Matematicas", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Quimica", 10.0);

        StudentDTO studentUpdate = new StudentDTO(
                23L, "Ruth", "Nota", 5.0, new ArrayList<>(Arrays.asList(subject1, subject2)));

        StudentDTO studentBefore = iStudentRepository.findAll().stream().filter(x -> x.getId().equals(23L)).findFirst().orElse(null);

        iStudentDAO.save(studentUpdate);

        StudentDTO studentAfter = iStudentRepository.findAll().stream().filter(x -> x.getId().equals(23L)).findFirst().orElse(null);

        assertEquals(studentAfter, studentBefore);
    }

    @Test
    public void deleteStudent() {

        createStudent();

        iStudentDAO.delete(23L);

        StudentDTO studentDelete = iStudentRepository.findAll().stream().filter(x -> x.getId().equals(23L)).findFirst().orElse(null);

        assertNull(studentDelete);
    }

    @Test
    public void getAllStudents() {

        createStudent();

        Set<StudentDTO> list = iStudentRepository.findAll();

        assertNotNull(list);
    }
}
