package com.javaW16.qatesters.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.javaW16.qatesters.dto.resDTO.TestResDTO;
import com.javaW16.qatesters.dto.resDTO.reqDTO.TestDTO;
import com.javaW16.qatesters.model.TestCase;
import com.javaW16.qatesters.repository.IRepository;
import com.javaW16.qatesters.utils.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ImpService implements IService {

   @Autowired
   IRepository repository;

   @Override
   public void saveTest(TestDTO testDTO) {
      repository.save(Mapper.testDTOtoTestCase(testDTO));   
   }

   @Override
   public void updateTest(Long id, TestDTO testDTO) {

      System.out.println(id);
      System.out.println(testDTO);

      TestCase resCase = repository.findById(id).orElse(null);   

      System.out.println(resCase);

      if(resCase != null) {
         resCase.setDescription(testDTO.getDescription());
         resCase.setTested(testDTO.getTested());
         resCase.setPassed(testDTO.getPassed());
         resCase.setNumbers_of_tries(testDTO.getNumbers_of_tries());
         resCase.setLast_update(testDTO.getLast_update());

         repository.save(resCase);   
      }

   }

   @Override
   public List<TestResDTO> listAllTests(String localDate) {

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


      if(localDate != null) {

      LocalDate fecha = LocalDate.parse(localDate,formatter);

         return Mapper.testCaseToListCaseResDTO(
            repository
            .findAll()
            .stream()
            .filter(o -> o.getLast_update().isAfter(fecha))
            .collect(Collectors.toList())
         );   
      }
      else{
         return Mapper.testCaseToListCaseResDTO(repository.findAll());   
      }
   }

   @Override
   public TestResDTO findById(Long id) {

      TestCase resCase = repository.findById(id).orElse(null);   

      if (resCase != null) {
         return Mapper.testCaseToTestResDTO(resCase);   
      } else {
         return null ;   
      }

   }

   @Override
   public void deleteTest(Long id) {
      repository.deleteById(id);	
   }

}
