package com.example.ejerciciodosvivo.service;

import com.example.ejerciciodosvivo.dto.ResponseTestDto;
import com.example.ejerciciodosvivo.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    //Crear un nuevo caso de prueba.
    ResponseTestDto createTest(TestCaseDto test);
    //Devolver todos los casos de prueba.
    // /Buscar todos los casos de prueba que hayan sido actualizados después de una determinada fecha.

    List<ResponseTestDto> findAll(String date);
   // Devolver un caso de prueba por id.
    ResponseTestDto findById(Long id);
    //Actualizar un caso de prueba por id.
    ResponseTestDto updateTestById(TestCaseDto test,Long id);
    //Eliminar un tutorial por id.
    void delateById(Long id);



}
