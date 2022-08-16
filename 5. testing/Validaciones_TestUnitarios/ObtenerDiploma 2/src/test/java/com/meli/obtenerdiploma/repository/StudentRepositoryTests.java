package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@SpringBootTest
public class StudentRepositoryTests {

    @Autowired
    private IStudentDAO iStudentDAO;

    @Autowired
    private IStudentRepository iStudentRepository;

    @Test
    public void listAllStudents(){

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

        Set<StudentDTO> listStudents = iStudentRepository.findAll();

        Assertions.assertNotNull(listStudents);
        Assertions.assertEquals(1,listStudents.size());
    }

}
