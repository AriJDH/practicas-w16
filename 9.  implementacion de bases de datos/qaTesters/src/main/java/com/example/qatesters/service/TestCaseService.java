package com.example.qatesters.service;

import com.example.qatesters.model.TestCase;
import com.example.qatesters.repository.TestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    private final TestCaseRepository testCaseRepository;

    public TestCaseService(TestCaseRepository testCaseRepo) {
        this.testCaseRepository = testCaseRepo;
    }

    @Override
    public TestCase findTestCase(Long id) {
        var res = testCaseRepository.findById(id).orElse(null);
        return res;
    }

    @Override
    public TestCase updateTestCase(Long id, TestCase testCase) {

        var res = testCaseRepository.findById(id).orElse(null);
        if(res==null) return null;

        res.setTested(testCase.getTested());
        res.setDescription(testCase.getDescription());
        res.setPassed(testCase.getPassed());
        res.setNumber_of_tries(testCase.getNumber_of_tries());
        res.setLast_update(testCase.getLast_update());
        testCaseRepository.save(res);

        return res;
    }

    @Override
    public void saveTestCase(TestCase jewerly) {
        testCaseRepository.save(jewerly);
    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCase> getTestCases() {
        return testCaseRepository.findAll();
    }

    @Override
    public List<TestCase> lastUpdates(String last) {
        var res = testCaseRepository.findAll();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var date = LocalDate.parse(last, formatter);
        
        var filter = res.stream().filter(x -> x.getLast_update().isAfter(date)).collect(java.util.stream.Collectors.toList());

        return filter;
    }
}
