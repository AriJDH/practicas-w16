package com.example.qatesters.service;

import com.example.qatesters.dto.TestCaseDto;
import com.example.qatesters.model.TestCase;
import com.example.qatesters.repository.ITestCaseRepository;
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

    public void save(TestCaseDto testCase) {
        var newTestCase = this.mapper.map(testCase, TestCase.class);
        this.testCaseRepository.save(newTestCase);
    }

    public List<TestCaseDto> getAll() {
        return this.testCaseRepository.findAll().stream()
                .map(testCase -> mapper.map(testCase, TestCaseDto.class))
                .collect(Collectors.toList());
    }

    public TestCaseDto getById(Long id) {
        return this.mapper.map(this.testCaseRepository.findById(id), TestCaseDto.class);
    }

    public void delete(Long id) {
        this.testCaseRepository.deleteById(id);
    }

    public void update(TestCaseDto testCaseDto, Long id) {
        if (!this.testCaseRepository.existsById(id)) {
            System.out.println("No existe el TestCase.");
            return;
        }
        var testCaseDtoMapped = mapper.map(testCaseDto, TestCase.class);

        this.testCaseRepository.save(testCaseDtoMapped);
    }

    public List<TestCaseDto> filterByDate(LocalDate last_update) {
        return this.testCaseRepository.findBylastUpdateGreaterThan(last_update).stream()
                .map(testCase -> this.mapper.map(testCase, TestCaseDto.class))
                .collect(Collectors.toList());
    }
}
