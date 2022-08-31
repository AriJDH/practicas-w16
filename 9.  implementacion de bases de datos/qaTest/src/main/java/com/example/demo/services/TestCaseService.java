package com.example.demo.services;

import com.example.demo.dto.GetTestCasesDTO;
import com.example.demo.entity.TestCase;
import com.example.demo.repository.IRepositoryTestCase;
import com.example.demo.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService {

    private final IRepositoryTestCase repositoryTestCase;

    public TestCaseService(IRepositoryTestCase repositoryTestCase) {
        this.repositoryTestCase = repositoryTestCase;
    }

    @Override
    public List<GetTestCasesDTO> getTestCases() {
        List<GetTestCasesDTO> dtos = repositoryTestCase.findAll().stream().map(x -> {
            return Mapper.toDTO(x);
        }).collect(Collectors.toList());
        return dtos;
    }
}
