package com.bootcamp.testcase.service;

import com.bootcamp.testcase.model.TestCase;
import com.bootcamp.testcase.repository.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestServices implements  ITestServices{
    @Autowired
    ITestRepository repository;

    @Override
    public List<TestCase> getTest(String localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate fecha = LocalDate.parse(localDate, formatter);

        if(localDate != null) {
            return repository.findAll().stream().filter(o -> o.getLast_update().isBefore(fecha)).collect(Collectors.toList());
        }
        else
            return  repository.findAll();
    }

    @Override
    public TestCase getFindById(Long Id) {
        return  repository.findById(Id).orElse(null);
    }

    @Override
    public void deleteById(Long Id) {
        TestCase testCase = getFindById(Id);
        if(testCase == null)
            throw  new RuntimeException("El test no se encuentra");

        repository.delete(testCase);
    }

    @Override
    public void create(TestCase testCase) {
        repository.save(testCase);
    }

    @Override
    public TestCase updateById(Long Id, TestCase testCase) {
        TestCase find = getFindById(Id);
        if(testCase == null)
            throw  new RuntimeException("El test no se encuentra");
        find.setLast_update(LocalDate.now());
        find.setTested(testCase.getPassed());
        find.setDescripcion(testCase.getDescripcion());
        find.setPassed(testCase.getPassed());
        find.setNumber_of_tries(testCase.getNumber_of_tries());
        repository.save(find);
        return testCase;
    }
}
