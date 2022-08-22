package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

public class StudentDAOTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private IStudentService studentService;

    @BeforeEach
    void setUp(){
        studentDAO= new StudentDAO();
    }



}
