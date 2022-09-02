package com.bootcamp.empleados.service;

import com.bootcamp.empleados.dto.EmpleadoDto;

import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoDto> listEmpleados();
    EmpleadoDto getEmpleado(String id);
    EmpleadoDto addEmpleado(EmpleadoDto empleado);
    EmpleadoDto updateEmpleado(EmpleadoDto empleado);
    void deleteEmleado(String id);
}
