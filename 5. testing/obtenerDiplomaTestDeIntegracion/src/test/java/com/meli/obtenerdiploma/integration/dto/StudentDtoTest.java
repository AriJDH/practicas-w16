package com.meli.obtenerdiploma.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDtoTest {

    Long id;
    String studentName;
    String message;
    Double averageScore;
    List<SubjectDtoTest> subjects;

}
