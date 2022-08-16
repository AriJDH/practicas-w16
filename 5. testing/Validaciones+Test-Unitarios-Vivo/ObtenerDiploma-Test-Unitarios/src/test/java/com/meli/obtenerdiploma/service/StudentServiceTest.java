package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void readTest() {

        //Arrange
        Long idStudent = 15L;

        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Geografía");
        subjectDTO.setScore(4.3);

        List<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(subjectDTO);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(idStudent);
        studentDTO.setStudentName("Katherine");
        studentDTO.setAverageScore(4.3);
        studentDTO.setSubjects(listSubject);

        when(iStudentDAO.findById(idStudent)).thenReturn(studentDTO);

        //Act
        StudentDTO resultStudentDTO;
        resultStudentDTO = studentService.read(idStudent);

        //Assert
        assertEquals(resultStudentDTO, studentDTO);

    }

}
