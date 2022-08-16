package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentDAOTests {

    @Autowired
    private IStudentDAO iStudentDAO;

    @Autowired
    private IStudentRepository iStudentRepository;

    @Test
    public void addStudent(){
        SubjectDTO subject1 = new SubjectDTO("Español", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Química", 7.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(10L);
        studentDTO.setStudentName("Lucía");
        studentDTO.setSubjects(subjects);

        iStudentDAO.save(studentDTO);

        Assertions.assertTrue(iStudentDAO.exists(studentDTO));
        Assertions.assertEquals(10L, studentDTO.getId());
        Assertions.assertEquals(iStudentDAO.findById(studentDTO.getId()), studentDTO);
    }

    @Test
    public void findStudentById(){
        SubjectDTO subject1 = new SubjectDTO("Inglés", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Sociales", 7.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(3L);
        studentDTO.setStudentName("Lucía");
        studentDTO.setSubjects(subjects);

        iStudentDAO.findById(studentDTO.getId());

        Assertions.assertNotNull(iStudentRepository.findAll().stream().filter(id -> id.getId().equals(3L)).findFirst().orElse(null));
    }

    @Test
    public void updateStudent(){
        SubjectDTO subject1 = new SubjectDTO("Ciencias", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 6.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(4L);
        studentDTO.setStudentName("Lucía");
        studentDTO.setSubjects(subjects);

        iStudentDAO.save(studentDTO);
        studentDTO.setStudentName("Tannia");
        iStudentDAO.save(studentDTO);

        Assertions.assertTrue(iStudentDAO.exists(studentDTO));
        Assertions.assertEquals("Tannia", studentDTO.getStudentName());
    }

    @Test
    public void deleteStudent(){
        SubjectDTO subject1 = new SubjectDTO("Matemáticas", 12.0);
        SubjectDTO subject2 = new SubjectDTO("Filosofía", 4.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Lucía");
        studentDTO.setSubjects(subjects);
        iStudentDAO.save(studentDTO);

        iStudentDAO.delete(studentDTO.getId());

        Assertions.assertFalse(iStudentDAO.exists(studentDTO));
        Assertions.assertNull(iStudentRepository.findAll().stream().filter(id -> id.getId().equals(1L)).findFirst().orElse(null));
    }
}
