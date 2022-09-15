package com.example.cars.service;

import com.example.cars.repository.SinisterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SinisterService {
    @Autowired
    SinisterRepository sinisterRepository;
    @Autowired
    private ModelMapper modelMapper;
}
