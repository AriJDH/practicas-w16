package com.tester.app.service;

import com.tester.app.dto.DeleteTestCaseDto;
import com.tester.app.dto.TestCaseDto;
import com.tester.app.model.TestCase;
import com.tester.app.repository.ITestCaseRespository;
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


    @Override
    public TestCaseDto save(TestCaseDto testCaseDto) {
        TestCase testCase = convertToEntity(testCaseDto);
        testCaseRespository.save(testCase);

        return testCaseDto;
    }

    @Override
    public List<TestCaseDto> findAll(String localDate) {
       if(localDate==null){
           return testCaseRespository.findAll()
                .stream()
                .map(t -> new TestCaseDto(t.getDescription(),t.isTested(),t.isPassed(),t.getNumberOfTries(),t.getLastUpdate()))
                .collect(Collectors.toList());
       }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       LocalDate localDateParse = LocalDate.parse(localDate,formatter);
        return testCaseRespository.findAll()
                .stream()
                .filter(t -> t.getLastUpdate().isAfter(localDateParse))
                .map(t -> new TestCaseDto(t.getDescription(),t.isTested(),t.isPassed(),t.getNumberOfTries(),t.getLastUpdate()))
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseDto findById(Long id) throws Exception {
        TestCase testCase = testCaseRespository.findById(id).orElse(null);

        if (testCase==null) throw new Exception("No se encontro el Test case con id: "+id);

        return convertToDto(testCase);
    }

    @Override
    public TestCaseDto update(Long id,TestCaseDto testCaseDto) throws Exception {
        TestCase testCase = testCaseRespository.findById(id).orElse(null);

        if (testCase==null) throw new Exception("No se encontro el Test case con id: "+id);

        TestCase testCaseDtoToUpdate = convertToEntity(testCaseDto);

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

//    @Override
//    public List<TestCaseDto> findByDate(LocalDate localDate) {
//        return testCaseRespository.findAll()
//                .stream()
//                .filter(t -> t.getLastUpdate().isAfter(localDate))
//                .map(t -> new TestCaseDto(t.getDescription(),t.isTested(),t.isPassed(),t.getNumberOfTries(),t.getLastUpdate()))
//                .collect(Collectors.toList());
//    }

    private TestCase convertToEntity(TestCaseDto testCaseDto){
        ModelMapper mapper = new ModelMapper();
        TestCase testCase = mapper.map(testCaseDto,TestCase.class);
        if (testCase != null) return testCase;
        return null;
    }

    private TestCaseDto convertToDto(TestCase testCase){
        ModelMapper mapper = new ModelMapper();
        TestCaseDto testCaseDto = mapper.map(testCase,TestCaseDto.class);
        if (testCaseDto != null) return testCaseDto;
        return null;
    }
}
