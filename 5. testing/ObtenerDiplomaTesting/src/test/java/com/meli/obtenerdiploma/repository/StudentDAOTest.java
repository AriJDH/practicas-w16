package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class StudentDAOTest {

    @Value("${api.scope}")
    private String SCOPE;
    private StudentDAO dao = new StudentDAO();


    @Test
    void save() {
        //Arrange
        StudentDTO student = new StudentDTO(0L, "", "", 0D, null);
        dao.save(student);
        System.out.println(SCOPE);

    }

    @Test
    void delete() {
    }

    @Test
    void exists() {

    }

    @Test
    void findById() {
    }
}