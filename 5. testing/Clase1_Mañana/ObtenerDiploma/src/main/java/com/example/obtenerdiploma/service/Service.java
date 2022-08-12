package com.example.obtenerdiploma.service;

import com.example.obtenerdiploma.DTO.ResponseDTO;
import com.example.obtenerdiploma.DTO.StudentDTO;
import com.example.obtenerdiploma.DTO.SubjectDTO;
import com.example.obtenerdiploma.entity.Subject;
import com.example.obtenerdiploma.utility.DTOMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements IService{
    @Autowired
    private DTOMapperUtil dtoMapperUtil;

    public ResponseDTO calculateAverage(StudentDTO studentDTO){
        ResponseDTO res = new ResponseDTO();
        res.setStudentName(studentDTO.getStudentName());
        double average = studentDTO.getSubjects().stream()
                .mapToDouble(SubjectDTO::getScore)
                .average()
                .getAsDouble();
        res.setAverageScore(average);
        res.setMessage("El Alumno "+ studentDTO.getStudentName()+" ha obtenido un promedio de "+ average);
        List<Subject> listDTO = dtoMapperUtil.mapList(studentDTO.getSubjects(), Subject.class);
        res.setSubjects(listDTO);
        return res;
    }
}
