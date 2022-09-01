package com.example.qatesters.service;

import com.example.qatesters.dto.TestCaseDTO;
import com.example.qatesters.entity.TestCase;
import com.example.qatesters.repository.ITestCaseRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    ITestCaseRepository iTestCaseRepository;

    @Override
    public List<TestCaseDTO> findAll(LocalDate last_update){
        if(last_update == null){
            return iTestCaseRepository.findAll().stream().map(this::entityToDTO)
                    .collect(Collectors.toList());
        } else {
            return findUpdatedAfterDate(last_update);
        }
    }

    @Override
    public void add(TestCaseDTO testCaseDTO) {
        iTestCaseRepository.save(dtoToEntity(testCaseDTO));
    }

    @Override
    public TestCaseDTO findById(Long id) {
        return entityToDTO(iTestCaseRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe")));
    }

    @Override
    public TestCaseDTO update(TestCaseDTO testCaseDTO, Long id) {
        TestCase testCaseToUpdate = dtoToEntity(this.findById(id));

        testCaseToUpdate.setDescription(testCaseDTO.getDescription());
        testCaseToUpdate.setTested(testCaseDTO.getTested());
        testCaseToUpdate.setPassed(testCaseDTO.getPassed());
        testCaseToUpdate.setNumberOfTries(testCaseDTO.getNumberOfTries());
        testCaseToUpdate.setLast_update(LocalDate.now());

        return entityToDTO(iTestCaseRepository.save(testCaseToUpdate));
    }

    @Override
    public void deleteById(Long id) {
        TestCase testCaseToDelete = dtoToEntity(this.findById(id));
        iTestCaseRepository.deleteById(id);
    }

    private List<TestCaseDTO> findUpdatedAfterDate(LocalDate last_update) {
        return iTestCaseRepository.findAll().stream()
                .filter(t -> t.getLast_update().isAfter(last_update))
                .map(this::entityToDTO).collect(Collectors.toList());
    }

    private TestCaseDTO entityToDTO(TestCase testCase){
        return new TestCaseDTO(testCase.getIdCase(), testCase.getDescription(), testCase.getTested(), testCase.getPassed(), testCase.getNumberOfTries(), testCase.getLast_update());
    }

    private TestCase dtoToEntity(TestCaseDTO testCaseDTO){
        return new TestCase(testCaseDTO.getIdCase(), testCaseDTO.getDescription(), testCaseDTO.getTested(), testCaseDTO.getPassed(), testCaseDTO.getNumberOfTries(), LocalDate.now(), false);
    }

}
