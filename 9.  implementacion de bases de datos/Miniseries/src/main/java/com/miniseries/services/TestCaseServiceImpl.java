package com.miniseries.services;

import com.miniseries.dto.TestCaseDTO;
import com.miniseries.entities.TestCase;
import com.miniseries.repositories.ITestCaseRepository;
import com.miniseries.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImpl implements ITestCaseService{

    private final ITestCaseRepository testCaseRepository;

    @Autowired
    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCaseDTO create(TestCaseDTO testCaseDTO) {
        return Mapper.parseTestCaseDTOFromTestCase(testCaseRepository.save(Mapper.parseTestCaseFromTestCaseDTO(testCaseDTO)));
    }

    @Override
    public TestCaseDTO findById(Long id) {
        return Mapper.parseTestCaseDTOFromTestCase(Objects.requireNonNull(testCaseRepository.findById(id).orElse(null)));
    }

    @Override
    public List<TestCaseDTO> find() {
        return testCaseRepository.findAll().stream().map(Mapper::parseTestCaseDTOFromTestCase).collect(Collectors.toList());
    }

    @Override
    public TestCaseDTO update(Long id, TestCaseDTO testCaseDTO) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        if (testCase != null) {
            TestCase updated = Mapper.parseTestCaseFromTestCaseDTO(testCaseDTO);
            updated.setId_case(testCase.getId_case());
            updated.setLast_update(LocalDate.now());
            testCaseRepository.save(updated);
            testCase = updated;
        }
        assert testCase != null;
        return Mapper.parseTestCaseDTOFromTestCase(testCase);
    }

    @Override
    public void delete(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCaseDTO> findByFecha(String fecha) {
        return null;
    }
}
