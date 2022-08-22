package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static StudentDTO getNewStudentDTO(Long id, String name) {
        return new StudentDTO(id, name, "", 0.0, Arrays.asList(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Fisica", 7.0)
        ));
    }

    public static StudentDTO getNewStudentDTO(String name) {
        return new StudentDTO(0l, name, "", 0.0, Arrays.asList(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Fisica", 7.0)
        ));
    }

    public static StudentDTO getNewStudentDTO(Long id, String name, List<SubjectDTO> subjectDTOList) {
        return new StudentDTO(id, name, "", 0.0, subjectDTOList);
    }

    public static StudentDTO getNewStudentDTO(String name, List<SubjectDTO> subjectDTOList) {
        return new StudentDTO(0l, name, "", 0.0, subjectDTOList);
    }
}
