package com.diploma.diploma;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.diploma.diploma.controller.StudentController;
import com.diploma.diploma.model.StudentDTO;
import com.diploma.diploma.service.IStudentService;
import com.diploma.util.UtilTestTools;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
    
    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void registerStudent(){
        StudentDTO stu = UtilTestTools.generateStudent("Francisco");
        controller.registerStudent(stu);
    }

    @Test
    public void testObtenerDiplomaControllerAnalyzeScores() throws Exception{

        StudentDTO stu = UtilTestTools.generateStudent("Francisco");
        controller.registerStudent(stu);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        assertEquals("application/json",mvcResult.getResponse().getContentType());

    }
}
