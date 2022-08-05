package com.bootcamp.ejerciciodeporte.dtos;

import com.bootcamp.ejerciciodeporte.entities.Sport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SportDto {

    private List<Sport> sports;

}
