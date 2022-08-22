package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utiles {


    public static StudentDTO getStudent(Long id, String name, List<SubjectDTO> listSubject){
        StudentDTO student = new StudentDTO();
        student.setId(id);
        student.setStudentName(name);
        student.setSubjects(listSubject);

        return student;
    }

    public static SubjectDTO getSubject(String name, Double score){
        SubjectDTO subject = new SubjectDTO(name, score);

        return subject;
    }



}
