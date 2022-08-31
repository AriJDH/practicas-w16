package com.meli.consigna.service;

import com.meli.consigna.entity.TestCase;
import com.meli.consigna.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;


    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCase> getTestCases() {
        return testCaseRepository.findAll();
    }

    @Override
    @Transactional
    public TestCase saveTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public TestCase findTestCase(Long id) {
        return testCaseRepository.findById(id).orElse(null);
    }

    @Override
    public List<TestCase> getTestCasesByDate(String date) {
        List<TestCase> testCases = testCaseRepository.findAll();
        LocalDate lastUpdate = LocalDate.parse(date.split("/")[2] + "-" + date.split("/")[1] + "-" + date.split("/")[0]);
        testCases = testCases.stream().filter(testCase -> testCase.getLastUpdate().isAfter(lastUpdate)).collect(Collectors.toList());
        return testCases;
    }
}
