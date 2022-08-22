package com.bootcamp.integrationtest.demo.service;

import com.bootcamp.integrationtest.demo.dto.HelloDto;

public interface IHelloService {
    HelloDto saludar();
    HelloDto saludarDos(String name);
}
