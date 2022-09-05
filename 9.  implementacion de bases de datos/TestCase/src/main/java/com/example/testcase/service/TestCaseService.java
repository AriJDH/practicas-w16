package com.example.testcase.service;


import com.example.testcase.model.TestCase;
import com.example.testcase.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService {

    @Autowired
    ITestCaseRepository iTestCaseRepository;


    @Override
    public List<TestCase> getTestCases() {

        return this.iTestCaseRepository.findAll();
    }

    @Override
    public void saveTestCases(TestCase testCase) {

        TestCase prueba = new TestCase( testCase.getId_case(),testCase.getDescripcion(),
                testCase.getTested(),testCase.getPassed(),testCase.getNumber_of_tries(),testCase.getLast_update());
        this.iTestCaseRepository.save(prueba);

    }

    @Override
    public void deleteTestCases(Long id) {
        this.iTestCaseRepository.deleteById(id);

    }

    @Override
    public TestCase findTestCases(Long id) {
        TestCase find = this.iTestCaseRepository.findById(id).orElse(null);
        return find;
    }

    @Override
    public void updateTest(TestCase testCase,Long id) {
        TestCase update= this.iTestCaseRepository.getReferenceById(id);
        update.setLast_update(testCase.getLast_update());
        update.setTested(testCase.getTested());
        update.setPassed(testCase.getPassed());
        update.setDescripcion(testCase.getDescripcion());
        update.setNumber_of_tries(testCase.getNumber_of_tries());
        System.out.println(update);
        this.iTestCaseRepository.save(update);

    }

    @Override
    public List<TestCase> findTestCasesByDate(String date) {

       List<TestCase> find= this.iTestCaseRepository.findAll();





        LocalDate localDate1 = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));



       return find.stream().filter(x-> x.getLast_update().isAfter(localDate1)).
               collect(Collectors.toList());
    }
}
