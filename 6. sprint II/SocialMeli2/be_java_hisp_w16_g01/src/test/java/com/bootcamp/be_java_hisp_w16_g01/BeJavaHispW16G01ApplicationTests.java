package com.bootcamp.be_java_hisp_w16_g01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class BeJavaHispW16G01ApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    int id = 1;

    @Test
    void contextLoads() throws Exception {
        //ProductDto productDto=new ProductDto(4,"Silla Gamer","Gamer","Racer","Rojo","Special edition");
        //PostDto postDto = new PostDto(1, LocalDate.now(),productDto,100,1500);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"user_id\": 3,\n" +
                                "    \"date\": \"13-08-2021\",\n" +
                                "    \"product\": {\n" +
                                "        \"product_id\": 4,\n" +
                                "        \"product_name\": \"Silla Gamer\",\n" +
                                "        \"type\": \"Gamer\",\n" +
                                "        \"brand\": \"Racer\",\n" +
                                "        \"color\": \"Red Black\",\n" +
                                "        \"notes\": \"Special Edition\"\n" +
                                "    },\n" +
                                "    \"category\": 100,\n" +
                                "    \"price\": 1500.50\n" +
                                "}"))
                .andDo(print())//Muestra el request y response
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Publicacion creada correctamente, id: " + id)).andReturn();

    }


}

