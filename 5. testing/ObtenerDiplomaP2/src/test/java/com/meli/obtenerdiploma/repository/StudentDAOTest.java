package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    StudentDAO studentDAO = new StudentDAO();

    List<SubjectDTO> subs = List.of(SubjectDTO.builder().score(10.0).name("Matemáticas").build());
    @Test
    public void testSave() {
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, subs);

        studentDAO.save(studentDTO);

        assertEquals(studentDAO.findById(studentDTO.getId()), studentDTO);
    }

    @Test
    public void testFindById() {
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, subs);

        studentDAO.save(studentDTO);

        assertNotNull(studentDAO.findById(studentDTO.getId()));
    }

    @Test
    public void testDelete() {
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, subs);

        studentDAO.save(studentDTO);

        studentDAO.delete(studentDTO.getId());

        assertFalse(studentDAO.exists(studentDTO));
    }

    @Test
    public void testModified() {
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, subs);

        studentDAO.save(studentDTO);

        assertEquals(studentDAO.findById(studentDTO.getId()), studentDTO);
    }

}
