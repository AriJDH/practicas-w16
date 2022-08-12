package com.example.obtenerdiploma.service;

import com.example.obtenerdiploma.DTO.ResponseDTO;
import com.example.obtenerdiploma.DTO.StudentDTO;

public interface IService {
     ResponseDTO calculateAverage(StudentDTO studentDTO);
}
