package com.example.qatesters.service;

import com.example.qatesters.dto.ReqPostTestCaseDTO;
import com.example.qatesters.dto.ReqPutUpdateTestCaseDTO;
import com.example.qatesters.dto.ResTestCaseDTO;
import com.example.qatesters.exception.NotFoundException;
import com.example.qatesters.model.TestCase;
import com.example.qatesters.repository.ITestCaseRepository;
import com.example.qatesters.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class TestCaseService implements ITestCaseService {
    @Autowired
    private ITestCaseRepository testCaseRepository;

    @Override
    public ResTestCaseDTO addTestCase(ReqPostTestCaseDTO reqPostTestCaseDTO) {
        TestCase testCase = new TestCase();
        testCase.setDescription(reqPostTestCaseDTO.getDescription());
        this.testCaseRepository.save(testCase);
        return Mapper.mapResTestCaseDTO(testCase);
    }

    @Override
    public List<ResTestCaseDTO> listAllTestCase(Optional<LocalDate> lastUpdate) {
        if(lastUpdate.orElse(null) != null) {
            return Mapper.mapListResTestCaseDTO(this.testCaseRepository.findTestCasesByLastUpdateAfter(lastUpdate.get()));
        }
        return Mapper.mapListResTestCaseDTO(this.testCaseRepository.findAll());
    }

    @Override
    public ResTestCaseDTO getTestCaseById(Long id) {
        TestCase testCase = this.testCaseRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("The testCase does not exists");
        });
        return Mapper.mapResTestCaseDTO(testCase);
    }

    @Override
    public ResTestCaseDTO updateTestCaseById(Long id, ReqPutUpdateTestCaseDTO reqPutUpdateTestCaseDTO) {
        TestCase testCase = this.testCaseRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("The testCase does not exists");
        });
        Boolean flag = false;
        if(reqPutUpdateTestCaseDTO.getDescription() != null) {
            testCase.setDescription(reqPutUpdateTestCaseDTO.getDescription());
            flag = true;
        }
        System.out.println("aaa");
        if(reqPutUpdateTestCaseDTO.getTested() != null) {
            testCase.setTested(reqPutUpdateTestCaseDTO.getTested());
            flag = true;
        }
        if(reqPutUpdateTestCaseDTO.getPassed() != null) {
            testCase.setPassed(reqPutUpdateTestCaseDTO.getPassed());
            flag = true;
        }
        if(reqPutUpdateTestCaseDTO.getNumberOfTries() != null) {
            testCase.setNumberOfTries(reqPutUpdateTestCaseDTO.getNumberOfTries());
            flag = true;
        }
        if(flag == true) testCase.setLastUpdate(LocalDate.now());
        return Mapper.mapResTestCaseDTO(testCase);
    }

    @Override
    public void deleteTestCaseById(Long id) {
        this.testCaseRepository.deleteById(id);
    }
}
