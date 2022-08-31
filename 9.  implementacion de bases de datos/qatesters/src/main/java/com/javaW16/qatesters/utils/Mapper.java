package com.javaW16.qatesters.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.javaW16.qatesters.dto.resDTO.TestResDTO;
import com.javaW16.qatesters.dto.resDTO.reqDTO.TestDTO;
import com.javaW16.qatesters.model.TestCase;

public class Mapper {

   public static TestCase testDTOtoTestCase (TestDTO testDTO) {
      return TestCase.builder()
      .description(testDTO.getDescription())
      .tested(testDTO.getTested())
      .passed(testDTO.getPassed())
      .numbers_of_tries(testDTO.getNumbers_of_tries())
      .last_update(testDTO.getLast_update())
      .build();   
   }

   public static TestResDTO testCaseToTestResDTO (TestCase testCase) {
      return TestResDTO.builder()
      .id_case(testCase.getId_case())
      .description(testCase.getDescription())
      .tested(testCase.getTested())
      .passed(testCase.getPassed())
      .numbers_of_tries(testCase.getNumbers_of_tries())
      .last_update(testCase.getLast_update())
      .build();   
   }

   public static List<TestResDTO> testCaseToListCaseResDTO (List<TestCase> listTestCase) {

      return listTestCase
      .stream()
      .map( Mapper::testCaseToTestResDTO )
      .collect(Collectors.toList());   
   }

}
