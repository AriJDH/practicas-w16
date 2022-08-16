package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    private StudentDAO dao = new StudentDAO();

    private IStudentRepository repo = new StudentRepository();

    @AfterEach
    void loadData() {
        TestUtils.emptyFile();
        dao = new StudentDAO();
    }

    @Test
    void testFindAll() {
        //Arrange
        StudentDTO s1 = TestUtils.generateStudentNoSubjects("John", 99L);
        StudentDTO s2 = TestUtils.generateStudentNoSubjects("Doe", 99L);
        StudentDTO s3 = TestUtils.generateStudentNoSubjects("JD", 99L);
        Set<StudentDTO> students = new HashSet<>(){{
            add(s1);
            add(s2);
            add(s3);
        }};
        students.forEach(s -> dao.save(s));

        //Act
        Set<StudentDTO> response = repo.findAll();

        //Assert
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertTrue(CollectionUtils.isEqualCollection(response, students));
    }
}