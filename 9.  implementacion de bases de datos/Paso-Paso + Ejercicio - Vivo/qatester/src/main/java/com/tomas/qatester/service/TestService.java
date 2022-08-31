package com.tomas.qatester.service;

import com.tomas.qatester.dto.ListTestCaseDTO;
import com.tomas.qatester.dto.ResponseDTO;
import com.tomas.qatester.dto.TestCaseDTO;
import com.tomas.qatester.model.TestCase;
import com.tomas.qatester.repository.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Service
public class TestService implements ITestService{

    @Autowired
    ITestRepository repository;

    @Override
    public ResponseDTO createTest(TestCaseDTO testCaseDTO) {

        repository.save(this.testCaseDtoToTestCaseModel(testCaseDTO));
        ResponseDTO responseDTO = new ResponseDTO(201, "Test create successful");
        return responseDTO;
    }

    @Override
    public ListTestCaseDTO findAllTestCase(String date) {

        if(date == null) {

            ListTestCaseDTO list = new ListTestCaseDTO();

            list.setTest(repository.findAll().stream().map(x -> {
                TestCaseDTO testCaseDTO = new TestCaseDTO();
                testCaseDTO.setDescription(x.getDescription());
                testCaseDTO.setPassed(x.isPassed());
                testCaseDTO.setTested(x.isTested());
                testCaseDTO.setNumberOfTries(x.getNumberOfTries());
                testCaseDTO.setLastUpdate(x.getLastUpdate());
                return testCaseDTO;
            }).collect(Collectors.toList()));

            return list;

        } else {
            return this.findTestDate(date);
        }
    }

    @Override
    public TestCaseDTO findId(Long id) {

        if(repository.existsById(id)) {

            return this.testCaseModelToTestCaseDto(repository.findById(id).get());

        } else {
            return null;
        }

    }

    @Override
    public ResponseDTO updateTest(Long id, TestCaseDTO testCaseDTO) {

        if(repository.existsById(id)) {

            TestCase testCase;
            testCase = this.testCaseDtoToTestCaseModel(testCaseDTO);
            testCase.setId(id);

            repository.save(testCase);

            ResponseDTO responseDTO = new ResponseDTO(200, "Test update successful");
            return responseDTO;

        } else {
            ResponseDTO responseDTO = new ResponseDTO(400, "User not found");
            return responseDTO;
        }
    }

    @Override
    public ResponseDTO deleteTest(Long id) {

        if(repository.existsById(id)) {

            repository.deleteById(id);

            ResponseDTO responseDTO = new ResponseDTO(200, "Test delete successful");
            return responseDTO;

        } else {
            ResponseDTO responseDTO = new ResponseDTO(400, "User not found");
            return responseDTO;
        }

    }


    private ListTestCaseDTO findTestDate(String date) {

        ListTestCaseDTO list = new ListTestCaseDTO();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formato);

        list.setTest(repository.findAll().stream().filter(y->y.getLastUpdate().isAfter(localDate))
                .collect(Collectors.toList()));

        return list;
    }


    private TestCase testCaseDtoToTestCaseModel(TestCaseDTO testCaseDTO){

        TestCase testCase = new TestCase();
        testCase.setDescription(testCaseDTO.getDescription());
        testCase.setTested(testCaseDTO.isTested());
        testCase.setLastUpdate(testCaseDTO.getLastUpdate());
        testCase.setPassed(testCaseDTO.isPassed());
        testCase.setNumberOfTries(testCaseDTO.getNumberOfTries());

        return testCase;

    }

    private TestCaseDTO testCaseModelToTestCaseDto(TestCase testCase){

        TestCaseDTO testCaseDTO = new TestCaseDTO();
        testCaseDTO.setDescription(testCase.getDescription());
        testCaseDTO.setTested(testCase.isTested());
        testCaseDTO.setPassed(testCase.isPassed());
        testCaseDTO.setNumberOfTries(testCase.getNumberOfTries());
        testCaseDTO.setLastUpdate(testCase.getLastUpdate());

        return testCaseDTO;

    }
}
