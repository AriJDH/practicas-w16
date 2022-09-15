package com.example.qatesters.service;

import com.example.qatesters.dto.ReqPostTestCaseDTO;
import com.example.qatesters.dto.ReqPutUpdateTestCaseDTO;
import com.example.qatesters.dto.ResTestCaseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITestCaseService {
    ResTestCaseDTO addTestCase(ReqPostTestCaseDTO reqPostTestCaseDTO);
    List<ResTestCaseDTO> listAllTestCase(Optional<LocalDate> lastUpdate);
    ResTestCaseDTO getTestCaseById(Long id);
    ResTestCaseDTO updateTestCaseById(Long id, ReqPutUpdateTestCaseDTO reqPutUpdateTestCaseDTO);
    void deleteTestCaseById(Long id);
}
