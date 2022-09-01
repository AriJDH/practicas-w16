package com.example.testers.service;

import com.example.testers.model.TestCase;
import com.example.testers.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    ITestCaseRepository testRepo;

    @Override
    public void saveTestCase(TestCase testCase) {
        testRepo.save(testCase);
    }

    @Override
    public List<TestCase> getTestCases() {
        List<TestCase> testsList = testRepo.findAll();
        return testsList;
    }

    @Override
    public TestCase findTestCase(Long id) {
        TestCase tesCase = testRepo.findById(id).orElse(null);
        return tesCase;
    }

    @Override
    public void updateTestCase(TestCase testCase, Long id) {
        TestCase test = findTestCase(id);
        test.setDescription(testCase.getDescription());
        test.setTested(testCase.getTested());
        test.setPassed(testCase.getPassed());
        test.setNumber_of_tries(testCase.getNumber_of_tries());
        test.setLast_update(testCase.getLast_update());
        saveTestCase(test);
    }

    @Override
    public void deleteTestCase(Long id) {
        testRepo.deleteById(id);
    }

    @Override
    public List<TestCase> findTestCasesByDate(String date) {
        List<TestCase> testList = getTestCases();
        LocalDate formatedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return testList.stream().filter(x -> x.getLast_update().isAfter(formatedDate)).collect(Collectors.toList());
    }
}
