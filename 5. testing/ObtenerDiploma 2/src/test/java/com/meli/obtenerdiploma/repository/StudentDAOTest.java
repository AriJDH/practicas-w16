package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentDAOTest {
    private StudentDAO tested = new StudentDAO();

    @Test
    public void saveStudentTest(){

        StudentDTO student = new StudentDTO(null,"Juan","Message",3.8,
                List.of(new SubjectDTO("Biology",2.0)));

        tested.save(student);

        Assertions.assertTrue(tested.exists(student));
    }


    @Test
    public void findById(){
        StudentDTO expected = new StudentDTO(5l,"Juan","Message",3.8,
                List.of(new SubjectDTO("Biology",2.0)));

        tested.save(expected);

        StudentDTO actual = tested.findById(5l);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void deleteStudentTest(){
        StudentDTO student = new StudentDTO(5l,"Juan","Message",3.8,
                List.of(new SubjectDTO("Biology",2.0)));

        tested.save(student);
        tested.delete(5l);

        Assertions.assertFalse(tested.exists(student));
    }

    @Test
    public void modifyStudent(){
        StudentDTO expected = new StudentDTO(4l,"Camilo","Message",3.8,
                List.of(new SubjectDTO("Biology",2.0)));


        tested.save(expected);

        StudentDTO actual = tested.findById(4l);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void findUserThenStudentNotFountExeption(){
        Assertions.assertThrows(StudentNotFoundException.class,()-> {
            tested.findById(20l);
        });
    }


}
