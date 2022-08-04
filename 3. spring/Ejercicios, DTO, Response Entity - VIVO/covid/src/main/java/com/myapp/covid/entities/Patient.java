package com.myapp.covid.entities;


import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class Patient {
    Person person;
    List<Symptom> symptoms;
}
