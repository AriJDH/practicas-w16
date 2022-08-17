package com.meli.obtenerdiploma;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {
    @Mock
    private  StudentDAO studentDAO;

    @InjectMocks
    private StudentService studentService;


    @Test
    void getAllStudents(){
        Set<StudentDTO> students=new HashSet<>();
        students.add(new StudentDTO(1l,"emanuel","message",1D,new ArrayList<>()));
        students.add(new StudentDTO(2l,"gonzalo","message",9D,new ArrayList<>()));
        when(studentDAO.findAll()).thenReturn(students);

        Set<StudentDTO> studentData=studentService.getAllB();

                assertEquals(students,studentData);
    }

    @Test
    void addAlumnoEqualsIdTest(){
        //Set<StudentDTO> students=new HashSet<>();
        StudentDTO students=new StudentDTO(1l,"emanuel","message",1D,new ArrayList<>());
        when(studentDAO.findById(1l)).thenReturn(students);

        //assert
        StudentDTO totLast=studentService.read(1l);
        assertEquals(1l,totLast.getId());
    }


    @Test
    void findAlumnoById(){
        StudentDTO student=new StudentDTO(12l,"pepe","hola",42D,new ArrayList<>());
        studentDAO.save(student);
        StudentDTO studentFind=studentDAO.findById(13l);

        assertEquals(student.getId(),studentFind.getId());
    }

    @Test
    void modifiedAlumno(){

    }

    @Test
    void delateAlumno(){

    }

    @Test
    void listAllAlumnos(){

    }
}
