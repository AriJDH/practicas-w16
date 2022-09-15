package com.example.qatesters.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReqPutUpdateTestCaseDTO {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer numberOfTries;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate lastUpdate;
}
