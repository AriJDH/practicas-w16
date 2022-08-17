package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

    @InjectMocks
    private StudentRepository studentRepository;

    @Test
    public void findAllTest() {
        ReflectionTestUtils.setField(studentRepository, "SCOPE", "test/jsonmocks/notempty");
        Assertions.assertTrue(studentRepository.findAll().size()>0);
    }

    @Test
    public void findAllEmptyListTest() {
        ReflectionTestUtils.setField(studentRepository, "SCOPE", "test/jsonmocks/empty");
        Assertions.assertTrue(studentRepository.findAll().isEmpty());
    }

    @Test
    public void findAllFileNotFoundExceptionTest() {
        ReflectionTestUtils.setField(studentRepository, "SCOPE", "null");
        Assertions.assertTrue(studentRepository.findAll().isEmpty());
    }

}
