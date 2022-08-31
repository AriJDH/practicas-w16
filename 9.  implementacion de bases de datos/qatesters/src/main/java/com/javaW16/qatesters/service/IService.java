package com.javaW16.qatesters.service;

import java.util.List;

import com.javaW16.qatesters.dto.resDTO.TestResDTO;
import com.javaW16.qatesters.dto.resDTO.reqDTO.TestDTO;

public interface IService {

   void saveTest (TestDTO testDTO);   

   void updateTest (Long id, TestDTO testDTO);   

   List<TestResDTO> listAllTests (String localDate);   

   TestResDTO findById (Long id);   

   void deleteTest (Long id);   

}
