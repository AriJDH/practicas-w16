package com.example.testers.service;

import com.example.testers.dto.TestCaseDTO;
import com.example.testers.model.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface ITesterService {

    TestCaseDTO crearTest(TestCaseDTO testdto);

    List<TestCaseDTO> recuperarTests();

    TestCaseDTO recuperarTestById(Long id);

    TestCaseDTO actualizarTestById(TestCaseDTO testdto, Long id);

    String eliminatTestById(Long id);

    List<TestCaseDTO> recuperarTestActualizadosPorFecha(LocalDate localDate);

}
