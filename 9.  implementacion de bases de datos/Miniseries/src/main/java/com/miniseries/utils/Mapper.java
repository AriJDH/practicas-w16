package com.miniseries.utils;

import com.miniseries.dto.JoyaDTO;
import com.miniseries.dto.TestCaseDTO;
import com.miniseries.entities.Joya;
import com.miniseries.entities.TestCase;

public class Mapper {

    public static Joya parseJoyaFromJoyaDTOWithoutId(JoyaDTO joyaDTO) {
        return Joya.builder()
                .nombre(joyaDTO.getNombre())
                .material(joyaDTO.getMaterial())
                .peso(joyaDTO.getPeso())
                .particularidad(joyaDTO.getParticularidad())
                .posee_piedra(joyaDTO.isPoseePiedra())
                .venta_o_no(joyaDTO.isVentaONo())
                .build();
    }

    public static JoyaDTO parseJoyaDTOFromJoya(Joya joya) {
        return JoyaDTO.builder()
                .id(joya.getId())
                .nombre(joya.getNombre())
                .material(joya.getMaterial())
                .peso(joya.getPeso())
                .particularidad(joya.getParticularidad())
                .poseePiedra(joya.isPosee_piedra())
                .ventaONo(joya.isVenta_o_no())
                .build();
    }

    public static Joya parseJoyaFromJoyaDTOWithtId(JoyaDTO joyaDTO) {
        return Joya.builder()
                .id(joyaDTO.getId())
                .nombre(joyaDTO.getNombre())
                .material(joyaDTO.getMaterial())
                .peso(joyaDTO.getPeso())
                .particularidad(joyaDTO.getParticularidad())
                .posee_piedra(joyaDTO.isPoseePiedra())
                .venta_o_no(joyaDTO.isVentaONo())
                .build();
    }

    public static TestCaseDTO parseTestCaseDTOFromTestCase(TestCase testCase) {
        return TestCaseDTO.builder()
                .id_case(testCase.getId_case())
                .description(testCase.getDescription())
                .tested(testCase.isTested())
                .passed(testCase.isPassed())
                .number_of_tries(testCase.getNumber_of_tries())
                .last_update(testCase.getLast_update())
                .build();
    }

    public static TestCase parseTestCaseFromTestCaseDTO(TestCaseDTO testCaseDTO) {
        return TestCase.builder()
                .id_case(testCaseDTO.getId_case())
                .description(testCaseDTO.getDescription())
                .tested(testCaseDTO.isTested())
                .passed(testCaseDTO.isPassed())
                .number_of_tries(testCaseDTO.getNumber_of_tries())
                .last_update(testCaseDTO.getLast_update())
                .build();
    }

}
