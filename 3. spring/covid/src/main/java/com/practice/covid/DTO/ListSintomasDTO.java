package com.practice.covid.DTO;

import com.practice.covid.entity.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListSintomasDTO {
    List<Sintoma> sintomasList;
}
