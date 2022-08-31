package com.bootcamp.qatester.service;

import com.bootcamp.qatester.model.TestCase;
import com.bootcamp.qatester.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService {

    @Autowired
    TestCaseRepository testCaseRepository;

    @Override
    public TestCase save(TestCase testCase) {
        testCase.setLast_update(LocalDate.now());
        testCaseRepository.save(testCase);
        return testCase;
    }

    @Override
    public TestCase findById(Long id) {
        return testCaseRepository.findById(id).orElse(null);
    }

    @Override
    public String delete(Long id) {
        testCaseRepository.deleteById(id);
        return "Test Case " + id + " deleted!";
    }

    @Override
    public TestCase edit(Long id, TestCase testCase) {
        TestCase testCaseFound = findById(id);
        if (testCaseFound != null) {
            testCaseFound.setTested(testCase.isTested());
            testCaseFound.setDescription(testCase.getDescription());
            testCaseFound.setLast_update(LocalDate.now());
            testCaseFound.setPassed(testCase.isPassed());
            testCaseFound.setNumber_of_tries(testCase.getNumber_of_tries());
            testCaseRepository.save(testCaseFound);
        }
        return testCaseFound;
    }

    @Override
    public List<TestCase> findAllOrByDate(LocalDate last_update) {
        if (last_update != null)
            return testCaseRepository.findAll().stream().filter(testCase -> testCase.getLast_update().isAfter(last_update)).collect(Collectors.toList());
        else return testCaseRepository.findAll();
    }
}
