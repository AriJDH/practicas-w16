package com.tester.app.service;

import com.tester.app.dto.ApiResponseDto;
import com.tester.app.dto.TestCaseDto;
import com.tester.app.exception.TestNotFoundException;
import com.tester.app.model.TestCase;
import com.tester.app.repository.ITestCaseRespository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImpl implements ITestCaseService{

    private final ITestCaseRespository testCaseRepository;
    private final ModelMapper mapper;

    public TestCaseServiceImpl(ITestCaseRespository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        mapper = new ModelMapper();
    }


    @Override
    public TestCaseDto save(TestCaseDto testCaseDto) {
        testCaseDto.setId(null);
        return toDto(testCaseRepository.save(toEntity(testCaseDto)));
    }

    @Override
    public List<TestCaseDto> findAll(LocalDate localDate) {
        return testCaseRepository.findAll()
                .stream()
                .filter(t -> localDate == null || (t.getLastUpdate() != null && localDate.isAfter(t.getLastUpdate())))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseDto findById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);

        if (testCase==null) throw new TestNotFoundException(id);

        return toDto(testCase);
    }

    @Override
    public TestCaseDto update(Long id,TestCaseDto testCaseDto) {
        if (testCaseRepository.findById(id).isEmpty()) throw new TestNotFoundException(id);

        TestCase testCaseDtoToUpdate = toEntity(testCaseDto);
        testCaseDtoToUpdate.setIdCase(id);

        return toDto(testCaseRepository.save(testCaseDtoToUpdate));
    }

    @Override
    public ApiResponseDto delete(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);

        if (testCase==null) throw new TestNotFoundException(id);
        testCaseRepository.delete(testCase);
        return new ApiResponseDto("El caso de prueba con id: " + id + " Se ha eliminado correctamente");
    }

    private TestCase toEntity(TestCaseDto testCaseDto){
        return mapper.map(testCaseDto,TestCase.class);
    }

    private TestCaseDto toDto(TestCase testCase){
        return mapper.map(testCase,TestCaseDto.class);
    }
}
