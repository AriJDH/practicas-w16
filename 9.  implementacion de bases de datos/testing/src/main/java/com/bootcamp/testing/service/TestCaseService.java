package com.bootcamp.testing.service;

import com.bootcamp.testing.dto.TestCaseDto;
import com.bootcamp.testing.model.TestCase;
import com.bootcamp.testing.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService {

    private ITestCaseRepository testCaseRepository;
    private ModelMapper mapper;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        this.mapper = new ModelMapper();
    }

    public void saveTestCase(TestCaseDto testCase) {
        var newTestCase = mapper.map(testCase, TestCase.class);
        testCaseRepository.save(newTestCase);
    }


    public List<TestCaseDto> getAllCases() {
        return testCaseRepository
                .findAll()
                .stream()
                .map(testCase -> mapper.map(testCase, TestCaseDto.class))
                .collect(Collectors.toList());
    }

    public TestCaseDto getById(Long id) {
        return mapper.map(testCaseRepository.findById(id), TestCaseDto.class);
    }

    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    public void updateTestCase(TestCaseDto testCase, Long id) {
        if (!testCaseRepository.existsById(id)) {
            System.out.println("No existe el objeto");
            return;
        }
        var testCaseMapped = mapper.map(testCase, TestCase.class);
        testCaseRepository.save(testCaseMapped);
    }

    public List<TestCaseDto> filterByDate(LocalDate last_update) {
        return testCaseRepository.findBylastUpdateGreaterThan(last_update)
                .stream()
                .map(testCase -> mapper.map(testCase, TestCaseDto.class))
                .collect(Collectors.toList());
    }
}
