package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private IStudentDAO studentDAO;
    @Autowired
    private IStudentRepository studentRepository;

    @BeforeEach
    @AfterEach
    public void reset() {
        this.studentDAO.clear();
    }

    @Test
    public void findAllTest() {
        this.studentDAO.save(Util.getNewStudentDTO("Gonzalo"));
        this.studentDAO.save(Util.getNewStudentDTO("Pablo"));
        this.studentDAO.save(Util.getNewStudentDTO("Juan"));
        this.studentDAO.save(Util.getNewStudentDTO("Alberto"));
        this.studentDAO.save(Util.getNewStudentDTO("Carlos"));

        Assertions.assertEquals(5, this.studentRepository.findAll().size());
    }
}
