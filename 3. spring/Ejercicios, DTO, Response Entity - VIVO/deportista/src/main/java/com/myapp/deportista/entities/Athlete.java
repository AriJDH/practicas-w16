package com.myapp.deportista.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Athlete {
    private Person person;
    private Sport sport;

}
