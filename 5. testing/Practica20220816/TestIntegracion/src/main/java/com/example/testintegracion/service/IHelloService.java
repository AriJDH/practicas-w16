package com.example.testintegracion.service;

import com.example.testintegracion.dto.HelloDTO;

public interface IHelloService {

    HelloDTO saludar();

    HelloDTO saludar2(String n);
}
