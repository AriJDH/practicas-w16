package com.example.testcase.service;

import com.example.testcase.dto.TestCaseDTO;
import com.example.testcase.dto.TestCaseIdDTO;
import com.example.testcase.exception.IdError;
import com.example.testcase.model.TestCase;
import com.example.testcase.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImp implements TestCaseService{

    final TestCaseRepository repo;
    ModelMapper mapper = new ModelMapper();

    public TestCaseServiceImp(TestCaseRepository repo) {
        this.repo = repo;
    }

    @Override
    public String addTest(TestCaseDTO testCaseDTO) {
        TestCase testCase = mapper.map(testCaseDTO, TestCase.class);
        repo.save(testCase);
        return "Test case :"+repo.count();
    }

    @Override
    public TestCaseIdDTO getTestById(long id) throws IdError {
        if(!repo.existsById(id))throw new IdError();
        TestCase testCase = repo.getReferenceById(id);
        TestCaseIdDTO testCaseDTO = mapper.map(testCase, TestCaseIdDTO.class);
        return testCaseDTO;
    }

    @Override
    public List<TestCaseIdDTO> getAllTest() {
        List<TestCase> tests = repo.findAll();
        return tests.stream()
                .map(test -> mapper.map(test, TestCaseIdDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String delete(long id) throws IdError {
        if(!repo.existsById(id))throw new IdError();
        repo.deleteById(id);
        return "Test Case deleted";
    }

    @Override
    public String update(long id, TestCaseDTO testCaseDTO) throws IdError {
        if(!repo.existsById(id))throw new IdError();
        TestCase test = repo.getReferenceById(id);
        test.setDescription(testCaseDTO.getDescription());
        test.setTested(testCaseDTO.isTested());
        test.setPassed(testCaseDTO.isPassed());
        test.setLast_update(testCaseDTO.getLast_update());
        test.setNumber_of_tries(testCaseDTO.getNumber_of_tries());
        repo.save(test);
        return "Test Case updated";
    }

    @Override
    public List<TestCaseIdDTO> getByDate(LocalDate date) {
        List<TestCase> tests = repo.findAll();
        return tests.stream()
                .filter(test -> test.getLast_update().isAfter(date))
                .map(testCase -> mapper.map(testCase,TestCaseIdDTO.class))
                .collect(Collectors.toList());
    }

}
