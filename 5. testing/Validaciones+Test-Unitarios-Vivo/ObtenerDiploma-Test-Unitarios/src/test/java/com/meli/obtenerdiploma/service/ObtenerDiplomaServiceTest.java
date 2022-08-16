package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    //Mismos datos de salida son los mismos de entrada
    @Test
    public void analyzeScoresTest(){

        //Arrange
        Long idStudent = 9L;

        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Español");
        subjectDTO.setScore(6.7);

        List<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(subjectDTO);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(idStudent);
        studentDTO.setStudentName("Juan");
        studentDTO.setAverageScore(6.7);
        studentDTO.setSubjects(listSubject);

        when(iStudentDAO.findById(idStudent)).thenReturn(studentDTO);

        //Act
        StudentDTO resultStudentDTO;
        resultStudentDTO = obtenerDiplomaService.analyzeScores(idStudent);

        //Assert
        assertEquals(resultStudentDTO, studentDTO);

    }


    @Test
    public void calculateAverageTest(){

        //Arrange
        Double resultExpected = 6.333333333333333;

        Long idStudent = 11L;

        SubjectDTO materiaUno = new SubjectDTO();
        materiaUno.setName("Inglés");
        materiaUno.setScore(4.3);

        SubjectDTO materiaDos = new SubjectDTO();
        materiaDos.setName("Lectura");
        materiaDos.setScore(7.9);

        SubjectDTO materiaTres = new SubjectDTO();
        materiaTres.setName("Geometría");
        materiaTres.setScore(6.8);

        List<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(materiaUno);
        listSubject.add(materiaDos);
        listSubject.add(materiaTres);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(idStudent);
        studentDTO.setStudentName("Juan");
        studentDTO.setAverageScore(6.333333333333333);
        studentDTO.setSubjects(listSubject);

        when(iStudentDAO.findById(idStudent)).thenReturn(studentDTO);

        //Act
        StudentDTO resultStudentDTO;
        resultStudentDTO = obtenerDiplomaService.analyzeScores(idStudent);


        //Assert
        assertEquals(resultExpected, resultStudentDTO.getAverageScore());


    }


    @Test
    public void getLegendDiploma() {

        //Arrange
        String resultExpected = "El alumno Juan ha obtenido un promedio de 7.85. Puedes mejorar.";

        Long idStudent = 19L;

        SubjectDTO materiaUno = new SubjectDTO();
        materiaUno.setName("Estadística");
        materiaUno.setScore(8.9);

        SubjectDTO materiaDos = new SubjectDTO();
        materiaDos.setName("Ciencias");
        materiaDos.setScore(6.8);

        List<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(materiaUno);
        listSubject.add(materiaDos);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(idStudent);
        studentDTO.setStudentName("Juan");
        studentDTO.setAverageScore(7.85);
        studentDTO.setSubjects(listSubject);

        when(iStudentDAO.findById(idStudent)).thenReturn(studentDTO);

        //Act
        StudentDTO resultStudentDTO;
        resultStudentDTO = obtenerDiplomaService.analyzeScores(idStudent);


        //Assert
        assertEquals(resultExpected, resultStudentDTO.getMessage());

    }


    @Test
    public void getDiplomaWithHonors(){

        //Arrange
        String resultExpected = "El alumno Fernando ha obtenido un promedio de 9.5. Felicitaciones!";

        Long idStudent = 35L;

        SubjectDTO materia = new SubjectDTO();
        materia.setName("Economía");
        materia.setScore(9.5);


        List<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(materia);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(idStudent);
        studentDTO.setStudentName("Fernando");
        studentDTO.setAverageScore(9.5);
        studentDTO.setSubjects(listSubject);

        when(iStudentDAO.findById(idStudent)).thenReturn(studentDTO);

        //Act
        StudentDTO resultStudentDTO;
        resultStudentDTO = obtenerDiplomaService.analyzeScores(idStudent);


        //Assert
        assertEquals(resultExpected, resultStudentDTO.getMessage());

    }

}
