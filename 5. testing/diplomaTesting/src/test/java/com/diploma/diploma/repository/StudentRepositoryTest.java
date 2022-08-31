package com.diploma.diploma.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.diploma.diploma.model.StudentDTO;
import com.diploma.util.UtilTestTools;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {
    
    IStudentRepository studentRepository;
    IStudentDAO studentDAO;

    @BeforeEach @AfterEach
    public void setUp() {
        UtilTestTools.emptyUsersFile();
        studentRepository = new StudentRepository();
        studentDAO = new StudentDAO();
    }

    @Test
    public void findAllExistingStudents(){
        
        //Arrange
        Set<StudentDTO> students = UtilTestTools.findAll();
        
        students.stream().forEach( studentDAO::save );

        //Act

        Set<StudentDTO> studentsFound = studentRepository.findAll();
        
        //Assert
        assertTrue(UtilTestTools.compareSets(students, studentsFound));
    }
}
