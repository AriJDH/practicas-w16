package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.dto.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(StudentDTO rq);
}
