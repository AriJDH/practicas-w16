package com.bootcamp.qatester.service;

import com.bootcamp.qatester.entity.TestCase;
import com.bootcamp.qatester.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service implements  IService {


    @Autowired
    private IRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<TestCase> getAllTests() {
      return repository.findAll();
    }

    @Override
    @Transactional
    public void saveTest(TestCase test) {
        repository.save(test);

    }

    @Override
    @Transactional
    public void deleteTest(long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public TestCase findTest(long id) {
        return repository.findById(id).orElse(null);
    }


    @Override
    @Transactional(readOnly = true)
    public List<TestCase> getAllTestsAfterDate(LocalDate fecha) {
        return repository.findAll().stream().filter(testCase -> testCase.getLastUpdate().isAfter(fecha)).collect(Collectors.toList());
    }


}
