package com.example.qatestersexercice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestCaseDto {
    Long id_case;
    String description;
    Boolean tested;
    Boolean passed;
    int number_of_tries;

    //@JsonFormat(pattern = "yyyy-mm-dd", shape = JsonFormat.Shape.STRING)
    LocalDate last_update;
}
