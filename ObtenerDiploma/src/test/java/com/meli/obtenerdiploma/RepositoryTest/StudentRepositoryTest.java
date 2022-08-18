package com.meli.obtenerdiploma.RepositoryTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;

public class StudentRepositoryTest {

    IStudentRepository studentRepository;
    @BeforeEach
    void init() {
        this.studentRepository = new StudentRepository();
    }
    @Test
    void findAllShouldReturnSet() {
        //Set<StudentDTO>
        assertTrue(this.studentRepository.findAll() instanceof Set);

    }
}
