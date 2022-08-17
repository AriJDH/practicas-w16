package com.meli.obtenerdiploma;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentSerivceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    private void initData(Double mat,Double leng){
        List<SubjectDTO> subjectDTO=new ArrayList<>();
        subjectDTO.add(new SubjectDTO("Matematicas",mat));
        subjectDTO.add(new SubjectDTO("Lengua",leng));
        StudentDTO students=new StudentDTO(1l,"emanuel","message",1D,subjectDTO);
        when(studentDAO.findById(1l)).thenReturn(students);
    }

    @Test
    public void createServiceTest(){
        Set<StudentDTO> stu=new HashSet<>();
        StudentDTO students=new StudentDTO(1l,"emanuel","message",1D,new ArrayList<>());
        stu.add(students);
        when(studentDAO.save(students)).thenReturn(true);

        boolean f=studentService.create(students);

        assertTrue(f);
    }
    public void otro(){
        Set<StudentDTO> stu=new HashSet<>();
        StudentDTO students=new StudentDTO(1l,"emanuel","message",1D,new ArrayList<>());
        stu.add(students);
        when(studentDAO.save(students)).thenReturn(true);

        boolean f=studentService.create(students);

        assertTrue(f);
    }


}
