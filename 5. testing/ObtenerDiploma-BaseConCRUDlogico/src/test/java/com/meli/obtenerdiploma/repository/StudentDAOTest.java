package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentDAOTest {
    @Autowired
    private IStudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    public void reset() {
        this.studentDAO.clear();
    }

    @Test
    public void saveTest() {
        this.studentDAO.save(Util.getNewStudentDTO("Gonzalo"));

        StudentDTO studentDTOSaved = this.studentDAO.findById(1l);

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, studentDTOSaved.getId(), "ASSERT_1: id."),
                () -> Assertions.assertEquals("Gonzalo", studentDTOSaved.getStudentName(), "ASSERT_2: nombre."),
                () -> Assertions.assertEquals(2, studentDTOSaved.getSubjects().size(), "ASSERT_3: cantidad de materias."),
                () -> Assertions.assertEquals("Matematica", studentDTOSaved.getSubjects().get(0).getName(), "ASSERT_4: nombre de la materia 1."),
                () -> Assertions.assertEquals(10.0, studentDTOSaved.getSubjects().get(0).getScore(), "ASSERT_5: score de la materia 1."),
                () -> Assertions.assertEquals("Fisica", studentDTOSaved.getSubjects().get(1).getName(), "ASSERT_6: nombre de la materia 2."),
                () -> Assertions.assertEquals(7.0, studentDTOSaved.getSubjects().get(1).getScore(), "ASSERT_7: score de la materia 2.")
        );
    }

    @Test
    public void deleteTest() {
        this.studentDAO.save(Util.getNewStudentDTO("Pablo"));

        boolean deleteSuccess = this.studentDAO.delete(1l);

        Assertions.assertTrue(deleteSuccess);
    }

    @Test
    public void existsTest() {
        StudentDTO studentDTO = Util.getNewStudentDTO("Juan");

        this.studentDAO.save(studentDTO);

        Assertions.assertTrue(this.studentDAO.exists(studentDTO));
    }

    @Test
    public void findByIdTest() {
        this.studentDAO.save(Util.getNewStudentDTO("Alberto"));

        StudentDTO studentDTOFound = this.studentDAO.findById(1l);

        Assertions.assertNotNull(studentDTOFound);
    }

    @Test
    public void findByIdWithExceptionTest() {
        Assertions.assertThrows(StudentNotFoundException.class, () -> this.studentDAO.findById(1l));
    }
}
