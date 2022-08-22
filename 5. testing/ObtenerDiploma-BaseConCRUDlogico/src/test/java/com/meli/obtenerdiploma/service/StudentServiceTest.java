package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private IStudentDAO mockStudentDAO;
    @Mock
    private IStudentRepository mockStudentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    public void readTest() {
        StudentDTO studentDTO = Util.getNewStudentDTO(1l, "Gonzalo");
        Mockito.when(this.mockStudentDAO.findById(1l)).thenReturn(studentDTO);

        StudentDTO studentDTOResult = this.studentService.read(1l);

        Assertions.assertEquals(1, studentDTOResult.getId());
    }

    @Test
    public void getAllTest() {
        Set<StudentDTO> studentDTOSet = new HashSet<>();
        studentDTOSet.add(Util.getNewStudentDTO("Gonzalo"));
        studentDTOSet.add(Util.getNewStudentDTO("Agustin"));
        studentDTOSet.add(Util.getNewStudentDTO("Fernando"));
        Mockito.when(this.mockStudentRepository.findAll()).thenReturn(studentDTOSet);

        Set<StudentDTO> studentDTOSetResult = this.mockStudentRepository.findAll();

        Assertions.assertEquals(3, studentDTOSetResult.size());
    }
}
