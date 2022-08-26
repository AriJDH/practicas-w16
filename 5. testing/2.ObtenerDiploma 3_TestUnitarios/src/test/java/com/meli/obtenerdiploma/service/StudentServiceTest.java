package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @DisplayName("Verifica la creacion correcta de un estudiente valido")
    @Test
    public void testCreateValidStudent() {

        //arrange mock
        StudentDTO studentMock = new StudentDTO(null, "Gonzalo", "mensaje", 4.5,
                List.of(new SubjectDTO("Sociales", 4.5)));

        //act
        studentService.create(studentMock);

        //assert
        verify(studentDAO, atLeastOnce()).save(studentMock);
    }

    @DisplayName("Verifica la busqueda por id de un estudiente valido")
    @Test
    public void testReadByIdValidStudent() {

        //arrange mock
        StudentDTO studentMock = new StudentDTO(8L, "Gonzalo", "mensaje", 4.5,
                List.of(new SubjectDTO("Sociales", 4.5)));

        when(studentDAO.findById(studentMock.getId())).thenReturn(studentMock);

        //act
        StudentDTO studentDTOCurrenly = studentService.read(8L);

        //assert
        Assertions.assertEquals(studentMock, studentDTOCurrenly);
    }

    @DisplayName("Verifica la excepcion a la busqueda por id de un estudiente No valido")
    @Test
    public void testReadByIdNoValidStudent() {

        when(studentDAO.findById(null)).thenThrow(StudentNotFoundException.class);;

        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.read(null));
    }

    @DisplayName("Verifica la actualizacion de datos de un estudiente valido")
    @Test
    public void testUpdateValidStudent() {

        //arrange mock
        StudentDTO studentMock = new StudentDTO(15L, "Gonzalo", "mensaje", 4.5,
                List.of(new SubjectDTO("Sociales", 4.5)));

        //act
        studentService.update(studentMock);

        verify(studentDAO, atLeastOnce()).save(studentMock);
    }

    @DisplayName("Verifica la obtencion de todos los estudiente validos")
    @Test
    public void testGetAllValidStudent() {

        //arrange mock
        Set<StudentDTO> studentsMock = new HashSet<>(
                List.of(
                        new StudentDTO(1L, "Martha", "No message", 4.5, List.of(new SubjectDTO("Science", 4.0))),
                        new StudentDTO(2L, "Karla", "No message", 3.5, List.of(new SubjectDTO("Canto", 4.5))))
        );

        when(studentRepository.findAll()).thenReturn(studentsMock);

        //act
        Set<StudentDTO> studentAllSet = studentService.getAll();

        //assert
        Assertions.assertEquals(studentsMock, studentAllSet);
        verify(studentRepository, atLeastOnce()).findAll();
    }

}