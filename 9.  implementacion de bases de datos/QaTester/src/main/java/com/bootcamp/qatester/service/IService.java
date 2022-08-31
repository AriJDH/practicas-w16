package com.bootcamp.qatester.service;

import com.bootcamp.qatester.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface IService {

        public List<TestCase> getAllTests();
        public void saveTest(TestCase test);
        public void deleteTest(long id);
        public TestCase findTest(long id);
        public List<TestCase> getAllTestsAfterDate(LocalDate fecha);
}
