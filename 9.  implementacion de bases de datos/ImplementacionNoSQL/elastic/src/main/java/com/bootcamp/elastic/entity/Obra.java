package com.bootcamp.elastic.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

/**
 * Obra
 */

@Data
@Document(indexName = "obras")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class Obra {

   @Id
   private String id;
   private String nombreObra;
   private String nombreAutor;
   private Integer cantidadDePaginas;
   private String editorial;
   @JsonFormat(pattern = "dd/MM/yyyy")
   @Field(type = FieldType.Date)
   private LocalDate anioPublicacion;

}
