package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class Ejercicio3 {
    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    StudentDTO studentMocked;

    @BeforeEach
    private void initialize() {
        studentMocked = new StudentDTO(1L, "Ricky", "message", 6.0, new ArrayList<>());
    }

    @Test
    void createStudent() {
        studentService.create(studentMocked);
        Mockito.verify(studentDAO, Mockito.times(1)).save(studentMocked);
    }


    @Test
    void SearchStudentById() {
        long idToSearch = 1L;

        Mockito.when(studentDAO.findById(idToSearch)).thenReturn(studentMocked);
        StudentDTO studentFetched = studentService.read(1L);

        Assertions.assertEquals(studentMocked, studentFetched);

    }

    @Test
    void updateUser() {
        studentService.update(studentMocked);
        Mockito.verify(studentDAO, Mockito.times(1)).save(studentMocked);
    }

    @Test
    void deleteUser() {
        long idToSearch = 1L;

        studentService.delete(idToSearch);

        Mockito.verify(studentDAO, Mockito.times(1)).delete(idToSearch);

    }

    @Test
    void getAllUsers() {
        //Arrage
        Set<StudentDTO> studentsMocked = new HashSet<>();
        studentsMocked.add(studentMocked);
        //Mock
        Mockito.when(studentRepository.findAll()).thenReturn(studentsMocked);
        //Act
        Set<StudentDTO> studentsFetched = studentService.getAll();
        //Assert
        Assertions.assertEquals(studentsMocked, studentsFetched);


    }


}
