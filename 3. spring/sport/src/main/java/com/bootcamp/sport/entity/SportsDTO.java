package com.bootcamp.sport.entity;

import com.bootcamp.sport.models.Sport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SportsDTO {
    private List<Sport> sports;
}
