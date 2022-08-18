package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentDAOTest {
    private static StudentDAO studentDAO;

    @BeforeAll
    public static void initialize(){
        studentDAO = new StudentDAO();
    }

    @Test
    public void shouldAddNewStudent(){
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.0, new ArrayList<>(
                Arrays.asList(new SubjectDTO("Materia", 10.0))
        ));
        studentDAO.save(studentDTO);

        assertEquals(studentDTO.getId(), studentDAO.findById(1l).getId());
    }
}
