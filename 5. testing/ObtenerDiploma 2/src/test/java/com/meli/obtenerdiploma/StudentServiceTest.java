package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void findAlltTest(){

        //Arrange
        Set<StudentDTO> set = new HashSet<StudentDTO>();
        set.add(new StudentDTO(123L, "German", "", 0.0,
                    new ArrayList<>(Arrays.asList(
                        new SubjectDTO("Matematica", 50.0),
                        new SubjectDTO("Fisica", 100.0))
                    )
                ));
        set.add(new StudentDTO(123L, "German", "", 0.0,
                    new ArrayList<>(Arrays.asList(
                        new SubjectDTO("Matematica", 50.0),
                        new SubjectDTO("Fisica", 100.0))
                    )
                ));

        when(studentRepository.findAll()).thenReturn(set);

        //Act
        Set<StudentDTO> result = studentService.getAll();

        //Assert
        assertEquals(set, result);
    }


}
