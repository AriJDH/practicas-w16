package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService iStudentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void testSaveStudent() {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 7.0);
        SubjectDTO subject3 = new SubjectDTO("Química", 6.0);

        StudentDTO studentCreate = new StudentDTO(
                23L, "Mariana", "Nota", 7.666666666666667, new ArrayList<>(Arrays.asList(subject1, subject2, subject3)));

        iStudentService.create(studentCreate);

        verify(iStudentService, times(1)).create(studentCreate);
    }

    @Test
    public void testFindStudentById() {
        SubjectDTO subject1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 7.0);
        SubjectDTO subject3 = new SubjectDTO("Química", 6.0);

        StudentDTO studentCreate = new StudentDTO(
                23L, "Mariana", "Nota", 7.666666666666667, new ArrayList<>(Arrays.asList(subject1, subject2, subject3)));

        iStudentService.create(studentCreate);

        StudentDTO getById = when(iStudentService.read(23L)).thenReturn(studentCreate).getMock();

        assertEquals(studentCreate, getById);
    }

}
