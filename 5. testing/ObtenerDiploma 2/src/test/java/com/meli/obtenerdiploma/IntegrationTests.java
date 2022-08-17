package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Mock
    IStudentService service;
    @InjectMocks
    StudentController controller;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void registerStudent(){
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        controller.registerStudent(stu);
    }

    @Test
    public void testObtenerDiplomaControllerAnalyzeScores() throws Exception{

        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        controller.registerStudent(stu);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",9999))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());

    }

}
