package com.javaW16.qatesters.dto.resDTO.reqDTO;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TestDTO {

   private String description;
   private Boolean tested;
   private Boolean passed;
   private int numbers_of_tries;
   private LocalDate last_update ;

}
