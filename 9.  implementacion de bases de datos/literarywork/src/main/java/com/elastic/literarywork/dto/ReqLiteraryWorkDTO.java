package com.elastic.literarywork.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ReqLiteraryWorkDTO {
    private String title;
    private String author;
    private Integer amountPages;
    private String publisher;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate yearPublication;
}
