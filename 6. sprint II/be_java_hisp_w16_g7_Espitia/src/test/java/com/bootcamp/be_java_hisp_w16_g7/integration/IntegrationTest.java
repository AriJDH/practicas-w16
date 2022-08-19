package com.bootcamp.be_java_hisp_w16_g7.integration;


import com.bootcamp.be_java_hisp_w16_g7.dto.PostDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {



    @Test
    void createPostIntegrationTest(){
        ProductDTO productDTO = new ProductDTO(1,"Moto","Vehiculo","WWW","Rojo","Nueva");
        PostDTO payloadDTO = new PostDTO(1, LocalDate.parse("2022-08-19"),productDTO,111,12312.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDTO);



    }
}
