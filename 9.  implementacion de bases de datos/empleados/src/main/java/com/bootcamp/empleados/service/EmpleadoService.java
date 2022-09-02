package com.bootcamp.empleados.service;

import com.bootcamp.empleados.dto.EmpleadoDto;
import com.bootcamp.empleados.exception.EmpleadoNotFoundException;
import com.bootcamp.empleados.model.Empleado;
import com.bootcamp.empleados.repository.EmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService{

    private final EmpleadoRepository repository;
    private final ModelMapper mapper;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
        mapper = new ModelMapper();
    }

    @Override
    public List<EmpleadoDto> listEmpleados() {
        List<EmpleadoDto> response = new ArrayList<>();
        repository.findAll()
                .forEach(e -> response.add(toDto(e)));
        return response;
    }

    @Override
    public EmpleadoDto getEmpleado(String id) {
        Optional<Empleado> empleado = repository.findById(id);
        if(empleado.isEmpty())
            throw new EmpleadoNotFoundException(id);
        return toDto(empleado.get());
    }

    @Override
    public EmpleadoDto addEmpleado(EmpleadoDto empleado) {
        empleado.setId(null);
        return toDto(repository.save(toEntity(empleado)));
    }

    @Override
    public EmpleadoDto updateEmpleado(EmpleadoDto empleado) {
        if(!repository.existsById(empleado.getId()))
            throw new EmpleadoNotFoundException(empleado.getId());
        return toDto(repository.save(toEntity(empleado)));
    }

    @Override
    public void deleteEmleado(String id) {
        repository.deleteById(id);
    }

    private EmpleadoDto toDto(Empleado e) {
        return mapper.map(e, EmpleadoDto.class);
    }

    private Empleado toEntity(EmpleadoDto dto) {
        return mapper.map(dto, Empleado.class);
    }
}
