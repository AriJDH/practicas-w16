package com.example.qatestersexercice.service;

import com.example.qatestersexercice.dto.InsertTestCaseDto;
import com.example.qatestersexercice.dto.TestCaseDto;
import com.example.qatestersexercice.model.TestCase;
import com.example.qatestersexercice.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService {

    ObjectMapper mapper = new ObjectMapper();
    private final ITestCaseRepository testCaseRepo;

    public TestCaseService(ITestCaseRepository testCaseRepo) {
        this.testCaseRepo = testCaseRepo;
    }


    @Override
    public void createTestCase(InsertTestCaseDto testcase) {
        TestCase newTest =  new TestCase();
        newTest.setDescription(testcase.getDescription());
        newTest.setTested(testcase.getTested());
        newTest.setPassed(testcase.getPassed());
        newTest.setNumber_of_tries(testcase.getNumber_of_tries());
        newTest.setLast_update(testcase.getLast_update());
        testCaseRepo.save(newTest);
    }

    @Override
    public List<TestCaseDto> getAllTestCases() {
        List<TestCase> listaTestCase = testCaseRepo.findAll();
        List<TestCaseDto> returnList = listaTestCase.stream().map(x->new TestCaseDto(x.getId_case(),x.getDescription(),x.getTested(),x.getPassed(),x.getNumber_of_tries(),x.getLast_update())).collect(Collectors.toList());
        return returnList;
    }

    @Override
    public TestCaseDto getTestCaseById(long id) {
        TestCase x = testCaseRepo.findById(id).get();
        return new TestCaseDto(x.getId_case(),x.getDescription(),x.getTested(),x.getPassed(),x.getNumber_of_tries(),x.getLast_update());
    }

    @Override
    public void updateTestCase(long id, TestCaseDto editedTestCase) {
        TestCase testCaseBuscado = testCaseRepo.findById(id).get();
        testCaseBuscado.setDescription(editedTestCase.getDescription());
        testCaseBuscado.setTested(editedTestCase.getTested());
        testCaseBuscado.setPassed(editedTestCase.getPassed());
        testCaseBuscado.setNumber_of_tries(editedTestCase.getNumber_of_tries());
        testCaseBuscado.setLast_update(editedTestCase.getLast_update());

        testCaseRepo.save(testCaseBuscado);
    }

    @Override
    public void deleteTestCaseById(long id) {
        testCaseRepo.deleteById(id);
    }

    @Override
    public List<TestCaseDto> getTestCaseUpdatedAfterADate(String date) {
        LocalDate fecha = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return testCaseRepo.findGraterThanDate(fecha).stream().map(x->new TestCaseDto(x.getId_case(),x.getDescription(),x.getTested(),x.getPassed(),x.getNumber_of_tries(),x.getLast_update())).collect(Collectors.toList());
    }
}
