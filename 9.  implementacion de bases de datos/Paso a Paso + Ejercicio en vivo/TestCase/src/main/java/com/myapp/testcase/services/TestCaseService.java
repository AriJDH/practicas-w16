package com.myapp.testcase.services;

import com.myapp.testcase.dto.TestCaseDTO;
import com.myapp.testcase.model.TestCase;
import com.myapp.testcase.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{
    private final ModelMapper mapper;
    private final ITestCaseRepository testCaseRepository;

    public TestCaseService(ITestCaseRepository testCaseRepository){
        this.testCaseRepository = testCaseRepository;
        mapper = new ModelMapper();
    }

    @Override
    public void saveTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = mapper.map(testCaseDTO, TestCase.class);
        testCaseRepository.save(testCase);
    }

    @Override
    public List<TestCaseDTO> getAllTestCase() {
        return testCaseRepository.findAll().stream()
                .map(testCase -> mapper.map(testCase, TestCaseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TestCaseDTO> getAllTestCaseByDate(LocalDate date) {
        if (date != null){
            return testCaseRepository.findAll().stream()
                    .filter(testCase -> testCase.getLast_update().isAfter(date))
                    .map(testCase -> mapper.map(testCase, TestCaseDTO.class))
                    .collect(Collectors.toList());
        } else {
            return getAllTestCase();
        }
    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.findById(id).ifPresent(testCaseRepository::delete);
    }

    @Override
    public TestCaseDTO getTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        TestCaseDTO testCaseDTO = null;
        if (testCase != null){
            testCaseDTO = mapper.map(testCase, TestCaseDTO.class);
        }
        return testCaseDTO;
    }

    @Override
    public void updateTestCase(Long id, TestCaseDTO testCaseDTO) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);

        if (testCase != null){
            testCase.setDescription(testCaseDTO.getDescription());
            testCase.setTested(testCaseDTO.getTested());
            testCase.setPassed(testCaseDTO.getPassed());
            testCase.setNumber_of_tries(testCaseDTO.getNumber_of_tries());
            testCase.setLast_update(testCaseDTO.getLast_update());

            testCaseRepository.save(testCase);
        }

    }
}
