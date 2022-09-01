package com.tester.app.service;

import com.tester.app.dto.DeleteTestCaseDto;
import com.tester.app.dto.TestCaseDto;
import com.tester.app.model.TestCase;
import com.tester.app.repository.ITestCaseRespository;
import com.tester.app.utility.DTOMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImpl implements ITestCaseService{

    @Autowired
    private ITestCaseRespository testCaseRespository;

    @Autowired
    private DTOMapperUtil dtoMapperUtil;


    @Override
    public TestCaseDto save(TestCaseDto testCaseDto) {
        TestCase testCase = dtoMapperUtil.map(testCaseDto, TestCase.class);
        testCaseRespository.save(testCase);

        return testCaseDto;
    }

    @Override
    public List<TestCaseDto> findAll(String localDate) {
       if(localDate==null){
           List<TestCase> testsCases = testCaseRespository.findAll();
           return dtoMapperUtil.mapList(testsCases, TestCaseDto.class);
       }
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       List<TestCase> testsCases = testCaseRespository.findByLastUpdateAfter(LocalDate.parse(localDate,formatter));
       return dtoMapperUtil.mapList(testsCases, TestCaseDto.class);
    }

    @Override
    public TestCaseDto findById(Long id) throws Exception {
        TestCase testCase = testCaseRespository.findById(id).orElse(null);

        if (testCase==null) throw new Exception("No se encontro el Test case con id: "+id);

        return dtoMapperUtil.map(testCase, TestCaseDto.class);
    }

    @Override
    public TestCaseDto update(Long id,TestCaseDto testCaseDto) throws Exception {
        TestCase testCase = testCaseRespository.findById(id).orElse(null);

        if (testCase==null) throw new Exception("No se encontro el Test case con id: "+id);

        TestCase testCaseDtoToUpdate = dtoMapperUtil.map(testCaseDto, TestCase.class);

        testCaseDtoToUpdate.setIdCase(testCase.getIdCase());

        testCaseRespository.save(testCaseDtoToUpdate);

        return testCaseDto;
    }

    @Override
    public DeleteTestCaseDto delete(Long id) throws Exception {
        TestCase testCase = testCaseRespository.findById(id).orElse(null);

        if (testCase==null) throw new Exception("No se encontro el Test case con id: "+id);
        testCaseRespository.delete(testCase);
        return new DeleteTestCaseDto("El caso de prueba con id: "+id+" Se ha eliminado correctamente");
    }
}
