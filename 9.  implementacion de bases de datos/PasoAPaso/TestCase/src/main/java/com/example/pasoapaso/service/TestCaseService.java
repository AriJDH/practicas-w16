package com.example.pasoapaso.service;

import com.example.pasoapaso.model.TestCase;
import com.example.pasoapaso.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    @Autowired
    private ITestCaseRepository testCaseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TestCase> getTestCase(String lastUpdate) {
        if (lastUpdate.isBlank()) {
            return testCaseRepository.findAll();
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return testCaseRepository.findAllByLastUpdateBetween(LocalDate.parse(lastUpdate, dtf), LocalDate.now());
    }

    @Override
    @Transactional()
    public void saveTestCase(TestCase testCase) {
        testCase.setLastUpdate(LocalDate.now());
        testCaseRepository.save(testCase);
    }

    @Override
    @Transactional()
    public void deleteTestCase(long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public TestCase findTestCase(long id) {
        return testCaseRepository.findById(id).orElse(null);
    }
}