package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentDAOTest {

    private StudentDAO studentDao;

    @BeforeEach
    public void setUp(){
        studentDao = new StudentDAO();
    }

    @Test
    public void testAddStudent(){
        //average
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Matematic", 6.0);
        SubjectDTO subject2 = new SubjectDTO("Quimica", 8.0);
        subjects.add(subject1);
        subjects.add(subject2);
        StudentDTO studentDto = new StudentDTO(5l, "Martin", null, null, subjects);

        //Act
        studentDao.save(studentDto);
        //Assert
        StudentDTO studentDtoSearch = studentDao.getStudents().stream().
                filter(stu-> stu.getId().equals(studentDto.getId())).findFirst().orElse(null);
        assertEquals(studentDtoSearch.getStudentName(), studentDto.getStudentName());
    }

    @Test
    public void testFindById(){
        //average
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Matematic", 6.0);
        SubjectDTO subject2 = new SubjectDTO("Quimica", 8.0);
        subjects.add(subject1);
        subjects.add(subject2);
        StudentDTO studentDto = new StudentDTO(29l, "Martin", null, null, subjects);
        studentDao.save(studentDto);

        //Act
        StudentDTO studentDtoExpect = studentDao.findById(studentDto.getId());

        //Assert
        assertAll(
                ()-> assertEquals(studentDtoExpect.getId(), studentDto.getId()),
                ()-> assertEquals(studentDtoExpect.getStudentName(), studentDto.getStudentName())

        );
    }
}
