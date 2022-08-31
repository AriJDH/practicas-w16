package com.ndemaio.ejerciciotestcases.service;

import com.ndemaio.ejerciciotestcases.model.TestCase;
import com.ndemaio.ejerciciotestcases.repository.TestCaseRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;

    public void createTestCase(TestCase testCase) {
        testCaseRepository.save(testCase);
    }

    public TestCase getTestCaseById(Long id) {
        return testCaseRepository.findById(id).get();
    }

    public void updateTestCaseById(Long id, TestCase updatedTestCase) {
        var testCaseToUpdate = getTestCaseById(id);
        updatedTestCase.setIdCase(testCaseToUpdate.getIdCase());
        updatedTestCase.setLastUpdate(LocalDate.now());
        testCaseRepository.save(updatedTestCase);
    }

    public void deleteTestCaseById(Long id) {
        testCaseRepository.deleteById(id);
    }

    // last_update=’dd/mm/yyyy’ - casos de prueba que hayan sido actualizados después de una determinada fecha.
    public List<TestCase> getTestCases(Map<String, String> someFilters) {
        var testCases = testCaseRepository.findAll();
        if (someFilters.containsKey("last_update")) {
            var date = LocalDate.parse(someFilters.get("last_update"));
            testCases = testCases.stream().filter(testCase -> testCase.getLastUpdate().isAfter(date)).collect(Collectors.toList());
        }
        return testCases;
    }
}
