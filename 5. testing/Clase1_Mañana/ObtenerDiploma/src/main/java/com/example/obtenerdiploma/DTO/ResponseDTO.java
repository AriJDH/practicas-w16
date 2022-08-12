package com.example.obtenerdiploma.DTO;

import com.example.obtenerdiploma.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private String studentName;
    private String message;
    private double averageScore;
    List<Subject> subjects;
}
