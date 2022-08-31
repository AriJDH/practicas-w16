package com.example.demo.services;

import com.example.demo.dto.GetTestCasesDTO;
import com.example.demo.entity.TestCase;
import com.example.demo.repository.IRepositoryTestCase;
import com.example.demo.utils.Mapper;
import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService {

    private final IRepositoryTestCase repositoryTestCase;

    public TestCaseService(IRepositoryTestCase repositoryTestCase) {
        this.repositoryTestCase = repositoryTestCase;
    }

    @Override
    @Transactional(readOnly = true)
    public List<GetTestCasesDTO> getTestCases() {
        List<GetTestCasesDTO> dtos = repositoryTestCase.findAll().stream().map(x -> {
            return Mapper.toDTO(x);
        }).collect(Collectors.toList());
        return dtos;
    }

    @Override
    @Transactional
    public void newTestCase() {
        TestCase newtc = new TestCase(0l, "new d", false, false, 0, LocalDate.now());
        repositoryTestCase.save(newtc);
    }
}
