package com.bootcamp.demo.service;

import com.bootcamp.demo.DTO.TestCaseDTO;
import com.bootcamp.demo.model.TestCase;
import com.bootcamp.demo.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TestCaseService implements ITestCaseService {

    private final ModelMapper mapper;

    private final ITestCaseRepository iTestCaseRepository;

    public TestCaseService(ITestCaseRepository iTestCaseRepository){
        this.iTestCaseRepository = iTestCaseRepository;
        mapper = new ModelMapper();
    }

    @Override
    //@Transactional(readOnly = true)
    public String saveTest(TestCaseDTO testCaseDTO) {
        TestCase testCase = mapper.map(testCaseDTO, TestCase.class);
        iTestCaseRepository.save(testCase);
        return "Test creado";
    }

    @Override
    public List<TestCaseDTO> getAll() {
        return iTestCaseRepository.findAll().stream().map(testCase -> mapper.map(testCase, TestCaseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public String updateTest(Long id, TestCaseDTO testCaseDTO) {

        TestCase testCase=iTestCaseRepository.findById(id).orElse(null);
        testCase.setDescription(testCaseDTO.getDescription());
        testCase.setTested(testCaseDTO.getTested());
        testCase.setPassed(testCaseDTO.getPassed());
        testCase.setNumberOfTries(testCaseDTO.getNumberOfTries());
        testCase.setLastUpdate(testCaseDTO.getLastUpdate());
        iTestCaseRepository.save(testCase);

        return "Registro actualizado!";
    }

    @Override
    public String deleteTest(Long id) {
        iTestCaseRepository.deleteById(id);
        return "Registro Eliminado";
    }
}
