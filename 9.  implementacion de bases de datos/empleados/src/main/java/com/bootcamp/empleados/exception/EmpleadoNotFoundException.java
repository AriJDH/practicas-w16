package com.bootcamp.empleados.exception;

public class EmpleadoNotFoundException extends RuntimeException {
    public EmpleadoNotFoundException(String id) {
        super("No se encontró el empleado con id " + id);
    }
}
